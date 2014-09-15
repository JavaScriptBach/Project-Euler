import java.math.BigInteger;
import java.util.*;
public class Problem169 {
	public static Map<Object169, Long> cache = new HashMap<Object169, Long>();
	public static void main(String[] args){
		System.out.println(count(BigInteger.valueOf(10).pow(25)));
	}
	public static long count(BigInteger n){
		BigInteger two = BigInteger.valueOf(2);
		if (n.remainder(two) == BigInteger.ZERO){
			return count(n, BigInteger.ZERO, 1) + count(n, two, 1);
		} else {
			return count(n, BigInteger.ONE, 1);
		}
	}
	
	private static long count(BigInteger target, BigInteger current, int currentPower){
		BigInteger exp = BigInteger.valueOf(2).pow(currentPower);
		if (current.compareTo(target) > 0)
			return 0;
		if (current.equals(target))
			return 1;
		if (exp.compareTo(target) > 0){
			return 0;
		}
		Object169 obj1 = new Object169(current, currentPower+1);
		if (!cache.containsKey(obj1)){
			long one = count(target, current, currentPower+1);
			cache.put(obj1, one);
		}
		BigInteger exp2 = current.add(exp);
		Object169 obj2 = new Object169(exp2, currentPower+1);
		if (!cache.containsKey(obj2)){
			long two = count(target, exp2, currentPower+1);
			cache.put(obj2, two);
		}
		BigInteger exp3 = exp2.add(exp);
		Object169 obj3 = new Object169(exp3, currentPower+1);
		if (!cache.containsKey(obj3)){
			long three = count(target, exp2.add(exp), currentPower+1);
			cache.put(obj3, three);
		}
		return cache.get(obj1) + cache.get(obj2) + cache.get(obj3);
	}
}
