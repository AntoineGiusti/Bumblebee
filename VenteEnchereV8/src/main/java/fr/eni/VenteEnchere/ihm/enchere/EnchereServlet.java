package fr.eni.VenteEnchere.ihm.enchere;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.VenteEnchere.bll.BLLException;
import fr.eni.VenteEnchere.bll.EnchereManager;
import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.dal.DALException;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/EnchereServlet")
public class EnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private static EnchereManager manager = EnchereManager.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String miseAPrix = request.getParameter("miseAPrix");
		
		if(request.getParameter("encherir") != null) {
			try {
				manager.ajouterEnchere();
			} catch (BLLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		request.getRequestDispatcher("WEB-INF/DetailVente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
