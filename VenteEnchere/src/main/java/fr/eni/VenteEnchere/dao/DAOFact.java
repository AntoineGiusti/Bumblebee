package fr.eni.VenteEnchere.dao;

public class DAOFact {
	public static MethodDAO getInstance() {
		return new EnchereDAOMock();
	}
}
