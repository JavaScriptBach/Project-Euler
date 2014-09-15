import java.util.List;
public class Problem77 {
	public static void main(String[] args) {
		boolean[] sieve = Primes.getPrimes(1000000);
		List<Integer> primes = Primes.getPrimesArray(sieve);
		int current = 5;
		while (explore(current, primes) <= 5000)
			current++;
		System.out.println(current);

	}
	
	public static int explore(int number, List<Integer> primes){
		int index = 0;
		while (primes.get(index) <= number)
			index++;
		return explore(number, primes.get(index - 1), primes);
	}
	private static int explore(int number, int currentPrime, List<Integer> primes){
		if (number < 0 || (number % 2 == 1 && currentPrime == 2))
			return 0;
		if (number == 0 || (number % 2 == 0 && currentPrime == 2))
			return 1;
		int count = 0;
		for (int i = 0; i <= number; i+=currentPrime){
			count += explore(number-i, primes.get(primes.indexOf(currentPrime) - 1), primes);
		}
		return count;
	}
}
