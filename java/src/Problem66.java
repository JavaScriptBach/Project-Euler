import java.util.List;
import java.math.BigInteger;
public class Problem66 {
	public static void main(String[] args){
		BigInteger max = BigInteger.ZERO;
		int maxD = 0;
		for (int i = 2; i <= 1000; i++){
			BigInteger current = solve(i);
			if (current.compareTo(max) > 0){
				max = current;
				maxD = i;
			}
		}
		System.out.println(maxD);
	}
	public static BigInteger solve(int d){
		int test = (int)Math.floor(Math.sqrt(d));
		if (test * test == d)
			return BigInteger.ONE;
		//find the continued fraction expansion for sqrt(d)
		SquareRootFraction f = new SquareRootFraction(d);
		List<Integer> period = f.getPeriod();
		int current = 0;
		Fraction answer = get(current, test, period);
		while (answer.getN().pow(2).subtract(answer.getD().pow(2).multiply(BigInteger.valueOf(d))).compareTo(BigInteger.ONE) != 0){
			current++;
			answer = get(current, test, period);
		}
		return answer.getN();
		//System.out.println(period);
		//System.out.println(get(9, test, period));
	}
	
	public static Fraction get(int count, int first, List<Integer> period){
		if (count == 0)
			return new Fraction(BigInteger.valueOf(first), BigInteger.ONE);
		Fraction output = new Fraction(BigInteger.ONE, BigInteger.valueOf(period.get((count-1) % period.size())));
		for (int i = count - 1; i >= 1; i--){
			output = output.add(new Fraction(BigInteger.valueOf(period.get((i-1) % period.size())), BigInteger.ONE));
			output = output.reciprocal();
		}
		output = output.add(new Fraction(BigInteger.valueOf(first), BigInteger.ONE));
		return output;
	}
}
