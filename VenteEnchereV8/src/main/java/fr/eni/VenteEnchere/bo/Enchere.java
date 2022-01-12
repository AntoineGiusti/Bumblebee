/**
 * 
 */
package fr.eni.VenteEnchere.bo;

import java.sql.Date;



/**
 * @author thamon2021
 *
 */
public class Enchere {

	private Date dateEnchere;
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
	public Enchere(Date dateEnchere, Integer montant_enchere, ArticleVendu articleVendu, Utilisateur utilisateur) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montant_enchere;
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
	}
	
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 */
	public Enchere(Date dateEnchere, Integer montant_enchere) {
		super();
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montant_enchere;
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
	public Date getDateEnchere() {
		return dateEnchere;
	}
	

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}
	/**
	 * @return the montant_enchere
	 */
	public Integer getMontant_enchere() {
		return montantEnchere;
	}
	/**
	 * @param montant_enchere the montant_enchere to set
	 */
	public void setMontant_enchere(Integer montant_enchere) {
		this.montantEnchere = montant_enchere;
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
