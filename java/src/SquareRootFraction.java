import java.util.*;
public class SquareRootFraction {
	private int n;
	private List<Integer> period;
	public SquareRootFraction(int n){
		this.n = n;
		period = new ArrayList<Integer>();
		final int first = (int)Math.floor(Math.sqrt(n));
		if (first * first != n){
			//double num = 1.0;
			//double deno = Math.sqrt(n) - first;
			int num = first;
			int deno = n - first * first;
			int next = (int)Math.floor((Math.sqrt(n) + num)/deno);
			period.add(next);
			num -= (next * deno);
			int temp = num;
			num = deno;
			deno = temp;
			//System.out.println("num = " + num);
			//System.out.println("deno = " + deno);
			while (num != 1 || deno != -1 * first){
				//num = 7, deno = -3, squareroot on bottom
				temp = -1 * deno;
				deno = n - deno * deno;
				while (gcd(num, deno) != 1){
					int gcd = gcd(num, deno);
					num = num/gcd;
					deno = deno/gcd;
				}
				int factor = num;
				num = factor * temp;
				//num = 3, deno = 2, squareroot on top
				next = (int)Math.floor((Math.sqrt(n) * factor + num)/deno);
				period.add(next);
				num -= (next * deno);
				temp = num;
				num = deno;
				deno = temp;
			}
		}
	}
	
	public int period(){
		//System.out.println(period);
		return period.size();
	}
	
	public List<Integer> getPeriod(){
		return period;
	}
	
	private int gcd(int a, int b){
		if (a > b){
			while (b != 0){
				int temp = a;
				a = b;
				b = temp % b;
			}
			return a;
		} else {
			while (a != 0){
				int temp = b;
				b = a;
				a = temp % a;
			}
			return b;
		}
	}
}
