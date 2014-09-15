import java.util.*;
public class Problem51 {
	public static final int TARGET = 8;
	public static void main(String[] args){
		boolean[] sieve = Primes.getPrimes(9999999);
		for (int i = 2; i <= 8; i++){
			List<String> possible = generate(i);
			for (String s : possible)
				if (check(s, sieve)){
					System.out.println("the pattern is " + s);
					for (int j = 1; j <= 9; j++){
						String current = s.replace('*', Character.forDigit(j, 10));
						if (sieve[Integer.parseInt(current)]){
							System.out.println("the answer is " + current);
							break;
						}
					}
					return;
				}
		}
	}
	
	public static boolean check(String number, boolean[] sieve){
		int count = 0;
		if (number.charAt(0) == '*'){
			for (int i = 1; i <= 9; i++){
				String current = number.replace('*', Character.forDigit(i, 10));
				if (sieve[Integer.parseInt(current)])
					count++;
			}
		} else {
			for (int i = 0; i <= 9; i++){
				String current = number.replace('*', Character.forDigit(i, 10));
				if (sieve[Integer.parseInt(current)])
					count++;
			}
		}
		return count == TARGET;
	}
	
	public static List<String> generate(int n){
		if (n < 2)
			throw new IllegalArgumentException();
		List<String> output = generate(n, new ArrayList<String>(), "", true);
		String forbidden = "";
		for (int i = 0; i < n; i++)
			forbidden += "*";
		output.remove(forbidden);
		return output;
		
	}
	
	private static List<String> generate(int n, List<String> output, String current, boolean first){
		if (current.length() == n){
			if (current.indexOf('*') == -1){
				return output;
			}
			output.add(current);
		} else {
			output = generate(n, output, current + "*", false);
			if (first){
				for (int i = 1; i <= 9; i++)
					output = generate(n, output, current + i, false);
			} else {
				
				for (int i = 0; i <= 9; i++)
					output = generate(n, output, current + i, false);
			}
		}
		return output;
	}
	
}
