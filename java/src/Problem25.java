import java.math.BigInteger;


public class Problem25 {
	public static void main(String[] args){
		BigInteger max = BigInteger.valueOf(10).pow(999);
		BigInteger first = BigInteger.ONE;
		BigInteger second = BigInteger.ONE;
		long count = 2;
		BigInteger third = BigInteger.ZERO;
		while (third.compareTo(max) == -1){
			third = first.add(second);
			first = second;
			second = third;
			count++;
		}
		System.out.println(count);
	}
}
