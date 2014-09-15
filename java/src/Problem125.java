import java.util.*;
public class Problem125 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		Set<Long> answers = new HashSet<Long>();
		for (int i = 2; i < 10000; i++){
			for (int j = 1; j < i; j++){
				long sum = count(j, i);
				if (sum < 100000000 && isPalindrome(sum))
					answers.add(sum);
			}
		}
		long answer = 0;
		Iterator<Long> i = answers.iterator();
		while (i.hasNext())
			answer += i.next();
		System.out.println(answer);
		System.out.println(System.currentTimeMillis() - start);

	}
	
	public static boolean isPalindrome(long n){
		String s = "" + n;
		for (int i = 0; i < s.length()/2; i++){
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
	
	public static long count(long start, long end){
		long a = end * (end + 1) * (2 * end + 1) / 6;
		long b = (start-1) * (start) * (2*start - 1) / 6;
		return a - b;
	}

}
