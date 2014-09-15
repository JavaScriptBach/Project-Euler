import java.util.*;
public class Problem47 {
	public static void main(String[] args){
		int current = 0;
		int count = 1;
		while (current < 4){
			count++;
			if (factorize(count).size() == 4){
				System.out.println(count);
				current++;
			}
			else
				current = 0;
		}
	}
	
	//pre: n > 1
	//post: returns a HashSet of all distinct prime factors
	public static Set<Long> factorize(long n){
		if (n < 2)
			throw new IllegalArgumentException();
		Set<Long> output = new HashSet<Long>();
		Primes p = new Primes();
		while (n != 1){
			if (n % p.get() == 0){
				output.add(p.get());
				while (n % p.get() == 0)
					n = n / p.get();
			}
			p.next();
		}
		return output;
	}
}
