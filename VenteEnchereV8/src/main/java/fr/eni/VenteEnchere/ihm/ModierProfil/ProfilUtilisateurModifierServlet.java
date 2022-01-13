package fr.eni.VenteEnchere.ihm.ModierProfil;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
CreationProfilModel model = new CreationProfilModel();
		
//		MonProfilModel model = (MonProfilModel)request.getSession().getAttribute("model");
		
		if(request.getParameter("enregister")!=null) {
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
