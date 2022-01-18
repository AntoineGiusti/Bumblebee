package fr.eni.VenteEnchere.dal;

import java.sql.Date;
import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Enchere;
import fr.eni.VenteEnchere.bo.Utilisateur;

public interface MethodDAO {

	/** Method utilisateur **/
	public void insertUser(Utilisateur utilisateur) throws DALException;
	public void updateUser(Utilisateur utilisateur)throws DALException;
	public void deleteUser (Utilisateur utilisateur)throws DALException;
	public List<Utilisateur> getAll () throws DALException;
	public Utilisateur selectById(Integer id)throws DALException;
		
	/** Method Article**/
	public void insertArticle(ArticleVendu articleVendu)throws DALException;
	public void updateArticle (ArticleVendu articleVendu)throws DALException;
	public void deleteArticle(ArticleVendu articleVendu)throws DALException;
	public List<ArticleVendu> getAllArticle () throws DALException;
	
	/**Method Enchere**/
	public void insertEnchere(Date dateEnchere, Integer montant_enchere, ArticleVendu articleVendu, Utilisateur utilisateur)throws DALException;
	public List<Enchere> getAllEnchere()throws DALException;
	
	
	
	
}
