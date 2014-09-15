import java.util.*;
public class Problem60 {
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		boolean[] sieve = Primes.getPrimes(100000000);
		List<Integer> primes = Primes.getPrimesArray(sieve);
		Set<Integer> answer = new HashSet<Integer>();
		for (int i : primes){
			answer.add(i);
			if (explore(answer, primes, sieve)){
				System.out.println("time elapsed = " + (System.currentTimeMillis() - start) + " ms");
				return;
			}
			answer.remove(i);
		}
	}
	
	public static boolean explore(Set<Integer> answer, List<Integer> primes, boolean[] sieve){
		if (answer.size() == 5){
			System.out.println(answer);
			int sum = 0;
			for (int i : answer)
				sum += i;
			System.out.println("sum = " + sum);
			return true;
		}
		for (int i : primes){
			String number = Integer.toString(i);
			boolean ok = true;
			for (int j : answer){
				if (Integer.parseInt(number + j) < sieve.length && Integer.parseInt(j + number) < sieve.length){
					if (!sieve[Integer.parseInt(number + j)] || !sieve[Integer.parseInt(j + number)])
						ok = false;
				} else {
					return false;
				}
			}
			if (ok){
				answer.add(i);
				if (explore(answer, primes, sieve))
					return true;
				//explore(answer, primes, sieve);
				answer.remove(i);
			}
		}
		return false;
	}
}
