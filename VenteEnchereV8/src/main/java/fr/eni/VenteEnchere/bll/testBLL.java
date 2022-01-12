package fr.eni.VenteEnchere.bll;

import fr.eni.VenteEnchere.bo.Utilisateur;

public class testBLL {

	
	public static void main(String[] args) {
		
		try {
			UtilisateurManager.getInstance().ajouterUtilisateur("blablza", "null", "null", "null", "null", "null", "32000", "null", "null", "null");
		
		System.out.println(UtilisateurManager.getInstance().listeUtilisateurs());
		} catch (BLLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
