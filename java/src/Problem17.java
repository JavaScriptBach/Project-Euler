
public class Problem17 {
	public static void main(String[] args){
		String onetonine = "onetwothreefourfivesixseveneightnine";
		String eleventonineteen = "eleventwelvethirteenfourteenfifteensixteenseventeeneighteennineteen";
		String answer = onetonine;
		answer += "ten";
		answer += eleventonineteen;
		answer += onetonine;
		for (int i = 0; i < 10; i++)
			answer += "twenty";
		answer += onetonine;
		for (int i = 0; i < 10; i++)
			answer += "thirty";
		answer += onetonine;
		for (int i = 0; i < 10; i++)
			answer += "forty";
		answer += onetonine;
		for (int i = 0; i < 10; i++)
			answer += "fifty";
		answer += onetonine;
		for (int i = 0; i < 10; i++)
			answer += "sixty";
		answer += onetonine;
		for (int i = 0; i < 10; i++)
			answer += "seventy";
		answer += onetonine;
		for (int i = 0; i < 10; i++)
			answer += "eighty";
		answer += onetonine;
		for (int i = 0; i < 10; i++)
			answer += "ninety";
		//have 1 to 99
		String oneto99 = answer;
		answer += oneto99;
		answer += "onehundred";
		for (int i = 0; i < 99; i++)
			answer += "onehundredand";
		answer += oneto99;
		answer += "twohundred";
		for (int i = 0; i < 99; i++)
			answer += "twohundredand";
		answer += oneto99;
		answer += "threehundred";
		for (int i = 0; i < 99; i++)
			answer += "threehundredand";
		answer += oneto99;
		answer += "fourhundred";
		for (int i = 0; i < 99; i++)
			answer += "fourhundredand";
		answer += oneto99;
		answer += "fivehundred";
		for (int i = 0; i < 99; i++)
			answer += "fivehundredand";
		answer += oneto99;
		answer += "sixhundred";
		for (int i = 0; i < 99; i++)
			answer += "sixhundredand";
		answer += oneto99;
		answer += "sevenhundred";
		for (int i = 0; i < 99; i++)
			answer += "sevenhundredand";
		answer += oneto99;
		answer += "eighthundred";
		for (int i = 0; i < 99; i++)
			answer += "eighthundredand";
		answer += oneto99;
		answer += "ninehundred";
		for (int i = 0; i < 99; i++)
			answer += "ninehundredand";
		answer += "onethousand";
		System.out.print(answer.length());
		
	}
}
