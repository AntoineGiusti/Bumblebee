package fr.eni.VenteEnchere.dal;

import fr.eni.VenteEnchere.dal.jdbc.VenteEnchereJdbcImpl;

public class DAOFact {
	public static MethodDAO getInstance() {
		return new VenteEnchereJdbcImpl();
	}
}
