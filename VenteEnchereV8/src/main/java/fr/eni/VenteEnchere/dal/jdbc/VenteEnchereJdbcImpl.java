package fr.eni.VenteEnchere.dal.jdbc;

import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.dal.DALException;
import fr.eni.VenteEnchere.dal.MethodDAO;

public class VenteEnchereJdbcImpl implements MethodDAO{ 
	
	/**Method utilisateurs **/
	private final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS noUtilisateur, pseudo, nom, prenom,email, telephone,"
			+ "rue, codePostal, ville, motDePasse, credit, administrateur";
	private final String UPDATE_UTILISATEUR = "UPDATE INTO UTILISATEURS SET nom =?, prenom =?,email =?, telephone =?,"
			+ "	rue =? , codePostal =?, ville =?, motDePasse =? WHERE pseudo =?";

	
	/**Method utilisateurs**/
	
	@Override
	public void insertUser(Utilisateur utilisateur) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Utilisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**Method articles**/
	
	@Override
	public void insertArticle(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateArticle(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteArticle(ArticleVendu articleVendu) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ArticleVendu> getAllArticle() {
		// TODO Auto-generated method stub
		return null;
	}

}
