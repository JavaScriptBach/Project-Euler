import java.util.Arrays;


public class Problem52 {

	public static void main(String[] args) {
		int current = 1;
		while (!same(current, 2*current) || !same(current, 3*current) || !same(current, 4*current) || !same(current, 5*current) || !same(current, 6*current)){
			current++;
		}
		System.out.println(current);
			
		

	}
	
	public static boolean same(int x, int y){
		int[] a = new int[(int)Math.floor(Math.log10(x)) + 1];
		int[] b = new int[(int)Math.floor(Math.log10(y)) + 1];
		for (int i = a.length - 1; i >= 0; i--){
			a[i] = x % 10;
			x = x/10;
		}
		for (int i = b.length - 1; i >= 0; i--){
			b[i] = y % 10;
			y = y/10;
		}
		if (a.length != b.length)
			return false;
		Arrays.sort(a);
		Arrays.sort(b);
		for (int i = 0; i < a.length; i++)
			if (a[i] != b[i])
				return false;
		return true;
	}

}
