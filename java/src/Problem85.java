import java.util.*;
public class Problem85 {

	public static void main(String[] args) {
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
		for (int i = 1; i <= 100; i++){
			for (int j = 1; j <= 100; j++){
				if (!m.containsKey(i*j))
					m.put(i*j, count(i, j));
			}
		}
		System.out.println(m);

	}
	
	public static int count(int width, int length){
		if (width < 1 || length < 1)
			throw new IllegalArgumentException();
		int count = 0;
		//1x2, 1x3, 1x4....1x length
		//2x1, 2x2, 2x3....2xlength
		//.....
		//width x 1, width x 2 ....width x length
		for (int i = 1; i <= length; i++){
			for (int j = 1; j <= width; j++){
				for (int k = 0; k < length; k++){
					for (int l = 0; l < width; l++){
						if (k + i <= length && l + j <= width)
							count++;
					}
				}
				//i am considering all possible rectangle dimensions
				//try placing this i*j rectangle in every square
				//if can be placed, count++
			}
		}
		return count;
	}

}
