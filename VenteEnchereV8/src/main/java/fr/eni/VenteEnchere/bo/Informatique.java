package fr.eni.VenteEnchere.bo;

import java.time.LocalDateTime;

public class Informatique extends ArticleVendu{

	private String informatique;

	public String getInformatique() {
		return informatique;
	}

	public void setInformatique(String informatique) {
		this.informatique = informatique;
	}

	public Informatique() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Informatique(Integer noArticle, String nomArticle, String description, LocalDateTime dateDebutEncheres,
			LocalDateTime dateFinEncheres, String miseAPrix, String prixVente, String etatVente) {
		super(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente);
		// TODO Auto-generated constructor stub
	}

	public Informatique(String nomArticle, String description, String miseAPrix, String prixVente, String etatVente, String informatique) {
		super(nomArticle, description, miseAPrix, prixVente, etatVente);
		this.informatique = informatique;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Informatique [informatique=");
		builder.append(informatique);
		builder.append("]");
		return builder.toString();
	}
	
	
}
