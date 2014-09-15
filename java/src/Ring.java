import java.util.*;
public class Ring {
	public int[] numbers;
	public int total;
	public boolean[] used;
	public Set<String> solutions;
	public Ring(int total){
		numbers = new int[10];
		this.total = total;
		used = new boolean[11];
		solutions = new TreeSet<String>();
	}
	
	public void place(int number, int index){
		if (!safe(number, index))
			throw new IllegalArgumentException();
		numbers[index] = number;
		used[number] = true;
	}
	
	public boolean safe(int number, int index){
		if (numbers[index] != 0)
			return false;
		if (index == 0)
			return check(number, numbers[1], numbers[2]);
		if (index == 1)
			return check(numbers[0], number, numbers[2]) && check(number, numbers[8], numbers[9]);
		if (index == 2)
			return check(number, numbers[3], numbers[4]) && check (number, numbers[0], numbers[1]);
		if (index == 3)
			return check(number, numbers[2], numbers[4]);
		if (index == 4)
			return check(number, numbers[6], numbers[5]) && check(number, numbers[2], numbers[3]);
		if (index == 5)
			return check(number, numbers[4], numbers[6]);
		if (index == 6)
			return check(number, numbers[4], numbers[5]) && check(number, numbers[7], numbers[8]);
		if (index == 7)
			return check(number, numbers[6], numbers[8]);
		if (index == 8)
			return check(number, numbers[1], numbers[9]) && check(number, numbers[6], numbers[7]);
		return check(number, numbers[1], numbers[8]);
	}
	
	private boolean check(int a, int b, int c){
		if (a == 0 || b == 0 || c == 0)
			return true;
		return a + b + c == total;
	}
	
	public void remove(int index){
		used[numbers[index]] = false;
		numbers[index] = 0;
	}
	
	
	public void solve(){
		explore(0);
	}
	
	private void explore(int index){
		if (index == 10){
			print();
			return;
		}
		for (int i = 1; i <= 10; i++){
			if (!used[i]){
				if (safe(i, index)){
					place(i, index);
					explore(index + 1);
					remove(index);
				}
			}
		}
		
		
	}
	
	public void print(){
		int a = numbers[0];
		int b = numbers[3];
		int c = numbers[5];
		int d = numbers[7];
		int e = numbers[9];
		int[] array = {a, b, c, d, e};
		Arrays.sort(array);
		String output = "";
		if (array[0] == a){
			for (int i = 1; i <= 5; i++)
				output += print(i);
		}
		else if (array[0] == b){
			for (int i = 2; i <= 5; i++)
				output += print(i);
			output += print(1);
		}
		else if (array[0] == c){
			for (int i = 3; i <= 5; i++)
				output += print(i);
			for (int i = 1; i <= 2; i++)
				output += print(i);
		}
		else if (array[0] == d){
			for (int i = 4; i <= 5; i++)
				output += print(i);
			for (int i = 1; i <= 3; i++)
				output += print(i);
		}
		else{
			output += print(5);
			for (int i = 1; i <= 4; i++)
				output += print(i);
		}
		//System.out.println(output);
		solutions.add(output);
	}
	
	private String print(int n){
		if (n == 1){
			return "" + numbers[0] + numbers[1] + numbers[2];
		} else if (n == 2){
			return "" + numbers[3] + numbers[2] + numbers[4];
		} else if (n == 3){
			return "" + numbers[5] + numbers[4] + numbers[6];
		} else if (n == 4){
			return "" + numbers[7] + numbers[6] + numbers[8];
		} else {
			return "" + numbers[9] + numbers[8] + numbers[1];
		}
	}
}
