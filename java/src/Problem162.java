import java.math.BigInteger;
public class Problem162 {
	
	public static void main(String[] args){
		System.out.println(solve());
	}
	
	public static BigInteger solve(){
		return solve(1, false, true, false).add(solve(1, false, false, true)).add(BigInteger.valueOf(13).multiply(solve(1, false, false, false)));
	}
	
	private static BigInteger solve(int current, boolean zero, boolean one, boolean a){
		if (current == 16){
			if (zero && one && a)
				return BigInteger.ONE;
			return BigInteger.ZERO;
		}
		
		if (zero && one && a)
			return BigInteger.ONE.add(BigInteger.valueOf(16).multiply(solve(current+1, true, true, true)));
		if (!zero && one && a)
			return solve(current+1, true, true, true).add(BigInteger.valueOf(15).multiply(solve(current+1, false, true, true)));
		if (zero && !one && a)
			return solve(current+1, true, true, true).add(BigInteger.valueOf(15).multiply(solve(current+1, true, false, true)));
		if (zero && one && !a)
			return solve(current+1, true, true, true).add(BigInteger.valueOf(15).multiply(solve(current+1, true, true, false)));
		if (!zero && !one && a)
			return solve(current+1, true, false, true).add(solve(current+1, false, true, true)).add(BigInteger.valueOf(14).multiply(solve(current+1, false, false, true)));
		if (!zero && one && !a)
			return solve(current+1, true, true, false).add(solve(current+1, false, true, true)).add(BigInteger.valueOf(14).multiply(solve(current+1, false, true, false)));
		if (zero && !one && !a)
			return solve(current+1, true, false, true).add(solve(current+1, true, true, false)).add(BigInteger.valueOf(14).multiply(solve(current+1, true, false, false)));
		return solve(current+1, true, false, false).add(solve(current+1, false, true, false)).add(solve(current+1, false, false, true)).add(BigInteger.valueOf(13).multiply(solve(current+1, false, false, false)));
	}
	
}
