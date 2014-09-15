
public class Problem34 {
	public static void main(String[] args) {
		int sum = 0;
		for (int i = 10; i < 10000000; i++)
			if (isDigitFactorial(i))
				sum += i;
		System.out.println(sum);

	}
	
	public static boolean isDigitFactorial(int n){
		int sum = 0;
		int current = n;
		while (current > 0){
			sum += factorial(current % 10);
			current = current/10;
		}
		return sum == n;
	}
	
	public static int factorial(int n){
		if (n <= 1)
			return 1;
		return n * factorial(n-1);
	}

}
