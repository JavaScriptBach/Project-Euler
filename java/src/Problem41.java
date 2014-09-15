import java.util.*;
public class Problem41 {
	public static void main(String[] args) {
		String current = "987654321";
		while (true){
			if (Primes.isPrime(Long.parseLong(current))){
				System.out.println(current);
				return;
			}
			current = getNextPandigital(current);
		}
	}
	
	//pre: given a pandigital
	//post: returns the next smallest pandigital
	public static String getNextPandigital(String current){
		for (int i = current.length() - 2; i >= 0; i--){
			String part = current.substring(i);
			String arrange = arrange(part);
			if (!arrange.equals(part)){
				return current.substring(0, i) + arrange;
			}
		}
		String output = "";
		for (int i = current.length() - 1; i >= 1; i--){
			output += i;
		}
		return output;
	}
	
	//pre: given a string like 6234, 21, 423 etc, 213.
	//returns the next smallest string out of the possible permutations
	public static String arrange(String s){
		boolean increasing = true;
		for (int i = 0; i < s.length() - 1; i++){
			int current = Character.getNumericValue(s.charAt(i));
			int next = Character.getNumericValue(s.charAt(i+1));
			if (current > next){
				increasing = false;
				break;
			}
		}
		if (increasing)
			return s;
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < s.length(); i++){
			numbers.add(Character.getNumericValue(s.charAt(i)));
		}
		boolean done = false;
		int current = numbers.get(0);
		while (!done){
			current--;
			if (numbers.contains(current))
				done = true;
		}
		String output = "" + current;
		Collections.sort(numbers);
		for (int i = numbers.size() - 1; i >= 0; i--){
			if (numbers.get(i) != current)
				output += numbers.get(i);
		}
		return output;
	}
}
