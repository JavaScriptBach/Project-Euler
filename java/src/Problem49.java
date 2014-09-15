import java.util.*;
public class Problem49 {

	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<Integer>();
		//grab all the 4 digit primes
		for (int i = 1000; i <= 9999; i++){
			if (Primes.isPrime(i))
				primes.add(i);
		}
		for (int p : primes){
			for (int i = 1; i < 4500; i++){
				// do something with p, p + i, p + 2i
				if (isPermutation(p, p+i) && isPermutation(p, p + 2*i) && primes.contains(p+i) && primes.contains(p + 2 * i)){
					System.out.println("" + p + (p+i) + (p + 2*i));
				}
				
			}
		}
	}
	
	public static boolean isPermutation(int a, int b){
		int[] digitsA = new int[(int)Math.floor(Math.log10(a)) + 1];
		int[] digitsB = new int[(int)Math.floor(Math.log10(b)) + 1];
		for (int i = 0; i < digitsA.length; i++){
			digitsA[i] = a % 10;
			a = a/10;
		}
		for (int i = 0; i < digitsB.length; i++){
			digitsB[i] = b % 10;
			b = b/10;
		}
		Arrays.sort(digitsA);
		Arrays.sort(digitsB);
		for (int i = 0; i < digitsA.length; i++)
			if (digitsA[i] != digitsB[i])
				return false;
		return true;
	}

}
