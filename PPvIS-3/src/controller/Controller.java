package controller;

import java.util.ArrayList;
import java.util.List;

import model.ChartPoint;
import model.CountCoordinates;
import ui.MainFrame;

public class Controller {

    private MainFrame mainFrame;
	double h = 0.01;	
    private CountCoordinates countCoords;

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.countCoords = new CountCoordinates();
    }
    
    public void countPoints(int n) {
    	getCoords().clear();
    	mainFrame.updateData();
    	
    	Thread counter = new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				double x = 0.0;
				double y = 0.0;
				mainFrame.buttonEnable(false);
				while (x < 0.51) {
					y = 0.0;
					for (int k = 0; k <= n; k++) {
						y += Math.pow(-1, k) * Math.pow(x, 2 * k) / factorial(k);
					}
					countCoords.addPoint(new ChartPoint(x, y));
					x += h;
					mainFrame.updateData();
					try{
						Thread.sleep(100);		
					} catch(InterruptedException e){}
				}
				mainFrame.setFocusable(true);
				mainFrame.buttonEnable(true);
			}
    		
    	});
    	counter.start();
    }
    
    public int getCoordsSize() {
    	return countCoords.getCoords().size();
    }
    
    public List<ChartPoint> getCoords() {
    	return countCoords.getCoords();
    }
    
    public ChartPoint getElement(int index) {
    	return countCoords.getCoords().get(index);
    }
	
	public void addPoint(ChartPoint point) {
        new Runnable() {
            @Override
            public void run() {
                countCoords.addPoint(point);
                mainFrame.updateData();
            }
        };
	}
	
	private double factorial(int number) {
		double result = 1;
		for (int factor = 2; factor <= number; factor++) {
			result *= factor;
		}
		return result;
	}
	
}
