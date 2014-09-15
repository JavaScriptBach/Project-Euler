public class Problem112 {
	public static void main(String[] args) {
		long numberBounces = 0;
		long total = 100;
		double percent = 0.0;
		while (percent != 99.0){
			total++;
			if (!isDecreasing(total) && !isIncreasing(total)){
				numberBounces++;
				percent = 100.0 * numberBounces / total;
			}
		}
		System.out.println(total);
	}
	
	public static boolean isDecreasing(long n){
		long prev = n % 10;
		n = n/10;
		while (n > 0){
			long current = n % 10;
			if (prev > current)
				return false;
			prev = current;
			n = n/10;
		}
		return true;
	}
	
	public static boolean isIncreasing(long n){
		long prev = n % 10;
		n = n/10;
		while (n > 0){
			long current = n % 10;
			if (prev < current)
				return false;
			prev = current;
			n = n/10;
		}
		return true;
	}
}
