import java.util.*;
public class Problem58 {
	public static void main(String[] args){
		boolean[] primes = Primes.getPrimes(700000000);
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(1);
		double ratio = 1.0;
		int current = 1;
		while (ratio >= 0.1){
			current += 2;
			numbers = generateDiagonals(current, numbers);
			int count = 0;
			for (int i: numbers){
				if (primes[i])
					count++;
			}
			ratio = count * 1.0 / numbers.size();
			System.out.println(ratio);
		}
		System.out.println(current);
	}
	
	//pre: List is already complete for the previous spiral square
	//post: generates all the diagonal numbers for a n by n spiral square
	public static List<Integer> generateDiagonals(int n, List<Integer> current){
		int number = current.get(current.size() - 1);
		for (int j = 0; j < 4; j++){
			number += n - 1;
			current.add(number);
		}
		return current;
	}
}
