import java.awt.Font;

import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import PanelVote.PanelButtonMouseAdapter;

import javax.swing.SpringLayout;
import java.awt.Color;

public class PanelVoteUtilisateur extends JPanel {

		private JPanel contentPane;
		
		private Image img_Uni = new ImageIcon(Menu.class.getResource("Ressource/MondeUni.png")).getImage().getScaledInstance(75,75,Image.SCALE_SMOOTH);
		private Image img_direct = new ImageIcon(Menu.class.getResource("Ressource/direct.png")).getImage().getScaledInstance(75,100,Image.SCALE_SMOOTH);
		private Image img_global = new ImageIcon(Menu.class.getResource("Ressource/global.png")).getImage().getScaledInstance(75,75,Image.SCALE_SMOOTH);


		public PanelVoteUtilisateur() {
			setBackground(new Color(47, 79, 79));
			setForeground(new Color(47, 79, 79));
			setBounds(0 ,0, 805, 554);
			setLayout(null);
			
			JPanel paneMenuVoteUtilisateur = new JPanel();
			paneMenuVoteUtilisateur.setLayout(null);
			paneMenuVoteUtilisateur.setName("");
			paneMenuVoteUtilisateur.setBounds(52, 10, 700, 75);
			add(paneMenuVoteUtilisateur);
			
			JLabel lblNewLabel = new JLabel("Menu de Vote");
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
			lblNewLabel.setBounds(220, 10, 300, 55);
			paneMenuVoteUtilisateur.add(lblNewLabel);
			
			JPanel panelChoix1 = new JPanel();
			panelChoix1.setBounds(52, 95, 205, 245);
			add(panelChoix1);
			panelChoix1.setLayout(null);
			panelChoix1.addMouseListener(new PanelButtonMouseAdapter(panelChoix1));
			
			JLabel lblNewLabel_1 = new JLabel("Vladomir Palputin");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 23));
			lblNewLabel_1.setBounds(0, 50, 205, 31);
			panelChoix1.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("Monde Uni\r\n");
			lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 23));
			lblNewLabel_1_1.setBounds(0, 101, 205, 31);
			panelChoix1.add(lblNewLabel_1_1);
			
			JLabel lblMondeUni = new JLabel("");
			lblMondeUni.setBounds(70, 160, 75, 75);
			panelChoix1.add(lblMondeUni);
			lblMondeUni.setIcon(new ImageIcon(img_Uni));
			
			JPanel panelChoix2 = new JPanel();
			panelChoix2.setBounds(303, 95, 205, 245);
			add(panelChoix2);
			panelChoix2.setLayout(null);
			panelChoix2.addMouseListener(new PanelButtonMouseAdapter(panelChoix2));
			
			JLabel lblNewLabel_1_2 = new JLabel("Capitaine Killian");
			lblNewLabel_1_2.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_2.setFont(new Font("Arial", Font.BOLD, 23));
			lblNewLabel_1_2.setBounds(0, 48, 205, 31);
			panelChoix2.add(lblNewLabel_1_2);
			
			JLabel lblNewLabel_1_1_1 = new JLabel("Liste Le Direct");
			lblNewLabel_1_1_1.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 23));
			lblNewLabel_1_1_1.setBounds(0, 102, 205, 31);
			panelChoix2.add(lblNewLabel_1_1_1);
			
			JLabel lblDirect = new JLabel("");
			lblDirect.setHorizontalAlignment(SwingConstants.CENTER);
			lblDirect.setBounds(58, 143, 97, 92);
			panelChoix2.add(lblDirect);
			lblDirect.setIcon(new ImageIcon(img_direct));
			
			JPanel panelChoix3 = new JPanel();
			panelChoix3.setBounds(547, 95, 205, 245);
			add(panelChoix3);
			panelChoix3.setLayout(null);
			panelChoix3.addMouseListener(new PanelButtonMouseAdapter(panelChoix3));
			
			JLabel lblNewLabel_1_1_2 = new JLabel("Dojoe Triden");
			lblNewLabel_1_1_2.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 23));
			lblNewLabel_1_1_2.setBounds(0, 48, 205, 31);
			panelChoix3.add(lblNewLabel_1_1_2);
			
			JLabel lblNewLabel_1_1_3 = new JLabel("Global Party\r\n");
			lblNewLabel_1_1_3.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_3.setFont(new Font("Arial", Font.BOLD, 23));
			lblNewLabel_1_1_3.setBounds(0, 101, 205, 31);
			panelChoix3.add(lblNewLabel_1_1_3);
			
			JLabel lblglobal = new JLabel("");
			lblglobal.setHorizontalAlignment(SwingConstants.CENTER);
			lblglobal.setBounds(58, 142, 97, 92);
			panelChoix3.add(lblglobal);
			lblglobal.setIcon(new ImageIcon(img_global));
			
			JPanel panelBlanc = new JPanel();
			panelBlanc.setBounds(249, 360, 300, 55);
			add(panelBlanc);
			panelBlanc.setLayout(null);
			panelBlanc.addMouseListener(new PanelButtonMouseAdapter(panelBlanc));
			
			JLabel lblNewLabel_1_1_3_1 = new JLabel("Vote Blanc");
			lblNewLabel_1_1_3_1.setVerticalAlignment(SwingConstants.TOP);
			lblNewLabel_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_3_1.setFont(new Font("Arial", Font.BOLD, 24));
			lblNewLabel_1_1_3_1.setBounds(10, 10, 280, 35);
			panelBlanc.add(lblNewLabel_1_1_3_1);
			
			JPanel panelVoter = new JPanel();
			panelVoter.setBounds(137, 431, 525, 95);
			add(panelVoter);
			panelVoter.setLayout(null);
			panelVoter.addMouseListener(new PanelButtonMouseAdapter(panelVoter));
			
			JLabel lblNewLabel_1_1_3_1_1 = new JLabel("VOTER !");
			lblNewLabel_1_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1_1_3_1_1.setFont(new Font("Arial", Font.BOLD, 42));
			lblNewLabel_1_1_3_1_1.setBounds(10, 10, 505, 75);
			panelVoter.add(lblNewLabel_1_1_3_1_1);
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
				panel.setBackground(new Color(240, 240, 240));
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
