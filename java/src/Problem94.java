
public class Problem94 {
	public static final int UPPER_BOUND = 1000000000;
	public static void main(String [] args){
		//boolean[] square = new boolean[UPPER_BOUND+1];
		//for (int i = 1; i <= Math.sqrt(UPPER_BOUND); i++)
		//	square[i*i] = true;
		
		long sum = 0;
		for (int i = 2; i <= UPPER_BOUND/3; i++){
			//System.out.println(i);
			//test triangles i, i, i+1 and i, i, i-1
			if (intarea(i, i+1))
				sum += 3*i + 1;
			if (intarea(i, i-1))
				sum += 3*i - 1;
		}
		System.out.println(sum);
	}
	public static boolean intarea(int a, int c, boolean[] square){
		if (a+1 == c){
			if (square[a-1] && square[3*a+1]){
				return (long)(a+1) * (long)(Math.sqrt((a-1)*(3*a+1))) % 4 == 0;
			}
			return false;
		} else if (a-1 == c){
			if (square[a+1] && square[3*a-1]){
				return (long)(a-1) * (long)(Math.sqrt((a+1)*(3*a-1))) % 4 == 0;
			}
			return false;
		} else {
			throw new IllegalArgumentException();
		}
	}
	
	public static boolean intarea(int a, int c){
		if (a+1 == c){
			long temp = (long)(3*a+1) * (a-1);
			long sqrt = (long)(Math.sqrt(temp) + 0.5);
			if (sqrt *sqrt == temp){
				return ((long)(a+1) * sqrt) % 4 == 0;
			}
			return false;
		} else if (a-1 == c){
			long temp = (long)(3*a-1) * (a+1);
			long sqrt = (long)(Math.sqrt(temp) + 0.5);
			if (sqrt *sqrt == temp){
				return ((long)(a-1) * sqrt) % 4 == 0;
			}
			return false;
		}
		throw new IllegalArgumentException();
	}

}
