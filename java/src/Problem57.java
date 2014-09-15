import java.math.BigInteger;
public class Problem57 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int count = 0;
		for (int i = 1; i <= 1000; i++){
			Fraction f = root2(i);
			if (f.n.toString().length() > f.d.toString().length())
				count++;
		}
		System.out.println(count);
		System.out.println(System.currentTimeMillis() - start);
	}
	
	public static Fraction root2(int n){
		if (n == 1)
			return new Fraction(BigInteger.valueOf(3), BigInteger.valueOf(2));
		if (n == 2)
			return new Fraction (BigInteger.valueOf(7), BigInteger.valueOf(5));
		Fraction current = new Fraction(BigInteger.valueOf(2), BigInteger.valueOf(5));
		for (int i = 0; i < n-2; i++){
			current.add(2);
			current.reciprocal();
		}
		current.add(1);
		return current;
	}

}
