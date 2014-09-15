
public class Problem206 {

	public static void main(String[] args) {
		//19 digits = 10^18
		//therefore square root should start at 10^9
		long current = 1929394959697989990L;
		while (!isSquare(current)){
			System.out.println(current);
			current = next("" + current);
		}
		System.out.println((long)Math.sqrt(current));
	}
	
	public static long next(String s){
		int currentIndex = 17;
		while (currentIndex > 0){
			int digit = Character.getNumericValue(s.charAt(currentIndex));
			if (digit > 0){
				return Long.parseLong(s.substring(0, currentIndex) + (digit - 1) + s.substring(currentIndex + 1));
			} else {
				s = s.substring(0, currentIndex) + 9 + s.substring(currentIndex + 1);
				currentIndex -= 2;
			}
		}
		return -1;
	}
	
	public static boolean isSquare(long n){
		return Math.floor(Math.sqrt(n)) == Math.sqrt(n);
	}

}
