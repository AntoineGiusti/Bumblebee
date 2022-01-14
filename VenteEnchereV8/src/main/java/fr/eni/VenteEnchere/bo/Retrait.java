package fr.eni.VenteEnchere.bo;

public class Retrait {
	
	private String rue;
	private String codePostal;
	private String ville;
	private ArticleVendu articleVendu;
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Retrait [rue=");
		builder.append(rue);
		builder.append(", codePostal=");
		builder.append(codePostal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", articleVendu=");
		builder.append(articleVendu);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	public Retrait(String rue, String codePostal, String ville) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}



	public Retrait() {
		super();
	}
	public Retrait(String rue, String codePostal, String ville, ArticleVendu articleVendu) {
		super();
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	
	
	
	

}
