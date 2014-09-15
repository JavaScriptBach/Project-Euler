
public class Problem37 {
	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		for (int i = 11; count < 11; i++){
			if (isPrime(i) && isTruncRight(i) && isTruncLeft(i)){
				count++;
				sum += i;
				System.out.println(i);
			}
		}
		System.out.println(sum);

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
	
	public static boolean isTruncRight(int n){
		while (n > 0){
			if (!isPrime(n))
				return false;
			n = n/10;
		}
		return true;
	}
	
	public static boolean isTruncLeft(int n){
		while (n > 10){
			if (!isPrime(n))
				return false;
			int digits = (int) Math.floor(Math.log10(n)) + 1;
			n = n % (int)Math.pow(10, digits - 1);
		}
		return isPrime(n);
	}

}
