/**
 * 
 */
package fr.eni.VenteEnchere.bo;

import java.time.LocalDateTime;



/**
 * @author thamon2021
 *
 */
public class Enchere {

	private LocalDateTime dateEnchere;
	private Integer montantEnchere;
	private ArticleVendu articleVendu;
	private Utilisateur utilisateur;
	
	
	//////////////////constructeurs////////////////////
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 * @param articleVendu
	 * @param utilisateur
	 */
	public Enchere(LocalDateTime dateEnchere, Integer montantEnchere, ArticleVendu articleVendu, Utilisateur utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
	}
	
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 */
	public Enchere(LocalDateTime dateEnchere, Integer montantEnchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
	}
	

	
	/**
	 * 
	 */
	public Enchere() {
		super();
	}
	////////////////////methode////////////////////
	
	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montantEnchere + ", articleVendu="
				+ articleVendu + ", utilisateur=" + utilisateur + "]";
	}

	
	/////////////////////getters setters//////////////////////
	/**
	 * @return the dateEnchere
	 */
	public LocalDateTime getDateEnchere() {
		return dateEnchere;
	}
	

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDateTime dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montant_enchere
	 */
	public Integer getMontantEnchere() {
		return montantEnchere;
	}
	/**
	 * @param montant_enchere the montant_enchere to set
	 */
	public void setMontantEnchere(Integer montantEnchere) {
		this.montantEnchere = montantEnchere;
	}
	/**
	 * @return the articleVendu
	 */
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	/**
	 * @param articleVendu the articleVendu to set
	 */
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	/**
	 * @return the utilisateur
	 */
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	/**
	 * @param utilisateur the utilisateur to set
	 */
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	
}
