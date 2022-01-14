/**
 * 
 */
package fr.eni.VenteEnchere.ihm.profilVendeur;

import fr.eni.VenteEnchere.bo.Utilisateur;

/**
 * @author mmainguy2021
 *
 */
public class ProfilVendeurModel {
	
	private Utilisateur utilisateur;
	
	/**
	 * 
	 */
	public ProfilVendeurModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param utilisateur
	 */
	public ProfilVendeurModel(Utilisateur utilisateur) {
		super();
		this.utilisateur = utilisateur;
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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ProfilVendeurModel [utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}
}
