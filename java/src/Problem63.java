import java.math.BigInteger;
public class Problem63 {

	public static void main(String[] args) {
		int sum = 0;
		int current = 1;
		int count = count(current);
		while (count != 0){
			sum += count;
			current++;
			count = count(current);
			
		}
		System.out.println(sum);

	}
	
	public static int count(int power){
		int count = 0;
		for (int i = 1; i <= 9; i++){
			if (BigInteger.valueOf(i).pow(power).toString().length() == power)
				count++;
		}
		return count;
	}

}
