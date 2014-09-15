import java.util.*;
public class Problem62 {
	public static void main(String[] args) {
		List<Long> cubes = new ArrayList<Long>();
		for (long i = 1; i <= 10000; i++)
			cubes.add(i*i*i);
		Map<Long, List<Long>> m = new TreeMap<Long, List<Long>>();
		for (long cube : cubes){
			boolean added = false;
			for (long smallest : m.keySet()){
				if(isPermutation(Long.toString(smallest), Long.toString(cube))){
					m.get(smallest).add(cube);
					added = true;
				}
			}
			if (!added){
				List<Long> list = new ArrayList<Long>();
				list.add(cube);
				m.put(cube, list);
			}
		}
		for (long key : m.keySet()){
			if (m.get(key).size() == 5){
				System.out.println(m.get(key));
				return;
			}
		}
	}
	
	public static boolean isPermutation(String a, String b){
		if (a.length() != b.length())
			return false;
		char[] one = new char[a.length()];
		char[] two = new char[b.length()];
		for (int i = 0 ; i < a.length(); i++){
			one[i] = a.charAt(i);
			two[i] = b.charAt(i);
		}
		Arrays.sort(one);
		Arrays.sort(two);
		for (int i = 0 ; i < a.length(); i++)
			if (one[i] != two[i])
				return false;
		return true;
	}
	/*
	public static Set<String> generate(long l){
		Set<String> list = new HashSet<String>();
		List<Character> remaining = new ArrayList<Character>();
		String s = Long.toString(l);
		for (int i = 0; i < s.length(); i++)
			remaining.add(s.charAt(i));
		list = build(list, "", remaining);
		return list;
	}
	
	
	private static Set<String> build(Set<String> list, String current, List<Character> remaining){
		if (current.length() > 0 && current.charAt(0) == '0')
			return list;
		if (remaining.isEmpty()){
			list.add(current);
		} else {
			Object[] temp = remaining.toArray();
			for (int i = 0; i < temp.length; i++){
				char c = (char)temp[i];
				remaining.remove(new Character(c));
				list = build(list, current+c, remaining);
				remaining.add(c);
			}
		}
		return list;
	}
	
	public static boolean solve(Set<String> list, List<Long> cubes){
		int count = 0;
		for (String s : list){
			if (count > 5)
				return false;
			long l = Long.parseLong(s);
			if (cubes.contains(l))
				count++;
		}
		return count == 3;
	}*/

}
