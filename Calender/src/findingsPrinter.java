import java.util.Calendar;
import java.util.GregorianCalendar;

public class findingsPrinter {

	private String prefix;
	private int day, date, month, year;
	private int standardDay, standardDate, standardMonth, standardYear;

	private int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public findingsPrinter(int dayH, int dateH, int monthH, int yearH) {
		day = dayH;
		date = dateH;
		month = monthH;
		year = yearH;
	}

	public void leapFebruary() {

		if ((year % 400 == 0 || year % 100!=0) && (year % 4 ==0)) {
			months[1] = 29;
			System.out.println("*This is a leap year.");
		} else {
			months[1] = 28;
			System.out.println("*This is not a leap year.");
		}
	}

	public void presentDate() {
		if (standardDate == 1 || standardDate == 21 || standardDate == 31) {
			prefix = "st";
		} else if (standardDate == 2 || standardDate == 22) {
			prefix = "nd";
		} else if (standardDate == 3 || standardDate == 23) {
			prefix = "rd";
		} else {
			prefix = "th";
		}

		GregorianCalendar presentDate = new GregorianCalendar();

		standardDay = presentDate.get(Calendar.DAY_OF_WEEK);
		standardDate = presentDate.get(Calendar.DATE);
		standardMonth = presentDate.get(Calendar.MONTH);
		standardYear = presentDate.get(Calendar.YEAR);
	}
	
	public void calYearDifferernt(){
		
	}

}
