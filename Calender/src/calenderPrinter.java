import java.util.Calendar;
import java.util.GregorianCalendar;

public class calenderPrinter {

	private String months[] = { "January", "Febuary", "March", "April", "May",
			"June", "July", "August", "September", "October", "November",
			"December" };

	private String weekDay[] = { "Saturday", "Sunday", "Monday", "Tuesday",
			"Wednesday", "Thursday", "Friday" };

	private String prefix;
	private int dayHolder, dateHolder, monthHolder, yearHolder;
	private int standardDayHolder, standardDateHolder, standardMonthHolder,
			standardYearHolder;

	public calenderPrinter(int inputDate, int inputMonth,
			int inputYear) {
		dateHolder = inputDate;
		monthHolder = inputMonth;
		yearHolder = inputYear;
	}

	public void inputedDate() {
		if (dateHolder == 1 || dateHolder == 21 || dateHolder == 31) {
			prefix = "st";
		} else if (dateHolder == 2 || dateHolder == 22) {
			prefix = "nd";
		} else if (dateHolder == 3 || dateHolder == 23) {
			prefix = "rd";
		} else {
			prefix = "th";
		}

		System.out.println("Inputed Date: " + weekDay[dayHolder] + " "
				+ dateHolder + prefix + " " + months[monthHolder - 1] + ", "
				+ yearHolder + ".");
	}

	public void presentDate() {
		if (standardDateHolder == 1 || standardDateHolder == 21
				|| standardDateHolder == 31) {
			prefix = "st";
		} else if (standardDateHolder == 2 || standardDateHolder == 22) {
			prefix = "nd";
		} else if (standardDateHolder == 3 || standardDateHolder == 23) {
			prefix = "rd";
		} else {
			prefix = "th";
		}

		GregorianCalendar presentDate = new GregorianCalendar();

		standardDayHolder = presentDate.get(Calendar.DAY_OF_WEEK);
		standardDateHolder = presentDate.get(Calendar.DATE);
		standardMonthHolder = presentDate.get(Calendar.MONTH);
		standardYearHolder = presentDate.get(Calendar.YEAR);

		System.out
				.println("Today's Date: " + weekDay[standardDayHolder] + " "
						+ standardDateHolder + prefix + " "
						+ months[standardMonthHolder] + ", "
						+ standardYearHolder + ".");
	}

}
