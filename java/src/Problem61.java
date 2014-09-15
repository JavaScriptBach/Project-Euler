import java.util.*;
public class Problem61 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		List<Integer> list = new ArrayList<Integer>();
		boolean[] remaining = new boolean[9];
		for (int i = 4; i < 9; i++)
			remaining[i] = true;
		for (int i = 45; i <= 140; i++){
			list.add(triangle(i));
			if (explore(list, remaining)){
				System.out.println("time elapsed: " + (System.currentTimeMillis() - start));
				return;
			}
			list.remove(0);
		}
		
	}
	
	//pre: list is already cyclic
	//4 <= current <= 8
	public static boolean explore(List<Integer> list, boolean[] remaining){
		if (list.size() == 6 && isCyclic(list.get(5), list.get(0))){
			System.out.println(list);
			int sum = 0;
			for (int i = 0; i < 6; i++)
				sum += list.get(i);
			System.out.println(sum);
			return true;
		}
		for (int i = 4; i <= 8; i++){
			if (remaining[i]){
				for (int j = getLower(i); j <= getUpper(i); j++){
					if (isCyclic(list.get(list.size() - 1), get(i, j))){
						list.add(get(i, j));
						remaining[i] = false;
						if (explore(list, remaining))
							return true;
						list.remove(list.size() - 1);
						remaining[i] = true;
					}
				}
			}
		}
		return false;
	}
	
	public static int get(int type, int n){
		if (type == 3)
			return triangle(n);
		if (type == 4)
			return square(n);
		if (type == 5)
			return pentagon(n);
		if (type == 6)
			return hexagon(n);
		if (type == 7)
			return heptagon(n);
		return octagon(n);
	}
	
	public static boolean isCyclic(int a, int b){
		return a % 100 == b / 100;
	}
	
	public static int getLower(int n){
		if (n == 4)
			return 32;
		if (n == 5)
			return 26;
		if (n == 6)
			return 23;
		if (n == 7)
			return 21;
		return 19;
	}
	
	public static int getUpper(int n){
		if (n == 4)
			return 99;
		if (n == 5)
			return 81;
		if (n == 6)
			return 70;
		if (n == 7)
			return 63;
		return 58;
	}
	public static int triangle(int n){
		if (n < 45 || n > 140)
			throw new IllegalArgumentException();
		return n * (n+1) / 2;
	}
	
	public static int square(int n){
		if (n < 32 || n > 99)
			throw new IllegalArgumentException();
		return n * n;
	}
	
	public static int pentagon(int n){
		if (n < 26 || n > 81)
			throw new IllegalArgumentException();
		return n * (3*n-1) / 2;
	}
	
	public static int hexagon(int n){
		if (n < 23 || n > 70)
			throw new IllegalArgumentException();
		return n * (2*n-1);
	}
	
	public static int heptagon(int n){
		if (n < 21 || n > 63)
			throw new IllegalArgumentException();
		return n * (5*n-3) / 2;
	}
	
	public static int octagon(int n){
		if (n < 19 || n > 58)
			throw new IllegalArgumentException();
		return n * (3*n-2);
	}

}
