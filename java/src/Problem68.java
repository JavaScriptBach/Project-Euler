
public class Problem68 {
	public static void main(String[] args){
		String s = "0000000000000000";
		for (int i = 12; i <= 37; i++){
			Ring r = new Ring(i);
			r.solve();
			for (String k : r.solutions)
				if (k.length() == 16 && k.compareTo(s) > 0)
					s = k;
		}
		System.out.println(s);
	}
}
