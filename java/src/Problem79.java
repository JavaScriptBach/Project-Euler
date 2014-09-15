import java.io.*;
import java.util.*;
public class Problem79 {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner input = new Scanner(new File("keylog.txt"));
		Map<Integer, Integer> m = new TreeMap<Integer, Integer>();
		while (input.hasNext()){
			int next = input.nextInt();
			while (next > 0){
				int digit = next % 10;
				if (!m.containsKey(digit))
					m.put(digit, 1);
				else
					m.put(digit, m.get(digit) + 1);
				next = next/10;
			}
		}
		System.out.println(m);
		//0 = 16
		//1 = 22
		//2 = 17
		//3 = 14
		//6 = 23
		//7 = 21
		//8 = 16
		//9 = 21
	}

}
