package model;

import java.util.ArrayList;

import controller.Controller;

public class CountCoordinates implements Runnable{
	 
	double h = 0.01;
	private Controller controller;
    private int numberTest;
    private boolean isAlive = false;
    private int numberIteration;
    private int iteration = 2;
	
	public CountCoordinates(Controller controller) {
		// TODO Auto-generated constructor stub
		this.controller = controller;
	}
	
    public void start() {
        isAlive = true;
        iteration = 2;
    }

    public void start(int n) {
        start();
    }

    public void shutdown() {
        isAlive = false;
}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public ChartPoint countPoint(double x, int n) {
		double y = 0.0;
		for (int k = 0; k <= n; k++) {
			y += Math.pow(-1, k) * Math.pow(x, 2 * k) / factorial(k);
		}
		return new ChartPoint(x, y);
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
