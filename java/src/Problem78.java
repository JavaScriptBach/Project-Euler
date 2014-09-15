import java.math.BigInteger;
public class Problem78 {
	public static final int MAX = 1000000;
	public static void main(String[] args){
		BigInteger[] partition = new BigInteger[MAX];
		partition[0] = BigInteger.ONE;
		for (int i = 1; i < MAX; i++){
			BigInteger sum = BigInteger.ZERO;
			for (int j = 1; j <= i; j++){
				BigInteger temp = BigInteger.ZERO;
				if (i - (long)j*(3*j-1)/2 >= 0)
					temp = temp.add(partition[i - j*(3*j-1)/2]);
				if (i - (long)j*(3*j+1)/2 >= 0)
					temp = temp.add(partition[i - j*(3*j+1)/2]);
				if (temp.equals(BigInteger.ZERO))
					break;
				if (j % 2 == 0){
					sum = sum.subtract(temp);
				} else {
					sum = sum.add(temp);
				}
			}
			partition[i] = sum;
			if (partition[i].remainder(BigInteger.valueOf(1000000)).equals(BigInteger.ZERO)){
				System.out.println(i);
				//System.out.println(partition[i]);
				return;
			}
		}
	}
	
}
