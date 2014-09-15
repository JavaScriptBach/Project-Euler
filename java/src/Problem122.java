import java.util.*;
public class Problem122 {
	public static void main(String[] args){
		System.out.println(compute(200));
	}
	
	public static int compute(int n){
		List<Integer> known = new ArrayList<Integer>();
		known.add(1);
		Set<Integer> answers = compute(n, 0, 0, known, new TreeSet<Integer>());
		System.out.println(answers);
		return answers.iterator().next();
	}
	
	private static Set<Integer> compute(int target, int current, int count, List<Integer> known, Set<Integer> answers){
		if (current > target)
			return answers;
		if (current == target)
			answers.add(count);
		else {
			for (int i = 0; i < known.size(); i++){
				int next = known.get(i);
				known.add(current + next);
				answers = compute(target, current + next, count + 1, known, answers);
				known.remove(new Integer(current + next));
			}
		}
		return answers;
	}
}
