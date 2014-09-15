import java.util.*;
public class Problem71 {
	public static final double TARGET = 3.0/7;
	public static void main(String[] args){
		System.out.println(solve());
	}
	
	//pre: a > b
	public static int gcd(int a, int b){
			//gcd(a, b) = gcd(b, a%b)
		while (b > 0){
			int temp = a;
			a = b;
			b = temp % b;
		}
			return a;
	}
	
	//returns the numerator of the fraction that is immediately to the left of 3/7
	//currently takes 20 minutes to solve LOL
	public static int solve(){
		double best = 0.4;
		int answer = 2;
		for (int i = 2; i <= 1000000; i++){
			System.out.println(i);
			for (int j = (int)Math.min(1, 0.4 * i); j < i/2; j++){
				double current = j * 1.0 / i;
				if (current < TARGET && current > best && gcd(i, j) == 1){
					best = current;
					answer = j;
				}
			}
		}
		return answer;
	}
}
