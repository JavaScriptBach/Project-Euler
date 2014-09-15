
public class Problem91 {
	public static void main(String[] args){
		int count = 0;
		for (int i = 0; i <= 50; i++){
			for (int j = 0; j <= 50; j++){
				for (int k = 0; k <= 50; k++){
					for (int l = 0; l <= 50; l++){
						if ((i == k && j == l) || (i == 0 && j == 0) || (k == 0 && l == 0)) continue;
						Point p1 = new Point(i, j);
						Point p2 = new Point(k, l);
						if (solve(p1, p2)) count++;
					}
				}
			}
		}
		System.out.println(count/2);
	}
	
	public static boolean solve(Point p1, Point p2){
		int a = p1.x * p1.x + p1.y * p1.y;
		int b = p2.x * p2.x + p2.y * p2.y;
		int c = (p2.x-p1.x) * (p2.x-p1.x) + (p2.y-p1.y) * (p2.y-p1.y);
		return a+b == c || c+b == a || a+c == b;
	}
}
