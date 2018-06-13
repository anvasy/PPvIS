package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controller;
import model.ChartPoint;

public class MainFrame extends JFrame {

	private JButton drawChart;
	private JTextField nField;
	private Controller ctr;
	private ChartPanel mainPanel;
	private boolean isChart = false;

	public MainFrame() {
		setTitle("������ �������");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(new Dimension(430, 520));
		
		//setResizable(false);

		ctr = new Controller(this);
		
		JPanel pan = new JPanel();
		pan.setPreferredSize(new Dimension(400, 40));
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		drawChart = new JButton("��������� ������");
		JLabel nLabel = new JLabel("n: ");
		nField = new JTextField(7);
		nField.setText("5");

		pan.add(nLabel);
		pan.add(nField);
		pan.add(drawChart);
		add(pan);

		action();
	}

	private void createAndShowGui() {
		
		List<ChartPoint> scores = new ArrayList<>();
		try {
			scores = ctr.countCoordinates(Integer.valueOf(nField.getText()));
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "�������� �����.", "��������!", JOptionPane.INFORMATION_MESSAGE);
		}

		if (isChart) {
			remove(mainPanel);
			mainPanel = null;
			mainPanel = new ChartPanel(scores);
			mainPanel.setPreferredSize(new Dimension(300, 300));
			add(mainPanel);
			
		} else {
			mainPanel = new ChartPanel(scores);
			mainPanel.setPreferredSize(new Dimension(300, 300));
			isChart = true;
			add(mainPanel);
		}


		revalidate();
		repaint();
		
	}

	private void action() {
		drawChart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Thread chart = new Thread(new Runnable() {
					public void run() {
						createAndShowGui();;
					}
				});

				chart.start();

			}
		});
	}
	
	public void removeAllData() {
		
	}
	
	public void updateData(int index) {
		
	}

}
