import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Inscription3 extends JFrame {
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
					Inscription3 frame = new Inscription3();
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
	public Inscription3() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100,800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(227, 11, 335, 54);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("INSCRIPTION ADMINISTATEUR");
		lblNewLabel_1.setBounds(23, 11, 290, 32);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(54, 203, 432, 63);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pseudo");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 88, 41);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(476, 203, 202, 63);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		textPseudo = new JTextField();
		textPseudo.setBounds(20, 11, 172, 41);
		panel_2.add(textPseudo);
		textPseudo.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(54, 300, 432, 63);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Mot De Passe");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(10, 11, 127, 41);
		panel_3.add(lblNewLabel_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(476, 300, 202, 63);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		textMDP = new JTextField();
		textMDP.setBounds(20, 5, 172, 47);
		panel_4.add(textMDP);
		textMDP.setColumns(10);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Arial", Font.BOLD, 20));
		lblExit.setForeground(Color.WHITE);
		lblExit.setBounds(767, 0, 33, 66);
		contentPane.add(lblExit);
		
		JButton btnNewButton = new JButton("S'inscrire");
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
					String Nom_admin=textPseudo.getText();
		        	String Mdp_electeur = textMDP.getText();
		        		           
		        try{		        	
		            String queryString="Insert into Administrateur"+ "(Pseudo_admin,Mdp_admin)"+"Values"+"('"+Nom_admin+"',SHA1('"+Mdp_electeur+"'))";
		            stmt.execute(queryString);
		            JOptionPane.showMessageDialog(null,"Admin Ajouté");
		            
		            Connexion3 J = new Connexion3();
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
		btnNewButton.setBounds(54, 454, 134, 54);
		contentPane.add(btnNewButton);
		
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
				String Nom_admin = textPseudo.getText();
		        String Mdp_admin = textMDP.getText();
		        try{
		        stmt.execute("Update Administrateur set Mdp_admin=SHA1('"+ Mdp_admin+"')"+"Where Pseudo_admin='"+Nom_admin+"'");
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
		btnNewButton_1.setBounds(227, 454, 134, 54);
		contentPane.add(btnNewButton_1);
		
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
					String Nom_admin=textPseudo.getText();		        	
		        		           
		        try{		        	
		            String queryString="DELETE FROM Administrateur WHERE Pseudo_admin='" +Nom_admin+"';";
		            stmt.execute(queryString);
		            JOptionPane.showMessageDialog(null,"Admin Supprimer");		            
		           
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
					Inscription3.this.dispose();
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
		
		btnNewButton_2.setBounds(391, 454, 134, 54);
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
		btnNewButton_3.setBounds(544, 454, 134, 54);
		contentPane.add(btnNewButton_3);
	}

}
