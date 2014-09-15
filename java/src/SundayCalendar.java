
public class SundayCalendar {
	public int year;
	public int month;
	public int day;
	public SundayCalendar(){
		//creates the first sunday of the 20th century
		year = 1901;
		month = 1;
		day = 6;
	}
	
	public void setNextSunday(){
		day += 7;
		if (is31Month()){
			if (day > 31){
				day = day % 31;
				month++;
			}
		}
		
		if (is30Month()){
			if (day > 30){
				day = day % 30;
				month++;
			}
		}
		
		if (isFeb()){
			if (day > 29 && isLeap()){
				day = day % 29;
				month++;
			}
			if (day > 28 && !isLeap()){
				day = day % 28;
				month++;
			}
		}
		
		if (month == 13){
			month = 1;
			year++;
		}
	}
	
	private boolean is31Month(){
		return month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12;
	}
	
	private boolean is30Month(){
		return month == 4 || month == 6 || month == 9 || month == 11;
	}
	
	private boolean isFeb(){
		return !is31Month() && !is30Month();
	}
	
	private boolean isLeap(){
		return year % 4 == 0;
	}
	
	public boolean isFirst(){
		return day == 1;
	}
}
