package fr.eni.VenteEnchere.dal;

public class DAOFact {
	public static MethodDAO getInstance() {
		return new EnchereDAOMock();
	}
}
