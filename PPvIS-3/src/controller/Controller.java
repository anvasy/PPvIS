package controller;

import java.util.ArrayList;

public class Controller {

	public ArrayList<Double> countCoordinates() {
		ArrayList<Double> coords = new ArrayList<>();
		double x = 0.0, y = 0.0;
		for (int k = 0; k <= 50; k++) {
			y+= Math.pow(-1, k) * Math.pow(x, 2 * k) / factorial(k); //????????
			coords.add(y);
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
