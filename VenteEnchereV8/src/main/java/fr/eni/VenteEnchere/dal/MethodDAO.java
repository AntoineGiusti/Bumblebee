package fr.eni.VenteEnchere.dal;

import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Utilisateur;

public interface MethodDAO {

	/** Method utilisateur **/
	public void insertUser(Utilisateur utilisateur) throws DALException;
	public void updateUser(Utilisateur utilisateur)throws DALException;
	public void deleteUser (Utilisateur utilisateur)throws DALException;
	public List<Utilisateur> getAll () throws DALException;
		
	/** Method Article**/
	public void insertArticle(ArticleVendu articleVendu)throws DALException;
	public void updateArticle (ArticleVendu articleVendu)throws DALException;
	public void deleteArticle(ArticleVendu articleVendu)throws DALException;
	public List<ArticleVendu> getAllArticle ();
	
}
