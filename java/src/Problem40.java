
public class Problem40 {
	public static void main(String[] args) {
		int answer = compute(1) * compute(10) * compute(100) * compute(1000) * compute(10000) * compute(100000) * compute(1000000);
		System.out.println(answer);

	}
	
	//computes the nth digit of Champernowne's constant
	public static int compute(int n){
		int current = 1;
		String answer = "";
		while (answer.length() < n){
			answer += current;
			current++;
		}
		return Character.getNumericValue(answer.charAt(n-1));
	}

}
