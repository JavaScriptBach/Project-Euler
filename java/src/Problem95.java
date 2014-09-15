import java.util.*;
public class Problem95 {
	public static Map<Integer, List<Integer>> m = new TreeMap<Integer, List<Integer>>();
	public static boolean[] sieve = Primes.getPrimes(1000000);
	public static void main(String[] args){
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000000; i++){
			generateChain(i);
		}
		int max = 0;
		int maxKey = -1;
		for (int i : m.keySet()){
			if (m.get(i) != null && m.get(i).size() > max){
				max = m.get(i).size();
				maxKey = i;
			}
		}
		System.out.println(maxKey);
		System.out.println("time elapsed: " + (System.currentTimeMillis() - start) + " ms");
	}
	
	public static int factors(int n){
		int sum = 1;
		for (int i = 2; i < Math.sqrt(n); i++){
			if (n % i == 0){
				sum += i + n/i;
			}
		}
		if (Math.sqrt(n) == Math.floor(Math.sqrt(n)))
			sum += Math.sqrt(n);
		return sum;
	}
	
	//pre: n > 1 and guaranteed to return to its starting position
	//aka, n is composite and not perfect
	//post: produces a LinkedList with the front being the lowest element of the chain
	public static void generateChain(int n){
		int current = factors(n);
		LinkedList<Integer> output = new LinkedList<Integer>();
		output.add(n);
		while (current != n){
			if (current > 1000000 || sieve[current] || current == 6 || current == 28 || current == 496 || current == 8128 || current < 2){
				m.put(n, null);
				return;
			}
			
			if (m.containsKey(current)){
				if (m.get(current) != null && m.get(current).contains(n)){
					m.put(n, m.get(current));
					return;
				} else {
					m.put(n, null);
					return;
				}
			}
			
			if (output.contains(current)){
				m.put(n, null);
				return;
			}
			output.add(current);
			current = factors(current);
		}
		//sort the list
		int min = 1000000;
		int minIndex = -1;
		Queue<Integer> temp = new LinkedList<Integer>();
		for (int i = 0; i < output.size(); i++){
			if (output.get(i) < min){
				min = output.get(i);
				minIndex = i;
			}
		}
		for (int i = 0; i < minIndex; i++)
			temp.add(output.remove());
		while (!temp.isEmpty())
			output.add(temp.remove());
		//update map
		for (int i : output)
			m.put(i, output);
	}
	
}
