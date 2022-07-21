import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JPanel;

public class Electeur {

	static String url ="jdbc:mysql://team-rcv.com:16390/TP4";
	static String username = "etudiant2";
	static String password = "Luigi77";
	
	public String[] Electeur(int ID) {
		try(Connection c = DriverManager.getConnection(url,username,password)){
			String[] list = new String[5];
			Statement st = c.createStatement();
			ResultSet res = st.executeQuery("select E.*, V.Nom_ville"
											+ " from Electeur as E JOIN Ville as V"
											+ " where E.ID_ville= V.ID_ville and E.ID_electeur =" + ID + ";");
			while (res.next()) {
				list[0] = res.getString("Nom_electeur");
				list[1] = res.getString("Prenom_electeur");
				list[2] = res.getString("Nom_ville");
				list[3] = String.valueOf(res.getInt("num_electeur"));
				list[4] = String.valueOf(res.getLong("num_secu"));
			}
			return list;
		}
		catch(SQLException e) {
			throw new IllegalStateException("Cannot connect to DB", e);
		}
	}
}
	
