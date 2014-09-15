
public class Problem23 {
	public static void main(String[] args){
		int sum = 276; //1+2+...+23
		for (int i = 25; i < 28123; i++){
			boolean can = false;
			for (int j = 1; j <= i/2; j++){
				if (isAbundant(j) && isAbundant(i-j)){
					can = true;
					break;
				}
			}
			if (!can)
				sum += i;
		}
		System.out.println(sum);
	}
	
	public static boolean isAbundant(int n){
		if (n == 1)
			return false;
		int sum = 1;
		for (int i = 2; i < Math.sqrt(n); i++){
			if (n % i == 0){
				sum += i;
				sum += n/i;
			}
		}
		if (Math.floor(Math.sqrt(n)) == Math.sqrt(n))
			sum += Math.sqrt(n);
		return sum > n;
	}
}
