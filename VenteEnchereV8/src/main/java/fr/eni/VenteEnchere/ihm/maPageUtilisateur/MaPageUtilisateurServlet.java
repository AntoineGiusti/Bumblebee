package fr.eni.VenteEnchere.ihm.maPageUtilisateur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import fr.eni.VenteEnchere.bll.ArticleManager;
import fr.eni.VenteEnchere.bll.BLLException;


/**
 * Servlet implementation class MaPageUtilisateurServlet
 */
@WebServlet("/MaPageUtilisateurServlet")
public class MaPageUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MaPageUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextScreen = "WEB-INF/MaPageUtilisateur.jsp";
		
		MaPageUtilisateurModel model = new MaPageUtilisateurModel();
		
		
		///////////navigation
		
		
		if(request.getParameter("encheres")!=null) {
			
			nextScreen ="MaPageUtilisateurServlet";
			}
		
		if(request.getParameter("vendreArticle")!=null) {
					
			nextScreen ="MaPageUtilisateurServlet";
				}
		
		if(request.getParameter("MonProfil")!=null) {
			
			nextScreen ="ProfilUtilisateurServlet";
				}
		
		if(request.getParameter("deconnexion")!=null) {
			request.getSession().setAttribute("utilisateur", null);
			if (request.getSession().getAttribute("utilisateur") == null) {
			}
			nextScreen ="AccueilServlet";
				}
		
		//////////encheres
		
		if(request.getParameter("rechercher")!=null) {	
			
			if (request.getParameter("filtre").length() > 0) {	
				try {
					model.setLstArticlesParMotClef(ArticleManager.getInstance().getArticleByMotClef(request.getParameter("filtre")));
					request.setAttribute("model", model);
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
			
			
			else {
				
			switch (request.getParameter("categorie")) {
			case "Toutes":
				try {
					model.setLstAllArticles(ArticleManager.getInstance().getAllArticle());
					request.setAttribute("model", model);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case "ameublement":
				
				try {
					
					model.setLstArticlesParCategorie(ArticleManager.getInstance().getArticleByCategorie(1));
					request.setAttribute("model", model);
				} catch (BLLException e) {
				
					e.printStackTrace();
				}
				
				break;
				
			case "informatique":
				
				try {
					model.setLstArticlesParCategorie(ArticleManager.getInstance().getArticleByCategorie(2));
					request.setAttribute("model", model);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case "sportEtLoisir":
				
				try {
					model.setLstArticlesParCategorie(ArticleManager.getInstance().getArticleByCategorie(3));
					request.setAttribute("model", model);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case "vetement":
				
				try {
					model.setLstArticlesParCategorie(ArticleManager.getInstance().getArticleByCategorie(4));
					request.setAttribute("model", model);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;

			default:
				break;
			}
		}
	}
		
			
		
		
		
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
