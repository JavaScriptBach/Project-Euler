import java.math.BigInteger;

public class Problem97 {
	public static void main(String[] args) {
		BigInteger prime = BigInteger.valueOf(2).pow(7830457).multiply(BigInteger.valueOf(28433)).add(BigInteger.ONE);
		for (int i = 0; i < 10; i++){ //prints in reverse
			System.out.print(prime.mod(BigInteger.TEN));
			prime = prime.divide(BigInteger.TEN);
		}
	}

}
