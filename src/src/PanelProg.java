import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelProg extends JPanel {

	private JPanel contentPane;

	public PanelProg() {
		setBounds(0 ,0, 805, 554);
		
		JLabel lblNewLabel = new JLabel("PROG Page");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 42));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 116, 591, 290);
		add(lblNewLabel);
	}

}
