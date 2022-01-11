package fr.eni.VenteEnchere.dal;

import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Utilisateur;

public interface MethodDAO {

	/** Method utilisateur **/
	public void insertUser(Utilisateur utilisateur);
	public void updateUser(Utilisateur utilisateur);
	public void deleteUser (Utilisateur utilisateur);
	public List<Utilisateur> getAll ();
		
	/** Method Article**/
	public void insertArticle(ArticleVendu articleVendu);
	public void updateArticle (ArticleVendu articleVendu);
	public void deleteArticle(ArticleVendu articleVendu);
	public List<ArticleVendu> getAllArticle ();
	
}
