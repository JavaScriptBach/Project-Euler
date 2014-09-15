import java.math.BigInteger;
public class Problem20 {
	public static void main(String[] args){
		BigInteger result = BigInteger.valueOf(1);
		int sum = 0;
		for (int i = 2; i <= 100; i++){
			result = result.multiply(BigInteger.valueOf(i));
		}
		String s = result.toString();
		for (int i = 0; i < s.length(); i++){
			sum += Character.getNumericValue(s.charAt(i));
		}
		System.out.println(sum);
	}
}
