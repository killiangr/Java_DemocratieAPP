import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class PanelProg extends JPanel {

	private JPanel contentPane;

	public PanelProg() {
		setBackground(new Color(47, 79, 79));
		setForeground(new Color(47, 79, 79));
		setBounds(0 ,0, 805, 554);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(110, 108, 608, 153);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Killian GRAINDORGE");
		lblNewLabel.setBounds(0, 10, 608, 54);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		//hyperlien
		final JLabel hyperlink = new JLabel("Programme du Candidat");
		hyperlink.setBounds(0, 101, 608, 54);
		panel.add(hyperlink);
		hyperlink.setForeground(new Color(0, 0, 255));
		hyperlink.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		//event listener
		hyperlink.addMouseListener(new MouseAdapter() {
			 
			//clic de souris
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                	hyperlink.setForeground(Color.BLUE.darker());
                    Desktop.getDesktop().browse(new URI("https://drive.google.com/file/d/1G-cyCICsETjwi9vs2UlkYHg4gQ-Vmqtr/view"));
                } catch (IOException | URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
 
            //curseur en dehors du lien
            @Override
            public void mouseExited(MouseEvent e) {
                hyperlink.setText("Programme du Candidat");
            }
 
            //curseur sur le lien
            @Override
            public void mouseEntered(MouseEvent e) {
                hyperlink.setText("<html><a href=''>" + "Programme du Candidat" + "</a></html>");
            }
 
        });
		
		//parametres d'apparence et de position
		hyperlink.setFont(new Font("Arial", Font.BOLD, 28));
		hyperlink.setHorizontalTextPosition(SwingConstants.CENTER);
		hyperlink.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblPartiPolitique = new JLabel("Parti Politique : Ceux qui Pique");
		lblPartiPolitique.setBounds(0, 55, 608, 54);
		panel.add(lblPartiPolitique);
		lblPartiPolitique.setHorizontalTextPosition(SwingConstants.CENTER);
		lblPartiPolitique.setHorizontalAlignment(SwingConstants.CENTER);
		lblPartiPolitique.setFont(new Font("Arial", Font.BOLD, 28));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 785, 76);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Programmes des Candidats");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 34));
		lblNewLabel_1.setBounds(10, 10, 755, 56);
		panel_1.add(lblNewLabel_1);
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(109, 291, 609, 153);
		add(panel_2);
		
		JLabel lblJeanmichelLecannard = new JLabel("Jean-Michel LECANNARD");
		lblJeanmichelLecannard.setHorizontalTextPosition(SwingConstants.CENTER);
		lblJeanmichelLecannard.setHorizontalAlignment(SwingConstants.CENTER);
		lblJeanmichelLecannard.setFont(new Font("Arial", Font.BOLD, 28));
		lblJeanmichelLecannard.setBounds(0, 10, 609, 54);
		panel_2.add(lblJeanmichelLecannard);
		
		JLabel hyperlink_1 = new JLabel("Programme du Candidat");
		hyperlink_1.setHorizontalTextPosition(SwingConstants.CENTER);
		hyperlink_1.setHorizontalAlignment(SwingConstants.CENTER);
		hyperlink_1.setForeground(Color.BLUE);
		hyperlink_1.setFont(new Font("Arial", Font.BOLD, 28));
		hyperlink_1.setBounds(0, 101, 609, 54);
		panel_2.add(hyperlink_1);
		
		//event listener
			hyperlink_1.addMouseListener(new MouseAdapter() {
					 
					//clic de souris
		            @Override
		            public void mouseClicked(MouseEvent e) {
		                try {
		                	hyperlink_1.setForeground(Color.BLUE.darker());
		                    Desktop.getDesktop().browse(new URI("https://www.youtube.com/watch?v=vdICniO6eTo&ab_channel=ROUENET"));
		                } catch (IOException | URISyntaxException e1) {
		                    e1.printStackTrace();
		                }
		            }
		 
		            //curseur en dehors du lien
		            @Override
		            public void mouseExited(MouseEvent e) {
		            	hyperlink_1.setText("Programme du Candidat");
		            }
		 
		            //curseur sur le lien
		            @Override
		            public void mouseEntered(MouseEvent e) {
		            	hyperlink_1.setText("<html><a href=''>" + "Programme du Candidat" + "</a></html>");
		            }
		 
		        });
				
				//parametres d'apparence et de position
				hyperlink_1.setFont(new Font("Arial", Font.BOLD, 28));
				hyperlink_1.setHorizontalTextPosition(SwingConstants.CENTER);
				hyperlink_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblLeRetourDe = new JLabel("Parti Politique : Le Retour de H");
		lblLeRetourDe.setHorizontalTextPosition(SwingConstants.CENTER);
		lblLeRetourDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblLeRetourDe.setFont(new Font("Arial", Font.BOLD, 28));
		lblLeRetourDe.setBounds(0, 55, 609, 54);
		panel_2.add(lblLeRetourDe);
	}
}
