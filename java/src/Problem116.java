
public class Problem116 {
	public static long[][] cache = new long[51][5];
	public static void main(String[] args){
		for (int i = 0; i < 51; i++)
			for (int j = 0; j < 5; j++)
				cache[i][j] = -1;
		System.out.println(solve(50));
	}
	
	public static long solve(int length){
		return solve(length, 2) + solve(length, 3) + solve(length, 4) - 3;
	}
	private static long solve(int length, int color){
		if (length < 0)
			return 0;
		if (length == 0)
			return 1;
		if (length < color)
			return solve(length-1, color);
		if (cache[length-1][color] == -1)
			cache[length-1][color] = solve(length - 1, color);
		if (cache[length-color][color] == -1)
			cache[length-color][color] = solve(length-color, color);
		return cache[length-1][color] + cache[length-color][color];
	}
}
