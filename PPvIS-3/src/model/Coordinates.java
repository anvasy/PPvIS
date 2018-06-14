package model;

import java.util.ArrayList;
import java.util.List;

public class Coordinates {
	private List<ChartPoint> coords;

    public Coordinates() {
    	coords = new ArrayList<>();
    }

    public int addPoint(ChartPoint point) {
        synchronized (coords) {
        	coords.add(point);
            return coords.size() - 1;
        }
    }

    public void removeAll() {
        synchronized (coords) {
        	coords.clear();
        }
    }
    
    public List<ChartPoint> getData() {
        return coords;
    }

    public int getSize() {
        synchronized (coords) {
            return coords.size();
        }
    }
}
