package fr.eni.VenteEnchere.ihm.accueil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.VenteEnchere.bll.ArticleManager;
import fr.eni.VenteEnchere.bll.BLLException;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		String nextScreen = "/WEB-INF/Accueil.jsp";
		
		AccueilModel model = new AccueilModel();
		
		
		try {
			model.setLstArticles(ArticleManager.getInstance().getAllArticle());
		} catch (BLLException e) {
		
			e.printStackTrace();
		}
		
		request.setAttribute("model", model);
		
		
		
		if(request.getParameter("Rechercher")!=null) {
			
			switch (request.getParameter("categorie")) {
			case "toutes":
				try {
					model.setLstArticles(ArticleManager.getInstance().getAllArticle());
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case "ameublement":
				
				try {
					
					model.setLstArticlesParCategorie(null);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case "informatique":
				
				try {
					System.out.println("comprend le menu deroule");
					request.setAttribute("lstInfo", ArticleManager.getInstance().getArticleByCategorie(2)); 
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case "sportEtLoisir":
				
				try {
					ArticleManager.getInstance().getArticleByCategorie(3);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;
				
			case "vetement":
				
				try {
					ArticleManager.getInstance().getArticleByCategorie(4);
				} catch (BLLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				break;

			default:
				break;
			}
			
			
			nextScreen ="/WEB-INF/Accueil.jsp";
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
