package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class MainFrame extends JFrame {
	
	private JButton drawChart;
	
	public MainFrame() {
		setTitle("График функции");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new FlowLayout(FlowLayout.LEADING));
		setSize(new Dimension(450, 500));
		setResizable(false);
		
		drawChart = new JButton("Построить график");
		add(drawChart);
		createAndShowGui();
		action();
	}
	
    private void createAndShowGui() {
        List<Double> scores = new ArrayList<>();
        Random random = new Random();
        int maxDataPoints = 40;
        int maxScore = 10;
        for (int i = 0; i < maxDataPoints; i++) {
            scores.add((double) random.nextDouble() * maxScore);
//            scores.add((double) i);
        }
        ChartComponent mainPanel = new ChartComponent(scores);
        mainPanel.setPreferredSize(new Dimension(800, 600));
        getContentPane().add(mainPanel);
        
        repaint();
    }
    
    private void action() {
    	drawChart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				Thread chart = new Thread(new Runnable()
				{
					public void run() 
					{
						createAndShowGui();
					}
				});
				
				chart.start();
				
			}
		});
    }
	
}
