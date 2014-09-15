import java.util.*;
public class Problem50 {
	public static void main(String[] args) {
		List<Integer> primes = Primes.getPrimesArray(1000000);
		System.out.println(solve(primes));

	}
	
	//pre: given a list of all primes below 1 million
	//post: finds the prime that can be written as the sum of most consecutive primes
	public static int solve(List<Integer> primes){
		int maxCount = 0;
		int maxPrime = 0;
		for (int i = 0; i < primes.size(); i++){
			int currentPrime = primes.get(i);
			for (int j = 0; j < i; j++){ //starting index for sum
				int sum = 0;
				int count = 0;
				int currentIndex = j;
				while (sum < currentPrime){
					sum += primes.get(currentIndex);
					currentIndex++;
					count++;
				}
				if (sum == currentPrime && count > maxCount){
					maxPrime = currentPrime;
					maxCount = count;
				}
			}
		}
		return maxPrime;
	}

}
