import java.math.BigInteger;
public class Problem56 {
	public static void main(String[] args) {
		int max = 0;
		for (int i = 1; i < 100; i++){
			for (int j = 1; j < 100; j++){
				int digitsum = digitSum(BigInteger.valueOf(i).pow(j));
				if (digitsum > max)
					max = digitsum;
			}
		}
		System.out.println(max);

	}
	
	public static int digitSum(BigInteger n){
		int sum = 0;
		while (!n.equals(BigInteger.ZERO)){
			sum += n.mod(BigInteger.TEN).intValue();
			n = n.divide(BigInteger.TEN);
		}
		return sum;
	}

}
