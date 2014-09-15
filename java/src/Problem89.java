import java.util.*;
import java.io.*;
public class Problem89 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("roman.txt"));
		int saved = 0;
		while (input.hasNextLine()){
			String next = input.nextLine();
			saved += next.length() - encode(decode(next)).length();
		}
		System.out.println(saved);

	}
	
	public static int decode(String roman){
		if (roman.length() == 0)
			throw new IllegalArgumentException();
		if (roman.length() == 1)
			return decodeNumeral(roman.charAt(0));
		int output = 0;
		for (int i = 0; i < roman.length(); i++){
			if (i == roman.length() - 1)
				output += decodeNumeral(roman.charAt(roman.length() - 1));
			else {
				char current = roman.charAt(i);
				char next = roman.charAt(i+1);
				if (decodeNumeral(current) >= decodeNumeral(next)){
					output += decodeNumeral(current);
				}
				else{
					output += decodeNumeral(next) - decodeNumeral(current);
					i++;
				}
			}
				
		}
		return output;
	}
	
	public static String encode(int number){
		String output = "";
		int count = number/1000;
		for (int i = 0; i < count; i++){
			output += 'M';
			number -= 1000;
		}
		if (number >= 900){
			number -= 900;
			output += "CM";
		}
		if (number >= 500){
			number -= 500;
			output += "D";
		}
		if (number >= 400){
			number -= 400;
			output += "CD";
		}
		while (number >= 100){
			number -= 100;
			output += "C";
		}
		if (number >= 90){
			number -= 90;
			output += "XC";
			
		}
		if (number >= 50){
			number -= 50;
			output += "L";
		}
		if (number >= 40){
			number -= 40;
			output += "XL";
		}
		while (number >= 10){
			number -=10;
			output += "X";
		}
		if (number == 9){
			return output + "IX";
		}
		if (number == 4){
			return output + "IV";
		}
		if (number >= 5){
			number -= 5;
			output += "V";
		}
		while (number >= 1){
			output += "I";
			number -= 1;
		}
		return output;
	}
	
	public static int decodeNumeral(char c){
		if (c == 'M')
			return 1000;
		if (c == 'D')
			return 500;
		if (c == 'C')
			return 100;
		if (c == 'L')
			return 50;
		if (c == 'X')
			return 10;
		if (c == 'V')
			return 5;
		return 1;
	}
}
