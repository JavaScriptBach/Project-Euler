import java.util.*;
public class Problem87 {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		boolean[] sieve = Primes.getPrimes(7071);
		List<Integer> primes = Primes.getPrimesArray(sieve);
		Set<Integer> answer = new HashSet<Integer>();
		for (int i = 0; i < primes.size(); i++){
			for (int j = 0; Math.pow(primes.get(i), 2) + Math.pow(primes.get(j),3 ) < 50000000; j++){
				for (int k = 0; Math.pow(primes.get(i), 2) + Math.pow(primes.get(j), 3) + Math.pow(primes.get(k), 4) < 50000000; k++){
					int sum = (int)(Math.pow(primes.get(i), 2) + Math.pow(primes.get(j), 3) + Math.pow(primes.get(k), 4));
					if (sum < 50000000)
						answer.add(sum);
				}
			}
		}
		System.out.println(answer.size());
		System.out.println("Time elapsed = " + (System.currentTimeMillis() - start) + " ms");
	}
	
}
