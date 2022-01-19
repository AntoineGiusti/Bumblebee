/**
 * 
 */
package fr.eni.VenteEnchere.ihm.maPageUtilisateur;

import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;

/**
 * @author thamon2021
 *
 */
public class MaPageUtilisateurModel {
	
	private List<ArticleVendu> lstAllArticles ;

	private List<ArticleVendu> lstArticlesParCategorie ;
	
	private List<ArticleVendu> lstArticlesParMotClef ;

	/**
	 * @param lstAllArticles
	 * @param lstArticlesParCategorie
	 * @param lstArticlesParMotClef
	 */
	public MaPageUtilisateurModel(List<ArticleVendu> lstAllArticles, List<ArticleVendu> lstArticlesParCategorie,
			List<ArticleVendu> lstArticlesParMotClef) {
		super();
		this.lstAllArticles = lstAllArticles;
		this.lstArticlesParCategorie = lstArticlesParCategorie;
		this.lstArticlesParMotClef = lstArticlesParMotClef;
	}

	/**
	 * 
	 */
	public MaPageUtilisateurModel() {
		super();
	}

	/**
	 * @return the lstAllArticles
	 */
	public List<ArticleVendu> getLstAllArticles() {
		return lstAllArticles;
	}

	/**
	 * @param lstAllArticles the lstAllArticles to set
	 */
	public void setLstAllArticles(List<ArticleVendu> lstAllArticles) {
		this.lstAllArticles = lstAllArticles;
	}

	/**
	 * @return the lstArticlesParCategorie
	 */
	public List<ArticleVendu> getLstArticlesParCategorie() {
		return lstArticlesParCategorie;
	}

	/**
	 * @param lstArticlesParCategorie the lstArticlesParCategorie to set
	 */
	public void setLstArticlesParCategorie(List<ArticleVendu> lstArticlesParCategorie) {
		this.lstArticlesParCategorie = lstArticlesParCategorie;
	}

	/**
	 * @return the lstArticlesParMotClef
	 */
	public List<ArticleVendu> getLstArticlesParMotClef() {
		return lstArticlesParMotClef;
	}

	/**
	 * @param lstArticlesParMotClef the lstArticlesParMotClef to set
	 */
	public void setLstArticlesParMotClef(List<ArticleVendu> lstArticlesParMotClef) {
		this.lstArticlesParMotClef = lstArticlesParMotClef;
	}
	
	

}
