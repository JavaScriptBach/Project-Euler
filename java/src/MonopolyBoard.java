import java.util.*;
public class MonopolyBoard {
	private int[] board;
	private int currentLocation;
	private int doubles;
	private Random r;
	private Queue<Integer> chance;
	private Queue<Integer> cc;
	public MonopolyBoard(){
		board = new int[40];
		r = new Random();
		chance = shuffle();
		cc = shuffle();
	}
	
	public void roll(){
		int d1 = r.nextInt(4) + 1;
		int d2 = r.nextInt(4) + 1;
		if (d1 == d2)
			doubles++;
		else
			doubles = 0;
		if (doubles == 3){
			currentLocation = 10; //go to jail
			board[10]++;
			doubles = 0;
		} else {
			currentLocation += d1 + d2;
			if (currentLocation >= 40)
				currentLocation = currentLocation % 40;
			if (currentLocation == 30){
				currentLocation = 10;
			} else if (currentLocation == 2 || currentLocation == 17 || currentLocation == 33){
				drawCC();
			} else if (currentLocation == 7 || currentLocation == 22 || currentLocation == 36){
				drawChance();
			}
			board[currentLocation]++;
		}
	}
	
	private Queue<Integer> shuffle(){
		Queue<Integer> output = new LinkedList<Integer>();
		List<Integer> numbers = new ArrayList<Integer>();
		for (int i = 1; i <= 16; i++)
			numbers.add(i);
		while (!numbers.isEmpty()){
			int index = (int)Math.floor(Math.random() * numbers.size());
			output.add(numbers.get(index));
			numbers.remove(index);
		}
		return output;
	}
	
	private void drawCC(){
		int next = cc.remove();
		if (next == 1)
			currentLocation = 0;
		else if (next == 2)
			currentLocation = 10;
		cc.add(next);
	}
	
	private void drawChance(){
		int next = chance.remove();
		if (next == 1)
			currentLocation = 0;
		else if (next == 2)
			currentLocation = 10;
		else if (next == 3)
			currentLocation = 11;
		else if (next == 4)
			currentLocation = 24;
		else if (next == 5)
			currentLocation = 39;
		else if (next == 6)
			currentLocation = 5;
		else if (next == 7 || next == 8){
			if (currentLocation >= 5 && currentLocation < 15)
				currentLocation = 15;
			else if (currentLocation >= 15 && currentLocation < 25)
				currentLocation = 25;
			else if (currentLocation >= 25 && currentLocation < 35)
				currentLocation = 35;
			else
				currentLocation = 5;
		}
		else if (next == 9){
			if (currentLocation >= 12 && currentLocation < 28)
				currentLocation = 28;
			else
				currentLocation = 12;
		}
		else if (next == 10){
			currentLocation -= 3;
			if (currentLocation == 33)
				drawCC();
		}
		chance.add(next);
	}
	
	public void print(){
		int total = 0;
		for (int i = 0; i < board.length; i++)
			total += board[i];
		for (int i = 0; i < board.length; i++){
			double percent = 100.0 * board[i] / total;
			System.out.println("Square " + i + ": " + percent + "%");
		}
	}
}
