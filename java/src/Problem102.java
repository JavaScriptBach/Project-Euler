import java.util.*;
import java.io.*;
public class Problem102 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("triangles.txt"));
		int count = 0;
		while (input.hasNextLine()){
			String[] next = input.nextLine().split(",");
			Point[] triangle = new Point[3];
			triangle[0] = new Point(next[0], next[1]);
			triangle[1] = new Point(next[2], next[3]);
			triangle[2] = new Point(next[4], next[5]);
			Arrays.sort(triangle);
			if (solve(triangle))
				count++;
		}
		input.close();
		System.out.println(count);
	}
	
	//pre: given a sorted array of 3 points
	//post: returns whether the triangle contains the origin
	public static boolean solve(Point[] triangle){
		if (triangle[0].x > 0 || triangle[2].x < 0)
			return false;
		boolean top = false;
		boolean bot = false;
		for (Point p : triangle){
			if (p.y > 0)
				top = true;
			if (p.y < 0)
				bot = true;
		}
		if (!top || !bot)
			return false;
		//piecewise function
		//ax+b < y < cx+d for -1 < x < 1
		Line l1 = new Line(triangle[0], triangle[2]);
		Line l2 = new Line(triangle[0], triangle[1]);
		Line l3 = new Line(triangle[1], triangle[2]);
		if (triangle[1].x > 0){
			//do something with l1 and l2
			if (l1.b > l2.b){
				return l2.b < 0 && l1.b > 0;
			}
			return l1.b < 0 && l2.b > 0;
		}
		//do something with l1 and l3
		if (l1.b > l3.b){
			return l1.b > 0 && l3.b < 0;
		}
		return l1.b < 0 && l3.b > 0;
	}
}
