package fr.eni.VenteEnchere.dal;

import java.util.ArrayList;
import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Utilisateur;

public class EnchereDAOMock implements MethodDAO {
	
	/** Methode pour les utilisateurs **/
	
	List<Utilisateur> lstUser = new ArrayList<Utilisateur>();

	@Override
	public void insertUser(Utilisateur utilisateur)throws DALException {
		try {
			lstUser.add(utilisateur);
		} catch (Exception e) {
			throw new DALException(e.getMessage());
		}
		

	}

	@Override
	public void updateUser(Utilisateur utilisateur) {
		for (Utilisateur user : lstUser) {
			if (user.getNoUtilisateur()== utilisateur.getNoUtilisateur()) {
				user=utilisateur;
			}
		}
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) {
		lstUser.remove(utilisateur);

	}

	@Override
	public List<Utilisateur> getAll() {		
		return lstUser;
	}

	
	/** Method pour les Articles **/
	
	List<ArticleVendu> lstArticle = new ArrayList<ArticleVendu>();
		
	
	
	@Override
	public void insertArticle(ArticleVendu articleVendu) {
		lstArticle.add(articleVendu);
	}

	@Override
	public void updateArticle(ArticleVendu articleVendu) {
		for (ArticleVendu articles : lstArticle) {
			if (articles.getNoArticle()== articleVendu.getNoArticle()) {
				articles=articleVendu;
			}
		}

	}

	@Override
	public void deleteArticle(ArticleVendu articleVendu) {
		lstArticle.remove(articleVendu);		
	}

	@Override
	public List<ArticleVendu> getAllArticle() {		
		return lstArticle;
	}

}
