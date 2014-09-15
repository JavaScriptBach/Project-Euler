import java.math.BigInteger;
public class Problem53 {

	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 100; i++){
			for (int j = 0; j <= i; j++){
				if (choose(i, j).compareTo(BigInteger.valueOf(1000000)) == 1){
					count++;
				}
			}
		}
		System.out.println(count);
	}
	
	public static BigInteger choose(int n, int r){
		if (n < r)
			throw new IllegalArgumentException();
		BigInteger answer = BigInteger.ONE;
		for (int i = n; i > Math.max(r, n-r); i--)
			answer = answer.multiply(BigInteger.valueOf(i));
		for (int i = 1; i <= Math.min(r, n-r); i++)
			answer = answer.divide(BigInteger.valueOf(i));
		return answer;
	}

}
