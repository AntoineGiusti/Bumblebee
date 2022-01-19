package fr.eni.VenteEnchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Categorie;
import fr.eni.VenteEnchere.bo.Enchere;
import fr.eni.VenteEnchere.bo.Retrait;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.dal.DALException;
import fr.eni.VenteEnchere.dal.MethodDAO;

/**
 * @author agiusti2021
 *
 */

public class VenteEnchereJdbcImpl implements MethodDAO {

	/** requete utilisateurs **/
	private final String INSERT_UTILISATEUR = "INSERT INTO UTILISATEURS (pseudo, nom, prenom, email, telephone,"
			+ "rue, code_postal, ville, mot_de_passe, credit, administrateur) VALUES(?,?,?,?,?,?,?,?,?,?,?)";

	private final String UPDATE_UTILISATEUR = "UPDATE UTILISATEURS SET pseudo=?, nom =?, prenom =?,email =?, telephone =?, rue =?, code_postal =? , ville=?,"
			+ "mot_de_passe =? WHERE no_utilisateur =?";	

	private final String SELECT_BY_ID = " SELECT * FROM UTILISATEURS WHERE no_utilisateur= ?";

	private final String DELETE_UTILISATEUR = "DELETE FROM UTILISATEURS WHERE no_utilisateur = ? ";

	private final String SELECT_ALL_UTILISATEURS = "SELECT * FROM UTILISATEURS";

	
	
	/** requete Articles **/
	private final String INSERT_ARTICLES_VENDUS = "INSERT INTO ARTICLES_VENDUS (nom_article, description ,date_debut_encheres, date_fin_encheres"

			+ ", prix_initial, no_utilisateur, no_categorie, prix_vente) VALUES (?,?,?,?,?,?,?,?)";
	
	private final String UPDATE_ARTICLES_VENDUS = "UPDATE INTO ARTICLES_VENDUS SET nom =?, prenom =?,email =?, telephone =?,"
			+ "	rue =? , code_postal =?, ville =?, mot_de_passe =? WHERE pseudo =?";
	
	private final String DELETE_ARTICLES_VENDUS = "DELETE FROM ARTICLES_VENDUS WHERE pseudo = ? ";

	private final String SELECT_ALL_ARTICLES_VENDUS = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres,"
			+ " prix_initial, prix_vente, no_utilisateur, ARTICLES_VENDUS.no_categorie, libelle"
			+ " FROM ARTICLES_VENDUS"
			+ " INNER JOIN CATEGORIES"
			+ " ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie";
	

	private final String UPDATE_ENCHERE = "UPDATE INTO ENCHERE SET montant_enchere = ? WHERE no_enchere = ?";

	private final String SELECT_ARTICLES_VENDUS_BYCATEGORIES = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres,"
			+ " prix_initial, prix_vente, no_utilisateur, ARTICLES_VENDUS.no_categorie, libelle"
			+ " FROM ARTICLES_VENDUS"
			+ " INNER JOIN CATEGORIES"
			+ " ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie"
			+ " WHERE ARTICLES_VENDUS.no_categorie = ?";
	
	private final static String SELECT_ART_BY_MOTCLE = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres,"
			+ " prix_initial, prix_vente, no_utilisateur, ARTICLES_VENDUS.no_categorie, libelle"
			+ " FROM ARTICLES_VENDUS"
			+ " INNER JOIN CATEGORIES"
			+ " ON ARTICLES_VENDUS.no_categorie = CATEGORIES.no_categorie"
			+ " WHERE nom_article LIKE ?";
	
		
	/** requete enchere **/

	private final String INSERT_ENCHERE = "INSERT INTO ENCHERES (no_enchere,date_enchere,montant_enchere,no_article_no_utilisateur) VALUES (?,?,?,?,?)";

	private final String SELECT_ALL_ENCHERE = "SELECT * FROM ENCHERES "
			+ "INNER JOIN UTILISATEURS ON ENCHERES.no_enchere = UTILISATEURS.no_utilisateur "
			+ "INNER JOIN ARTICLES_VENDUS ON ENCHERES.no_enchere = ARTICLES_VENDUS.vente_utilisateur ";

	
	
	
	/** Method utilisateurs **/

	/**
	 * method d'insertion des utilisateurs
	 */
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

	/**
	 * method de selection des donn�es d'un utilisateur en passant par son pseudo
	 */
	@Override
	public Utilisateur selectById(Integer noUtilisateur) throws DALException {
		Utilisateur utilisateur = null;
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_BY_ID);
			String noUtil = noUtilisateur.toString();
			pStmt.setString(1, noUtil);
			ResultSet rs = pStmt.executeQuery();
			while (rs.next()) {
				Integer id = rs.getInt("no_utilisateur");
				String pseudo = rs.getString("pseudo");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String email = rs.getString("email");
				String telephone = rs.getString("telephone");
				String rue = rs.getString("rue");
				String codePostal = rs.getString("code_postal");
				String ville = rs.getString("ville");
				String motDePasse = rs.getString("mot_de_passe");
				Integer credits = rs.getInt("credit");
				boolean administrateur = rs.getBoolean("administrateur");
			
				utilisateur = new Utilisateur(id, pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse, credits, administrateur);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Je ne trouve pas ce pseudo");
		}

		return utilisateur;
	}

	/**
	 * method pour afficher la liste des utilisateurs
	 */
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

				lstUsers.add(new Utilisateur(noUtilisateur, pseudo, nom, prenom, email, telephone, rue, codePostale,
						ville, motDePasse, credit, administrateur));

			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Impossible de lire la base de donnee");
		}
		return lstUsers;
	}

	/**
	 * method de modification des utilisateurs
	 */
	@Override
	public void updateUser(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_UTILISATEUR);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, utilisateur.getNom());
			pStmt.setString(3, utilisateur.getPrenom());
			pStmt.setString(4, utilisateur.getEmail());
			pStmt.setString(5, utilisateur.getTelephone());
			pStmt.setString(6, utilisateur.getRue());
			pStmt.setString(7, utilisateur.getCodePostal());
			pStmt.setString(8, utilisateur.getVille());
			pStmt.setString(9, utilisateur.getMotDePasse());
			pStmt.setInt(10, utilisateur.getNoUtilisateur());
			System.out.println(utilisateur);
			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("impossible de modifier l'utilisaeur");
		}

	}

	/**
	 * method de suppression d'un utilisateurs en passant par son pseudo
	 */
	@Override
	public void deleteUser(Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE_UTILISATEUR);
			pStmt.setInt(1, utilisateur.getNoUtilisateur());
			pStmt.executeUpdate();
			
			System.out.println("suppression passe par dao");

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Impossible de supprimer cet utilisateur");
		}

	}

	/** Method articles **/

	/**
	 * method d'insertion des articles
	 */
	@Override
	public void insertArticle(ArticleVendu articleVendu) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection()) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ARTICLES_VENDUS, PreparedStatement.RETURN_GENERATED_KEYS);
			
			System.out.println(articleVendu);
			
			pStmt.setString(1, articleVendu.getNomArticle());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setDate(3, Date.valueOf(articleVendu.getDateDebutEncheres()));
			pStmt.setDate(4, Date.valueOf(articleVendu.getDateFinEncheres()));
			pStmt.setInt(5, articleVendu.getMiseAPrix());
			pStmt.setInt(6, articleVendu.getutilisateur().getNoUtilisateur());
			pStmt.setInt(7, articleVendu.getCategorie().getNoCategorie());
			pStmt.setInt(8, articleVendu.getPrixVente());
			pStmt.executeUpdate();

			ResultSet rs = pStmt.getGeneratedKeys();
			if (rs.next()) {
				int id = rs.getInt(1);
				articleVendu.setNoArticle(id);

			}
		} catch (SQLException e) {

			e.printStackTrace();
			throw new DALException("Impossible d'inserer article");
		}
	}

	/**
	 * method d'affichage d'une liste d'article
	 */
	@Override
	public List<ArticleVendu> getAllArticle() throws DALException {
		List<ArticleVendu> lstArticles = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection();) {

			Statement stmt = cnx.createStatement();
			ResultSet rs = stmt.executeQuery(SELECT_ALL_ARTICLES_VENDUS);

			while (rs.next()) {
				
				Integer noArticle = rs.getInt("no_article");
				System.out.println(noArticle);
				
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutVente = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFinVente = rs.getDate("date_fin_encheres").toLocalDate();
				Integer miseInitial = rs.getInt("prix_initial");
				Integer prixVente = rs.getInt("prix_vente");
				Integer noUtilisateur = rs.getInt("no_utilisateur");
				Integer noCategorie = rs.getInt("no_categorie");
				
				Utilisateur utilisateur = selectById(noUtilisateur);
		
				String libelleCat = rs.getString("libelle");
				Categorie categorie = new Categorie(noCategorie, libelleCat);
				
				
				
				ArticleVendu articleVendu = new ArticleVendu(noArticle, nomArticle, description, 
						dateDebutVente, dateFinVente, miseInitial, prixVente, utilisateur, categorie);
						
				System.out.println(articleVendu);
				lstArticles.add(articleVendu);		
	
			}


		
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Impossible de lire la base de donnee");
		}

		return lstArticles;
	}
	
	
	public List<ArticleVendu> getArticleByCategotie(Integer no_categorieSelect) throws DALException {
		
		List<ArticleVendu> lstArticlesByCat = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_ARTICLES_VENDUS_BYCATEGORIES);
			pStmt.setInt(1, no_categorieSelect);
			ResultSet rs = pStmt.executeQuery();
			

			while (rs.next()) {
				
				Integer noArticle = rs.getInt("no_article");	
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutVente = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFinVente = rs.getDate("date_fin_encheres").toLocalDate();
				Integer miseInitial = rs.getInt("prix_initial");
				Integer prixVente = rs.getInt("prix_vente");
				Integer noUtilisateur = rs.getInt("no_utilisateur");
				Integer noCategorie = rs.getInt("no_categorie");
				
				Utilisateur utilisateur = selectById(noUtilisateur);
		
				String libelleCat = rs.getString("libelle");
				Categorie categorie = new Categorie(noCategorie, libelleCat);
				
				ArticleVendu articleVendu = new ArticleVendu(noArticle, nomArticle, description, 
						dateDebutVente, dateFinVente, miseInitial, prixVente, utilisateur, categorie);
						
				lstArticlesByCat.add(articleVendu);
				
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new DALException("Impossible de lire la base de donnee");
			}
		
		
		return lstArticlesByCat;
	}
	
	
	@Override
	public List<ArticleVendu> getArticleByMotClef(String motClef) throws DALException {
		
		List<ArticleVendu> lstArticlesByMotClef = new ArrayList<ArticleVendu>();
		try (Connection cnx = ConnectionProvider.getConnection();) {
			
			PreparedStatement pStmt = cnx.prepareStatement(SELECT_ART_BY_MOTCLE);
			pStmt.setString(1,'%'+motClef+'%');
			ResultSet rs = pStmt.executeQuery();
			
			
			
			while (rs.next()) {
				
				Integer noArticle = rs.getInt("no_article");	
				String nomArticle = rs.getString("nom_article");
				String description = rs.getString("description");
				LocalDate dateDebutVente = rs.getDate("date_debut_encheres").toLocalDate();
				LocalDate dateFinVente = rs.getDate("date_fin_encheres").toLocalDate();
				Integer miseInitial = rs.getInt("prix_initial");
				Integer prixVente = rs.getInt("prix_vente");
				Integer noUtilisateur = rs.getInt("no_utilisateur");
				Integer noCategorie = rs.getInt("no_categorie");
				
				Utilisateur utilisateur = selectById(noUtilisateur);
		
				String libelleCat = rs.getString("libelle");
				Categorie categorie = new Categorie(noCategorie, libelleCat);
				
				ArticleVendu articleVendu = new ArticleVendu(noArticle, nomArticle, description, 
						dateDebutVente, dateFinVente, miseInitial, prixVente, utilisateur, categorie);
						
				lstArticlesByMotClef.add(articleVendu);
				
			}
			
			} catch (Exception e) {
				e.printStackTrace();
				throw new DALException("Impossible de lire la base de donnee");
			}
		
		
		return lstArticlesByMotClef;
	}

	/**
	 * method de mise a jour des article
	 */
	@Override
	public void updateArticle(ArticleVendu articleVendu) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(UPDATE_ARTICLES_VENDUS);
			pStmt.setString(1, articleVendu.getNomArticle());
			pStmt.setString(2, articleVendu.getDescription());
			pStmt.setInt(3, articleVendu.getMiseAPrix());
			pStmt.setInt(4, articleVendu.getPrixVente());
			pStmt.setString(5, articleVendu.getEtatVente());
			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("impossible de modifier l'article");
		}

	}

	/**
	 * method de suppression d'un article par son nom
	 */
	@Override
	public void deleteArticle(ArticleVendu articleVendu) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(DELETE_ARTICLES_VENDUS);
			pStmt.setString(1, articleVendu.getNomArticle());
			pStmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("Impossible de supprimer cet article");
		}

	}

	/** Method Encheres **/

	/**
	 * method d'insertion d'une enchere
	 */
	@Override
	public void insertEnchere(Date dateEnchere, Integer montantEnchere, ArticleVendu articleVendu,
			Utilisateur utilisateur) throws DALException {
		try (Connection cnx = ConnectionProvider.getConnection();) {
			PreparedStatement pStmt = cnx.prepareStatement(INSERT_ENCHERE);
			pStmt.setString(1, utilisateur.getPseudo());
			pStmt.setString(2, articleVendu.getNomArticle());
			pStmt.setString(3, articleVendu.getDescription());
			Timestamp timeStampStart = Timestamp.valueOf(
					articleVendu.getDateDebutEncheres().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			pStmt.setTimestamp(4, timeStampStart);
			Timestamp timeStampEnd = Timestamp.valueOf(
					articleVendu.getDateFinEncheres().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
			pStmt.setTimestamp(5, timeStampEnd);
			pStmt.setInt(6, articleVendu.getMiseAPrix());
			pStmt.setInt(7, articleVendu.getPrixVente());
			pStmt.setString(8, articleVendu.getEtatVente());
			Enchere enchere = new Enchere();
			pStmt.setInt(9, enchere.getMontantEnchere());
			Retrait retrait = new Retrait();
			pStmt.setString(10, utilisateur.getRue() );
			pStmt.setString(11,utilisateur.getCodePostal());
			pStmt.setString(12, utilisateur.getVille());
			pStmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DALException("impossible d'inserer l'enchere");
		}

	}

	/**
	 * method d'affichage des encheres
	 */
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
			e.printStackTrace();
			throw new DALException("Impossible de lire la base de donnee");
		}

		return lstEncheres;
	}


	@Override
	public void insertEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}

	

	

	


}
