/**
 * 
 */
package fr.eni.VenteEnchere.ihm;

import java.util.List;

import fr.eni.VenteEnchere.bo.Utilisateur;

/**
 * @author mmainguy2021
 *
 */
public class MonProfilModel extends Utilisateur {
	
	private Utilisateur utilisateur;
	
	private List<Utilisateur> lstUser;
	
	/**
	 * 
	 */
	public MonProfilModel() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param utilisateur
	 * @param lstUser
	 */
	public MonProfilModel(Utilisateur utilisateur, List<Utilisateur> lstUser) {
		super();
		this.utilisateur = utilisateur;
		this.lstUser = lstUser;
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

	/**
	 * @return the lstUser
	 */
	public List<Utilisateur> getLstUser() {
		return lstUser;
	}

	/**
	 * @param lstUser the lstUser to set
	 */
	public void setLstUser(List<Utilisateur> lstUser) {
		this.lstUser = lstUser;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModelMonProfil [utilisateur=");
		builder.append(utilisateur);
		builder.append(", lstUser=");
		builder.append(lstUser);
		builder.append("]");
		return builder.toString();
	}
}
