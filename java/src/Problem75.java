import java.util.*;
public class Problem75 {
	public static void main(String[] args) {
		/*int total = 0;
		
		for (int i = 12; i <= 1500000; i++)
			m.put(i, generate(i));
		int count = 0;
		for (int i = 0; i < m.size(); i++){
			if (m.get(i).size() == 1)
				count++;
		}
		System.out.println(count);*/
		int count = 0;
		List<RightTriangle> set = generate(1500000);
		//System.out.println(set);
		//System.out.println(set.size());
		Map<Integer, List<RightTriangle>> m = new TreeMap<Integer, List<RightTriangle>>();
		Iterator<RightTriangle> i = set.iterator();
		while (i.hasNext()){
			RightTriangle t = i.next();
			if (!m.containsKey(t.getPerimeter())){
				m.put(t.getPerimeter(), new ArrayList<RightTriangle>());
			}
			m.get(t.getPerimeter()).add(t);
		}
		for (int foo : m.keySet()){
			if (m.get(foo).size() == 1)
				count++;
		}
		System.out.println(count);

	}
	
	//generates all pythagorean triples with perimeter <= L
	public static List<RightTriangle> generate(int L){
		List<RightTriangle> output = new ArrayList<RightTriangle>();
		for (int m = 2; 2*m*m + 2*m <= L; m++){
			for (int n = 1; n < m; n++){
				if (gcd(m, n) == 1 && (m-n) % 2 == 1 && 2*m*m + 2*m*n <= L){
					output.add(new RightTriangle(m*m-n*n, 2*m*n, m*m+n*n));
					for (int k = 2; 2*k*m*m + 2*k*m*n <= L; k++)
						output.add(new RightTriangle(m*m*k-n*n*k, 2*k*m*n, k*m*m+k*n*n));
				}
			}
		}
		return output;
	}
	
	public static int gcd(int a, int b){
		if (b == 0)
			return a;
		return gcd(b, a%b);
	}

}
