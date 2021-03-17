package domein;

import persistentie.SpelerMapper;

public class SpelerRepository {

	private SpelerMapper mapper;
	
	public SpelerRepository() {
		mapper = new SpelerMapper();
	}
	
	public Speler zoekSpeler(String spelersnaam, String wachtwoord) {
		return mapper.zoekSpeler(spelersnaam, wachtwoord); 
	}
	
}
