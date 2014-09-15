import java.util.*;
public class Problem21 {
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		for (int a = 2; a < 10000; a++){
			int b = d(a);
			if (d(b) == a && a != b && !list.contains(a)){
				list.add(a);
			}
		}
		int sum = 0;
		for (int i = 0; i < list.size(); i++)
			sum += list.get(i);
		System.out.println(sum);
	}
	
	public static int d(int n){
		if (n == 1)
			return 0;
		int sum = 1;
		for (int i = 2; i < Math.sqrt(n); i++){
			if (n % i == 0){
				sum += i + n / i;
			}
		}
		
		if (Math.floor(Math.sqrt(n)) == Math.sqrt(n))
				sum += Math.sqrt(n);
		return sum;
	}
}
