package fr.eni.VenteEnchere.ihm.profilUtilisateur;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.VenteEnchere.bll.BLLException;
import fr.eni.VenteEnchere.bll.UtilisateurManager;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.ihm.creationProfil.CreationProfilModel;

/**
 * Servlet implementation class ProfilUtilisateurServlet
 */
@WebServlet("/ProfilUtilisateurServlet")
public class ProfilUtilisateurServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurManager manager = UtilisateurManager.getInstance();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilUtilisateurServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProfilUtilisateurModel model = new ProfilUtilisateurModel();
		
		String nextScreen = "WEB-INF/ProfilUtilisateur.jsp";
		
		if(request.getParameter("modifier")!=null) {
		
			nextScreen = "ProfilUtilisateurModifierServlet";
			
		}
		
		request.setAttribute("model", model);
		
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
