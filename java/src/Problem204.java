import java.util.List;
public class Problem204 {
	public static final int MAX = 1000000000;
	public static void main(String[] args){
		List<Integer> primes = Primes.getPrimesArray(Primes.getPrimes(MAX));
		while (primes.get(0) <= 100)
			primes.remove(0);
		boolean[] array = new boolean[MAX + 1];
		for (int i = 1; i < array.length; i++)
			array[i] = true;
		for (int i : primes){
			for (int j = i; j < array.length; j+=i)
				array[j] = false;
		}
		int count = 0;
		for (int i = 1; i < array.length; i++)
			if (array[i])
				count++;
		System.out.println(count);
		
	}

}
