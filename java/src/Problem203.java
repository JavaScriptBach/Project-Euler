import java.util.List;
import java.util.Set;
import java.util.HashSet;
public class Problem203 {
	public static void main(String[] args){
		boolean[] sieve = Primes.getPrimes(15746723);
		List<Integer> primes = Primes.getPrimesArray(sieve);
		long[][] pascal = new long[51][51];
		pascal[0][0] = 1;
		pascal[1][0] = 1;
		pascal[1][1] = 1;
		for (int i = 2; i <= 50; i++){
			pascal[i][0] = 1;
			for (int j = 1; j < i; j++)
				pascal[i][j] = pascal[i-1][j] + pascal[i-1][j-1];
			pascal[i][i] = 1;
		}
		Set<Long> answers = new HashSet<Long>();
		for (int i = 0 ; i < 51; i++){
			for (int j = 0; j <= i; j++){
				if (isSquareFree(pascal[i][j], primes))
					answers.add(pascal[i][j]);
			}
		}
		long sum = 0;
		for (long l : answers)
			sum += l;
		System.out.println(sum);
		
	}
	
	public static boolean isSquareFree(long n, List<Integer> primes){
		for (int i = 0; i < primes.size(); i++){
			long product = (long)primes.get(i) * primes.get(i);
			if (product > n)
				return true;
			if (n % product == 0)
				return false;
		}
		return true;
	}
}
