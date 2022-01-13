package fr.eni.VenteEnchere.bo;

import java.time.LocalDateTime;

public class Vetement extends ArticleVendu {
	
	private String vetement;

	public String getVetement() {
		return vetement;
	}

	public void setVetement(String vetement) {
		this.vetement = vetement;
	}

	public Vetement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vetement(Integer noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, String miseAPrix, String prixVente, String etatVente) {
		super(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente);
		// TODO Auto-generated constructor stub
	}

	public Vetement(String nomArticle, String description, String miseAPrix, String prixVente, String etatVente, String vetement) {
		super(nomArticle, description, miseAPrix, prixVente, etatVente);
		this.vetement = vetement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Vetement [vetement=");
		builder.append(vetement);
		builder.append("]");
		return builder.toString();
	}
	
	
		
	

}
