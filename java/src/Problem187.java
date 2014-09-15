import java.util.List;
public class Problem187 {
	public static void main(String[] args) {
		boolean[] sieve = Primes.getPrimes(100000000);
		List<Integer> primes = Primes.getPrimesArray(sieve);
		int count = 0;
		for (int i = 2; i < 100000000; i++){
			System.out.println(i);
			if (isSemiPrime(i, primes, sieve))
				count++;
		}
		System.out.println(count);

	}
	
	//pre: is composite
	//post: returns whether n is semiprime
	public static boolean isSemiPrime(int n, List<Integer> primes, boolean[] sieve){
		if (sieve[n])
			return false;
		for (int i : primes){
			if (n % i == 0){
				return sieve[n/i];
			}
		}
		return false;
	}

}
