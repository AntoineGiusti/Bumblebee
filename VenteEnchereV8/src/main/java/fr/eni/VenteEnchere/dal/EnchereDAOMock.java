package fr.eni.VenteEnchere.dal;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Enchere;
import fr.eni.VenteEnchere.bo.Utilisateur;

public class EnchereDAOMock implements MethodDAO {
	
	/** Methode pour les utilisateurs **/
	
	public static List<Utilisateur> lstUser = new ArrayList<Utilisateur>();

	@Override
	public void insertUser(Utilisateur utilisateur)throws DALException {
		try {
			lstUser.add(utilisateur);
			//System.out.println(lstUser);
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

	@Override
	public Utilisateur selectById(Integer pseudo) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertEnchere(Date dateEnchere, Integer montant_enchere, ArticleVendu articleVendu,
			Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
