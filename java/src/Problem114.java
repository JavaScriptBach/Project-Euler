
public class Problem114 {
	public static long[][] cache = new long[51][2];
	public static void main(String[] args){
		System.out.println(solve(50));
	}
	
	public static long solve(int length){
		return solve(length, true);
	}
	
	private static long solve(int length, boolean red){
		if (length < 0)
			return 0;
		if (length == 0)
			return 1;
		long sum = 0;
		if (cache[length-1][1] == 0)
			cache[length-1][1] = solve(length-1, true);
		sum += cache[length-1][1];
		if (red){
			for (int i = 3; i <= length; i++){
				if (length >= i){
					if (cache[length-i][0] == 0)
						cache[length-i][0] = solve(length-i, false);
					sum += cache[length-i][0];
				}
			}
		}
		return sum;
	}
}
