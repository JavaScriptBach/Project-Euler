import java.math.BigInteger;
public class Problem55 {
	public static void main(String[] args){
		int count = 0;
		for (int i = 0; i < 10000; i++){
			if (isLychrel(BigInteger.valueOf(i)))
				count++;
		}
		System.out.println(count);
		
	}
	
	public static boolean isPalindrome(String s){
		for (int i = 0; i < s.length()/2; i++){
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
	
	public static String reverse(String s){
		String answer = "";
		for (int i = s.length() - 1; i >= 0; i--)
			answer += s.charAt(i);
		return answer;
	}
	
	public static boolean isLychrel(BigInteger n){
		BigInteger current = n;
		for (int i = 1; i < 50; i++){
			BigInteger reverse = new BigInteger(reverse(current.toString()));
			BigInteger sum = reverse.add(current);
			if (isPalindrome(sum.toString()))
				return false;
			current = sum;
		}
		return true;
	}
}
