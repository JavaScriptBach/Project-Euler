
public class Problem179 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int current = 1;
		int next = 2;
		int count = 0;
		int currentFactors = countFactors(current);
		while (current < 10000000){
			int nextFactors = countFactors(next);
			if (currentFactors == nextFactors)
				count++;
			current = next;
			currentFactors = nextFactors;
			next++;
			System.out.println(current);
		}
		System.out.println(count);

	}
	
	public static int countFactors(int n){
		int count = 0;
		double root = Math.sqrt(n);
		for (int i = 1; i < root; i++){
			if (n%i == 0)
				count += 2;
		}
		if (Math.floor(root) == root)
			count++;
		return count;
		
	}
}
