/**
 * 
 */
package fr.eni.VenteEnchere.ihm.detailVente;

import fr.eni.VenteEnchere.bo.ArticleVendu;

/**
 * @author mmainguy2021
 *
 */
public class DetailVenteModel {
	
	private ArticleVendu article;

	/**
	 * @return the article
	 */
	public ArticleVendu getArticle() {
		return article;
	}

	/**
	 * @param article the article to set
	 */
	public void setArticle(ArticleVendu article) {
		this.article = article;
	}

	/**
	 * @param article
	 */
	public DetailVenteModel(ArticleVendu article) {
		super();
		this.article = article;
	}

	/**
	 * 
	 */
	public DetailVenteModel() {
		super();
	}

	@Override
	public String toString() {
		return "DetailVenteModel [article=" + article + "]";
	}
	
	

	
	
	
}
