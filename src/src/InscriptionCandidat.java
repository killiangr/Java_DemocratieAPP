import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscriptionCandidat extends JFrame {
	private Statement stmt;
	private JPanel contentPane;
	private JTextField texte_nom;
	private JTextField texte_prenom;
	private JTextField texte_Parti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionCandidat frame = new InscriptionCandidat();
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
	public InscriptionCandidat() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 555);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setFont(new Font("Arial", Font.BOLD, 20));
		lblExit.setBounds(650, -1, 33, 66);
		contentPane.add(lblExit);
		
		JPanel panel = new JPanel();
		panel.setBounds(97, 184, 481, 55);
		contentPane.add(panel);
		panel.setLayout(null);
		
		texte_nom = new JTextField();
		texte_nom.setBounds(349, 11, 122, 30);
		panel.add(texte_nom);
		texte_nom.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nom");
		lblNewLabel_1.setBounds(26, 11, 129, 33);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(201, 22, 255, 55);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inscription Candidat");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(31, 11, 202, 39);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(97, 262, 481, 55);
		contentPane.add(panel_2);
		
		texte_prenom = new JTextField();
		texte_prenom.setColumns(10);
		texte_prenom.setBounds(349, 11, 122, 30);
		panel_2.add(texte_prenom);
		
		JLabel lblNewLabel_1_1 = new JLabel("Prénom");
		lblNewLabel_1_1.setBounds(26, 11, 129, 33);
		panel_2.add(lblNewLabel_1_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBounds(97, 341, 481, 55);
		contentPane.add(panel_2_1);
		
		texte_Parti = new JTextField();
		texte_Parti.setColumns(10);
		texte_Parti.setBounds(349, 11, 122, 30);
		panel_2_1.add(texte_Parti);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Parti Candidat");
		lblNewLabel_1_1_1.setBounds(26, 11, 129, 33);
		panel_2_1.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton = new JButton("Inscription");
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
					String Nom_candidat=texte_nom.getText();
		        	String Prenom_candidat = texte_prenom.getText();
		        	String Parti_candidat = texte_Parti.getText();
		        		           
		        try{		
		        	String queryString="Insert into Candidats"+ "(Nom_candidat,Prenom_candidat,Parti_candidat)"+"Values"+"('"+Nom_candidat+"','"+Prenom_candidat+"','"+Parti_candidat+"')";
		            stmt.execute(queryString);
		            JOptionPane.showMessageDialog(null,"Candidat Ajouté");
		            
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
		btnNewButton.setBounds(68, 477, 89, 23);
		contentPane.add(btnNewButton);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Voulez vraiment quitter DemocratieAPP ?","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					InscriptionCandidat.this.dispose();
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
}
