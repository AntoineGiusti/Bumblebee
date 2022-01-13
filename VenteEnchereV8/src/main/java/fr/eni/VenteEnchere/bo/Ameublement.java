package fr.eni.VenteEnchere.bo;

public class Ameublement extends ArticleVendu {
	
	private String ameublement;

	public String getAmeublement() {
		return ameublement;
	}

	public void setAmeublement(String ameublement) {
		this.ameublement = ameublement;
	}

	public Ameublement() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ameublement(Integer noArticle, String nomArticle, String description, String dateDebutEncheres,
			String dateFinEncheres, String miseAPrix, String prixVente, String etatVente) {
		super(noArticle, nomArticle, description, dateDebutEncheres, dateFinEncheres, miseAPrix, prixVente, etatVente);
		// TODO Auto-generated constructor stub
	}

	public Ameublement(String nomArticle, String description, String miseAPrix, String prixVente, String etatVente, String ameublement) {
		super(nomArticle, description, miseAPrix, prixVente, etatVente);
		this.ameublement = ameublement;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Ameublement [ameublement=");
		builder.append(ameublement);
		builder.append("]");
		return builder.toString();
	}

	
	

}
