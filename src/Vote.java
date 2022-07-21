import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;  

import javax.swing.JOptionPane;

public class Vote {
	
	static String url ="jdbc:mysql://team-rcv.com:16390/TP4";
	static String username = "etudiant2";
	static String password = "Luigi77";
	
	public int ID;
	public int ID_elec;
	public int ID_vote;
	public int cpt = 0;

	public boolean check_id() {
		try(Connection c = DriverManager.getConnection(url,username,password)){
			int C_nb = 0;
			Statement st = c.createStatement();
			ResultSet res = st.executeQuery("SELECT COUNT(Nom_candidat) as C_nb FROM Candidats"
											+ " JOIN candidate c on Candidats.ID_candidat = c.ID_candidat"
											+ " WHERE ID_election =" + ID_vote + ";");
			while (res.next()) {
				C_nb = res.getInt("C_nb");
			}
			if (ID > C_nb)
				return false;
			else
				return true;	
		}
		catch(SQLException e) {
			throw new IllegalStateException("Cannot connect to DB", e);
		}
	}
	
	public void create_new_vote() {
		try(Connection c = DriverManager.getConnection(url,username,password)){
			Statement st = c.createStatement();
			st.executeUpdate("INSERT INTO vote (ID_election, ID_electeur, peut_voter, a_voter)"
					 		+ " VALUES(" + ID_vote + "," + ID_elec + ", 1, 0);");
		}
		catch(SQLException e) {
			throw new IllegalStateException("Cannot connect to DB", e);
		}
	}
	
	public void update_vote() {
		try(Connection c = DriverManager.getConnection(url,username,password)){
			 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			 Date date = new Date();  
			 java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			
			Statement st = c.createStatement();
			st.executeUpdate("UPDATE vote SET peut_voter = 0"
							+ " WHERE ID_election =" + ID_vote + " AND ID_electeur =" + ID_elec +";");
			
			Statement st2 = c.createStatement();
			st2.executeUpdate("UPDATE vote SET a_voter = 1"
							+ " WHERE ID_election =" + ID_vote + " AND ID_electeur =" + ID_elec +";");
			
			Statement st3 = c.createStatement();
			st3.executeUpdate("INSERT INTO Resultat (Date_vote, ID_candidat, ID_election)"
							 + " VALUES('" + formatter.format(sqlDate) + "'," + ID + "," + ID_vote + ");");
		}
		catch(SQLException e) {
			throw new IllegalStateException("Cannot connect to DB", e);
		}
	}
	
	public void check_vote() {
		try(Connection c = DriverManager.getConnection(url,username,password)){
			PreparedStatement st = c.prepareStatement("SELECT * FROM vote WHERE ID_election =" + ID_vote + " AND ID_electeur =" + ID_elec + ";");
			ResultSet res = st.executeQuery();
		
			if (res.next()) {
				int result = res.getInt("a_voter");
				if (result == 0) {
					update_vote();
					JOptionPane.showMessageDialog(null,"Vote bien enregistré");
				}
				else {
					if (cpt == 1)
						JOptionPane.showMessageDialog(null,"vous avez deja voté pour cette election");
				}					
			}
			else {
				create_new_vote();
			}
			cpt = 1;
		}
		catch(SQLException e) {
			throw new IllegalStateException("Cannot connect to DB", e);
		}
	}
	
	
}
