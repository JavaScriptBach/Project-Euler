
public class Problem205 {
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		double sum = 0.0;
		for (int i = 9; i <= 36; i++){
			double pete = probPete(i);
			double colin = 0.0;
			for (int j = 6; j < i; j++){
				colin += probColin(j);
			}
			sum += pete * colin;
		}
		System.out.println(sum);
		System.out.println(System.currentTimeMillis() - start);

	}
	
	public static double probPete(int target){
		if (target < 9 || target > 36)
			return 0.0;
		return 1.0 * countPete(target, 9) / Math.pow(4, 9);
	}
	
	//pre: 9 <= target <= 36
	//post: returns the number of internal arrangements
	//9 dice that range from 1-4
	private static int countPete(int target, int currentDice){
		if (target < 0)
			return 0;
		if (target == 0 && currentDice == 0)
			return 1;
		if (target == 0 && currentDice > 0)
			return 0;
		if (target > 0 && currentDice == 0)
			return 0;
		int sum = 0;
		for (int i = 1; i <= 4; i++){
			sum += countPete(target - i, currentDice - 1);
		}
		return sum;
	}
	
	public static double probColin(int target){
		if (target < 6 || target > 36)
			return 0.0;
		return 1.0 * countColin(target, 6) / Math.pow(6, 6);
	}
	
	//pre: 6 <= target <= 36
	//post: returns the number of internal arrangements
	//9 dice that range from 1-4
	private static int countColin(int target, int currentDice){
		if (target < 0)
			return 0;
		if (target == 0 && currentDice == 0)
			return 1;
		if (target == 0 && currentDice > 0)
			return 0;
		if (target > 0 && currentDice == 0)
			return 0;
		int sum = 0;
		for (int i = 1; i <= 6; i++){
			sum += countColin(target - i, currentDice - 1);
		}
		return sum;
	}

}
