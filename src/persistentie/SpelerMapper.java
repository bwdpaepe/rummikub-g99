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

}
	