public class Problem28 {
	public static void main(String[] args) {
		System.out.println(compute(1001));
	}
	
	//pre: n is odd, n >= 1
	//post: computes the sum of the diagonals of a n by n spiral
	public static int compute(int n){
		
		//start with 1
		//add 2 four times to 9
		//add 4 four times to 25
		//add 6 four times to 49
		//....
		//add (n-1) four times to n^2
		
		//(n-2)^2 + (n-1)
		//(n-2)^2 + (n-1) + (n-1)
		//(n-2)^2 + (n-1) + (n-1) + (n-1)
		//(n-2)^2 + (n-1) + (n-1) + (n-1) + (n-1)
		if (n == 1)
			return 1;
		return compute(n-2) + 4 * (n-2) * (n-2) + 10 * (n-1);
	}

}
