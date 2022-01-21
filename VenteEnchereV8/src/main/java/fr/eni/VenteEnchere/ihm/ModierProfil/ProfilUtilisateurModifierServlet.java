package fr.eni.VenteEnchere.ihm.ModierProfil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.VenteEnchere.bll.BLLException;
import fr.eni.VenteEnchere.bll.UtilisateurManager;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.ihm.creationProfil.CreationProfilModel;

/**
 * Servlet implementation class ProfilUtilisateurModifierServlet
 */
@WebServlet("/ProfilUtilisateurModifierServlet")
public class ProfilUtilisateurModifierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfilUtilisateurModifierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(); // appel de l' objet session
		
		String nextScreen = "WEB-INF/MonProfilUtilisateurModifier.jsp";
		
		ProfilUtilisateurModifierModel model = null;
		
		// variable determinant quel utilisateur sera appele dans le model
		Utilisateur utilisateurModel = (Utilisateur) session.getAttribute("utilisateur"); 
		
		
		// cree le model avec l utilisateur avec les attribut en base de donnee de l utilisateur en session
		try {
			model = new ProfilUtilisateurModifierModel(UtilisateurManager.getInstance().utilisateurParId(utilisateurModel.getNoUtilisateur())); 
		} catch (BLLException e2) {

			e2.printStackTrace();
		}
		
		// transfert a la jsp les attribut du model
		request.setAttribute("model", model);
		
		// cree une variable de l utilisateur en session
		Utilisateur utilisateurAModifier = (Utilisateur) session.getAttribute("utilisateur");
		
		// cree un nouvel utilisateur avec le pseudo en l email de l utilisateur session , pour etre comparer ( contrainte d unicite)
		Utilisateur utilisateurOrigin = new Utilisateur(utilisateurAModifier.getPseudo(),utilisateurAModifier.getEmail());
		
		
		if(request.getParameter("enregister")!=null) {
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal= request.getParameter("codePostal");
			String ville= request.getParameter("ville");
			String motDePasseActuel = request.getParameter("motDePasseActuel");
			String NouveauMotDePasse = request.getParameter("NouveauMotDePasse");
			String confirmation = request.getParameter("confirmation");
			
			/////
			
			//verifie la comformite du mot de passe
			Boolean logOk = false;
			try {
				logOk = UtilisateurManager.getInstance().verificationMotDePasseActuel(motDePasseActuel, utilisateurAModifier.getMotDePasse());
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			
			if (!logOk) {
				request.setAttribute("verifMp", "mot de passe errone");
			}
			
			// si le mot de passe est conforme , l utilisateur session est modifie
			else {
			utilisateurAModifier.setPseudo(pseudo);
			utilisateurAModifier.setNom(nom);
			utilisateurAModifier.setPrenom(prenom);
			utilisateurAModifier.setEmail(email);
			utilisateurAModifier.setTelephone(telephone);
			utilisateurAModifier.setRue(rue);
			utilisateurAModifier.setCodePostal(codePostal);
			utilisateurAModifier.setVille(ville);
			utilisateurAModifier.setMotDePasse(NouveauMotDePasse);
			
			
			try {
				// les modification sont envoyees en bdd
				UtilisateurManager.getInstance().modifierUtilisateur(utilisateurAModifier,utilisateurOrigin, confirmation);
				// le model est maj par la bdd
				Utilisateur utilisateurModifie = UtilisateurManager.getInstance().utilisateurParId(utilisateurAModifier.getNoUtilisateur());
				ProfilUtilisateurModifierModel modelmodifie = new ProfilUtilisateurModifierModel(utilisateurModifie);
				// les nouveaux attributs sont envoyes a la jsp
				request.setAttribute("model", modelmodifie);
				
			} catch (BLLException e) {
				request.setAttribute("erreur", e.toString());
				e.printStackTrace();
			}
			
			
			}		
						
		}
		
		
		//////////////////
		
		if (request.getParameter("supprimer")!=null) {
				
			Utilisateur utilisateurSupprimer = (Utilisateur) session.getAttribute("utilisateur");
			UtilisateurManager.getInstance().supprimerUtilisateur(utilisateurSupprimer);
			
			request.getSession().setAttribute("utilisateur", null);
			
			nextScreen ="AccueilServlet";
			
			if (request.getSession().getAttribute("utilisateur") == null) {
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
