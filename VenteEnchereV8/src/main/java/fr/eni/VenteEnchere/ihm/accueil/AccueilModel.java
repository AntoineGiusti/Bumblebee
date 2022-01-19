/**
 * 
 */
package fr.eni.VenteEnchere.ihm.accueil;

import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;

/**
 * @author mmainguy2021
 *
 */
public class AccueilModel {
	
	private List<ArticleVendu> lstArticles ;
	
	private List<ArticleVendu> lstArticlesParCategorie ;
	
	
	
	


	/**
	 * 
	 */
	public AccueilModel() {
		super();
	}

	/**
	 * @param lstArticles
	 */
	public AccueilModel(List<ArticleVendu> lstArticles) {
		super();
		this.lstArticles = lstArticles;
	}

	/**
	 * @param lstArticles
	 * @param lstArticlesParCategorie
	 */
	public AccueilModel(List<ArticleVendu> lstArticles, List<ArticleVendu> lstArticlesParCategorie) {
		super();
		this.lstArticles = lstArticles;
		this.lstArticlesParCategorie = lstArticlesParCategorie;
	}
	
	
	@Override
	public String toString() {
		return "AccueilModel [lstArticles=" + lstArticles + "]";
	}




	/**
	 * @return the lstArticles
	 */
	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	/**
	 * @param lstArticles the lstArticles to set
	 */
	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}




	public List<ArticleVendu> getLstArticlesParCategorie() {
		return lstArticlesParCategorie;
	}




	public void setLstArticlesParCategorie(List<ArticleVendu> lstArticlesParCategorie) {
		this.lstArticlesParCategorie = lstArticlesParCategorie;
	}
	

}
