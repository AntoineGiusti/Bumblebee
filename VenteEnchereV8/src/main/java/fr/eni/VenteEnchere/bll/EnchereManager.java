/**
 * 
 */
package fr.eni.VenteEnchere.bll;

import java.sql.Date;
import java.time.LocalDate;

import fr.eni.VenteEnchere.bo.ArticleVendu;
import fr.eni.VenteEnchere.bo.Enchere;
import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.dal.DALException;
import fr.eni.VenteEnchere.dal.DAOFact;

/**
 * @author mmainguy2021
 *
 */
public class EnchereManager {

	/////////////////////singleton/////////////////
	
	private static class EnchereManagerHolder {
		private static EnchereManager instance = new EnchereManager();
	}
	
	private EnchereManager() { }
	
	public static EnchereManager getInstance() {
		return EnchereManagerHolder.instance;
	}
	
	

	////////////////////singleton//////////////////

	public void ajouterEnchere(LocalDate dateEnchere, Integer montantEnchere, ArticleVendu article, Utilisateur utilisateur) throws BLLException, DALException {
			Enchere enchere = new Enchere(dateEnchere, montantEnchere, article, utilisateur);
		DAOFact.getInstance().insertEnchere(enchere);

	}
}

