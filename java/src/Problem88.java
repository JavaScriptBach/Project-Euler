
public class Problem88 {
	//public static boolean[][][][] cache = new boolean[12001][12001][12001][12001];
	public static void main(String[] args){
		System.out.println(minProductSum(50));
	}
	
	public static long minProductSum(int n){
		if (n < 2)
			throw new IllegalArgumentException();
		int current = 2;
		while (!minProductSum(n, current, 0, 1)){
			current++;
		}
		return current;
	}
	
	private static boolean minProductSum(int numberTerms, long target, long currentSum, long currentProduct){
		if (target < 0 || currentSum < 0 || currentProduct < 0)
			throw new IllegalArgumentException();
		if (currentProduct > target || currentSum > target)
			return false;
		if (numberTerms == 1)
			return currentProduct * (target - currentSum) == target;
		for (long i = 1; currentProduct * i <= target; i++){
			if (minProductSum(numberTerms - 1, target, currentSum + i, currentProduct * i))
				return true;
		}
		return false;
	}
}
