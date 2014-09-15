import java.util.List;
public class Problem72 {
	public static void main(String[] args){
		boolean[] sieve = new boolean[1000001];
		for (int i = 1; i < sieve.length; i++)
			sieve[i] = true;
		List<Integer> primes = Primes.getPrimesArray(Primes.getPrimes(1000000));
		long count = 0;
		for (int i = 2; i <= 1000000; i++){
			System.out.println(i);
			for (int j = 0; j < primes.size(); j++){
				if (primes.get(j) >= i)
					break;
				if (i % primes.get(j) == 0){
					for (int k = primes.get(j); k < i; k+=primes.get(j))
						sieve[k] = false;
				}
			}
			for (int k = 1; k < i; k++)
				if (sieve[k])
					count++;
				else
					sieve[k] = true;
			/*for (int j = 1; j < i; j++){
				if (gcd(i, j) == 1)
					count++;
			}*/
		}
		System.out.println(count);
	}
	//pre: a > b
	public static int gcd(int a, int b){
			//gcd(a, b) = gcd(b, a%b)
		while (b > 0){
			int temp = a;
			a = b;
			b = temp % b;
		}
			return a;
	}
}
