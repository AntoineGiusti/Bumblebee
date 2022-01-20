/**
 * 
 */
package fr.eni.VenteEnchere.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;



/**
 * @author thamon2021
 *
 */
public class Enchere {
	
	
	private Integer noEnchere;
	private LocalDate dateEnchere;
	private Integer montantEnchere;
	private ArticleVendu articleVendu;
	private Utilisateur utilisateur;
	
	
	
	
	
	/**
	 * @param noEnchere
	 * @param dateEnchere
	 * @param montantEnchere
	 * @param articleVendu
	 * @param utilisateur
	 */
	public Enchere(Integer noEnchere, LocalDate dateEnchere, Integer montantEnchere, ArticleVendu articleVendu,
			Utilisateur utilisateur) {
		super();
		this.noEnchere = noEnchere;
		this.dateEnchere = dateEnchere;
		this.montantEnchere = montantEnchere;
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
	}



	//////////////////constructeurs////////////////////
	
	
	
	
	
	/**
	 * @param dateEnchere
	 * @param montant_enchere
	 * @param articleVendu
	 * @param utilisateur
	 */
	public Enchere(LocalDate dateEnchere, Integer montantEnchere, ArticleVendu articleVendu, Utilisateur utilisateur) {
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
	public Enchere(LocalDate dateEnchere, Integer montantEnchere) {
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
	public LocalDate getDateEnchere() {
		return dateEnchere;
	}
	

	/**
	 * @param dateEnchere the dateEnchere to set
	 */
	public void setDateEnchere(LocalDate dateEnchere) {
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



	public Integer getNoEnchere() {
		return noEnchere;
	}



	public void setNoEnchere(Integer noEnchere) {
		this.noEnchere = noEnchere;
	}
	
	
}
