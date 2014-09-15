
public class Problem191 {
	public static long[][][] cache = new long[31][3][4];
	public static void main(String[] args){
		System.out.println(solve());
	}
	public static long solve(){
		return solve(0, 0, 0);
	}
	private static long solve(int current, int late, int absent){
		if (late == 2 || absent == 3)
			return 0;
		if (current == 30)
			return 1;
		if (cache[current+1][late][0] == 0)
			cache[current+1][late][0] = solve(current+1, late, 0);
		if (cache[current+1][late+1][0] == 0)
			cache[current+1][late+1][0] = solve(current+1, late+1, 0);
		if (cache[current+1][late][absent+1] == 0)
			cache[current+1][late][absent+1] = solve(current+1, late, absent+1);
		return cache[current+1][late][0] + cache[current+1][late+1][0] + cache[current+1][late][absent+1];
	}
}
