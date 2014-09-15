import java.util.Arrays;


public class Problem32 {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 1000; i <= 9999; i++)
			if (isPandigitalProduct(i))
				sum += i;
		System.out.println(sum);

	}
	
	public static boolean isPandigital(String s){
		if (s.length() != 9)
			return false;
		char[] digits = new char[9];
		for (int i = 0; i < 9; i++)
			digits[i] = s.charAt(i);
		Arrays.sort(digits);
		for (int i = 0; i < 9; i++)
			if (Character.getNumericValue(digits[i]) != i+1)
				return false;
		return true;
	}
	
	public static boolean isPandigitalProduct(int n){
		if (n >= 10000)
			return false;
		//find all factor pairs
		for (int i = 2; i < Math.sqrt(n); i++){
			if (n%i == 0){
				if (isPandigital("" + (n/i) + i + n))
					return true;
			}
		}
		if (Math.floor(Math.sqrt(n)) == Math.sqrt(n))
			if (isPandigital("" + (int)Math.sqrt(n) + (int)Math.sqrt(n) + n))
				return true;
		return false;
	}
}
