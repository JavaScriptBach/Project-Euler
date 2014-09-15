
public class Problem433 {
	public static final int DIMENSIONS = 1000;
	public static int[][] cache = new int[DIMENSIONS][DIMENSIONS];
	public static void main(String[] args){
		System.out.println(sum(100000));
	}
	public static int count(int a, int b){
		int count = 0;
		int oldA = a;
		int oldB = b;
		while (b != 0){
			if (a <= DIMENSIONS && b <= DIMENSIONS && cache[a-1][b-1] != 0)
				return count + cache[a-1][b-1];
			int temp = a;
			a = b;
			b = temp % b;
			count++;
			
		}
		if (oldA <= DIMENSIONS && oldB <= DIMENSIONS)
			cache[oldA-1][oldB-1] = count;
		return count;
	}
	
	public static int sum(int n){
		int sum = 0;
		for (int i = 1; i <= n; i++){
			for (int j = 1; j < i; j++){
				int temp = count(i, j);
				sum += 2 * temp + 1;
			}
		}
		for (int i = 1; i <= n; i++)
			sum += 1;
		return sum;
	}
}
