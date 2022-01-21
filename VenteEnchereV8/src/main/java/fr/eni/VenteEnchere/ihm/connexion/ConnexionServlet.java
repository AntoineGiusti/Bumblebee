package fr.eni.VenteEnchere.ihm.connexion;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.VenteEnchere.bll.UtilisateurManager;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.dal.DALException;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConnexionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextScreen = "WEB-INF/Connexion.jsp";
		
		if (request.getParameter("connexion") != null) {
			
			String pseudo = request.getParameter("pseudo");
			String motDePasse = request.getParameter("motDePasse");
			
			try {
				Utilisateur utilisateurConnect = UtilisateurManager.getInstance().verifLog(pseudo, motDePasse);
				
				if (utilisateurConnect == null) {
					request.setAttribute("erreur", "le pseudo et/ou le mot de passe sont erronés");
				}
				
				HttpSession session = request.getSession();
				
				session.setAttribute("utilisateur", utilisateurConnect);
				
						
				if(utilisateurConnect != null){
					
					nextScreen = "MaPageUtilisateurServlet";
				}		
			} catch (DALException e) {
				e.printStackTrace();
			}	
			
		}
		
		if (request.getParameter("creer") != null) {
			nextScreen = "CreationProfilServlet";
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
