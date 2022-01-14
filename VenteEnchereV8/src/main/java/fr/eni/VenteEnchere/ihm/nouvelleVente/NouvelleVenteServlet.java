package fr.eni.VenteEnchere.ihm.nouvelleVente;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.VenteEnchere.bll.UtilisateurManager;
import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Retrait;
import fr.eni.VenteEnchere.bo.Utilisateur;


/**
 * Servlet implementation class NouvelleVenteServlet
 */
@WebServlet("/NouvelleVenteServlet")
public class NouvelleVenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static UtilisateurManager manager = UtilisateurManager.getInstance();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NouvelleVenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		Utilisateur utilisateurConnecte = (Utilisateur) session.getAttribute("utilisateur");
		
		
		NouvelleVenteModel model = new NouvelleVenteModel();
		String nextScreen = "/WEB-INF/NouvelleVente.jsp";
		
		
		
		
		if (request.getParameter("enregistrer") != null ) {
			String nomArticle = request.getParameter("article");
			String description = request.getParameter("description");
			String categorie = request.getParameter("categorie");			
			String dateDebutEnchere = request.getParameter("dateDebutEnchere");
			try {
				Timestamp dateDebut = new Timestamp(((new SimpleDateFormat("dd/MM/yyyy").parse(dateDebutEnchere)).getTime()));
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
			String dateFinEnchere = request.getParameter("dateFinEnchere");
			try {
				Timestamp dateFin = new Timestamp(((new SimpleDateFormat("dd/MM/yyyy").parse(dateFinEnchere)).getTime()));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			String miseAPrix = request.getParameter("miseAPrix");
			
			Utilisateur utilisateur = utilisateurConnecte;
			
			String libelleCategorie = request.getParameter("categorie");
			int no_categorie = 0;
			
			switch (libelleCategorie) {
			case "Ameublement": 
				no_categorie = 1;
				break;
				
			case "Informatique": 
				no_categorie = 2;
				break;
				
			case "Sport et loisir": 
				no_categorie = 3;
				break;
				
			case "Vetement": 
				no_categorie = 4;
				break;

			default:
				break;
			}
			
			
			
			
			model.getLstArticles();
			
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("codePostal");
			String ville = request.getParameter("ville");			
			Retrait retrait = new Retrait(rue,codePostal,ville);
			
			
			retrait = new  Retrait(rue, codePostal,ville);
			
			
			ArticleVendu article = new ArticleVendu(nomArticle,description, dateDebutEnchere, dateFinEnchere, miseAPrix, utilisateur, no_categorie, retrait);
			
			
		}
		if(request.getParameter("annuler") != null ) {
			request.setAttribute("article","");
			request.setAttribute("description","");
			request.setAttribute("categorie","");
			request.setAttribute("dateDebutEnchere","");
			request.setAttribute("dateFinEnchere","");
			request.setAttribute("miseAPrix","");
			request.setAttribute("rue","");
			request.setAttribute("codePostal","");
			request.setAttribute("ville","");
			
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
