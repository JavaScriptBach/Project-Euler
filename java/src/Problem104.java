import java.math.BigInteger;
import java.util.Arrays;
public class Problem104 {
	public static int[] digits = new int[9];
	public static void main(String[] args) {
		int count = 3;
		BigInteger one = BigInteger.ONE;
		BigInteger two = BigInteger.ONE;
		BigInteger three = one.add(two);
		while (!isPandigital(three)){
			BigInteger temp = two;
			two = three;
			one = temp;
			three = one.add(two);
			count++;
			//System.out.println(count);
			
		}
		System.out.println(count);
	}
	
	public static boolean isPandigital(BigInteger n){
		String last = n.remainder(BigInteger.valueOf(1000000000)).toString();
		if (last.length() != 9)
			return false;
		for (int i = 0; i < 9; i++)
			digits[i] = Character.getNumericValue(last.charAt(i));
		Arrays.sort(digits);
		for (int i = 0 ; i < 9; i++)
			if (digits[i] != i+1)
				return false;
		String first = n.toString().substring(0, 10);
		for (int i = 0; i < 9; i++)
			digits[i] = Character.getNumericValue(first.charAt(i));
		Arrays.sort(digits);
		for (int i = 0 ; i < 9; i++)
			if (digits[i] != i+1)
				return false;
		return true;
	}

}
