package fr.eni.VenteEnchere.ihm.maPageUtilisateur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		if (request.getSession().getAttribute("utilisateur") != null) {
			System.out.println("session mapageUtilisateur en cours");
		}
		
		String nextScreen = "WEB-INF/MaPageUtilisateur.jsp";
		
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
			System.out.println("ca passe par deconnection");
			request.getSession().setAttribute("utilisateur", null);
			
			nextScreen ="AccueilServlet";
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
