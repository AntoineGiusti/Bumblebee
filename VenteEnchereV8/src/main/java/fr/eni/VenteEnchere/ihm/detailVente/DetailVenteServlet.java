package fr.eni.VenteEnchere.ihm.detailVente;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.VenteEnchere.bll.ArticleManager;
import fr.eni.VenteEnchere.bll.BLLException;
import fr.eni.VenteEnchere.bll.EnchereManager;
import fr.eni.VenteEnchere.bll.UtilisateurManager;
import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.dal.DALException;

/**
 * Servlet implementation class DetailVenteServlet
 */
@WebServlet("/DetailVenteServlet")
public class DetailVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailVenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		
		EnchereManager enchereManager = EnchereManager.getInstance();
		UtilisateurManager utilisateurManager = UtilisateurManager.getInstance();
		
		String nextScreen = "WEB-INF/DetailVente.jsp";
		DetailVenteModel model = new DetailVenteModel();
		Integer noArticle = Integer.valueOf(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		//////affiche l enchere///////////////
		
		ArticleVendu article = null;
		try {
			article = ArticleManager.getInstance().getArticleParNo(noArticle);
		} catch (BLLException e1) {
			e1.printStackTrace();
		}
		
			model.setArticle(article);
			
		request.setAttribute("model", model);
		
		/////////encheri/////////////////////
		
		if(request.getParameter("encherir")!=null) {
			
			LocalDate dateEnchere = LocalDate.now();	
			Integer enchereProposee = Integer.parseInt(request.getParameter("proposition"));
			
			
			if (enchereProposee >= article.getPrixVente() && enchereProposee <= utilisateur.getCredit()) {
			
				try {
					enchereManager.ajouterEnchere(dateEnchere, enchereProposee, article, utilisateur);
					utilisateurManager.enleverCreditUtilisateur(utilisateur, enchereProposee);
				} catch (BLLException e) {
					e.printStackTrace();
				} catch (DALException e) {
					e.printStackTrace();
				}
				
				
				
				
				nextScreen = "WEB-INF/DetailVente.jsp";
				
			}
			
		
			else {
				request.setAttribute("erreur","Montant propose trop faible ou compte credit insuffisant");
			}
			
			
		}
		
	//	request.getSession().setAttribute("model", model);
		
		request.getRequestDispatcher(nextScreen).forward(request, response);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
