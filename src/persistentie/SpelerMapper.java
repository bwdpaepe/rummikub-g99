package persistentie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import domein.Speler;
import exceptions.SpelerNietInDBException;
import talen.Language;
	
public class SpelerMapper {
	
	private Language language = Language.getInstance();
	
	public SpelerMapper() {
		
	} 
	
	public Speler zoekSpeler(String spelersnaam, String wachtwoord) throws SpelerNietInDBException {
		
		if(!(spelersnaam==null) && !spelersnaam.isBlank() && !(wachtwoord==null) && !wachtwoord.isBlank())
		{
		
			try(Connection conn = DriverManager.getConnection(Connectie.JDBC_URL);
//				PreparedStatement query = conn.prepareStatement("SELECT COUNT(*) FROM ID344009_g99.speler WHERE spelersnaam = ? AND wachtwoord = ?"))
                PreparedStatement query = conn.prepareStatement("SELECT spelersnaam, wachtwoord FROM ID344009_g99.speler WHERE spelersnaam = ? AND wachtwoord = ?"))
			{
				query.setString(1, spelersnaam);
				query.setString(2, wachtwoord);
				try(ResultSet rs = query.executeQuery())
				{
					//check als rs niet empty is
					if(rs.next()) {
						String naam = rs.getString(1);
						String ww = rs.getString(2);
						return new Speler(naam, ww);
					}
					throw new SpelerNietInDBException(String.format(language.getString("spelerNietInDB")));
					//throw new SpelerNietInDBException("De Speler/paswoord combinatie is niet aanwezig in de database!");
					
//					rs.next();
//					int count = rs.getInt(1);
//					if(count == 1)
//					{
//						return (new Speler(spelersnaam, wachtwoord));
//					}
//					return null;
				}  
			}
			catch (SQLException ex)
			{
				throw new RuntimeException(ex);
			}
		}
		return null;
	}

}
	