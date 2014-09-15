import java.util.*;
import java.math.BigInteger;
public class Problem121 {
	public static void main(String[] args){
		Fraction sum = new Fraction(BigInteger.ZERO, BigInteger.ONE);
		for (int i = 7; i >= 0; i--)
			sum = sum.add(calculate(generate(i, 15-i)));
		System.out.println(sum);
		System.out.println(sum.getD().divide(sum.getN()));
	}
	
	public static Fraction calculate(List<String> list){
		Fraction output = new Fraction(BigInteger.ZERO, BigInteger.ONE);
		for (String s: list){
			output = output.add(calculate(s));
		}
		return output;
	}
	public static List<String> generate(int red, int blue){
		return generate(red, blue, "", new ArrayList<String>());
	}
	
	private static List<String> generate(int red, int blue, String current, List<String> output){
		if (red == 0){
			for (int i = 0; i < blue; i++)
				current += "B";
			output.add(current);
			return output;
		}
		
		if (blue == 0){
			for (int i = 0; i < red; i++)
				current += "R";
			output.add(current);
			return output;
		}
		output = generate(red-1, blue, current + "R", output);
		output = generate(red, blue-1, current + "B", output);
		return output;
	}
	
	public static Fraction calculate(String s){
		Fraction output = new Fraction(BigInteger.ONE, BigInteger.ONE);
		for (int i = 0; i < s.length(); i++){
			//there are 2+i discs in the box; 1 blue disc, 1+i red discs
			char next = s.charAt(i);
			if (next == 'R'){
				output = output.multiply(new Fraction(BigInteger.valueOf(1+i), BigInteger.valueOf(2+i)));
			} else {
				output = output.multiply(new Fraction(BigInteger.ONE, BigInteger.valueOf(2+i)));
			}
		}
		return output;
	}
}
