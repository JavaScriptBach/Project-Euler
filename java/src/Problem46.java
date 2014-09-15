public class Problem46 {
	public static void main(String[] args) {
		int current = 9;
		while (canBeWritten(current)){
			current = getNextOddComposite(current);
		}
		System.out.println(current);
	}
	
	public static boolean canBeWritten(int n){
		for (int i = 1; i <= n/2; i++){
			//do something with i and n-i
			if (isTwiceSquare(i) && isPrime(n-i) || isTwiceSquare(n-i) && isPrime(i))
					return true;
		}
		return false;
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
	
	public static boolean isTwiceSquare(int n){
		return n % 2 == 0 && Math.floor(Math.sqrt(n/2)) == Math.sqrt(n/2);
	}
	
	public static int getNextOddComposite(int n){
		while (true){
			n += 2;
			if (!isPrime(n))
				return n;
		}
	}
}
