import java.util.*;
import java.io.*;
public class Problem54 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(new File("poker.txt"));
		int sum = 0;
		while (input.hasNextLine()){
			String line = input.nextLine();
			String[] cards = line.split(" ");
			String[] hand1 = {cards[0], cards[1], cards[2], cards[3], cards[4]};
			String[] hand2 = {cards[5], cards[6], cards[7], cards[8], cards[9]};
			PokerHand p1 = new PokerHand(hand1);
			PokerHand p2 = new PokerHand(hand2);
			int result = p1.compareTo(p2);
			if (result > 0){
				sum++;
			}
		}
		System.out.println(sum);
		input.close();

	}

}
