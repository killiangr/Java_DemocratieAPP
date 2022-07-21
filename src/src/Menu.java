import java.awt.BorderLayout;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Menu extends JFrame {

	private JPanel contentPane;

	private Image img_logo = new ImageIcon(Menu.class.getResource("Ressource/profile.png")).getImage().getScaledInstance(150,150,Image.SCALE_SMOOTH);
	private Image img_home = new ImageIcon(Menu.class.getResource("Ressource/home.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_parametre = new ImageIcon(Menu.class.getResource("Ressource/parametre.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	private Image img_vote = new ImageIcon(Menu.class.getResource("Ressource/vote.png")).getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH);
	private Image img_prog = new ImageIcon(Menu.class.getResource("Ressource/text.png")).getImage().getScaledInstance(70,50,Image.SCALE_SMOOTH);
	private Image img_stat = new ImageIcon(Menu.class.getResource("Ressource/stat.png")).getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
	
	private PanelHome panelHome;
	private PanelUser panelUser;
	private PanelVote panelVote;
	private PanelProg panelProg;
	private PanelStat panelStat;
	private PanelVoteUtilisateur panelVoteU;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try { 
					Menu frame = new Menu();
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
	public Menu() {
		setLocationRelativeTo(null);
		setBackground(new Color(0, 128, 128));
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1180, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelHome = new PanelHome();
		panelUser = new PanelUser();
		panelVote = new PanelVote();
		panelProg = new PanelProg();
		panelStat = new PanelStat();
		panelVoteU = new PanelVoteUtilisateur();
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panelMenu.setBackground(new Color(47, 79, 79));
		panelMenu.setBounds(0, 0, 355, 600);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel LabelIcon = new JLabel("");
		LabelIcon.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelIcon.setHorizontalAlignment(SwingConstants.CENTER);
		LabelIcon.setBounds(10, 20, 330, 200);
		LabelIcon.setIcon(new ImageIcon(img_logo));
		panelMenu.add(LabelIcon);
		
		JPanel paneHome = new JPanel();
		paneHome.addMouseListener(new PanelButtonMouseAdapter(paneHome) {
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelHome);
			}
		});
		paneHome.setBackground(new Color(47, 79, 79));
		paneHome.setBorder(null);
		paneHome.setBounds(0, 250, 350, 70);
		panelMenu.add(paneHome);
		paneHome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ACCUEIL");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(82, 0, 268, 70);
		paneHome.add(lblNewLabel);
		
		JLabel LabelHome = new JLabel("");
		LabelHome.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelHome.setHorizontalAlignment(SwingConstants.CENTER);
		LabelHome.setBounds(0, 0, 70, 60);
		LabelHome.setIcon(new ImageIcon(img_home));
		paneHome.add(LabelHome);
		
		JPanel paneUser = new JPanel();
		paneUser.addMouseListener(new PanelButtonMouseAdapter(paneUser){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelUser);
			}
		});
		paneUser.setBackground(new Color(47, 79, 79));
		paneUser.setBorder(null);
		paneUser.setBounds(0, 320, 350, 70);
		panelMenu.add(paneUser);
		paneUser.setLayout(null);
		
		JLabel lblCompteUtilisateur = new JLabel("COMPTE UTILISATEUR\r\n");
		lblCompteUtilisateur.setForeground(new Color(255, 255, 255));
		lblCompteUtilisateur.setHorizontalTextPosition(SwingConstants.CENTER);
		lblCompteUtilisateur.setHorizontalAlignment(SwingConstants.LEFT);
		lblCompteUtilisateur.setFont(new Font("Dialog", Font.BOLD, 18));
		lblCompteUtilisateur.setBounds(82, 0, 268, 70);
		paneUser.add(lblCompteUtilisateur);
		
		JLabel LabelUser = new JLabel("");
		LabelUser.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelUser.setHorizontalAlignment(SwingConstants.CENTER);
		LabelUser.setBounds(2, 0, 70, 60);
		LabelUser.setIcon(new ImageIcon(img_parametre));
		paneUser.add(LabelUser);
		
		JPanel paneVote = new JPanel();
		paneVote.addMouseListener(new PanelButtonMouseAdapter(paneVote){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelVoteU);
			}
		});
		paneVote.setBackground(new Color(47, 79, 79));
		paneVote.setBorder(null);
		paneVote.setBounds(0, 390, 350, 70);
		panelMenu.add(paneVote);
		paneVote.setLayout(null);
		
		JLabel lblVoter = new JLabel("VOTER \u00C0 UNE ELECTION\r\n");
		lblVoter.setForeground(new Color(255, 255, 255));
		lblVoter.setHorizontalTextPosition(SwingConstants.CENTER);
		lblVoter.setHorizontalAlignment(SwingConstants.LEFT);
		lblVoter.setFont(new Font("Dialog", Font.BOLD, 18));
		lblVoter.setBounds(81, 0, 269, 70);
		paneVote.add(lblVoter);
		
		JLabel LabelVote = new JLabel("");
		LabelVote.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelVote.setHorizontalAlignment(SwingConstants.CENTER);
		LabelVote.setBounds(1, 0, 70, 60);
		LabelVote.setIcon(new ImageIcon(img_vote));
		paneVote.add(LabelVote);
		
		JPanel paneProg = new JPanel();
		paneProg.addMouseListener(new PanelButtonMouseAdapter(paneProg){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelProg);
			}
		});
		paneProg.setBackground(new Color(47, 79, 79));
		paneProg.setBorder(null);
		paneProg.setBounds(0, 460, 350, 70);
		panelMenu.add(paneProg);
		paneProg.setLayout(null);
		
		JLabel lblProgrammesCandidats = new JLabel("PROGRAMMES CANDIDATS");
		lblProgrammesCandidats.setForeground(new Color(255, 255, 255));
		lblProgrammesCandidats.setHorizontalTextPosition(SwingConstants.CENTER);
		lblProgrammesCandidats.setHorizontalAlignment(SwingConstants.LEFT);
		lblProgrammesCandidats.setFont(new Font("Dialog", Font.BOLD, 18));
		lblProgrammesCandidats.setBounds(80, 0, 270, 70);
		paneProg.add(lblProgrammesCandidats);
		
		JLabel LabelProg = new JLabel("");
		LabelProg.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelProg.setHorizontalAlignment(SwingConstants.CENTER);
		LabelProg.setBounds(0, 0, 70, 60);
		LabelProg.setIcon(new ImageIcon(img_prog));
		paneProg.add(LabelProg);
		
		JPanel paneStat = new JPanel();
		paneStat.addMouseListener(new PanelButtonMouseAdapter(paneStat){
			@Override
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelStat);
			}
		});
		paneStat.setBackground(new Color(47, 79, 79));
		paneStat.setBorder(null);
		paneStat.setBounds(0, 530, 350, 70);
		panelMenu.add(paneStat);
		paneStat.setLayout(null);
		
		JLabel lblResultatsElection = new JLabel("RESULTATS ELECTION");
		lblResultatsElection.setForeground(new Color(255, 255, 255));
		lblResultatsElection.setHorizontalTextPosition(SwingConstants.CENTER);
		lblResultatsElection.setHorizontalAlignment(SwingConstants.LEFT);
		lblResultatsElection.setFont(new Font("Dialog", Font.BOLD, 18));
		lblResultatsElection.setBounds(81, 0, 269, 70);
		paneStat.add(lblResultatsElection);
		
		JLabel LabelStat = new JLabel("");
		LabelStat.setHorizontalTextPosition(SwingConstants.CENTER);
		LabelStat.setHorizontalAlignment(SwingConstants.CENTER);
		LabelStat.setBounds(1, 0, 70, 60);
		LabelStat.setIcon(new ImageIcon(img_stat));
		paneStat.add(LabelStat);
		
		JLabel lblExit = new JLabel("X");
		lblExit.setBorder(null);
		lblExit.setForeground(new Color(255, 255, 255));
		lblExit.setHorizontalTextPosition(SwingConstants.CENTER);
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setFont(new Font("Arial", Font.BOLD, 24));
		lblExit.setBounds(1136, 0, 44, 47);
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(JOptionPane.showConfirmDialog(null,"Voulez vraiment quitter DemocratieAPP ?","Confirmation", JOptionPane.YES_NO_OPTION) == 0) {
					Menu.this.dispose();
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
		contentPane.add(lblExit);
		
		JPanel panel = new JPanel();
		panel.setBounds(365, 36, 805, 554);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(365, 36, 805, 554);
		contentPane.add(paneMainContent);
		paneMainContent.setLayout(null);
		
		
		paneMainContent.add(panelHome);
		paneMainContent.add(panelUser);
		paneMainContent.add(panelVote);
		paneMainContent.add(panelProg);
		paneMainContent.add(panelStat);
		paneMainContent.add(panelVoteU);
		
		menuClicked(panelHome);
	}
	
	public void menuClicked(JPanel panel) {
		panelHome.setVisible(false);
		panelUser.setVisible(false);
		panelVote.setVisible(false);
		panelProg.setVisible(false);
		panelStat.setVisible(false);
		panelVoteU.setVisible(false);
		
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
