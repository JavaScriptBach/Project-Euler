import java.util.*;
import java.io.*;
public class Problem22 {
	public static void main(String[] args) throws FileNotFoundException{
		String content = new Scanner(new File("names.txt")).useDelimiter("\\Z").next();
		String[] tokens = content.split(",");
		Arrays.sort(tokens);
		long scores = 0L;
		for (int i = 0; i < tokens.length; i++){
			tokens[i] = tokens[i].replaceAll("\"", "");
			long score = (i+1) * value(tokens[i]);
			scores += score;
		}
		System.out.println(scores);
	}
	
	public static int value(String word){
		int sum = 0;
		for (int i = 0; i < word.length(); i++){
			sum += word.charAt(i) - 64;
		}
		return sum;
	}
}
