package model;

public class ChartPoint {
	private double x;
	private double y;
	
	public ChartPoint(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Object getValue(int index){
        switch (index){
            case 0: return getX();
            case 1: return getY();
        }
        return null;
    }

}
