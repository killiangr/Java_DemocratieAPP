import java.awt.BorderLayout;
import java.sql.*;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Inscription2 extends JFrame {
	private Statement stmt;

	private JPanel contentPane;
	private JTextField textNom;
	private JTextField textNumElecteur;
	private JTextField textMDP;
	private JTextField textSecu;
	private JTextField textVille;
	private JTextField textPrenom;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inscription2 frame = new Inscription2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Inscription2() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(265, 11, 263, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("INSCRIPTION ELECTEUR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 243, 32);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(139, 118, 389, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 5, 92, 29);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(139, 188, 389, 45);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Numéro Electeur");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 5, 92, 29);
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(139, 254, 389, 45);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Mot de Passe");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 5, 92, 29);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(139, 336, 389, 45);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Numéro Sécurité Sociale");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 5, 131, 29);
		panel_4.add(lblNewLabel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(524, 118, 172, 45);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		textNom = new JTextField();
		textNom.setBounds(8, 5, 154, 29);
		panel_5.add(textNom);
		textNom.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(524, 188, 172, 45);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		textNumElecteur = new JTextField();
		textNumElecteur.setBounds(8, 5, 154, 29);
		panel_6.add(textNumElecteur);
		textNumElecteur.setColumns(10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(524, 254, 172, 45);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		textMDP = new JTextField();
		textMDP.setBounds(8, 5, 154, 29);
		panel_7.add(textMDP);
		textMDP.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(524, 336, 172, 45);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		textSecu = new JTextField();
		textSecu.setBounds(8, 5, 154, 29);
		panel_8.add(textSecu);
		textSecu.setColumns(10);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(139, 399, 389, 45);
		contentPane.add(panel_10);
		panel_10.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("ID Ville");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(10, 11, 123, 23);
		panel_10.add(lblNewLabel_5);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(524, 399, 172, 45);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		textVille = new JTextField();
		textVille.setBounds(10, 5, 152, 29);
		panel_11.add(textVille);
		textVille.setColumns(10);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Arial", Font.BOLD, 20));
		lblExit.setBounds(767, -1, 33, 66);
		contentPane.add(lblExit);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(139, 469, 389, 45);
		contentPane.add(panel_12);
		panel_12.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Prénom");
		lblNewLabel_6.setBounds(10, 11, 86, 23);
		panel_12.add(lblNewLabel_6);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(524, 469, 172, 45);
		contentPane.add(panel_13);
		panel_13.setLayout(null);
		
		textPrenom = new JTextField();
		textPrenom.setBounds(10, 5, 160, 29);
		panel_13.add(textPrenom);
		textPrenom.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Modifier");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {            
		            
		            Class.forName("com.mysql.jdbc.Driver");
		            JOptionPane.showMessageDialog(null, "Driver Loaded");
		            Connection con = DriverManager.getConnection("jdbc:mysql://Team-rcv.com:16390/TP4","etudiant2","Luigi77");
		            JOptionPane.showMessageDialog(null, "Database Connected"); 
		            //this message appears when the user has established, thanks to the program, a connection with the database
		            stmt = con.createStatement();
		        }
		        catch (Exception ex)
		        {		            
		            //this message appears when it is not possible to have a connection with the Database or the Driver for some reason
		        }
				String Nom_electeur=textNom.getText();
				String Prenom_electeur=textPrenom.getText();
	        	String Num_electeur = textNumElecteur.getText();
	        	String Mdp_electeur = textMDP.getText();
	        	String Num_secu = textSecu.getText();
	        	String ID_ville = textVille.getText();	
		        try{
		        stmt.execute("Update Electeur set Prenom_electeur='"+ Prenom_electeur+"'"+"Where Nom_electeur='"+Nom_electeur+"'");
		        stmt.execute("Update Electeur set Num_electeur='"+ Num_electeur+"'"+"Where Nom_electeur='"+Nom_electeur+"'");
		        stmt.execute("Update Electeur set Mdp_electeur=SHA1('"+ Mdp_electeur+"')"+"Where Nom_electeur='"+Nom_electeur+"'");
		        stmt.execute("Update Electeur set Num_secu='"+ Num_secu+"'"+"Where Nom_electeur='"+Nom_electeur+"'");
		        stmt.execute("Update Electeur set ID_ville='"+ ID_ville+"'"+"Where Nom_electeur='"+Nom_electeur+"'");
		        JOptionPane.showMessageDialog(null,"MotDePasse Modifié");
		        Connexion3 J = new Connexion3();
                J.setVisible(true);
                this.setVisible( false );
		        }
		        catch(SQLException ex){
		            JOptionPane.showMessageDialog(null,ex);
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setBounds(278, 543, 112, 46);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("S'inscrire");
		btnNewButton.setBounds(139, 543, 112, 46);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Supprimer");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {            
		            
		            Class.forName("com.mysql.jdbc.Driver");
		            JOptionPane.showMessageDialog(null, "Driver Loaded");
		            Connection con = DriverManager.getConnection("jdbc:mysql://Team-rcv.com:16390/TP4","etudiant2","Luigi77");
		            JOptionPane.showMessageDialog(null, "Database Connected"); 
		            //this message appears when the user has established, thanks to the program, a connection with the database
		            stmt = con.createStatement();
		        }
		        catch (Exception ex)
		        {		            
		            //this message appears when it is not possible to have a connection with the Database or the Driver for some reason
		        }
				String Nom_electeur=textNom.getText();
				String Num_electeur=textNumElecteur.getText();
		           
		        try{		        	
		            String queryString="DELETE FROM Electeur WHERE Nom_electeur='" +Nom_electeur+"' and Num_electeur='" +Num_electeur+"';";
		            stmt.execute(queryString);
		            JOptionPane.showMessageDialog(null,"Electeur Supprimer");		            
		           
		        }
		        catch(SQLException ex){
		            
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_2.setBounds(438, 543, 112, 46);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Retour Menu");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEntrée J = new MenuEntrée();
                J.setVisible(true);
                this.setVisible( false );
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_3.setBounds(584, 543, 112, 46);
		contentPane.add(btnNewButton_3);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
		        {            
		            
		            Class.forName("com.mysql.jdbc.Driver");
		            JOptionPane.showMessageDialog(null, "Driver Loaded");
		            Connection con = DriverManager.getConnection("jdbc:mysql://Team-rcv.com:16390/TP4","etudiant2","Luigi77");
		            JOptionPane.showMessageDialog(null, "Database Connected"); 
		            //this message appears when the user has established, thanks to the program, a connection with the database
		            stmt = con.createStatement();
		        }
		        catch (Exception ex)
		        {		            
		            //this message appears when it is not possible to have a connection with the Database or the Driver for some reason
		        }
					String Nom_electeur=textNom.getText();
					String Prenom_electeur=textPrenom.getText();
		        	String Num_electeur = textNumElecteur.getText();
		        	String Mdp_electeur = textMDP.getText();
		        	String Num_secu = textSecu.getText();
		        	String ID_ville = textVille.getText();		           
		        try{		        	
		            String queryString="Insert into Electeur"+ "(Nom_electeur,Prenom_electeur,Num_secu,Num_electeur,Mdp_electeur,ID_ville)"+"Values"+"('"+Nom_electeur+"','"+Prenom_electeur+"','"+Num_secu+"','"+Num_electeur+"',SHA1('"+Mdp_electeur+"'),'"+ID_ville+"')";
		            stmt.execute(queryString);
		            JOptionPane.showMessageDialog(null,"New User Added");
		            
		            Connexion2 J = new Connexion2();
	                J.setVisible(true);
	                this.setVisible( false );
		        }
		        catch(SQLException ex){
		            
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Voulez vraiment quitter DemocratieAPP ?","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Inscription2.this.dispose();
				}
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
				lblExit.setForeground(Color.RED);
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				lblExit.setForeground(Color.WHITE);
			}
		});
		
	}
	
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel = panel;
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(47, 79, 79));
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(60, 179, 113));
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(112, 128, 144));
		}
		
	}
}
