package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SpringLayout;

import controller.CustomMouseListener;
import model.ChartPoint;

public class ChartPanel extends JPanel {
	
	private JLabel scaleSize;
	private int prevX, prevY;
	private JScrollPane scrolls; 
	ChartComponent chartComponent;
	
	public ChartPanel(List<ChartPoint> scores) {
		JPanel pan = new JPanel();
		pan.setLayout(new BoxLayout(pan, BoxLayout.Y_AXIS));
		setPreferredSize(new Dimension(400, 300));
		SpringLayout layout = new SpringLayout();
		setLayout(layout);
		scaleSize = new JLabel("Масштаб 1,00 : 1");	
		
		chartComponent = new ChartComponent(scores);
		layout.putConstraint(SpringLayout.NORTH, this,
                -5,
                SpringLayout.NORTH, chartComponent);
		
		scrolls = new JScrollPane(pan);
		
		pan.add(scaleSize);
		pan.add(chartComponent);
		add(scrolls);
		
		//action();
	}
	
	public JScrollPane getScrolls() {
		return scrolls;
	}
	
	public ChartComponent getChartComponent() {
		return chartComponent;
	}
	
	public void updateScaleSize(String text) {
		scaleSize.setText(text);
	}
}
