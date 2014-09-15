import java.math.BigInteger;
public class Problem65 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Fraction f = e(100);
		int sum = 0;
		String big = f.n.toString();
		for (int i = 0 ; i < big.length(); i++)
			sum += Character.getNumericValue(big.charAt(i));
		System.out.println(sum);
		System.out.println("time = " + (System.currentTimeMillis() - start) + " ms");
	}
	
	public static Fraction e(int n){
		if (n == 1)
			return new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(1));
		if (n == 2)
			return new Fraction (BigInteger.valueOf(3), BigInteger.valueOf(1));
		if (n == 3)
			return new Fraction (BigInteger.valueOf(8), BigInteger.valueOf(3));
		Fraction current = new Fraction(BigInteger.valueOf(1), BigInteger.valueOf(current(n)));
		for (int i = n-1; i > 1; i--){
			current.add(current(i));
			current.reciprocal();			
		}
		current.add(2);
		return current;
	}
	
	public static int current (int n){
		if (n < 1)
			throw new IllegalArgumentException();
		if (n == 1)
			return 2;
		if (n % 3 == 0)
			return n / 3 * 2;
		return 1;
	}

}
