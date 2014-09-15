import java.math.BigInteger;
public class Problem100 {
	public static final long min = 1000000000001L;
	public static final double target = 0.5;
	//first probability > 1/sqrt(2)
	//second probablity < 1/sqrt(2)
	public static void main(String[] args){
		for (long i = min; i <= Long.MAX_VALUE; i++){
			long num = find(i);
			Fraction f = new Fraction(BigInteger.valueOf(num), BigInteger.valueOf(i)).multiply(new Fraction(BigInteger.valueOf(num-1), BigInteger.valueOf(i-1)));
			if (f.getN().equals(BigInteger.ONE) && f.getD().equals(BigInteger.valueOf(2))){
				System.out.println(num);
				return;
			}
		}
	}
	
	//finds the smallest num such that num/deno > 1/sqrt(2)
	public static long find(long deno){
		//num = deno/sqrt(2)
		return (long)Math.ceil(1.0 * deno / Math.sqrt(2));
	}

}
