import java.math.BigInteger;
public class Problem80 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i < 100; i++)
			sum += count(i);
		System.out.println(sum);
	}
	
	//pre: 0 <= n <= 99
	public static int count(int n){
		int test = (int)Math.floor(Math.sqrt(n));
		if (test * test == n)
			return 0;
		String output = test + ".";
		int sum = test;
		BigInteger current = BigInteger.valueOf((n-test * test) * 100);
		while (output.length() < 101){
			int x = 9;
			BigInteger p = new BigInteger(output.replace(".", ""));
			BigInteger product = BigInteger.valueOf(x).multiply(BigInteger.valueOf(20).multiply(p).add(BigInteger.valueOf(x)));
			while (product.compareTo(current) > 0){
				x--;
				product = BigInteger.valueOf(x).multiply(BigInteger.valueOf(20).multiply(p).add(BigInteger.valueOf(x)));
			}
			output += x;
			sum += x;
			current = current.subtract(product).multiply(BigInteger.valueOf(100));
		}
		//System.out.println(output);
		return sum;
		
	}
	
}
