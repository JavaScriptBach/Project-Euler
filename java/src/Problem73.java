
public class Problem73 {
	public static final double LOWER = 1.0/3;
	public static final double UPPER = 0.5;
	public static void main(String[] args) {
		int count = 3;
		for (int d = 9; d <= 12000; d++){
			System.out.println(d);
			for (int n = d/3; n <= d/2; n++){
				if (gcd(d, n) == 1){
					double fraction = 1.0 * n/d;
					if (fraction > LOWER && fraction < UPPER)
						count++;
				}
			}
		}
		System.out.println(count);
	}
	
	//pre: a > b
		public static int gcd(int a, int b){
				//gcd(a, b) = gcd(b, a%b)
			while (b > 0){
				int temp = a;
				a = b;
				b = temp % b;
			}
				return a;
		}

}
