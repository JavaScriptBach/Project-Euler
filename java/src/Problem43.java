import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Problem43 {
	public static void main(String[] args) {
		long sum = 0;
		String current = "9876543210";
		while (!current.equals("1023456789")){
			if (divis(current))
				sum += Long.parseLong(current);
			current = getNextPandigital(current);
		}
		if (divis("1023456789"))
			sum += Long.parseLong(current);
		System.out.println(sum);
	}
	
	public static boolean divis(String s){
		int one = Integer.parseInt(s.substring(1, 4));
		int two = Integer.parseInt(s.substring(2, 5));
		int three = Integer.parseInt(s.substring(3, 6));
		int four = Integer.parseInt(s.substring(4, 7));
		int five = Integer.parseInt(s.substring(5, 8));
		int six = Integer.parseInt(s.substring(6, 9));
		int seven = Integer.parseInt(s.substring(7, 10));
		return one % 2 == 0 && two % 3 == 0 && three % 5 == 0 && four % 7 == 0 && five % 11 == 0 && six % 13 == 0 && seven % 17 == 0;
	
	}
	//pre: given a pandigital
		//post: returns the next smallest pandigital
		public static String getNextPandigital(String current){
			if (current.equals("1023456789"))
				return current;
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
