package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseWheelEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.ChartPoint;

public class ChartComponent extends JPanel {

	private JLabel scaleSize;
	private int padding = 25;
	private int labelPadding = 25;
	private Color lineColor = new Color(44, 102, 230, 180);
	private Color pointColor = new Color(100, 100, 100, 180);
	private Color gridColor = new Color(200, 200, 200, 200);
	private static final Stroke GRAPH_STROKE = new BasicStroke(2f);
	private int pointWidth = 4;
	private int numberYDivisions = 10;
	private int numberXDivisions = 10;
	private List<ChartPoint> scores;
	public boolean ctrlIsPressed = false;
	private double scale = 2;

	public ChartComponent(List<ChartPoint> scores) {
		this.scores = scores;
		scaleSize = new JLabel("������� 1,00 : 1");
		add(scaleSize);
		setPreferredSize(new Dimension(300, 300));
		action();
	}

	@Override
	protected void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		double xScale = ((double) getWidth() - (2 * padding) - labelPadding) / 0.5;
		double yScale = ((double) getHeight() - 2 * padding - labelPadding) / (getMaxScore() - getMinScore());

		List<Point> graphPoints = new ArrayList<>();
		for (int el = 0; el < scores.size(); el++) {
			int x1 = (int) Math.ceil(scores.get(el).getX() * xScale + padding + labelPadding);
			int y1 = (int) Math.ceil((getMaxScore() - scores.get(el).getY()) * yScale + padding);
			graphPoints.add(new Point(x1, y1));
		}

		g2.setColor(Color.WHITE);
		g2.fillRect(padding + labelPadding, padding, getWidth() - (2 * padding) - labelPadding,
				getHeight() - 2 * padding - labelPadding);
		g2.setColor(Color.BLACK);

		for (int yDiv = 0; yDiv < numberYDivisions + 1; yDiv++) {
			int x0 = padding + labelPadding;
			int x1 = pointWidth + padding + labelPadding;
			int y0 = getHeight() - ((yDiv * (getHeight() - padding * 2 - labelPadding)) / numberYDivisions + padding + labelPadding);
			int y1 = y0;

			g2.setColor(gridColor);
			g2.drawLine(padding + labelPadding + 1 + pointWidth, y0, getWidth() - padding, y1);
			g2.setColor(Color.BLACK);
			String yLabel;
			if (scores.size() > 0) {
				yLabel = ((int) ((getMinScore() + (getMaxScore() - getMinScore()) * ((yDiv * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
			}
			else {
				yLabel = ((int) ((0 + (1) * ((yDiv * 1.0) / numberYDivisions)) * 100)) / 100.0 + "";
			}
			FontMetrics metrics = g2.getFontMetrics();
			int labelWidth = metrics.stringWidth(yLabel);
			g2.drawString(yLabel, x0 - labelWidth - 5, y0 + (metrics.getHeight() / 2) - 3);

			g2.drawLine(x0, y0, x1, y1);
		}

		double xNum = 0.0;

		for (int xDiv = 0; xDiv < numberXDivisions; xDiv++) {
			int x0 = xDiv * (getWidth() - padding * 2 - labelPadding) / (11 - 1) + padding + labelPadding;
			int x1 = x0;
			int y0 = getHeight() - padding - labelPadding;
			int y1 = y0 - pointWidth;
			if ((xDiv % ((int) ((11 / 20.0)) + 1)) == 0) {
				g2.setColor(gridColor);
				g2.drawLine(x0, getHeight() - padding - labelPadding - 1 - pointWidth, x1, padding);
				g2.setColor(Color.BLACK);
				String xLabel = new DecimalFormat("#0.00").format(xNum) + "";
				FontMetrics metrics = g2.getFontMetrics();
				int labelWidth = metrics.stringWidth(xLabel);
				g2.drawString(xLabel, x0 - labelWidth / 2, y0 + metrics.getHeight() + 3);
				xNum += 0.05;
			}
			g2.drawLine(x0, y0, x1, y1);
		}

		g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, padding + labelPadding, padding);
		g2.drawLine(padding + labelPadding, getHeight() - padding - labelPadding, getWidth() - padding,
				getHeight() - padding - labelPadding);

		Stroke oldStroke = g2.getStroke();
		g2.setColor(lineColor);
		g2.setStroke(GRAPH_STROKE);

		for (int pointNum = 0; pointNum < graphPoints.size() - 1; pointNum++) {
			Point point = graphPoints.get(pointNum);
			int x1 = (int) (point.getX());
			int y1 = (int) point.getY();
			Point point2 = graphPoints.get(pointNum + 1);
			int x2 = (int) point2.getX();
			int y2 = (int) point2.getY();
			g2.drawLine(x1, y1, x2, y2);
		}

		g2.setStroke(oldStroke);
		g2.setColor(pointColor);
		for (int pointNum = 0; pointNum < graphPoints.size(); pointNum++) {
			Point point = graphPoints.get(pointNum);
			int x = (int) Math.ceil(point.getX() - pointWidth / 2);
			int y = (int) Math.ceil(point.getY() - pointWidth / 2);
			int ovalW = pointWidth;
			int ovalH = pointWidth;
			g2.fillOval(x, y, ovalW, ovalH);
		}

	}

	public double getScale() {
		return scale;
	}

	private void action() {
		addMouseWheelListener(new MouseAdapter() {
			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (scale >= 2 && scale <= 8 && e.getModifiers() == InputEvent.CTRL_MASK) {
					double delta = 0.05f * e.getPreciseWheelRotation();
					scale += delta;
					if (scale < 2) {
						scale = 2;
					}
					if (scale > 8) {
						scale = 8;
					}
				}
				scaleSize.setText("������� " + String.format("%.2f", scale / 2) + " : 1");
				revalidate();
				repaint();
			}
		});
	}

	@Override
	public Dimension getPreferredSize() {
		Dimension size = new Dimension(200, 200);
		size.width = (int) Math.round(size.width * scale);
		size.height = (int) Math.round(size.height * scale);
		return size;
	}

	private double getMinScore() {
		double minScore = Double.MAX_VALUE;
		for (ChartPoint score : scores) {
			minScore = Math.min(minScore, score.getY());
		}
		return minScore;
	}

	private double getMaxScore() {
		double maxScore = Double.MIN_VALUE;
		for (ChartPoint score : scores) {
			maxScore = Math.max(maxScore, score.getY());
		}
		return maxScore;
	}

	public void setScores(List<ChartPoint> scores) {
		this.scores = scores;
		invalidate();
		this.repaint();
	}

	public List<ChartPoint> getScores() {
		return scores;
	}

	@Override
	public void setFocusable(boolean b) {
		super.setFocusable(b);
	}

	public void updateChart() {
		this.update(getGraphics());
	}

}