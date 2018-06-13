package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import model.ChartPoint;

public class ChartPanel extends JPanel {
	
	private JLabel scaleSize;
	
	public ChartPanel(List<ChartPoint> scores) {
		setPreferredSize(new Dimension(400, 300));
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		scaleSize = new JLabel("Масштаб 1,00 : 1");	
		
		ChartComponent chartComponent = new ChartComponent(scores, this);
		layout.putConstraint(SpringLayout.NORTH, this,
                -5,
                SpringLayout.NORTH, chartComponent);
		
		
		//add(scaleSize);
		add(new JScrollPane(chartComponent));
	}
	
	public void updateScaleSize(String text) {
		scaleSize.setText(text);
	}
}
