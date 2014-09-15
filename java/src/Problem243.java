import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class Problem243 {
	public static final int MAX = 9999999;
	public static final Fraction TARGET = new Fraction(BigInteger.valueOf(15499), BigInteger.valueOf(94744));
	public static void main(String[] args){
		boolean[] sieve = Primes.getPrimes(MAX);
		List<Integer> primes = Primes.getPrimesArray(sieve);
		for (int i = 2; i <= MAX; i++){
			if (!sieve[i]){
				Fraction f1 = new Fraction(BigInteger.valueOf(phi(i, primes)), BigInteger.valueOf(i-1));
				if (f1.compareTo(TARGET) < 0){
					System.out.println(i-1);
					return;
				}
			}
		}
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
}
