package fr.eni.VenteEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.eni.VenteEnchere.bo.Ameublement;
import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Enchere;
import fr.eni.VenteEnchere.bo.Informatique;
import fr.eni.VenteEnchere.bo.SportEtLoisir;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.bo.Vetement;
import fr.eni.VenteEnchere.dal.DALException;
import fr.eni.VenteEnchere.dal.MethodDAO;

public class VenteEnchereJdbcImpl implements MethodDAO {

	/** requete utilisateurs **/
	private final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone,"
			+ "rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private final String UPDATE_UTILISATEUR = "UPDATE INTO UTILISATEURS SET pseudo=?, nom =?, prenom =?,email =?, telephone =?, rue =?, code_postal =? , ville=?"
			+ "	rue =? , code_postal =?, ville =?, mot_de_passe =? WHERE pseudo =?";
	private final String SELECT_BY_PSEUDO = " SELECT * FROM UTILISATEURS WHERE pseudo= ?";

	private final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE pseudo = ? ";

	private final String SELECT_ALL_UTILISATEURS = "SELECT * FROM UTILISATEURS";

	/** requete Articles **/
	private final String INSERT_ARTICLES_VENDUS = "INSERT INTO ARTICLES_VENDUS nom_article, description, date_debut_encheres,date_fin_encheres, prix_initial,"

			+ "prix_vente, no_uilisateur, no_categorie VALUES (?,?,?,?,?,?,?,?)";
	private final String UPDATE_ARTICLES_VENDUS = "UPDATE INTO ARTICLES_VENDUS SET nom =?, prenom =?,email =?, telephone =?,"
			+ "	rue =? , code_postal =?, ville =?, mot_de_passe =? WHERE pseudo =?";
	private final String DELETE_ARTICLES_VENDUS = "DELETE FROm ARTICLES_VENDUS WHERE pseudo = ? ";

	private final String SELECT_ALL_ARTICLES_VENDUS = "SELECT * FROM ARTICLES_VENDUS";

	/** requete enchere **/

	private final String INSERT_ENCHERE = "INSERT INTO ENCHERES (no_enchere,date_enchere,montant_enchere,no_article_no_utilisateur) VALUES (?,?,?,?,?)";

	private final String SELECT_ALL_ENCHERE = "SELECT * FROME ENCHERES";

	/** Method utilisateurs **/

	@Override
	public void insertUser(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
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
			if (rs.next()) {
				int id = rs.getInt(1);
				utilisateur.setNoUtilisateur(id);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Impossible d'inserer");
		}

	}

	@Override
	public Utilisateur selectByPseudo(String pseudo) throws DALException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_PSEUDO);
			pStmt.setString(1, "pseudo");
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postale");
				String ville = rs.getString("ville");

				utilisateur = new Utilisateur(nom, prenom, email, telephone, rue, codePostal, ville);
			}
		} catch (Exception e) {
			throw new DALException("Je ne trouve pas ce pseudo");
		}

		return utilisateur;
	}

	
	@Override
	public List<Utilisateur> getAll() throws DALException {
		List<Utilisateur> lstUsers = new ArrayList<Utilisateur>();
		try (Connection cnx = ConnectionProvider.getConnection();) {

			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_UTILISATEURS);

			while (rs.next()) {
				Integer noUtilisateur = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String codePostale = rs.getString("code_postal");
				String ville = rs.getString("ville");				
				String motDePasse = rs.getString("mot_de_passe");
				Integer credit = rs.getInt("credit");
				boolean administrateur = rs.getBoolean("administrateur");
				
				if (administrateur = true) {
					lstUsers.add(new Utilisateur(noUtilisateur,pseudo, nom, prenom, email, telephone, rue, codePostale,ville, motDePasse, credit, administrateur));
				}else lstUsers.add(new Utilisateur(noUtilisateur,pseudo, nom, prenom, email,telephone,rue,codePostale,ville, motDePasse, credit));
				

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Impossible de lire la base de donnee");
		}
		return lstUsers;
	}

	@Override
	public void updateUser(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getMotDePasse());
			pStmt.setString(6, utilisateur.getTelephone());
			pStmt.setString(7, utilisateur.getRue());
			pStmt.setString(8, utilisateur.getCodePostal());
			pStmt.setString(9, utilisateur.getVille());
			pStmt.executeUpdate();

		} catch (Exception e) {
			throw new DALException("impossible de modifier l'utilisaeur");
		}

	}

	@Override
	public void deleteUser(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE_UTILISATEUR);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.executeUpdate();

		} catch (Exception e) {
			throw new DALException("Impossible de supprimer cet utilisateur");
		}

	}

	/** Method articles **/

	@Override
	public void insertArticle(ArticleVendu articleVendu) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS,
					PreparedStatement.RETURN_GENERATED_KEYS);

			pStmt.setString(1, articleVendu.getNomArticle());
			pStmt.setString(2, articleVendu.getDescription());
			Timestamp timeStampStart = Timestamp.valueOf(
					articleVendu.getDateDebutEncheres().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			pStmt.setTimestamp(4, timeStampStart);
			Timestamp timeStampEnd = Timestamp.valueOf(
					articleVendu.getDateFinEncheres().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			pStmt.setTimestamp(5, timeStampEnd);
			pStmt.setString(5, articleVendu.getMiseAPrix());
			pStmt.setString(6, articleVendu.getPrixVente());
			pStmt.setString(7, articleVendu.getEtatVente());
			pStmt.executeUpdate();

			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				articleVendu.setNoArticle(id);

			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DALException("Impossible d'inserer");
		}
	}

	@Override
	public List<ArticleVendu> getAllArticle() throws DALException {
		List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection();) {

			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLES_VENDUS);

			while (rs.next()) {
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				String miseAPrix = rs.getString("mise_a_Prix");
				String prixVente = rs.getString("prix_de_vente");
				String etatVente = rs.getString("etat");
				String categorie = rs.getString("categorie").trim();
				ArticleVendu articleVendu = null;

				if (categorie.equalsIgnoreCase("sport") || categorie.equalsIgnoreCase("loisir")) {
					String sport = rs.getString("sport et loisir");
					articleVendu = new SportEtLoisir(nomArticle, description, miseAPrix, prixVente, etatVente, sport);
				}
				if (categorie.equalsIgnoreCase("ameublement")) {
					String ameublement = rs.getString("ameublement");
					articleVendu = new Ameublement(nomArticle, description, miseAPrix, prixVente, etatVente,
							ameublement);
				}
				if (categorie.equalsIgnoreCase("informatique")) {
					String informatique = rs.getString("informatique");
					articleVendu = new Informatique(nomArticle, description, miseAPrix, prixVente, etatVente,
							informatique);
				}
				if (categorie.equalsIgnoreCase("vetement")) {
					String vetement = rs.getString("vetement");
					articleVendu = new Vetement(nomArticle, description, miseAPrix, prixVente, etatVente, vetement);
				}

			}
		} catch (Exception e) {
			throw new DALException("Impossible de lire la base de donnee");
		}

		return lstArticles;
	}

	@Override
	public void updateArticle(ArticleVendu articleVendu) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_ARTICLES_VENDUS);
			pStmt.setString(1, articleVendu.getNomArticle());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setString(3, articleVendu.getMiseAPrix());
			pStmt.setString(4, articleVendu.getPrixVente());
			pStmt.setString(5, articleVendu.getEtatVente());
			pStmt.executeUpdate();

		} catch (Exception e) {
			throw new DALException("impossible de modifier l'article");
		}

	}

	@Override
	public void deleteArticle(ArticleVendu articleVendu) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE_ARTICLES_VENDUS);
			pStmt.setString(1, articleVendu.getNomArticle());
			pStmt.executeUpdate();

		} catch (Exception e) {
			throw new DALException("Impossible de supprimer cet article");
		}

	}

	/** Method Encheres **/

	@Override
	public void insertEnchere(Date dateEnchere, Integer montantEnchere, ArticleVendu articleVendu,
			Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ENCHERE);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, articleVendu.getNomArticle());
			pStmt.setString(3, articleVendu.getDescription());
			Timestamp timeStampStart = Timestamp.valueOf(
					articleVendu.getDateDebutEncheres().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			pStmt.setTimestamp(4, timeStampStart);
			Timestamp timeStampEnd = Timestamp.valueOf(
					articleVendu.getDateFinEncheres().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			pStmt.setTimestamp(5, timeStampEnd);
			pStmt.setString(6, articleVendu.getMiseAPrix());
			pStmt.setString(7, articleVendu.getPrixVente());
			pStmt.setString(8, articleVendu.getEtatVente());
			Enchere enchere = new Enchere();
			pStmt.setInt(9, enchere.getMontantEnchere());
			pStmt.executeUpdate();

		} catch (Exception e) {
			throw new DALException("impossible d'inserer l'enchere");
		}

	}

	@Override
	public List<Enchere> getAllEnchere() throws DALException {
		List<Enchere> lstEncheres = new ArrayList<Enchere>();
		try (Connection cnx = ConnectionProvider.getConnection();) {

			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ENCHERE);

			while (rs.next()) {

				LocalDateTime dateEnchere = rs.getTimestamp("date_enchere").toLocalDateTime();
				Integer montantEnchere = rs.getInt("montant_enchere");

				lstEncheres.add(new Enchere(dateEnchere, montantEnchere));

			}

		} catch (Exception e) {
			throw new DALException("Impossible de lire la base de donnee");
		}

		return lstEncheres;
	}

}
