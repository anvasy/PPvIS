package controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class CustomMouseListener extends MouseAdapter {
	private int prevX, prevY;
	private JScrollPane scrolls;

	public CustomMouseListener(JScrollPane scrolls) {
		this.scrolls = scrolls;
	}
	
	@Override
	public void mouseDragged(MouseEvent e){
		super.mouseDragged(e);
		int dX = prevX - e.getX();
		int dY = prevY - e.getY();
	
		JScrollBar verticalScrollBar = scrolls.getVerticalScrollBar();
	
		verticalScrollBar.addAdjustmentListener(e1 -> { });
		JScrollBar horizontalScrollBar = scrolls.getHorizontalScrollBar();
		verticalScrollBar.setValue(verticalScrollBar.getValue() + dY);
		horizontalScrollBar.setValue(horizontalScrollBar.getValue() + dX);
	
		prevX = e.getX();
		prevY = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		prevX = e.getX();
		prevY = e.getY();
	}
}
