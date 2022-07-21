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

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;


public class Connexion2 extends JFrame {
	private Statement stmt;

	private JPanel contentPane;
	private JTextField textNNom;
	private JTextField textNElecteur;
	private JTextField textNPass;
	private JTextField textNSecu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connexion2 frame = new Connexion2();
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
	public Connexion2() {
		setUndecorated(true);
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
		
		JLabel lblNewLabel = new JLabel("CONNEXION ELECTEUR");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(76, 93, 428, 66);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(10, 5, 119, 50);
		lblNewLabel_1.setFont(new Font("Calibri", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(500, 93, 166, 66);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textNNom = new JTextField();
		textNNom.setBounds(10, 11, 146, 44);
		panel_2.add(textNNom);
		textNNom.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(76, 271, 428, 66);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nouveau Mot De Passe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 5, 119, 50);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(500, 180, 166, 66);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		textNElecteur = new JTextField();
		textNElecteur.setBounds(10, 5, 146, 50);
		panel_4.add(textNElecteur);
		textNElecteur.setColumns(10);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(76, 180, 428, 66);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Numero Electeur");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 5, 119, 50);
		panel_6.add(lblNewLabel_3);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(500, 271, 166, 66);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		textNPass = new JTextField();
		textNPass.setBounds(10, 5, 146, 50);
		panel_7.add(textNPass);
		textNPass.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBounds(76, 365, 428, 66);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("Nouveau numéro Sécu");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(10, 5, 119, 50);
		panel_8.add(lblNewLabel_4);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(500, 365, 166, 66);
		contentPane.add(panel_9);
		panel_9.setLayout(null);
		
		textNSecu = new JTextField();
		textNSecu.setBounds(10, 5, 146, 50);
		panel_9.add(textNSecu);
		textNSecu.setColumns(10);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Arial", Font.BOLD, 20));
		lblExit.setForeground(Color.WHITE);
		lblExit.setBounds(767, 0, 33, 66);
		contentPane.add(lblExit);
		
		JButton btnNewButton_1 = new JButton("Connexion Appli");
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
		            JOptionPane.showMessageDialog(null, "Error" + ex);
		            //this message appears when it is not possible to have a connection with the Database or the Driver for some reason
		        }				
				String Nom= textNNom.getText();
				String Num_el= textNElecteur.getText();
		        String Mdp = textNPass.getText();
		        String Num_sec = textNPass.getText();
		        
		        
		        try
		        {
		            String queryString="Select * from Electeur where Nom_electeur='" +Nom+ "'and Num_electeur='"+Num_el+"'and Mdp_electeur=SHA1('"+Mdp+"')";
		            ResultSet rset= stmt.executeQuery(queryString);
		            
		            
		            if (rset.next() && Nom.equals(Nom) && Num_el.equals(Num_el)&& Mdp.equals(Mdp))
		            {
		                String Nom_electeur = rset.getString(1);
		                String Num_electeur = rset.getString(2);
		                String Mdp_electeur = rset.getString(3);
		                String Num_secu = rset.getString(4);
		                JOptionPane.showMessageDialog( null , "Welcome " +  Nom_electeur);
		                
		                Menu J = new Menu();
		                J.setVisible(true);
		                this.setVisible( false );
		                
		            }
		            else
		            {
		                JOptionPane.showMessageDialog (null, "Wrong User or Password" );
		                textNNom.setText(""); 
		                textNElecteur.setText("");
		                textNPass.setText("");
		                textNSecu.setText("");
		                		               
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
		btnNewButton_1.setBounds(76, 507, 146, 44);
		contentPane.add(btnNewButton_1);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Voulez vraiment quitter DemocratieAPP ?","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Connexion2.this.dispose();
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
		
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Voulez vraiment quitter DemocratieAPP ?","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Connexion2.this.dispose();
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
