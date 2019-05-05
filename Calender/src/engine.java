public class engine {

	private int day1, month1, year1, day2, month2, year2, leapYear, fullYears,
			noOfDays, countLeapDay;

	private int[] months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public engine(int fstDate, int fstMonth, int fstYear, int sndDate,
			int sndMonth, int sndYear) {
		day1 = fstDate;
		month1 = fstMonth;
		year1 = fstYear;
		day2 = sndDate;
		month2 = sndMonth;
		year2 = sndYear;
		boolean found = false;
		int stYear = year1;
		while (!found) {
			if ((stYear % 400 == 0 || stYear % 100 != 0) && (stYear % 4 == 0)) {
				months[1] = 29;
				System.out.println("Leap year found: " + stYear);
				found = true;

			} else {
				months[1] = 28;
				stYear++;
				found = false;
			}
		}
	}

	public int countLeapDays() {

		int stYear = year1 + 1;
		while (stYear < (year2 - 1)) {
			if ((stYear % 400 == 0 || stYear % 100 != 0) && (stYear % 4 == 0)) {

				countLeapDay++;
				stYear++;

			} else {
				stYear++;
			}
		}
		return countLeapDay;
	}

	public int fullYearsBetween() {

		fullYears = (year2 - (year1 + 1));
		System.out.println(fullYears + " Years apart.");
		noOfDays = (fullYears * 365) + countLeapDays();
		return noOfDays;
	}

	public int firstYearRemainingDays() {
		int mFloat = month1;
		int restDays = months[mFloat - 1] - day1;
		while (mFloat < 12) {
			restDays += months[mFloat];

			mFloat++;
		}
		return restDays;
	}

	public int secondYearRemainingDays() {

		int mFloat = month2;
		int b4Days;
		if ((year2 % 400 == 0 || year2 % 100 != 0) && (year2 % 4 == 0)) {
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

	public void totalDays() {
		int total = fullYearsBetween() + firstYearRemainingDays()
				+ secondYearRemainingDays();
		System.out.println("Total Number Of Days: " + total);
	}
}
