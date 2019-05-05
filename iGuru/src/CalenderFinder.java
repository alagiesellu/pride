import java.util.*;
public class CalenderFinder {

	private int dayHolder, monthHolder,yearHolder;
	private int standardDayHolder, standardMonthHolder,standardYearHolder;
	
	public CalenderFinder(int inputDay, int inputMonth, int inputYear){
		dayHolder = inputDay;
		monthHolder = inputMonth;
		yearHolder = inputMonth;
	}
	private void date(){
		GregorianCalendar presentDate = new GregorianCalendar();
		
		standardDayHolder = presentDate.get(Calendar.DATE);
		standardMonthHolder = presentDate.get(Calendar.MONTH);
		standardYearHolder = presentDate.get(Calendar.YEAR);
	}
}
