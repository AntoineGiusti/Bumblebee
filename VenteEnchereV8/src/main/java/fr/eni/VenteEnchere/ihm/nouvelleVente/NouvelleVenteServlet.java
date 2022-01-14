package fr.eni.VenteEnchere.ihm.nouvelleVente;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.VenteEnchere.bll.UtilisateurManager;
import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Retrait;

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
		
		NouvelleVenteModel model = new NouvelleVenteModel();
	
		LocalDateTime.parse("yyyy-MM-dd : HH:mm:ss");
		LocalDateTime localDateTime = LocalDateTime.now();
		
		
		
		
		
		if (request.getParameter("Enregistrer") != null ) {
			String nomArticle = request.getParameter("Article");
			String description = request.getParameter("description");
			String categorie = request.getParameter("categorie");			
			String dateDebutEnchere = request.getParameter("debut de l'enchere");
			try {
				Timestamp dateDebut = new Timestamp(((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateDebutEnchere)).getTime()));
			} catch (ParseException e) {
			
				e.printStackTrace();
			}
			String dateFinEnchere = request.getParameter("dateFinEnchere");
			try {
				Timestamp dateFin = new Timestamp(((new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateFinEnchere)).getTime()));
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			String miseAPrix = request.getParameter("Mise a prix");
			ArticleVendu article = new ArticleVendu(nomArticle,description, dateDebutEnchere, dateFinEnchere, miseAPrix);
			
			model.setArticleVendu(model);
			
			try {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			String rue = request.getParameter("rue");
			String codePostal = request.getParameter("code postal");
			String ville = request.getParameter("ville");
			Retrait retrait = new Retrait(rue,codePostal,ville);
			
			model.getRetrait();
		}
		String nextScreen = "/WEB-INF/NouvelleVente.jsp";
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
