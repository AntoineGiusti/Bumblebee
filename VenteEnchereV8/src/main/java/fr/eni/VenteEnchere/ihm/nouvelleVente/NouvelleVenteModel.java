package fr.eni.VenteEnchere.ihm.nouvelleVente;

import fr.eni.VenteEnchere.bo.ArticleVendu;

/**
 * @author agiusti2021
 *
 */
public class NouvelleVenteModel extends ArticleVendu {
	
	private ArticleVendu articleVendu;
	
	
	public NouvelleVenteModel(String nomArticle, String description, String miseAPrix, String prixVente,
			String etatVente) {
		super(nomArticle, description, miseAPrix, prixVente, etatVente);
	}

	public NouvelleVenteModel() {
		// TODO Auto-generated constructor stub
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NouvelleVenteModel [articleVendu=");
		builder.append(articleVendu);
		builder.append("]");
		return builder.toString();
	}
	
	

}
