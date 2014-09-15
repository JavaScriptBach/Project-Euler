import java.io.*;
import java.util.*;
public class Problem42 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws FileNotFoundException {
		String content = new Scanner(new File("words.txt")).useDelimiter("\\Z").next();
		String[] words = content.split(",");
		int count = 0;
		for (int i = 0; i < words.length; i++){
			words[i] = words[i].replaceAll("\"", "");
			int score = 0;
			for (int j = 0; j < words[i].length(); j++){
				score += words[i].charAt(j) - 64;
			}
			if (isTriangle(score))
				count++;
		}
		System.out.println(count);

	}
	
	public static boolean isTriangle(int a){
		//2a = n(n+1)
		//n^2 + n - 2a = 0
		//n = -1 +/- sqrt(1 + 8a) / 2
		double n = (Math.sqrt(1 + 8*a) - 1) / 2;
		return n == Math.round(n);
	}

}
