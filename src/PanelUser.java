import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;

public class PanelUser extends JPanel {

	private JPanel contentPane;
	public int ID_electeur;

	public PanelUser() {
		setBounds(0 ,0, 805, 554);
		setLayout(null);
		Electeur elec = new Electeur();
		
		ID_electeur = 3;
		
		String[] l_user = elec.Electeur(ID_electeur);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(0, 160, 257, 44);
		lblName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Dialog", Font.BOLD, 24));
		add(lblName);
		
		JLabel lblNewLabel = new JLabel("USER Page");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 42));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(267, 44, 229, 54);
		add(lblNewLabel);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSurname.setBounds(0, 214, 257, 44);
		add(lblSurname);
		
		JLabel lblElecterNumber = new JLabel("City");
		lblElecterNumber.setHorizontalTextPosition(SwingConstants.CENTER);
		lblElecterNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblElecterNumber.setFont(new Font("Dialog", Font.BOLD, 24));
		lblElecterNumber.setBounds(0, 268, 257, 44);
		add(lblElecterNumber);
		
		JPanel panel_green_1 = new JPanel();
		panel_green_1.setLayout(null);
		panel_green_1.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_green_1.setBackground(new Color(47, 79, 79));
		panel_green_1.setBounds(266, 160, 490, 44);
		add(panel_green_1);
		
		JLabel Var_name = new JLabel(l_user[0]);
		Var_name.setHorizontalTextPosition(SwingConstants.CENTER);
		Var_name.setHorizontalAlignment(SwingConstants.CENTER);
		Var_name.setForeground(new Color(50, 205, 50));
		Var_name.setFont(new Font("Arial", Font.BOLD, 24));
		Var_name.setBounds(10, 10, 470, 24);
		panel_green_1.add(Var_name);
		
		JPanel panel_green_2 = new JPanel();
		panel_green_2.setLayout(null);
		panel_green_2.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_green_2.setBackground(new Color(47, 79, 79));
		panel_green_2.setBounds(267, 214, 490, 44);
		add(panel_green_2);
		
		JLabel Var_surname = new JLabel(l_user[1]);
		Var_surname.setHorizontalTextPosition(SwingConstants.CENTER);
		Var_surname.setHorizontalAlignment(SwingConstants.CENTER);
		Var_surname.setForeground(new Color(50, 205, 50));
		Var_surname.setFont(new Font("Arial", Font.BOLD, 24));
		Var_surname.setBounds(10, 10, 470, 24);
		panel_green_2.add(Var_surname);
		
		JPanel panel_green_3 = new JPanel();
		panel_green_3.setLayout(null);
		panel_green_3.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_green_3.setBackground(new Color(47, 79, 79));
		panel_green_3.setBounds(267, 268, 490, 44);
		add(panel_green_3);
		
		JLabel Var_city = new JLabel(l_user[2]);
		Var_city.setHorizontalTextPosition(SwingConstants.CENTER);
		Var_city.setHorizontalAlignment(SwingConstants.CENTER);
		Var_city.setForeground(new Color(50, 205, 50));
		Var_city.setFont(new Font("Arial", Font.BOLD, 24));
		Var_city.setBounds(10, 10, 470, 24);
		panel_green_3.add(Var_city);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(586, 488, 170, 44);
		add(btnNewButton);
		
		JLabel lblSecurityNumber = new JLabel("Security number");
		lblSecurityNumber.setHorizontalTextPosition(SwingConstants.CENTER);
		lblSecurityNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecurityNumber.setFont(new Font("Dialog", Font.BOLD, 24));
		lblSecurityNumber.setBounds(0, 322, 257, 44);
		add(lblSecurityNumber);
		
		JLabel lblElecterNumber_2 = new JLabel("Electer number");
		lblElecterNumber_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblElecterNumber_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblElecterNumber_2.setFont(new Font("Dialog", Font.BOLD, 24));
		lblElecterNumber_2.setBounds(0, 372, 257, 44);
		add(lblElecterNumber_2);
		
		JPanel panel_green_4 = new JPanel();
		panel_green_4.setLayout(null);
		panel_green_4.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_green_4.setBackground(new Color(47, 79, 79));
		panel_green_4.setBounds(267, 322, 490, 44);
		add(panel_green_4);
		
		JLabel Var_nbr_sec = new JLabel(l_user[4]);
		Var_nbr_sec.setHorizontalTextPosition(SwingConstants.CENTER);
		Var_nbr_sec.setHorizontalAlignment(SwingConstants.CENTER);
		Var_nbr_sec.setForeground(new Color(50, 205, 50));
		Var_nbr_sec.setFont(new Font("Arial", Font.BOLD, 24));
		Var_nbr_sec.setBounds(10, 10, 470, 24);
		panel_green_4.add(Var_nbr_sec);
		
		JPanel panel_green_5 = new JPanel();
		panel_green_5.setLayout(null);
		panel_green_5.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel_green_5.setBackground(new Color(47, 79, 79));
		panel_green_5.setBounds(266, 376, 490, 44);
		add(panel_green_5);
		
		JLabel Var_nbr_elec = new JLabel(l_user[3]);
		Var_nbr_elec.setHorizontalTextPosition(SwingConstants.CENTER);
		Var_nbr_elec.setHorizontalAlignment(SwingConstants.CENTER);
		Var_nbr_elec.setForeground(new Color(50, 205, 50));
		Var_nbr_elec.setFont(new Font("Arial", Font.BOLD, 24));
		Var_nbr_elec.setBounds(10, 10, 470, 24);
		panel_green_5.add(Var_nbr_elec);
	}
}
