import java.math.BigInteger;
public class Problem45 {
	public static void main(String[] args) {
		Triangle t = new Triangle(285);
		Pentagon p = new Pentagon(165);
		Hexagon h = new Hexagon(143);
		boolean done = false;
		while (!done){
			h.next();
			while (t.get().compareTo(h.get()) < 0){
				t.next();
			}
			while (p.get().compareTo(h.get()) < 0){
				p.next();
			}
			if (t.get().equals(p.get()) && t.get().equals(h.get()))
				done = true;
		}
		System.out.println(t.get());

	}
	
	public static boolean isPentagonal(long a){
		//2a = n(3n-1)
		//3n^2 -n - 2a = 0
		//n = 1 +/- sqrt(1 + 24a) / 6
		double n = (1 + Math.sqrt(1 + 24 * a)) / 6;
		return Math.round(n) == n;
	}
	
	public static boolean isHexagonal(long a){
		//2n^2 - n - a = 0
		//n = 1 +/- sqrt(1 + 8a) / 4
		double n = (1 + Math.sqrt(1 + 8 * a)) / 4;
		return Math.round(n) == n;
	}

}
