/**
 * 
 */
package fr.eni.VenteEnchere.ihm.ModierProfil;

import fr.eni.VenteEnchere.bo.Utilisateur;

/**
 * @author thamon2021
 *
 */
public class ProfilUtilisateurModifierModel {
	
	private Utilisateur utilisateurUdapte;
	
	
	

	

	/**
	 * @param utilisateurUdapte
	 */
	public ProfilUtilisateurModifierModel(Utilisateur utilisateurUdapte) {
		super();
		this.utilisateurUdapte = utilisateurUdapte;
	}
	
	@Override
	public String toString() {
		return "ProfilUtilisateurModifierModel [utilisateurUdapte=" + utilisateurUdapte + "]";
	}

	public Utilisateur getUtilisateurUdapte() {
		return utilisateurUdapte;
	}

	public void setUtilisateurUdapte(Utilisateur utilisateurUdapte) {
		this.utilisateurUdapte = utilisateurUdapte;
	}

}
