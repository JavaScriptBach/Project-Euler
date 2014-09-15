
public class Problem117 {
	public static long[] cache = new long[51];
	public static void main(String[] args){
		System.out.println(solve(50));
	}
	
	public static long solve(int length){
		if (length < 0)
			return 0;
		if (length == 0)
			return 1;
		long sum = 0;
		for (int i = 1; i <= 4; i++){
			if (length >= i){ 
				if (cache[length-i] == 0){
					cache[length-i] = solve(length-i);
				}
				sum += cache[length-i];
			}
		}
		return sum;
	}
}
