//1, 2, 3, 4, 5, 6, 7, 8, 9
//11, 12, 13, 14, 15, 16, 17, 18, 19
//22, 23, 24, 25, 26, 27, 28, 29
//33, 34, 35, 36, 37, 38, 39
//44, 45, 46, 47, 48, 49
//55, 56, 57, 58, 59
//66, 67, 68, 69
//77, 78, 79
//88, 89
//99
//101-199
//
public class Problem145 {
	public static void main(String[] args){
		int count = 0;
		boolean[] checked = new boolean[1000000001];
		for (int i = 1; i < 1000000000; i++){
			if (i % 10 != 0){
				if (!checked[i]){
					checked[i] = true;
					int reverse = reverse(i);
					checked[reverse] = true;
					if (isReverse(i, reverse))
						count+=2;
				}
			}
		}
		System.out.println(count);
	}
	
	public static int reverse(int l){
		String number = Integer.toString(l);
		String answer = "";
		for (int i = number.length() - 1; i >= 0; i--)
			answer += number.charAt(i);
		return Integer.parseInt(answer);
	}
	
	public static boolean isReverse(int current, int reverse){
		int sum = current + reverse;
		while (sum > 0){
			int digit = (int)sum % 10;
			if (digit % 2 != 1)
				return false;
			sum = sum / 10;
		}
		return true;
	}
}
