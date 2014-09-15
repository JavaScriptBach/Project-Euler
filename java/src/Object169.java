import java.math.BigInteger;
public class Object169 {
	public BigInteger current;
	public int currentPower;
	
	public Object169(BigInteger current, int currentPower){
		this.current = current;
		this.currentPower = currentPower;
	}
	public boolean equals(Object other){
		Object169 obj = (Object169)other;
		if (other instanceof Object169){
			return this.current.equals(obj.current) && this.currentPower == obj.currentPower;
		}
		return false;
	}
	
	public int hashCode(){
		return current.hashCode() + currentPower;
	}
}
