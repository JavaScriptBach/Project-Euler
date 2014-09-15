
public class Problem148 {
	public static final int MAX = 100;
	public static int[][] triangle = new int[MAX][MAX];
	public static void main(String[] args){
		triangle[0][0] = 1;
		for (int i = 1; i < MAX; i++){
			triangle[i][0] = 1;
			for (int j = 1; j <= i; j++)
				triangle[i][j] = ((triangle[i-1][j] + triangle[i-1][j-1]) % 7);
		}
		//print();
		System.out.println(countZeroes(100));
	}
	
	public static void print(){
		for (int i = 0; i < MAX; i++){
			for (int j = 0; j <= i; j++)
				System.out.print(triangle[i][j] + " ");
			System.out.println();
		}
	}
	
	public static int count(){
		int count = 0;
		for (int i = 0; i < MAX; i++){
			for (int j = 0; j <= i; j++){
				if (triangle[i][j] != 0)
					count++;
			}
		}
		return count;
	}
	
	public static int countZeroes(int n){
		if (n <= 7)
			return 0;
		int sum = 0;
		for (int i = 8; i <= n; i++){
			if (i % 7 == 0) continue;
			sum += (i/7) * (7 - (i % 7));
		}
		return sum;
		
		
	}
}
