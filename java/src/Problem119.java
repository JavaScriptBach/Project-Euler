import java.math.BigInteger;
public class Problem119 {
	public static void main(String[] args){
		int count = 0;
		BigInteger current = BigInteger.valueOf(11);
		while (count != 30){
			//System.out.println(current);
			if (isDigitPower(current)){
				count++;
				System.out.println(count + ". " + current);
			}
			current = current.add(BigInteger.ONE);
		}
	}
	
	public static int sumDigits(BigInteger n){
		int sum = 0;
		String number = n.toString();
		for (int i = 0; i < number.length(); i++)
			sum += Character.getNumericValue(number.charAt(i));
		return sum;
	}
	
	public static boolean isDigitPower(BigInteger n){
		int base = sumDigits(n);
		if (base <= 1)
			return false;
		BigInteger current = BigInteger.valueOf(base);
		while (current.compareTo(n) < 0){
			current = current.multiply(BigInteger.valueOf(base));
		}
		return current.equals(n);
	}
}
