import java.util.*;
public class Problem26 {
	public static void main(String[] args){
		int max = 0;
		int maxIndex = 0;
		for (int i = 2; i < 1000; i++)
			if (solve(i) > max){
				maxIndex = i;
				max = solve(i);
			}
		System.out.println(maxIndex);
	}
	
	//pre: n >= 2
	//post: returns the length of the recurring cycle for 1/n
	public static int solve(int n){
		if (n < 2)
			throw new IllegalArgumentException();
		List<Integer> list = new ArrayList<Integer>();
		int current = (int)Math.pow(10, digits(n));
		while (!list.contains(current)){
			if (current % n == 0)
				return 0;
			list.add(current);
			current = (int)Math.pow(10, digits(n)) * (current % n);
		}
		//System.out.println(list);
		return list.size() - list.indexOf(current);
	}
	
	public static int digits(int n){
		return (int)Math.floor(Math.log10(n)) + 1;
	}
}
