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
	
	public static EnchereManager getInstance() {
		return EnchereManagerHolder.instance;
	}
	
	private EnchereManager() { }

	////////////////////singleton//////////////////

	public void ajouterEnchere(String articleVendu, LocalDate dateEnchere, String montantEnchere, String utilisateur) throws BLLException, DALException {
			Enchere enchere = new Enchere();
		DAOFact.getInstance().insertEnchere(enchere);

	}
}

