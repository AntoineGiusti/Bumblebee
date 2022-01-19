/**
 * 
 */
package fr.eni.VenteEnchere.bll;

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
	
	public EnchereManager getInstance() {
		return EnchereManagerHolder.instance;
	}
	
	private EnchereManager() { }

	////////////////////singleton//////////////////

	private void modifPrixEnchere(Enchere montantEnchere) throws BLLException {
			try {
				DAOFact.getInstance().insertEnchere();
			} catch (DALException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

