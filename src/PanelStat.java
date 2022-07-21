import java.awt.BorderLayout;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PanelStat extends JPanel {

	boolean toggled = false;
	
	static String url ="jdbc:mysql://team-rcv.com:16390/TP4";
	static String username = "etudiant2";
	static String password = "Luigi77";
	
	public int ID_vote = 1;
	
	CategoryDataset datasetBar = createDatasetBar();
	
    JFreeChart barChart = createbarChart(datasetBar);
    ChartPanel barChartPanel = new ChartPanel(barChart);
	
	DefaultPieDataset datasetPie = createDatasetPie();

    JFreeChart pieChart = createpieChart(datasetPie);
    ChartPanel pieChartPanel = new ChartPanel(pieChart);
	
	public PanelStat() {
		setBounds(0 ,0, 805, 554);
		
		//label titre STAT page
		/*
		JLabel lblNewLabel = new JLabel("STAT Page");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 42));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 116, 591, 290);
		add(lblNewLabel);
		*/
		
		SwitchChartButton();
		
        showBar(barChartPanel);
        
        validate();
    }
	
	public void SwitchChartButton() {
		JButton btnNewButton = new JButton("Switch chart");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				toggled = !toggled;
				if (toggled) {
					//remove(barChartPanel);
					barChartPanel.setVisible(false);
					showPie(pieChartPanel);
					pieChartPanel.setVisible(true);
				}
				else {
					//remove(pieChartPanel);
					pieChartPanel.setVisible(false);
					showBar(barChartPanel);
					barChartPanel.setVisible(true);
				}
				validate();
			}
		});
		add(btnNewButton);
	}
	
    private void showBar(ChartPanel chartPanel) {
    	//mise en page
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        //affichage
        add(chartPanel, BorderLayout.CENTER);
        //validate();
    }

    //création des données, à changer pour récupérer les données de la bdd
    private CategoryDataset createDatasetBar() {
    	
    	try(Connection c = DriverManager.getConnection(url,username,password)){
    		var dataset = new DefaultCategoryDataset();
    		Statement st = c.createStatement();
			ResultSet res = st.executeQuery("SELECT Nom_candidat, Prenom_candidat, COUNT(r.ID_candidat) as nb_vote FROM Candidats"
											+ " JOIN Resultat r"
											+ " ON Candidats.ID_candidat = r.ID_candidat"
											+ " AND ID_election =" + ID_vote
											+ " GROUP BY Nom_candidat;");
			while (res.next()) {
				dataset.addValue(res.getInt("nb_vote"), "votes", res.getString("Nom_candidat"));
			}	
			return dataset;
		}
		catch(SQLException e) {
			throw new IllegalStateException("Cannot connect to DB", e);
		}
    }

    //création du graphe
    private JFreeChart createbarChart(CategoryDataset dataset) {

        JFreeChart barChart = ChartFactory.createBarChart(
        		//titre
                "Nombre de vote",
                //titre de l'abscisse
                "",
                //titre de l'ordonnée 
                "votes",
                //données
                dataset,
                PlotOrientation.VERTICAL,
                false, true, false);

        return barChart;
    }
    
    private void showPie(ChartPanel chartPanel) {
        chartPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        chartPanel.setBackground(Color.white);
        add(chartPanel, BorderLayout.CENTER);
        //validate();
    }

    private DefaultPieDataset createDatasetPie() {

    	try(Connection c = DriverManager.getConnection(url,username,password)){
    		var dataset = new DefaultPieDataset();
    		Statement st = c.createStatement();
			ResultSet res = st.executeQuery("SELECT Nom_candidat, Prenom_candidat, COUNT(r.ID_candidat) as nb_vote FROM Candidats"
											+ " JOIN Resultat r"
											+ " ON Candidats.ID_candidat = r.ID_candidat"
											+ " AND ID_election =" + ID_vote
											+ " GROUP BY Nom_candidat;");
			while (res.next()) {
				dataset.setValue(res.getString("Nom_candidat"),res.getInt("nb_vote"));
			}	
			return dataset;
		}
		catch(SQLException e) {
			throw new IllegalStateException("Cannot connect to DB", e);
		}
    }

    private JFreeChart createpieChart(DefaultPieDataset dataset) {

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Nombre de vote",
                dataset,
                false, true, false);

        return pieChart;
    }
}
