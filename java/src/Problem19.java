
public class Problem19 {
	public static void main(String[] args){
		SundayCalendar cal = new SundayCalendar();
		int total = 0;
		while (cal.year <= 2000){
			if (cal.isFirst())
				total++;
			cal.setNextSunday();
		}
		System.out.println(total);
	}
}
