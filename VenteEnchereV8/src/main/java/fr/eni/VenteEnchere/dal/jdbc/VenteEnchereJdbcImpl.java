package fr.eni.VenteEnchere.dal.jdbc;

import java.lang.reflect.Executable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	private final String UPDATE_UTILISATEUR = "UPDATE INTO UTILISATEURS SET pseudo=?, nom =?, prenom =?,email =?, telephone =?, rue =?, code_postal =? , ville=?"
			+ "	rue =? , codePostal =?, ville =?, motDePasse =? WHERE pseudo =?";
	private final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEUR WHERE pseudo = ? ";
	
	private final String SELECT_ALL_UTILISATEURS = "SELECT * FROM UTILISATEURS";
	
	/** Method Articles **/
	private final String INSERT_ARTICLES_VENDUS = "INSERT INTO ARTICLES_VENDUS nom_article, description, date_debut_encheres,date_fin_encheres, prix_initial,"
			+ "prix_vente, no_uilisateur, no_catégorie VALUES (?,?,?,?,?,?,?,?)";
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
	public List<Utilisateur> getAll() throws DALException {
		List<Utilisateur> lstUsers = new ArrayList<Utilisateur>();
		try (Connection cnx = ConnectionProvider.getConnection();){
			
		Statement stmt = cnx.createStatement();
		ResultSet rs = stmt.executeQuery(SELECT_ALL_UTILISATEURS);
		
		while (rs.next()) {
			String pseudo = rs.getString("pseudo");
			String nom = rs.getString("nom");
			String prenom = rs.getString("nom");			
			String email = rs.getString("email");
			String motDePasse = rs.getString("mot de passe");
			
		}
			
			
		} catch (Exception e) {
			throw new DALException("Impossible de lire la base de donnee");
		}				
	return lstUsers;
	}
	@Override
	public void updateUser(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();){
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2,utilisateur.getNom());
			pStmt.setString(3,utilisateur.getPrenom());
			pStmt.setString(4,utilisateur.getEmail());
			pStmt.setString(5,utilisateur.getTelephone());
			pStmt.setString(6,utilisateur.getRue());
			pStmt.setString(7,utilisateur.getCodePostal());	
			pStmt.setString(8,utilisateur.getVille());			
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			throw new DALException("impossible de modifier l'utilisaeur");
		}
		
		
	}

	@Override
	public void deleteUser(Utilisateur utilisateur)throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();){
			PreparedStatement pStmt = cnx.prepareStatement(DELETE_UTILISATEUR);
			pStmt.setString(1,utilisateur.getPseudo());
			pStmt.executeUpdate();
			
			
		} catch (Exception e) {
			throw new DALException("Impossible de supprimer cet utilisateur");
		}
		
		
	}

	

	/**Method articles**/
	
	@Override
	public void insertArticle(ArticleVendu articleVendu)  throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()){
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS, PreparedStatement.RETURN_GENERATED_KEYS);
			
			pStmt.setString(1, articleVendu.getNonArticle());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setDate(3,Date.valueOf(articleVendu.getDateDebutEncheres()) );
			pStmt.setDate(4,Date.valueOf( articleVendu.getDateFinEncheres()));
			pStmt.setString(5, articleVendu.getMiseAPrix());
			pStmt.setString(6, articleVendu.getPrixVente());
			pStmt.setString(7, articleVendu.getEtatVente());			
			pStmt.executeUpdate();
			
			ResultSet rs = pStmt.getGeneratedKeys();
			if(rs.next()) {
				int id = rs.getInt(1);
				articleVendu.setNoArticle(id);
			
		}
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DALException("Impossible d'inserer");
		}
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
