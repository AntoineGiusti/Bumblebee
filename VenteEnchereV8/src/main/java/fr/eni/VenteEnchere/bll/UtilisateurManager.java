/**
 * 
 */
package fr.eni.VenteEnchere.bll;

import fr.eni.VenteEnchere.bo.Utilisateur;
import fr.eni.VenteEnchere.dal.DALException;
import fr.eni.VenteEnchere.dal.DAOFact;




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
	
	public void ajouterUtilisateur(String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String codePostal, String ville, String motDePasse) throws BLLException {
		
		Utilisateur utilisateur = null;
		
		BLLException be = new BLLException();

		verificationPseudo(pseudo, be);
		verificationNom(nom, be);
		verificationPrenom(prenom, be);
		verificationEmail(email, be);
		verificationTelephone(telephone, be);
		verificationRue(rue, be);
		verificationCodePostal(codePostal, be);
		verificationVille(ville, be);
		verificationMotDePasse(motDePasse, be);
		
		

		if (be.hasErreur()) {
			throw be;
		}
		
	
		utilisateur = new Utilisateur(pseudo, nom, prenom, email, telephone, rue, codePostal, ville, motDePasse);

		try {
            DAOFact.getInstance().insertUser(utilisateur);
        } catch (DALException e) {
            e.printStackTrace();
            throw new BLLException(e);
        }

	}
	
	////////////////////methode de verification////////////////
	
	//TODO verif pour doublon
	
	private void verificationPseudo(String pseudo, BLLException be) {
		if(pseudo == null || pseudo.isBlank() || pseudo.length() > 30) {
			be.ajouterErreur(new ParameterException("Le pseudo est obligatoire et doit etre <= 30"));
		}
	}
	
	private void verificationNom(String nom, BLLException be) {
		if(nom == null || nom.isBlank() || nom.length() > 30) {
			be.ajouterErreur(new ParameterException("Le nom est obligatoire et doit etre <= 30"));
		}
	}
	
	private void verificationPrenom(String prenom, BLLException be) {
		if(prenom == null || prenom.isBlank() || prenom.length() > 30) {
			be.ajouterErreur(new ParameterException("Le Prenom est obligatoire et doit etre <= 30"));
		}
	}
	
	private void verificationEmail(String email, BLLException be) {
		if(email == null || email.isBlank() || email.length() > 50) {
			be.ajouterErreur(new ParameterException("L'Email est obligatoire et doit etre <= 50"));
		}
	}
	
	private void verificationTelephone(String telephone, BLLException be) {
		if(telephone == null || telephone.isBlank() || telephone.length() > 15) {
			be.ajouterErreur(new ParameterException("Le telephone est obligatoire et doit etre <= 15"));
		}
	}
	
	private void verificationRue(String rue, BLLException be) {
		if(rue == null || rue.isBlank() || rue.length() > 30) {
			be.ajouterErreur(new ParameterException("La rue est obligatoire et doit etre <= 30"));
		}
	}
	
	
	private void verificationCodePostal(String codePostal, BLLException be) {
		if(codePostal == null || codePostal.isBlank() || codePostal.length() > 5) {
			be.ajouterErreur(new ParameterException("Le code postal est obligatoire et doit etre <= 5"));
		}
	}
	
	private void verificationVille(String ville, BLLException be) {
		if(ville == null || ville.isBlank() || ville.length() > 50) {
			be.ajouterErreur(new ParameterException("La ville est obligatoire et doit etre <= 50"));
		}
	}
	
	private void verificationMotDePasse(String motDePasse, BLLException be) {
		if(motDePasse == null || motDePasse.isBlank() || motDePasse.length() > 30) {
			be.ajouterErreur(new ParameterException("Le mot de passe est obligatoire et doit etre <= 30"));
		}
	}
	
	
}
