
public class Problem84 {
	public static void main(String[] args){
		MonopolyBoard m = new MonopolyBoard();
		for (int i = 0; i < Integer.MAX_VALUE; i++)
			m.roll();
		m.print();
	}
}
