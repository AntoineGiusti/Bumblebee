package fr.eni.VenteEnchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.VenteEnchere.bll.UtilisateurManager;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.ecole.bll.ParticipantManager;
import fr.eni.ecole.bll.ParticipantManagerSingleton;
import fr.eni.ecole.bo.Participant;

/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/UtilisateurServlet")
public class MonProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UtilisateurManager manager = UtilisateurManager.getInstance();
    /**
     * Default constructor. 
     */
    public MonProfilServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		MonProfilModel model = (MonProfilModel)request.getSession().getAttribute("model");
		
		if(request.getParameter("valider")!=null) {
			Integer noUtilisateur = request.getParameter("noUtilisateur");
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String  codePostal= request.getParameter("codePostal");
			String  ville= request.getParameter("ville");
			String motDePasse = request.getParameter("motDePasse");
			String confirmation = request.getParameter("confirmation");
	
			
			Utilisateur utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, confirmation);
			
			model.setUtilisateur(utilisateur);			
			
			model.getLstUser().add(utilisateur);
			
			
			manager.ajouterUtilisateur(utilisateur);
			
			manager.supprimerUtilisateur(utilisateur);
			
			manager.modifierUtilisateur(utilisateur);
			
		}
	}
	
	request.getRequestDispatcher(WEB).forward(request, response);
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
