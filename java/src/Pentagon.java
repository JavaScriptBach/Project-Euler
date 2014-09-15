import java.math.BigInteger;
public class Pentagon {
	private int n;
	private BigInteger current;
	public Pentagon(int n){
		if (n < 1)
			throw new IllegalArgumentException();
		this.n = n;
		current = BigInteger.valueOf(n).pow(2).multiply(BigInteger.valueOf(3)).subtract(BigInteger.valueOf(n)).divide(BigInteger.valueOf(2));
	}
	
	public BigInteger get(){
		return current;
	}
	
	public void next(){
		n++;
		current = BigInteger.valueOf(n).pow(2).multiply(BigInteger.valueOf(3)).subtract(BigInteger.valueOf(n)).divide(BigInteger.valueOf(2));
	}
}
