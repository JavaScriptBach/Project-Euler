
public class Problem164 {
	public static long[][][][] cache = new long[21][10][10][10];
	public static void main(String[] args){
		System.out.println(solve());
	}
	public static long solve(){
		long sum = 0;
		for (int i = 1; i <= 9; i++)
			sum += solve(1, i, -1, -1);
		return sum;
	}
	private static long solve(int current, int first, int second, int third){
		if (first + second + third > 9)
			return 0;
		if (current == 20)
			return 1;
		long sum = 0;
		for (int i = 0; i <= 9; i++){
			if (second == -1)
				sum += solve(current+1, first, i, -1);
			else if (third == -1)
				sum += solve(current+1, first, second, i);
			else{
				if (cache[current+1][second][third][i] == 0)
					cache[current+1][second][third][i] = solve(current+1, second, third, i);
				sum += cache[current+1][second][third][i];
			}
		}
		return sum;
	}
}
