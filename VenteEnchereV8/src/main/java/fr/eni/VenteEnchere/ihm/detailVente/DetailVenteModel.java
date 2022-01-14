/**
 * 
 */
package fr.eni.VenteEnchere.ihm.detailVente;

import java.util.ArrayList;
import java.util.List;

import fr.eni.VenteEnchere.bo.Categorie;
import fr.eni.VenteEnchere.bo.Utilisateur;

/**
 * @author mmainguy2021
 *
 */
public class DetailVenteModel {
	private List<Categorie> lstcategorie =  new ArrayList<>();
	
	private List<Utilisateur> lstUtilisateur = new ArrayList<>();
	
	/**
	 * 
	 */
	public DetailVenteModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param lstcategorie
	 * @param lstUtilisateur
	 */
	public DetailVenteModel(List<Categorie> lstcategorie, List<Utilisateur> lstUtilisateur) {
		super();
		this.lstcategorie = lstcategorie;
		this.lstUtilisateur = lstUtilisateur;
	}

	/**
	 * @return the lstcategorie
	 */
	public List<Categorie> getLstcategorie() {
		return lstcategorie;
	}

	/**
	 * @param lstcategorie the lstcategorie to set
	 */
	public void setLstcategorie(List<Categorie> lstcategorie) {
		this.lstcategorie = lstcategorie;
	}

	/**
	 * @return the lstUtilisateur
	 */
	public List<Utilisateur> getLstUtilisateur() {
		return lstUtilisateur;
	}

	/**
	 * @param lstUtilisateur the lstUtilisateur to set
	 */
	public void setLstUtilisateur(List<Utilisateur> lstUtilisateur) {
		this.lstUtilisateur = lstUtilisateur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DetailVenteModel [lstcategorie=");
		builder.append(lstcategorie);
		builder.append(", lstUtilisateur=");
		builder.append(lstUtilisateur);
		builder.append("]");
		return builder.toString();
	}
}
