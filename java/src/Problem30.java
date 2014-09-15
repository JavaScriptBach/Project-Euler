
public class Problem30 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 10; i < 10000000; i++)
			if (isFifthPower(i))
				sum += i;
		System.out.println(sum);
	}
	
	public static boolean isFifthPower(int n){
		double sum = 0.0;
		int current = n;
		while (current > 0){
			sum += Math.pow(current % 10, 5);
			current = current / 10;
		}
		return sum == n;
	}

}
