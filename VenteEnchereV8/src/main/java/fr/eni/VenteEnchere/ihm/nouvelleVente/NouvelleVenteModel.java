package fr.eni.VenteEnchere.ihm.nouvelleVente;

import java.util.ArrayList;
import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Retrait;

/**
 * @author agiusti2021
 *
 */
public class NouvelleVenteModel extends ArticleVendu {
	
	private ArticleVendu articleVendu;
	private Retrait retrait;
	private List<ArticleVendu> lstArticles = new ArrayList<>();
	
	
	
//	public NouvelleVenteModel(String nomArticle, String description, String miseAPrix, String prixVente,
//			String etatVente) {
//		super(nomArticle, description, miseAPrix, prixVente, etatVente);
//	}

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

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait model) {
		this.retrait = model;
	}

	public List<ArticleVendu> getLstArticles() {
		return lstArticles;
	}

	public void setLstArticles(List<ArticleVendu> lstArticles) {
		this.lstArticles = lstArticles;
	}

	

	
	
	

}
