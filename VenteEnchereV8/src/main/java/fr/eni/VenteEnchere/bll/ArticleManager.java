/**
 * 
 */
package fr.eni.VenteEnchere.bll;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.dal.DALException;
import fr.eni.VenteEnchere.dal.DAOFact;

/**
 * @author thamon2021
 *
 */
	public class ArticleManager {
	
	/////////////////////singleton////////////////////
		
	private static class ArticleManagerHolder {
	private static ArticleManager instance = new ArticleManager();
	}
	
	private ArticleManager() { }
	
	public static ArticleManager getInstance() {
	return ArticleManagerHolder.instance;
	}
	
	
	public void ajouterArticleAVendre(ArticleVendu article) {
		try {
			DAOFact.getInstance().insertArticle(article);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	public List<ArticleVendu> getAllArticle() throws BLLException {
		
		List<ArticleVendu> encheresEnCours = new ArrayList<ArticleVendu>(); 
		try {
			for (ArticleVendu articleVendu : DAOFact.getInstance().getAllArticle()) {
				
				if (articleVendu.getDateFinEncheres().isAfter(LocalDate.now()) ) {
					encheresEnCours.add(articleVendu);
				}
					
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return encheresEnCours;
	}
	
	
	
	
	public List<ArticleVendu> getArticleByCategorie(Integer noCategorie) throws BLLException {
		List<ArticleVendu> encheresEnCours = new ArrayList<ArticleVendu>(); 
		try {
			for (ArticleVendu articleVendu : DAOFact.getInstance().getArticleByCategotie(noCategorie)) {
				
				if (articleVendu.getDateFinEncheres().isAfter(LocalDate.now()) ) {
					encheresEnCours.add(articleVendu);
				}
					
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return encheresEnCours;
	}
	

	public List<ArticleVendu> getArticleByMotClef(String motClef) throws BLLException {
		List<ArticleVendu> encheresEnCours = new ArrayList<ArticleVendu>(); 
		try {
			for (ArticleVendu articleVendu : DAOFact.getInstance().getArticleByMotClef(motClef)) {
				
				if (articleVendu.getDateFinEncheres().isAfter(LocalDate.now()) ) {
					encheresEnCours.add(articleVendu);
				}
					
			}
		} catch (DALException e) {
			e.printStackTrace();
		}
		
		return encheresEnCours;
	}
	
	
	public ArticleVendu getArticleById (Integer noArticle) throws BLLException {
		ArticleVendu article = null;
		try {
			article = DAOFact.getInstance().getArticleById(noArticle);
		} catch (DALException e) {	
			e.printStackTrace();
		}
		return article;
		
	}
	
	
}
