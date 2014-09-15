import java.math.BigInteger;
public class Triangle {
	private int n;
	private BigInteger current;
	public Triangle(int n){
		if (n < 1)
			throw new IllegalArgumentException();
		this.n = n;
		current = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n+1)).divide(BigInteger.valueOf(2));
	}
	
	public BigInteger get(){
		return current;
	}
	
	public void next(){
		n++;
		current = BigInteger.valueOf(n).multiply(BigInteger.valueOf(n+1)).divide(BigInteger.valueOf(2));
	}
}
