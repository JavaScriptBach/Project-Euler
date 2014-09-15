import java.util.*;
public class Problem70 {

	public static void main(String[] args) {
		boolean[] sieve = Primes.getPrimes(10000000);
		List<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i < sieve.length; i++){
			if (sieve[i])
				primes.add(i);
		}
		double min = 9999.0;
		int minValue = 0;
		for (int i = 2; i < 10000000; i++){
			System.out.println(i);
			if (!sieve[i]){
				int phi = phi(i, primes);
				double ratio = 1.0 * i / phi;
				if (isPermutation(phi, i) && ratio < min){
					min = ratio;
					minValue = i;
				}
			}
		}
		System.out.println(minValue);
	}
	
	public static int phi(int n, List<Integer> primes){
		//prime factorize the number
		//return n * (1- 1/p) for all prime factors
		double answer = 1.0 * n;
		Set<Integer> factors = new HashSet<Integer>();
		int current = 0;
		while (n > 1){
			int next = primes.get(current);
			if (n % next == 0){
				factors.add(next);
				while (n % next == 0)
					n = n/next;
			}
			current++;
		}
		Iterator<Integer> i = factors.iterator();
		while (i.hasNext()){
			int next = i.next();
			answer = answer * (next-1) / next;
		}
		return (int) answer;
	}
	
	public static boolean isPermutation(int a, int b){
		int[] digitsA = new int[(int)Math.floor(Math.log10(a)) + 1];
		int[] digitsB = new int[(int)Math.floor(Math.log10(b)) + 1];
		if (digitsA.length != digitsB.length)
			return false;
		for (int i = 0; i < digitsA.length; i++){
			digitsA[i] = a % 10;
			digitsB[i] = b % 10;
			a = a/10;
			b = b/10;
		}
		Arrays.sort(digitsA);
		Arrays.sort(digitsB);
		for (int i = 0; i < digitsA.length; i++)
			if (digitsA[i] != digitsB[i])
				return false;
		return true;
	}

}
