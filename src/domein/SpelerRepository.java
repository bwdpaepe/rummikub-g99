package domein;

import persistentie.SpelerMapper;

public class SpelerRepository {

	private SpelerMapper mapper;
	
	public SpelerRepository() {
		mapper = new SpelerMapper();
	}
	
	// vraag: op die manier heb ik toch in 1 keer speler gemaakt en geretourneert?
	public Speler zoekSpeler(String spelersnaam, String wachtwoord) {
		return mapper.geefSpeler(spelersnaam, wachtwoord); 
	}
	
}
