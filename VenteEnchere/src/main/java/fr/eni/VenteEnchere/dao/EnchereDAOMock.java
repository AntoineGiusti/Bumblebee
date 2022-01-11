package fr.eni.VenteEnchere.dao;

import java.util.ArrayList;
import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Utilisateur;

public class EnchereDAOMock implements MethodDAO {
	
	/** Methode pour les utilisateurs **/
	
	List<Utilisateur> lstUser = new ArrayList<Utilisateur>();

	@Override
	public void insertUser(Utilisateur utilisateur) {
		lstUser.add(utilisateur);

	}

	@Override
	public void updateUser(Utilisateur utilisateur) {
		Utilisateur userUpdate = new Utilisateur();
		lstUser.add(userUpdate);

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
		ArticleVendu articleUpdate = new ArticleVendu();
		lstArticle.add(articleUpdate);

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
