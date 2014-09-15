import java.util.*;
public class Problem31 {
	public static void main(String[] args) {
		long current = System.currentTimeMillis();
		System.out.println(explore(200, 200));
		System.out.println(System.currentTimeMillis() - current);
		
		//pick 0-1 200p coins
		//pick 0-2 100p coins
		//pick 0-4 50p coins
		//pick 0-10 20p coins
		//pick 0-20 10p coins
		//pick 0-40 5p coins
		//pick 0-100 2p coins
		//leftover are pennies
	}
	
	public static int explore(int money, int type){
		if (money < 0)
			return 0;
		if (type == 1 || money == 0)
			return 1;
		if (type == 200)
			return explore(money, 100) + explore(money-200, 100);
		if (type == 100)
			return explore(money, 50) + explore(money-100, 50) + explore(money - 200, 50);
		if (type == 50)
			return explore(money, 20) + explore(money-50, 20) + explore(money-100, 20) + explore(money-150, 20) + explore(money-200, 20);
		if (type == 20){
			int sum = 0;
			for (int i = 0; i <= 200; i+= 20)
				sum += explore(money - i, 10);
			return sum;
		}
		if (type == 10){
			int sum = 0;
			for (int i = 0; i <= 200; i+= 10)
				sum += explore(money - i, 5);
			return sum;
		}
		if (type == 5){
			int sum = 0;
			for (int i = 0; i <= 200; i+= 5)
				sum += explore(money - i, 2);
			return sum;
		}
		int sum = 0;
		for (int i = 0; i <= 200; i+= 2)
			sum += explore(money - i, 1);
		return sum;
			
	}
}