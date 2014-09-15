//Phillip Huang
//this class is where I write programs to help me do Math 380 homework
public class Math380 {
	public static void main(String[] args){
		boolean[] sieve = Primes.getPrimes(200);
		int count = 0;
		for (int i = 100; i < sieve.length; i++){
			if (sieve[i]){
				System.out.println(i);
				count++;
			}
		}
		System.out.println("there are " + count + " primes less than or equal to " + (sieve.length - 1));
		System.out.println("percentage of numbers that are prime: " + (100.0 * count / (sieve.length - 1)) + "%");
	}
	
}
