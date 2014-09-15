
public class Problem44 {
	public static void main(String[] args) {
		int diff = 0;
		for (int j = 0; j < 10000; j++){
			for (int k = j + 1; k < 100000; k++){
				int pk = pentagon(k);
				int pj = pentagon(k-j);
				if (isPentagonal(pk+pj) && isPentagonal(pk-pj)){
					diff = pk-pj;
				}
			}
		}
		System.out.println(diff);

	}
	
	//pre: n > 0
	public static int pentagon(int n){
		return n * (3*n-1) / 2;
	}
	
	public static boolean isPentagonal(int a){
		//2a = n(3n-1)
		//3n^2 -n - 2a = 0
		//n = 1 +/- sqrt(1 + 24a) / 6
		double n = (1 + Math.sqrt(1 + 24 * a)) / 6;
		return Math.round(n) == n;
	}
	
	//Pj - Pk = j(3j-1) - k(3k-1) / 2
}
