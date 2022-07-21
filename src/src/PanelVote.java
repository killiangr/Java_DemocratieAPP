import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class PanelVote extends JPanel {
	
	private PanelVoteUtilisateur panelVoteUtilisateur;

	private JPanel contentPane;

	public PanelVote() {
		setBackground(new Color(47, 79, 79));
		setBounds(0 ,0, 805, 554);
		setLayout(null);
		
		JPanel paneMenuVote = new JPanel();
		paneMenuVote.setName("");
		paneMenuVote.setBounds(52, 10, 700, 75);
		add(paneMenuVote);
		paneMenuVote.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Menu de Vote");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel.setBounds(220, 10, 300, 55);
		paneMenuVote.add(lblNewLabel);
		
		JPanel panePresid = new JPanel();
		panePresid.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panePresid.setBackground(new Color(47, 79, 79));
		panePresid.setBounds(112, 105, 600, 100);
		add(panePresid);
		panePresid.addMouseListener(new PanelButtonMouseAdapter(panePresid){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelVoteUtilisateur);
			}
		});;
		panePresid.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Election Pr\u00E9sidentielle (DISPONIBLE)");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1.setBounds(10, 10, 580, 80);
		panePresid.add(lblNewLabel_1);
		
		JPanel panelRegion = new JPanel();
		panelRegion.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panelRegion.setBackground(new Color(47, 79, 79));
		panelRegion.setBounds(112, 215, 600, 100);
		panelRegion.addMouseListener(new PanelButtonMouseAdapter(panelRegion));
		add(panelRegion);
		panelRegion.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Election R\u00E9gionale (INDISPONIBLE)");
		lblNewLabel_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1_1.setBounds(10, 10, 580, 80);
		panelRegion.add(lblNewLabel_1_1);
		
		JPanel paneDepartement = new JPanel();
		paneDepartement.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		paneDepartement.setBackground(new Color(47, 79, 79));
		paneDepartement.setBounds(112, 325, 600, 100);
		add(paneDepartement);
		paneDepartement.addMouseListener(new PanelButtonMouseAdapter(paneDepartement));
		paneDepartement.setLayout(null);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Election D\u00E9partementale (INDISPONIBLE)");
		lblNewLabel_1_1_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(220, 20, 60));
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1_1_1.setBounds(10, 10, 580, 80);
		paneDepartement.add(lblNewLabel_1_1_1);
		
		JPanel paneMunicip = new JPanel();
		paneMunicip.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		paneMunicip.setBackground(new Color(47, 79, 79));
		paneMunicip.setBounds(112, 435, 600, 100);
		paneMunicip.addMouseListener(new PanelButtonMouseAdapter(paneMunicip));
		add(paneMunicip);
		paneMunicip.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Election R\u00E9gionale (INDISPONIBLE)");
		lblNewLabel_1_1_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_2.setForeground(new Color(220, 20, 60));
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 24));
		lblNewLabel_1_1_2.setBounds(10, 10, 580, 80);
		paneMunicip.add(lblNewLabel_1_1_2);
	}
	
	public void menuClicked(JPanel panel) {
		panelVoteUtilisateur.setVisible(false);

		panel.setVisible(true);
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
