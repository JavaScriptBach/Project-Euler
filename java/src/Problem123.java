import java.math.BigInteger;
import java.util.List;
public class Problem123 {
	public static void main(String[] args) {
		boolean[] sieve = Primes.getPrimes(1000000);
		List<Integer> primes = Primes.getPrimesArray(sieve);
		for (int i = 0; i < primes.size(); i++){
			int prime = primes.get(i);
			if (remainder(BigInteger.valueOf(prime), i+1) > 1000000000){
				System.out.println(i+1);
				return;
			}
			//System.out.println(i+1);
		}
		//System.out.println(remainder(BigInteger.valueOf(71059), 7037));

	}
	
	public static long remainder(BigInteger prime, int n){
		BigInteger num1 = prime.subtract(BigInteger.ONE).pow(n);
		BigInteger num2 = prime.add(BigInteger.ONE).pow(n);
		BigInteger deno = prime.multiply(prime);
		return num1.add(num2).remainder(deno).longValue();
	}

}
