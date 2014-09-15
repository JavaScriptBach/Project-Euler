import java.util.*;
public class Problem39 {

	public static void main(String[] args) {
		int max = 0;
		int maxP = 0;
		for (int i = 5; i <= 1000; i++)
			if (solve(i) > max){
				max = solve(i);
				maxP = i;
			}
		System.out.println(maxP);
	}
	
	//pre: p >= 0
	//post: returns the number of solutions of integer right triangles
	public static int solve(int p){
		//maximum length of hypotenuse: p/2 - 1 if p is even
		// p/2 if p is odd
		//a^2 + b^2 = c^2
		//min length: a sqrt 2
		//2a + a sqrt2 = p
		//a = p / (2 + sqrt 2)
		Set<int[]> set = new HashSet<int[]>();
		for (int i = p/4; i <= p/2; i++){
			for (int j = 1; j <= 3 * i/4; j++){
				//do something with i, j, p - i - j
				if (j * j + (p-i-j) * (p-i-j) == i*i){
					int[] array = {i, j, p-i-j};
					Arrays.sort(array);
					set.add(array);
					//System.out.println(Arrays.toString(array));
				}
			}
		}
		return set.size();
	}

}
