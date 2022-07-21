import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Connexion3 extends JFrame {
	private Statement stmt;

	private JPanel contentPane;
	private JTextField textPseudo;
	private JTextField textMDP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion3 frame = new Connexion3();
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
	public Connexion3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(267, 11, 214, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CONNEXION AD");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 214, 35);
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(142, 183, 266, 52);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Pseudo");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(27, 11, 102, 30);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(406, 183, 135, 52);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textPseudo = new JTextField();
		textPseudo.setBounds(10, 5, 115, 36);
		panel_2.add(textPseudo);
		textPseudo.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(142, 276, 266, 52);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mot De Passe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 11, 152, 30);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(406, 276, 135, 52);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		textMDP = new JTextField();
		textMDP.setBounds(10, 5, 115, 36);
		panel_4.add(textMDP);
		textMDP.setColumns(10);
		
		JButton btnNewButton = new JButton("Connexion Inscription ad");
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
		            JOptionPane.showMessageDialog(null, "Error" + ex);
		            //this message appears when it is not possible to have a connection with the Database or the Driver for some reason
		        }
				String Pseudo= textPseudo.getText();
				String Mdp= textMDP.getText();
		        	        
		        
		        try
		        {
		            String queryString="Select * from Administrateur where Pseudo_admin='" +Pseudo+ "'and Mdp_admin=SHA1('"+Mdp+"')";
		            ResultSet rset= stmt.executeQuery(queryString);
		            
		            
		            if (rset.next() && Pseudo.equals(Pseudo) && Mdp.equals(Mdp))
		            {
		                String Pseudo_admin = rset.getString(1);		               
		                String Mdp_admin = rset.getString(2);		                
		                JOptionPane.showMessageDialog( null , "Welcome " +  Pseudo_admin);
		                
		                Inscription3 J = new Inscription3();
		                J.setVisible(true);
		                this.setVisible( false );
		                
		            }
		            else
		            {
		                JOptionPane.showMessageDialog (null, "Wrong User or Password" );
		                textPseudo.setText(""); 
		                textMDP.setText("");	                
		                		               
		            }
		            rset.close ();
		        }
		        catch(SQLException ex)
		        {
		            JOptionPane.showMessageDialog(null,ex);
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBounds(10, 482, 197, 45);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Retour Menu");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEntrée J = new MenuEntrée();
                J.setVisible(true);
                this.setVisible( false );
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_1.setBounds(617, 482, 159, 45);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Connexion Appli");
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
		            JOptionPane.showMessageDialog(null, "Error" + ex);
		            //this message appears when it is not possible to have a connection with the Database or the Driver for some reason
		        }
				String Pseudo= textPseudo.getText();
				String Mdp= textMDP.getText();
		        	        
		        
		        try
		        {
		            String queryString="Select * from Administrateur where Pseudo_admin='" +Pseudo+ "'and Mdp_admin=SHA1('"+Mdp+"')";
		            ResultSet rset= stmt.executeQuery(queryString);
		            
		            
		            if (rset.next() && Pseudo.equals(Pseudo) && Mdp.equals(Mdp))
		            {
		                String Pseudo_admin = rset.getString(1);		               
		                String Mdp_admin = rset.getString(2);		                
		                JOptionPane.showMessageDialog( null , "Welcome " +  Pseudo_admin);
		                
		                Menu J = new Menu();
		                J.setVisible(true);
		                this.setVisible( false );
		                
		            }
		            else
		            {
		                JOptionPane.showMessageDialog (null, "Wrong User or Password" );
		                textPseudo.setText(""); 
		                textMDP.setText("");	                
		                		               
		            }
		            rset.close ();
		        }
		        catch(SQLException ex)
		        {
		            JOptionPane.showMessageDialog(null,ex);
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_2.setBounds(423, 482, 184, 45);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Connexion Inscription EL");
		btnNewButton_3.addActionListener(new ActionListener() {
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
		            JOptionPane.showMessageDialog(null, "Error" + ex);
		            //this message appears when it is not possible to have a connection with the Database or the Driver for some reason
		        }
				String Pseudo= textPseudo.getText();
				String Mdp= textMDP.getText();
		        	        
		        
		        try
		        {
		            String queryString="Select * from Administrateur where Pseudo_admin='" +Pseudo+ "'and Mdp_admin=SHA1('"+Mdp+"')";
		            ResultSet rset= stmt.executeQuery(queryString);
		            
		            
		            if (rset.next() && Pseudo.equals(Pseudo) && Mdp.equals(Mdp))
		            {
		                String Pseudo_admin = rset.getString(1);		               
		                String Mdp_admin = rset.getString(2);		                
		                JOptionPane.showMessageDialog( null , "Welcome " +  Pseudo_admin);
		                
		                Inscription2 J = new Inscription2();
		                J.setVisible(true);
		                this.setVisible( false );
		                
		            }
		            else
		            {
		                JOptionPane.showMessageDialog (null, "Wrong User or Password" );
		                textPseudo.setText(""); 
		                textMDP.setText("");	                
		                		               
		            }
		            rset.close ();
		        }
		        catch(SQLException ex)
		        {
		            JOptionPane.showMessageDialog(null,ex);
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton_3.setBounds(217, 482, 197, 45);
		contentPane.add(btnNewButton_3);
		
		JButton btnConnexionInscriptionCand = new JButton("Connexion Inscription Candidat");
		btnConnexionInscriptionCand.addActionListener(new ActionListener() {
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
		            JOptionPane.showMessageDialog(null, "Error" + ex);
		            //this message appears when it is not possible to have a connection with the Database or the Driver for some reason
		        }
				String Pseudo= textPseudo.getText();
				String Mdp= textMDP.getText();
		        	        
		        
		        try
		        {
		            String queryString="Select * from Administrateur where Pseudo_admin='" +Pseudo+ "'and Mdp_admin=SHA1('"+Mdp+"')";
		            ResultSet rset= stmt.executeQuery(queryString);
		            
		            
		            if (rset.next() && Pseudo.equals(Pseudo) && Mdp.equals(Mdp))
		            {
		                String Pseudo_admin = rset.getString(1);		               
		                String Mdp_admin = rset.getString(2);		                
		                JOptionPane.showMessageDialog( null , "Welcome " +  Pseudo_admin);
		                
		                InscriptionCandidat J = new InscriptionCandidat();
		                J.setVisible(true);
		                this.setVisible( false );
		                
		            }
		            else
		            {
		                JOptionPane.showMessageDialog (null, "Wrong User or Password" );
		                textPseudo.setText(""); 
		                textMDP.setText("");	                
		                		               
		            }
		            rset.close ();
		        }
		        catch(SQLException ex)
		        {
		            JOptionPane.showMessageDialog(null,ex);
		        }
			}

			private void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}
		});
		btnConnexionInscriptionCand.setBounds(10, 426, 197, 45);
		contentPane.add(btnConnexionInscriptionCand);
	}

}
