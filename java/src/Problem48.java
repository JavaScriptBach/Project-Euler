import java.math.BigInteger;


public class Problem48 {

	public static void main(String[] args) {
		BigInteger sum = BigInteger.ZERO;
		for (int i = 1; i <= 1000; i++){
			sum = sum.add(BigInteger.valueOf(i).pow(i));
		}
		int[] digits = new int[10];
		for (int i = 0; i < 10; i++){
			digits[i] = sum.mod(BigInteger.TEN).intValue();
			sum = sum.divide(BigInteger.TEN);
		}
		for (int i = 9; i >= 0; i--)
			System.out.print(digits[i]);
	}

}
