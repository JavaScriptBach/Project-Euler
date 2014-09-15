
public class Problem113 {
	public static long[][][] cache = new long[100][10][2];
	public static void main(String[] args){
		System.out.println(solve(100));
	}
	
	//returns all the non-bouncy numbers whose digits <= digits
	public static long solve(int digits){
		long sum = 9;
		for (int i = 2; i <= digits; i++)
			sum += solve(i, 1, true) + solve(i, 9, false) - 10;
		return sum;
	}
	private static long solve(int digits, int previous, boolean increasing){
		if (increasing){
			if (digits == 0 || previous == 9)
				return 1;
			long sum = 0;
			for (int i = previous; i <= 9; i++){
				if (cache[digits-1][i][1] == 0)
					cache[digits-1][i][1] = solve(digits-1, i, true);
				sum += cache[digits-1][i][1];
			}
			return sum;
		} else {
			if (digits == 0 || previous == 0)
				return 1;
			long sum = 0;
			for (int i = previous; i >= 0; i--){
				if (cache[digits-1][i][0] == 0)
					cache[digits-1][i][0] = solve(digits-1, i, false);
				sum += cache[digits-1][i][0];
			}
			return sum;
		}
	}
}
