import java.math.BigInteger;
public class Hexagon {
	private int n;
	private BigInteger current;
	public Hexagon(int n){
		if (n < 1)
			throw new IllegalArgumentException();
		this.n = n;
		current = BigInteger.valueOf(n).pow(2).multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(n));
	}
	
	public BigInteger get(){
		return current;
	}
	
	public void next(){
		n++;
		current = BigInteger.valueOf(n).pow(2).multiply(BigInteger.valueOf(2)).subtract(BigInteger.valueOf(n));
	}
}
