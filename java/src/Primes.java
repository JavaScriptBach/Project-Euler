import java.util.*;
public class Primes {
	public boolean[] primes;
	public Primes(int L){
		 primes = new boolean[L+1];
	        for (int i = 2; i < primes.length; i++) {
	            primes[i] = true;
	        }

	        for (int i = 2; i < Math.sqrt(primes.length); i++) {
	            if (primes[i]) {
	                for (int j = i * i; j < primes.length; j += i) {
	                    primes[j] = false;
	                }
	            }
	        }
	}
	
	public static boolean[] getPrimes(int L){
		boolean[] output = new boolean[L+1];
        for (int i = 2; i < output.length; i++) {
            output[i] = true;
        }

        for (int i = 2; i < Math.sqrt(output.length); i++) {
            if (output[i]) {
                for (int j = i * i; j < output.length; j += i) {
                    output[j] = false;
                }
            }
        }
        return output;
	}

	public static boolean isPrime(long n){
		if (n < 2)
			return false;
		for (long i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}
	
	
	public static List<Integer> getPrimesArray(boolean[] sieve){
		List<Integer> output = new ArrayList<Integer>();
		for (int i = 0; i < sieve.length; i++)
			if (sieve[i])
				output.add(i);
		return output;
	}
	
	public String toString(){
		String output = "";
		for (int i = 2; i < primes.length; i++){
			output += i + ": " + primes[i];
		}
		return output;
	}
}
