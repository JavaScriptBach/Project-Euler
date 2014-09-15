
public class Problem92 {
	public static void main(String[] args){
		int sum = 0;
		for (long i = 2; i < 10000000; i++){
			long current = i;
			while (current != 1 && current != 89){
				current = convert(current);
			}
			if (current == 89)
				sum++;
		}
		System.out.println(sum);
	}
	
	public static long convert(long number){
		long output = 0;
		while (number > 0){
			int digit = (int)number % 10;
			output += digit * digit;
			number = number / 10;
		}
		return output;
	}
}
