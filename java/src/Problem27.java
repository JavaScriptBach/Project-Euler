
public class Problem27 {
	public static void main(String[] args) {
		int max = 0;
		int product = 0;
		for (int a = -999; a <= 999; a++){
			for (int b = -999; b <= 999; b++){
				int number = computeNumberOfPrimes(a, b);
				if (number > max){
					max = number;
					product = a * b;
				}
			}
		}
		System.out.println(product);
	}
	
	public static int computeNumberOfPrimes(int a, int b){
		int answer = b;
		int count = 0;
		int n = 0;
		while (isPrime(answer)){
			count++;
			n++;
			answer = n * n + a * n + b;
			
		}
		return count;
		
	}
	
	public static boolean isPrime(int n){
		if (n < 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++){
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
