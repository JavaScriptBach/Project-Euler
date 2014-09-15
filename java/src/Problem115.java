
public class Problem115 {
	public static long[][][] cache = new long[57][1000][2];
	public static void main(String[] args){
		int current = 50;
		while (solve(50,current) <= 1000000){
			current++;
		}
		System.out.println(current);
	}
	
	public static long solve(int red, int length){
		return solve(red, length, true);
	}
	
	private static long solve(int redLength, int length, boolean red){
		if (length < 0)
			return 0;
		if (length == 0)
			return 1;
		long sum = 0;
		if (cache[redLength][length-1][1] == 0)
			cache[redLength][length-1][1] = solve(redLength, length-1, true);
		sum += cache[redLength][length-1][1];
		if (red){
			for (int i = redLength; i <= length; i++){
				if (length >= i){
					if (cache[redLength][length-i][0] == 0)
						cache[redLength][length-i][0] = solve(redLength, length-i, false);
					sum += cache[redLength][length-i][0];
				}
			}
		}
		return sum;
	}
}
