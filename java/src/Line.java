//creates a line of the form y = mx+b
public class Line {
	public double m;
	public double b;
	public Line(Point p1, Point p2){
		m = p1.slope(p2);
		b = p1.y - m * p1.x;
	}
	
}
