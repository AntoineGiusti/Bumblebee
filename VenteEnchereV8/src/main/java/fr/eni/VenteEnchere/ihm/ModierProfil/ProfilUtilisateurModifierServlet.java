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
		
		HttpSession session = request.getSession();
		
		String nextScreen = "WEB-INF/MonProfilUtilisateurModifier.jsp";
		
		ProfilUtilisateurModifierModel model = null;
		
		Utilisateur utilisateurModel = (Utilisateur) session.getAttribute("utilisateur");
		
		try {
			model = new ProfilUtilisateurModifierModel(UtilisateurManager.getInstance().utilisateurParId(utilisateurModel.getNoUtilisateur()));
		} catch (BLLException e2) {

			e2.printStackTrace();
		}
		
		request.setAttribute("model", model);
		
		
		Utilisateur utilisateurAModifier = (Utilisateur) session.getAttribute("utilisateur");
		
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
					
			Boolean logOk = false;
			try {
				logOk = UtilisateurManager.getInstance().verificationMotDePasseActuel(motDePasseActuel, utilisateurAModifier.getMotDePasse());
			} catch (BLLException e1) {
				e1.printStackTrace();
			}
			
			if (!logOk) {
				System.out.println("mot de passe errone");
				request.setAttribute("verifMp", "mot de passe errone");
			}
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
				UtilisateurManager.getInstance().modifierUtilisateur(utilisateurAModifier,utilisateurOrigin, confirmation);
				Utilisateur utilisateurModifie = UtilisateurManager.getInstance().utilisateurParId(utilisateurAModifier.getNoUtilisateur());
				ProfilUtilisateurModifierModel modelmodifie = new ProfilUtilisateurModifierModel(utilisateurModifie);
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
				System.out.println("vous etes deconnecte");
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
