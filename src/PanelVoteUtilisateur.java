import java.awt.Font;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;


import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;


public class PanelVoteUtilisateur extends JPanel {

		private JPanel contentPane;
		
		private JTextField TFSaisie;
		private JTable table;

		public int ID_vote = 1;	// a relier a la connection
		public int ID_elec = 13; // a relier a la connection

		public PanelVoteUtilisateur() {
			setBackground(new Color(47, 79, 79));
			setForeground(new Color(47, 79, 79));
			setBounds(0 ,0, 805, 554);
			setLayout(null);
			
			Vote vote = new Vote();
			vote.ID_vote = ID_vote;
			vote.ID_elec = ID_elec;
			vote.check_vote();
			
			JPanel paneMenuVoteUtilisateur = new JPanel();
			paneMenuVoteUtilisateur.setLayout(null);
			paneMenuVoteUtilisateur.setName("");
			paneMenuVoteUtilisateur.setBounds(52, 10, 700, 75);
			add(paneMenuVoteUtilisateur);
			
			try 
			  {
			      String url = "jdbc:mysql://team-rcv.com:16390/TP4";
			      String user = "etudiant2";
			      String password = "Luigi77";
			    
			      Connection con = DriverManager.getConnection(url, user, password);
			    
			      String query = "SELECT * FROM Candidats";
			    
			      Statement stm = con.createStatement();
			      ResultSet res = stm.executeQuery(query);
			    
			      String columns[] = { "ID_candidats", "Nom_candidat", "Prénom_candidat", "Parti_candidat" };
			      String data[][] = new String[20][4];
			      
			      int i = 0;
			      while (res.next()) {
			    	data[i][0] = String.valueOf(res.getInt("ID_candidat"));
			    	data[i][1] = res.getString("Nom_candidat");
			    	data[i][2] = res.getString("Prenom_candidat");
			    	data[i][3] = res.getString("Parti_candidat");
			        i++;
			      }
			    
			      DefaultTableModel model = new DefaultTableModel(data, columns);
			      JTable table = new JTable(model);
			      table.setBounds(352, 224, 400, 160);
			      add(table);
			      
			    
			    } catch(SQLException e) {
			      e.printStackTrace();
			    }
			
			JLabel lblNewLabel = new JLabel("Menu de Vote");
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
			lblNewLabel.setBounds(220, 10, 300, 55);
			paneMenuVoteUtilisateur.add(lblNewLabel);
			
			JPanel paneRegister = new JPanel();
			paneRegister.setName("");
			paneRegister.setBounds(42, 181, 300, 250);
			add(paneRegister);
			paneRegister.setLayout(null);
			
			JLabel lblDescription = new JLabel("Saisir l'ID du candidat pour voter :");
			lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescription.setHorizontalTextPosition(SwingConstants.CENTER);
			lblDescription.setFont(new Font("Arial", Font.BOLD, 16));
			lblDescription.setBounds(10, 38, 280, 50);
			paneRegister.add(lblDescription);
			
			TFSaisie = new JTextField();
			TFSaisie.setFont(new Font("Arial", Font.BOLD, 14));
			TFSaisie.setBounds(94, 112, 117, 38);
			paneRegister.add(TFSaisie);
			TFSaisie.setColumns(10);
			
			JLabel lblVoter = new JLabel("\u00C0 VOTER !");
			lblVoter.setHorizontalTextPosition(SwingConstants.CENTER);
			lblVoter.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lblVoter.setHorizontalAlignment(SwingConstants.CENTER);
			lblVoter.setFont(new Font("Arial", Font.BOLD, 14));
			lblVoter.setBounds(94, 188, 117, 52);
			paneRegister.add(lblVoter);
			lblVoter.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					if(JOptionPane.showConfirmDialog(null,"Voulez vraiment valider votre vote ?","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
						vote.ID = Integer.parseInt(TFSaisie.getText());
						if (vote.check_id()==false) {
							JOptionPane.showMessageDialog(null,"Le participant pour lequel vous voulez voter n'existe pas");
						}
						else {
							vote.check_vote();
						}	
					}
				}
				@Override
				public void mouseEntered(MouseEvent arg0) {
					lblVoter.setForeground(Color.RED);
				}
				@Override
				public void mouseExited(MouseEvent arg0) {
					lblVoter.setForeground(Color.BLACK);
				}
			});
			
		}
		
}
