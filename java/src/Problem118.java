import java.util.*;
public class Problem118 {
	public static final boolean[] sieve = Primes.getPrimes(987654321);
	public static Set<Set<Integer>> answers = new TreeSet<Set<Integer>>();
	public static void main(String[] args){
		
	}
	
	public static void solve(boolean[] digits, Set<Integer> set){
		
	}
	
	public static boolean done(boolean[] digits){
		for (int i = 1; i <= 9; i++){
			if (!digits[i])
				return false;
		}
		return true;
	}
}
