import java.util.List;
public class Rad implements Comparable<Rad> {
	private int n;
	private int rad;
	public Rad(int n, List<Integer> primes) {
		this.n = n;
		int output = 1;
		int currentIndex = 0;
		while (n > 1){
			int currentPrime = primes.get(currentIndex);
			if (n % currentPrime == 0)
				output = output * currentPrime;
			while (n % currentPrime == 0){
				n = n / currentPrime;
			}
			currentIndex++;
		}
		this.rad = output;
	}
	
	public int compareTo(Rad other){
		if (this.rad > other.rad)
			return 1;
		if (this.rad < other.rad)
			return -1;
		return this.n - other.n;
	}
	
	public int getN(){
		return n;
	}
}
