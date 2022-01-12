/**
 * 
 */
package fr.eni.VenteEnchere.bo;

import java.util.List;

/**
 * @author thamon2021
 *
 */
public class Categorie {

	private Integer noCategorie;
	private String libelle;
	private List<ArticleVendu> lstAticlevendus;
	
	
	
	
	/**
	 * 
	 */
	public Categorie() {
		super();
	}
	
	
	
	/**
	 * @param noCategorie
	 * @param libelle
	 */
	public Categorie(Integer noCategorie, String libelle) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
	}



	/**
	 * @param noCategorie
	 * @param libelle
	 * @param lstAticlevendus
	 */
	public Categorie(Integer noCategorie, String libelle, List<ArticleVendu> lstAticlevendus) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.lstAticlevendus = lstAticlevendus;
	}


	

	@Override
	public String toString() {
		return "Categorie [noCategorie=" + noCategorie + ", libelle=" + libelle + ", lstAticlevendus=" + lstAticlevendus
				+ "]";
	}



	/**
	 * @return the noCategorie
	 */
	public Integer getNoCategorie() {
		return noCategorie;
	}
	/**
	 * @param noCategorie the noCategorie to set
	 */
	public void setNoCategorie(Integer noCategorie) {
		this.noCategorie = noCategorie;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}
	/**
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	/**
	 * @return the lstAticlevendus
	 */
	public List<ArticleVendu> getLstAticlevendus() {
		return lstAticlevendus;
	}
	/**
	 * @param lstAticlevendus the lstAticlevendus to set
	 */
	public void setLstAticlevendus(List<ArticleVendu> lstAticlevendus) {
		this.lstAticlevendus = lstAticlevendus;
	}
	
}
