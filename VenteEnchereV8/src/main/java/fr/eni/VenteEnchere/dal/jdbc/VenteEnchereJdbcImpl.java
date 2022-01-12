package fr.eni.VenteEnchere.dal.jdbc;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.dal.DALException;
import fr.eni.VenteEnchere.dal.MethodDAO;

public class VenteEnchereJdbcImpl implements MethodDAO{ 
	
	/**Method utilisateurs **/
	private final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone,"
			+ "rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_UTILISATEUR = "UPDATE INTO UTILISATEURS SET nom =?, prenom =?,email =?, telephone =?,"
			+ "	rue =? , codePostal =?, ville =?, motDePasse =? WHERE pseudo =?";
	private final String DELETE_UTILISATEUR = "DELETE FROm UTILISATEUR WHERE pseudo = ? ";
	
	private final String SELECT_ALL_UTILISATEURS = "SELECT * FROM UTILISATEURS";
	
	/** Method Articles **/
	private final String INSERT_ARTICLES_VENDUS = "INSERT INTO ARTICLES_VENDUS noUtilisateur, pseudo, nom, prenom,email, telephone,"
			+ "rue, codePostal, ville, motDePasse, credit, administrateur";
	private final String UPDATE_ARTICLES_VENDUS = "UPDATE INTO ARTICLES_VENDUS SET nom =?, prenom =?,email =?, telephone =?,"
			+ "	rue =? , codePostal =?, ville =?, motDePasse =? WHERE pseudo =?";
	private final String DELETE_ARTICLES_VENDUS = "DELETE FROm ARTICLES_VENDUS WHERE pseudo = ? ";
	
	private final String SELECT_ALL_ARTICLES_VENDUS = "SELECT * FROM ARTICLES_VENDUS";
	
	

	
	/**Method utilisateurs**/
	
	@Override
	public void insertUser(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_UTILISATEUR, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getCredit());
			pStmt.setBoolean(11, utilisateur.isAdministrateur());
			pStmt.executeUpdate();
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				utilisateur.setNoUtilisateur(id);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Impossible d'inserer");
		}
		
	}
	
//	@Override
	public List<Utilisateur> getAll()throws DALException {
//		List<Utilisateur> lstUsers = new ArrayList<>();
//		try (Connection cnx = ConnectionProvider.getConnection()){
//			
//			Statement stmt = cnx.createStatement();
//			ResultSet rs = stmt.executeQuery(SELECT_ALL_UTILISATEURS);
//			
//			while (rs.next()){
//				Integer noUtilsateur = rs.getInt("numero utilisateur");
//				String pseudo = rs.getString("pseudo");
//				String nom = rs.getString("pseudo");
//				String prenom = rs.getString("pseudo");
//				String email = rs.getString("pseudo");
//				String  = rs.getString("pseudo");
//				String pseudo = rs.getString("pseudo");
//				
//				
//			}
//			
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		return null;}
//	}
	

	@Override
	public void updateUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		
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
