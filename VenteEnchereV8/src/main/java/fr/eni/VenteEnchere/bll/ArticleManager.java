/**
 * 
 */
package fr.eni.VenteEnchere.bll;

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
		try {
			return DAOFact.getInstance().getAllArticle();
		} catch (DALException e) {
			e.printStackTrace();
			throw new BLLException();
			
		}
	}
	
}
