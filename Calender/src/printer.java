import java.util.Calendar;
import java.util.GregorianCalendar;

public class printer {

	private int date1, month1, year1, date2, month2, year2, dateP, monthP,
			yearP;

	private String months[] = { "January", "Febuary", "March", "April", "May",
			"June", "July", "August", "September", "October", "November",
			"December" };

	private String prefix;

	public printer(int fstDate, int fstMonth, int fstYear, int sndDate,
			int sndMonth, int sndYear) {
		date1 = fstDate;
		month1 = fstMonth;
		year1 = fstYear;
		date2 = sndDate;
		month2 = sndMonth;
		year2 = sndYear;
	}

	public void fstDatePrint() {

		if (date1 == 1 || date1 == 21 || date1 == 31) {
			prefix = "st";
		} else if (date1 == 2 || date1 == 22) {
			prefix = "nd";
		} else if (date1 == 3 || date1 == 23) {
			prefix = "rd";
		} else {
			prefix = "th";
		}

		System.out.println("\nFirst Date: " + date1 + prefix + " "
				+ months[month1 - 1] + ", " + year1 + ".");//
	}

	public void sndDatePrint() {

		if (date2 == 1 || date2 == 21 || date2 == 31) {
			prefix = "st";
		} else if (date2 == 2 || date2 == 22) {
			prefix = "nd";
		} else if (date2 == 3 || date2 == 23) {
			prefix = "rd";
		} else {
			prefix = "th";
		}

		System.out.println("Second Date: " + date2 + prefix + " "
				+ months[month2 - 1] + ", " + year2 + ".");
	}

	public void presentDate() {
		if (dateP == 1 || dateP == 21 || dateP == 31) {
			prefix = "st";
		} else if (dateP == 2 || dateP == 22) {
			prefix = "nd";
		} else if (dateP == 3 || dateP == 23) {
			prefix = "rd";
		} else {
			prefix = "th";
		}

		GregorianCalendar presentDate = new GregorianCalendar();

		dateP = presentDate.get(Calendar.DATE);
		monthP = presentDate.get(Calendar.MONTH);
		yearP = presentDate.get(Calendar.YEAR);
		
		System.out.println("Present Date: " + dateP + prefix + " "
				+ months[monthP] + ", " + yearP + ".");
	}
}
