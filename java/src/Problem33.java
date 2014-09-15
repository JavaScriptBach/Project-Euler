
public class Problem33 {

	public static void main(String[] args) {
		for (int i = 10; i <= 99; i++){
			for (int j = 10; j < i; j++){
				if (isCanceling(j, i))
					System.out.println(j + " " + i);
			}
		}

	}
	
	//pre: 10 <= num, deno, <= 99
	public static boolean isCanceling(int num, int deno){
		int[] numDigits = new int[2];
		int[] denoDigits = new int[2];
		numDigits[1] = num % 10;
		numDigits[0] = num/10;
		denoDigits[1] = deno % 10;
		denoDigits[0] = deno/10;
		if (numDigits[0] == denoDigits[0])
			return numDigits[1] * deno == denoDigits[1] * num;
		if (numDigits[0] == denoDigits[1])
			return numDigits[1] * deno == denoDigits[0] * num;
		if (numDigits[1] == denoDigits[0])
			return numDigits[0] * deno == denoDigits[1] * num;
		if (numDigits[1] == denoDigits[1])
			return numDigits[0] * deno == denoDigits[0] * num;
		return false;
	}

}
