/**
 * 
 */
package fr.eni.VenteEnchere.bll;



/**
 * @author thamon2021
 *
 */
public class UtilisateurManager {

	/////////////////////singleton////////////////////
	
	private static class UtilisateurManagerHolder {
	private static UtilisateurManager instance = new UtilisateurManager();
	}
	
	private UtilisateurManager() { }
	
	public static UtilisateurManager getInstance() {
	return UtilisateurManagerHolder.instance;
	}
	
	///////////////////////////////////////////////////
	
	
}
