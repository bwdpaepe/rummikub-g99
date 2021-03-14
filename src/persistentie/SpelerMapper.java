package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domein.Speler;
	
public class SpelerMapper {
	/*
	public SpelerMapper() {
		
	} 
	
	public Speler zoekSpeler(String spelersnaam, String wachtwoord) {
		
		if(!(spelersnaam==null) && !spelersnaam.trim().isEmpty() && !(wachtwoord==null) && !wachtwoord.trim().isEmpty())
		{
		
			try(Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
                PreparedStatement query = conn.prepareStatement("SELECT COUNT(*) FROM ID344009_g99.speler WHERE spelersnaam = ? AND wachtwoord = ?"))
			{
				query.setString(1, spelersnaam);
				query.setString(2, wachtwoord);
				try(ResultSet rs = query.executeQuery())
				{
					rs.next();
					int count = rs.getInt(1);
					if(count == 1)
					{
						return (new Speler(spelersnaam, wachtwoord));
					}
					return null;
				}  
			}
			catch (SQLException ex)
			{
				throw new RuntimeException(ex);
			}
		}
		return null;
	}
*/
private List<Speler> spelers;
	
	public SpelerMapper() {
		// tijdelijk de methode laadSpelers gemaakt en aangeroepen om DB te simuleren 
		laadSpelers();
	} 
	
	// tijdelijke een lijst aangemaakt met spelers tot de databank link aanwezig is.
	public void laadSpelers(){
		//System.out.printf("Tijdelijk een databank geïnitialiseerd in de mapper. Te verwijderen na connectie met DB\n");
		List<Speler> spelerstemp = new ArrayList<Speler>();
		spelerstemp.add(new Speler("Joost", "test"));
		spelerstemp.add(new Speler("Bart", "Hogent"));
		spelerstemp.add(new Speler("Lynn", "Ugent"));
		spelerstemp.add(new Speler("Svetlana", "weg"));
		this.spelers = spelerstemp;
	}
	
	public Speler zoekSpeler(String spelersnaam, String wachtwoord) {
		for(Speler s:spelers) {
			// te wissen enkel voor demo
			//System.out.printf("test %s afgelopen via spelersmapper voor %s \n",s.getGebruikersnaam(), gebruikersnaam);
			if(s.getSpelersnaam().equals(spelersnaam) && s.getWachtwoord().equals(wachtwoord)) return s;
		}
		return null;
	}

}
	