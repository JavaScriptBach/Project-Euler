import java.util.*;
public class Problem38 {

	public static void main(String[] args) {
		for (int i = 9999; i > 0; i--){
			String s = "" + i;
			int counter = 2;
			while (s.length() < 9){
				s += (counter * i);
				counter++;
			}
			if (isPandigital(s)){
				System.out.println(s);
				return;
			}
		}

	}
	
	public static boolean isPandigital(String s){
		if (s.length() != 9)
			return false;
		char[] digits = new char[9];
		for (int i = 0; i < 9; i++)
			digits[i] = s.charAt(i);
		Arrays.sort(digits);
		for (int i = 0; i < 9; i++)
			if (Character.getNumericValue(digits[i]) != i+1)
				return false;
		return true;
	}
}
