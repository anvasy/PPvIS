package ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.Controller;
import controller.CustomMouseListener;

public class MainFrame extends JFrame implements KeyListener {

	private JButton drawChart;
	private JTextField nField;
	private Controller ctr;
	private ChartComponent mainPanel;
	private boolean isChart = false;
	private CustomMouseListener mListener;
	private CoordsTable table;

	public MainFrame() {
		setTitle("График функции");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setSize(new Dimension(430, 620));

		setResizable(false);
		addKeyListener(this);

		ctr = new Controller(this);

		JPanel pan = new JPanel();
		pan.setPreferredSize(new Dimension(400, 40));
		pan.setLayout(new FlowLayout(FlowLayout.CENTER));
		drawChart = new JButton("Построить график");
		JLabel nLabel = new JLabel("n: ");
		nField = new JTextField(7);
		nField.setText("1");
		table = new CoordsTable(ctr);

		pan.add(nLabel);
		pan.add(nField);
		pan.add(drawChart);

		add(pan);

		mainPanel = new ChartComponent(ctr);
		mainPanel.setPreferredSize(new Dimension(300, 300));
		JScrollPane scrolls = new JScrollPane(mainPanel);
		add(scrolls);

		mListener = new CustomMouseListener(scrolls, mainPanel);
		mainPanel.addMouseMotionListener(mListener);

		add(table.getPane());

		setFocusable(true);

		action();
	}

	private void action() {
		drawChart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Thread chart = new Thread(new Runnable() {
					public void run() {
						try {
							ctr.countPoints(Integer.valueOf(nField.getText()));
						} catch (Exception ex) {
							JOptionPane.showMessageDialog(MainFrame.this, "Неверное число.", "Внимание!",
									JOptionPane.INFORMATION_MESSAGE);
						}
						updateData();
						drawChart.setFocusable(false);
						table.getPane().setFocusable(false);
						MainFrame.this.setFocusable(true);
					}
				});
				chart.start();
			}
		});
	}

	public void updateData() {
		revalidate();
		repaint();
		mainPanel.updateChart();
		generateTable();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_CONTROL) {
			mainPanel.ctrlIsPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("here");
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_CONTROL) {
			mainPanel.ctrlIsPressed = false;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) { }

	public void generateTable() {
		table.addCoord();
		revalidate();
		repaint();
	}

}
