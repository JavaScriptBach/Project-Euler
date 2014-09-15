import java.math.BigInteger;
public class Fraction implements Comparable<Fraction>{
	private final BigInteger n;
	private final BigInteger d;
	
	public Fraction(BigInteger n, BigInteger d){
		while (gcd(n, d).compareTo(BigInteger.ONE) != 0){
			BigInteger f = gcd(n, d);
			n = n.divide(f);
			d = d.divide(f);
		}
		this.n = n;
		this.d = d;
	}
	
	public String toString(){
		return n.toString() + "/" + d.toString();
	}
	
	public BigInteger getN(){
		return n;
	}
	
	public BigInteger getD(){
		return d;
	}
	
	public Fraction multiply(Fraction other){
		BigInteger n1 = this.n;
		BigInteger d1 = this.d;
		BigInteger n2 = other.n;
		BigInteger d2 = other.d;
		while (gcd(n1, d2).compareTo(BigInteger.ONE) != 0){
			BigInteger f = gcd(n1, d2);
			n1 = n1.divide(f);
			d2 = d2.divide(f);
		}
		while (gcd(n2, d1).compareTo(BigInteger.ONE) != 0){
			BigInteger f = gcd(n2, d1);
			n2 = n2.divide(f);
			d1 = d1.divide(f);
		}
		return new Fraction(n1.multiply(n2), d1.multiply(d2));
	}
	
	public Fraction add(Fraction other){
		BigInteger deno = this.d.multiply(other.d).divide(gcd(this.d, other.d));
		BigInteger num = this.n.multiply(deno).divide(this.d).add(other.n.multiply(deno).divide(other.d));
		return new Fraction(num, deno);
	}
	
	public Fraction reciprocal(){
		return new Fraction(d, n);
	}
	private static BigInteger gcd(BigInteger a, BigInteger b){
		if (a.compareTo(BigInteger.ZERO) < 0 || b.compareTo(BigInteger.ZERO) < 0)
			throw new IllegalArgumentException();
		if (a.compareTo(b) > 0){
			while (b.compareTo(BigInteger.ZERO) != 0){
				BigInteger temp = a;
				a = b;
				b = temp.mod(b);
			}
			return a;
		} else {
			while (a.compareTo(BigInteger.ZERO) != 0){
				BigInteger temp = b;
				b = a;
				a = temp.mod(a);
			}
			return b;
		}
	}
	
	public int compareTo(Fraction other){
		BigInteger lcm = this.d.multiply(other.d).divide(gcd(this.d, other.d));
		BigInteger num1 = lcm.divide(d).multiply(n);
		BigInteger num2 = lcm.divide(other.d).multiply(other.n);
		return num1.compareTo(num2);
	}
}
