import java.util.*;
public class Problem124 {

	public static void main(String[] args) {
		boolean[] sieve = Primes.getPrimes(100000);
		List<Integer> primes = Primes.getPrimesArray(sieve);
		List<Rad> rads = new ArrayList<Rad>();
		for (int i = 1; i <= 100000; i++){
			rads.add(new Rad(i, primes));
		}
		Collections.sort(rads);
		System.out.println(rads.get(9999).getN());

	}

}
