/**
 * 
 */
package fr.eni.VenteEnchere.bll;

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

	private Integer modifierPrixEnchere(Integer prixModifier) {
		return prixModifier;
	}
	
	private void meilleurNomAcheteur(String nomModifier) throws BLLException, DALException {
		DAOFact.getInstance().update(nomModifier);
		
		
	}
}
