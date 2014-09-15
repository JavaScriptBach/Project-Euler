import java.util.*;
public class Problem74 {
	public static final int[] factorial = {1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880};
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i < 1000000; i++){
			System.out.println(i);
			if (countChains(i) == 60)
				count++;
		}
		System.out.println(count);
	}
	
	public static int countChains(int n){
		List<Integer> list = new ArrayList<Integer>();
		list.add(n);
		int next = compute(n);
		while (!list.contains(next)){
			list.add(next);
			next = compute(next);
		}
		return list.size();
		
	}
	public static int compute(int n){
		int output = 0;
		while (n > 0){
			output += factorial[n%10];
			n/=10;

		}
		return output;
	}

}
