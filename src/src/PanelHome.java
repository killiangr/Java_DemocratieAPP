import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelHome extends JPanel {

	public PanelHome() {
		setBounds(0, 0, 805, 554);
		setLayout(null);
		setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Home Page");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 42));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 116, 591, 290);
		add(lblNewLabel);
	}
}
