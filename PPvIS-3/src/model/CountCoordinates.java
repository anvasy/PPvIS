package model;

import java.util.ArrayList;
import java.util.List;

public class CountCoordinates {
	 
	double h = 0.01;
	private Coordinates coords;

	public CountCoordinates() {
		coords = new Coordinates();
	}
	
	public void clearCoords() {
		coords.removeAll();
	}
	
	public List<ChartPoint> getCoords() {
		synchronized (coords) {
			return coords.getData();
		}
	}
	
	public int addPoint(ChartPoint point) {
		synchronized (coords) {
			return coords.addPoint(point);
		}
	}

}
