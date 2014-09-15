
public class Problem76 {
	public static void main(String[] args) {
		long current = System.currentTimeMillis();
		System.out.println(explore(100, 99));
		System.out.println(System.currentTimeMillis() - current);

	}
	
	public static int explore(int sum, int current){
			if (sum < 0)
				return 0;
			if (sum == 0 || current == 1)
				return 1;
			int count = 0;
			for (int i = 0; i <= sum; i += current)
				count += explore(sum-i, current-1);
			return count;
	}

}
