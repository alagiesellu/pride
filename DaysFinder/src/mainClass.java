import java.util.Scanner;

public class mainClass {
	public static void main(String[] args) {

		int fstDate, fstMonth, fstYear, sndDate, sndMonth, sndYear;

		Scanner scan = new Scanner(System.in);
		try {
			
			// input first day
			System.out.print("Enter 1st date: ");
			fstDate = scan.nextInt();
			System.out.print("Enter 1st month: ");
			fstMonth = scan.nextInt();
			System.out.print("Enter 1st year: ");
			fstYear = scan.nextInt();
			
			// input second day
			System.out.print("Enter 2nd date: ");
			sndDate = scan.nextInt();
			System.out.print("Enter 2nd month: ");
			sndMonth = scan.nextInt();
			System.out.print("Enter 2nd year: ");
			sndYear = scan.nextInt();
		} finally {
			scan.close();
		}
		daysEngine calDate = new daysEngine(fstDate, fstMonth, fstYear,
				sndDate, sndMonth, sndYear);

		calDate.totalDays();

	}

}
