import java.util.Arrays;


public class Problem35 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 2; i < 1000000; i++){
			int[] current = rotateDigits(i);
			if (isCircularPrime(current))
				count++;
		}
		System.out.println(count);

	}
	
	//pre: passed an int[] of all possible digit rotations
	//post: determines whether a number is a circular prime
	public static boolean isCircularPrime(int[] numbers){
		for (int i = 0; i < numbers.length; i++)
			if (!Primes.isPrime(numbers[i]))
				return false;
		return true;
	}
	
	public static int[] rotateDigits (int n){
		int[] output = new int[(int)Math.floor((Math.log10(n))) + 1];
		output[0] = n;
		String number = "" + n;
		for (int i = 1; i < output.length; i++){
			String start = number.substring(i);
			String end = number.substring(0, i);
			output[i] = Integer.parseInt(start + end);
		}
		
		return output;
	}
}
