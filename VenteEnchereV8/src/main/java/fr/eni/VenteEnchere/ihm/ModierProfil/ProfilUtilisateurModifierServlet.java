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
		
		String nextScreen = "WEB-INF/MonProfilUtilisateurModifier.jsp";
		
	
		if(request.getParameter("enregister")!=null) {
			String pseudo = request.getParameter("pseudo");
			String nom = request.getParameter("nom");
			String prenom = request.getParameter("prenom");
			String email = request.getParameter("email");
			String telephone = request.getParameter("telephone");
			String rue = request.getParameter("rue");
			String codePostal= request.getParameter("codePostal");
			String ville= request.getParameter("ville");
			String motDePasse = request.getParameter("motDePasseActuel");
			String NouveauMotDePasse = request.getParameter("NouveauMotDePasse");
			String confirmation = request.getParameter("confirmation");
			
			//TODO voir pour utiliser l utilisateru en session
			
			HttpSession session = request.getSession();
			
			Utilisateur utilisateurModifier = (Utilisateur) session.getAttribute("utilisateur");
			utilisateurModifier.setPseudo(pseudo);
			utilisateurModifier.setNom(nom);
			utilisateurModifier.setPrenom(prenom);
			utilisateurModifier.setEmail(email);
			utilisateurModifier.setTelephone(telephone);
			utilisateurModifier.setRue(rue);
			utilisateurModifier.setCodePostal(codePostal);
			utilisateurModifier.setMotDePasse(NouveauMotDePasse);
			
			
			
			//Utilisateur UtilisateurModifier = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);
			
			try {
				UtilisateurManager.getInstance().modifierUtilisateur(utilisateurModifier, NouveauMotDePasse, confirmation);
			} catch (BLLException e) {
				e.printStackTrace();
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
