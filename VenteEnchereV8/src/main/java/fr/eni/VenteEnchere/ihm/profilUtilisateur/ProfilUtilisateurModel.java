/**
 * 
 */
package fr.eni.VenteEnchere.ihm.profilUtilisateur;

import fr.eni.VenteEnchere.bo.Utilisateur;

/**
 * @author mmainguy2021
 *
 */
public class ProfilUtilisateurModel {
	
	private Utilisateur utilisateur;
	
	/**
	 * 
	 */
	public ProfilUtilisateurModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param utilisateur
	 */
	public ProfilUtilisateurModel(Utilisateur utilisateur) {
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
		builder.append("ProfilUtilisateurModel [utilisateur=");
		builder.append(utilisateur);
		builder.append("]");
		return builder.toString();
	}
}
