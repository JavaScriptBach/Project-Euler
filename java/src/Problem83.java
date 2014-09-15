import java.util.*;
import java.io.*;
public class Problem83 {
	public static void main(String[] args) throws Exception{
		Scanner input = new Scanner(new File("matrix.txt"));
		int[][] matrix = new int[80][80];
		for (int i = 0; i < 80; i++){
			String line = input.nextLine();
			String[] ints = line.split(",");
			for (int j = 0; j < 80; j++)
				matrix[i][j] = Integer.parseInt(ints[j]);
		}
		input.close();
		solve(matrix);
	}
	
	public static void solve(int[][] matrix){
		Set<Point> solved = new HashSet<Point>();
		solved.add(new Point(0, 0));
		int[][] distance = new int[80][80];
		for (int i = 0; i < 80; i++)
			for (int j = 0 ; j < 80; j++)
				distance[i][j] = -1;
		distance[0][0] = 4445;
		Point target = new Point(79, 79);
		while (!solved.contains(target)){
			int min = 9999999;
			int x = -1;
			int y = -1;
			for (Point p : solved){
				Set<Point> neighbors = neighbors(p.x, p.y, solved);
				for (Point q : neighbors){
					int current = distance[p.x][p.y] + matrix[q.x][q.y];
					if (current < min){
						min = current;
						x = q.x;
						y = q.y;
					}
				}
			}
			solved.add(new Point(x, y));
			distance[x][y] = min;
		}
		System.out.println(distance[79][79]);
	}
	
	public static Set<Point> neighbors(int a, int b, Set<Point> solved){
		Set<Point> output = new HashSet<Point>();
		if (a-1 >= 0 && !solved.contains(new Point(a-1, b)))
			output.add(new Point(a-1, b));
		if (a+1 < 80 && !solved.contains(new Point(a+1, b)))
			output.add(new Point(a+1, b));
		if (b-1 >= 0 && !solved.contains(new Point(a, b-1)))
			output.add(new Point(a, b-1));
		if (b+1 < 80 && !solved.contains(new Point(a, b+1)))
			output.add(new Point(a, b+1));
		return output;
	}
}
