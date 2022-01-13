package fr.eni.VenteEnchere.bo;

public class SportEtLoisir extends ArticleVendu {
	
	private String sport;
	
	
	

	public SportEtLoisir() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SportEtLoisir(Integer noArticle, String nomArticle, String description, String dateDebutEncheres,
			String dateFinEncheres, String miseAPrix, String prixVente, String etatVente) {
		super(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente);
		// TODO Auto-generated constructor stub
	}

	public SportEtLoisir(String nomArticle, String description, String miseAPrix, String prixVente, String etatVente, String sport) {
		super(nomArticle, description, miseAPrix, prixVente, etatVente);
		this.sport = sport;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("SportEtLoisir [sport=");
		builder.append(sport);
		builder.append("]");
		return builder.toString();
	}
	
	

}