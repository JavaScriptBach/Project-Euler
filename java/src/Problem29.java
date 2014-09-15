import java.util.*;
import java.math.BigInteger;
public class Problem29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<BigInteger> set = new HashSet<BigInteger>();
		for (int i = 2; i <= 100; i++){
			for (int j = 2; j <= 100; j++){
				BigInteger number = BigInteger.valueOf(i).pow(j);
				set.add(number);
			}
		}
		
		System.out.println(set.size());

	}

}
