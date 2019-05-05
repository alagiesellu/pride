import java.util.GregorianCalendar;

public class daysEngine {

	private int day1, month1, year1, day2, month2, year2;
	GregorianCalendar calendar = new GregorianCalendar();

	// initialize number of days in a month
	private int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public daysEngine(int fstDate, int fstMonth, int fstYear, int sndDate,
			int sndMonth, int sndYear) {
		day1 = fstDate;
		month1 = fstMonth;
		year1 = fstYear;
		day2 = sndDate;
		month2 = sndMonth;
		year2 = sndYear;
		firstLeapYearFound(year1);
	}

	// find the first leap year
	public int firstLeapYearFound(int startYear) {
		boolean found = false;
		while (!found) {
			if (calendar.isLeapYear(startYear)) {
				months[1] = 29;
				found = true;
			} else {
				months[1] = 28;
				startYear++;
				found = false;
			}
		}
		return startYear;
	}

	// count the number of leap years
	public int countLeapDays() {
		int countLeapDay = 0;
		int startYear = year1 + 1;
		while (startYear < (year2 - 1)) {
			if (calendar.isLeapYear(startYear)) {
				countLeapDay++;
				startYear++;
			} else {
				startYear++;
			}
		}
		return countLeapDay;
	}

	// find the number of days in all years excluding the first and last year
	public int fullYearDaysBetween() {
		int fullYears = (year2 - (year1 + 1));
		int noOfDays = (fullYears * 365) + countLeapDays();
		return noOfDays;
	}

	// find the number of days left in the first year
	public int firstYearRemainingDays() {
		int mFloat = month1;
		int restDays = months[mFloat - 1] - day1;
		while (mFloat < 12) {
			restDays += months[mFloat];
			mFloat++;
		}
		return restDays;
	}

	// find the number of days left in the second year
	public int secondYearRemainingDays() {

		int mFloat = month2;
		int b4Days;
		if (calendar.isLeapYear(year2)) {
			months[1] = 29;
			b4Days = 366;
		} else {
			months[1] = 28;
			b4Days = 365;
		}
		int restDays = months[mFloat - 1] - day2;
		while (mFloat < 12) {
			restDays += months[mFloat];
			mFloat++;
		}
		b4Days -= restDays;
		return b4Days;
	}

	// calculate the total number of days
	public void totalDays() {
		int total = fullYearDaysBetween() + firstYearRemainingDays()
				+ secondYearRemainingDays();
		System.out.println("Total Number Of Days: " + total);
		howManyYears(total - 1);
	}

	// calculate the how many full years apart
	public void howManyYears(int totalDays) {
		int fullYears = (totalDays - countLeapDays()) / 365;
		System.out.println(fullYears + " full years apart.");
	}
}
