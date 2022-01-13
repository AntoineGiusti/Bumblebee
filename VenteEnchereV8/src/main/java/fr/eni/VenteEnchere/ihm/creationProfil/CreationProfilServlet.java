package fr.eni.VenteEnchere.ihm.creationProfil;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.VenteEnchere.bll.BLLException;
import fr.eni.VenteEnchere.bll.UtilisateurManager;
import fr.eni.VenteEnchere.bo.Utilisateur;


/**
 * Servlet implementation class UtilisateurServlet
 */
@WebServlet("/MonProfilServlet")
public class CreationProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UtilisateurManager manager = UtilisateurManager.getInstance();
    /**
     * Default constructor. 
     */
    public CreationProfilServlet() {
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		CreationProfilModel model = new CreationProfilModel();
		
//		MonProfilModel model = (MonProfilModel)request.getSession().getAttribute("model");
		
		if(request.getParameter("valider")!=null) {
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
			
			Utilisateur candidat = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);

			model.setUtilisateur(candidat);			
//			
//			model.getLstUser().add(utilisateur);

			
			try {
				manager.ajouterUtilisateur(pseudo, nom, prenom, email, telephone, 

						rue, codePostal, ville, motDePasse, confirmation);

				System.out.println("ca passe");
				
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
//			manager.supprimerUtilisateur(utilisateur);
//			
//			manager.modifierUtilisateur(utilisateur);
//			
		}
			request.setAttribute("model", model);
	
			request.getRequestDispatcher("WEB-INF/monProfil.jsp").forward(request, response);
		}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
