
public class Point implements Comparable<Point> {
	public int x;
	public int y;
	
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(String x, String y){
		this.x = Integer.parseInt(x);
		this.y = Integer.parseInt(y);
	}
	
	public int compareTo(Point other){
		if (this.x != other.x)
			return this.x - other.x;
		return this.y - other.y;
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}
	
	public double slope(Point other){
		return 1.0 * (other.y - this.y) / (other.x - this.x);
	}
	
	public boolean equals(Object other){
		if (other instanceof Point){
			Point p = (Point) other;
			return this.x == p.x && this.y == p.y;
		}
		return false;
	}
	
	public int hashCode(){
		return (41 * (41 + x + y));
	}
}
