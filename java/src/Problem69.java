import java.util.*;
public class Problem69 {
	public static void main(String[] args){
		Primes p = new Primes(1000000);
		List<Integer> primes = p.getPrimesArray();
		boolean[] sieve = Primes.getPrimes(1000000);
		double max = 0.0;
		int maxValue = 0;
		for (int i = 2; i <= 1000000; i++){
			double result = solve(i, sieve, primes);
			if (result > max){
				max = result;
				maxValue = i;
			}
		}
		System.out.println(maxValue);
	}
	
	//pre: a > b
	public static int gcd(int a, int b){
		//gcd(a, b) = gcd(b, a%b)
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
	
	public static double solve(int n, boolean[] sieve, List<Integer> primes){
		if (sieve[n])
			return 1.0 * n / (n-1);
		//prime factorize the number
		//return n * (1- 1/p) for all prime factors
		Set<Integer> factors = new HashSet<Integer>();
		int current = 0;
		while (n > 1){
			int next = primes.get(current);
			if (n % next == 0)
				factors.add(next);
			while (n % next == 0)
				n = n/next;
			current++;
		}
		double answer = 1.0;
		Iterator<Integer> i = factors.iterator();
		while (i.hasNext()){
			int next = i.next();
			answer = answer * next / (next-1);
		}
		return answer;
	}
}
