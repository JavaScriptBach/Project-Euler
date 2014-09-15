import java.io.*;
import java.util.*;
public class Problem99 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("base_exp.txt"));
		int largestBase = 632382;
		int largestExp = 518061;
		int currentLine = 3;
		int largestLine = 2;
		input.nextLine();
		input.nextLine();
		while (input.hasNextLine()){
			String line = input.nextLine();
			String[] tokens = line.split(",");
			int base = Integer.parseInt(tokens[0]);
			int exp = Integer.parseInt(tokens[1]);
			double largest = largestExp * Math.log(largestBase);
			double current = exp * Math.log(base);
			if (current > largest){
				largestLine = currentLine;
				largestBase = base;
				largestExp = exp;
			}
			currentLine++;
		}
		System.out.println(largestLine);
		input.close();
	}
}
