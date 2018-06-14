package controller;

import java.util.ArrayList;
import java.util.List;

import model.ChartPoint;
import model.Coordinates;
import model.CountCoordinates;
import ui.MainFrame;
import model.ChartPoint;

public class Controller {

    private MainFrame mainFrame;
    private Thread thread;
	double h = 0.01;
    private CountCoordinates countCoords;

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.countCoords = new CountCoordinates(this);
    }

    public void countCoords(int n) {
        if (thread != null) {
            countCoords.shutdown();
            while (thread.isAlive()) ;
            countCoords.clearCoords();
            mainFrame.removeAllData();
        }
        countCoords.start(n);
        thread = new Thread(countCoords);
        thread.start();
    }

    public ChartPoint getData(int index) {
        List<ChartPoint> data = countCoords.getCoords();
        if (index != -1)
            return data.get(index);
        return null;
    }

    public void close() {
        if (thread != null) {
            countCoords.shutdown();
            while (thread.isAlive()) ;
        }
    }
	
	public void addPoint(ChartPoint point) {
        new Runnable() {
            @Override
            public void run() {
                int index = countCoords.addPoint(point);
                mainFrame.updateData(index);
            }
        };
	}
	
	public ArrayList<ChartPoint> countCoordinates(int n) {
		ArrayList<ChartPoint> coords = new ArrayList<>();
		double x = 0.0;
		double y;
		while (x <= 0.5) {
			y = 0.0;
			for (int k = 0; k <= n; k++) {
				y += Math.pow(-1, k) * Math.pow(x, 2 * k) / factorial(k);
			}
			coords.add(new ChartPoint(x, y));
			x += h;
		}
		return coords;
	}
	
	private int factorial(int number) {
		int result = 1;
		for (int factor = 2; factor <= number; factor++) {
			result *= factor;
		}
		return result;
	}
	
}
