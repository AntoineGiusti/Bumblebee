package fr.eni.VenteEnchere.ihm.detailVente;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.VenteEnchere.bll.ArticleManager;
import fr.eni.VenteEnchere.bll.BLLException;
import fr.eni.VenteEnchere.bo.Utilisateur;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nextScreen = "WEB-INF/DetailVente.jsp";
		
		Integer noArticle = Integer.valueOf(request.getParameter("id"));
		DetailVenteModel model = new DetailVenteModel();
		HttpSession session = request.getSession();
		Utilisateur utilisateur = (Utilisateur) session.getAttribute("utilisateur");
		
		try {
			model.setArticle(ArticleManager.getInstance().getArticleById(noArticle));
		} catch (BLLException e) {
			e.printStackTrace();
		}
		
		
		request.setAttribute("model", model);
		
		if(request.getParameter("encherir")!=null) {
			
			
			nextScreen = "DetailVenteServlet";
			
			
			
			
			
			
			
			
			
		}
		
		//request.getSession().setAttribute("model", model);
		
		request.getRequestDispatcher("WEB-INF/DetailVente.jsp").forward(request, response);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
