package domein;

import exceptions.SpelerNietInDBException;
import persistentie.SpelerMapper;

public class SpelerRepository {

	private SpelerMapper mapper;
	
	public SpelerRepository() {
		mapper = new SpelerMapper();
	}
	
	public Speler zoekSpeler(String spelersnaam, String wachtwoord) throws SpelerNietInDBException {
		return mapper.zoekSpeler(spelersnaam, wachtwoord); 
	}
	
}
