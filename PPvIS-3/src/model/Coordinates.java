package model;

import java.util.ArrayList;

public class Coordinates {
	private ArrayList<ChartPoint> coords;

    public Coordinates() {
    	coords = new ArrayList<>();
    }

    public int addPoint(ChartPoint point) {
        synchronized (coords) {
            /*if(graphic.size()==0){
                return -1;
            }*/
        	coords.add(point);
            return coords.size() - 1;
        }
    }

    public void removeAll() {
        synchronized (coords) {
        	coords.clear();
        }
    }

    public ArrayList<ChartPoint> getGraphic() {
        synchronized (coords) {
            return new ArrayList<>(coords);
        }
    }

    public int getSize() {
        synchronized (coords) {
            return coords.size();
        }
}
}
