
public class Problem64 {
	public static void main(String[] args){
		int sum = 0;
		for (int i = 2; i <= 10000; i++){
			if (Math.sqrt(i) == Math.floor(Math.sqrt(i))) continue;
			SquareRootFraction f = new SquareRootFraction(i);
			if (f.period() % 2 == 1)
				sum++;
		}
		System.out.println(sum);
	}
}
