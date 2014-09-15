
public class Problem173 {
	public static int countAll(int n){
		int sum = 0;
		for (int i = 1; i <= n; i++)
			sum += count(i);
		return sum;
	}
	public static int count(int n){
		//n, x, y > 0
		//n, x, y are integers
		if (n < 8)
			return 0;
		//n + x^2 = y^2
		//y = sqrt(x^2 + n)
		//(y-x) % 2 == 0
	}
}
