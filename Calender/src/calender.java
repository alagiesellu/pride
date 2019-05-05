import java.util.*;

public class calender {

	public static void main(String[] args) {

		int fstDate, fstMonth, fstYear, sndDate, sndMonth, sndYear;

		System.out.println("Enter date in this format (29/12/1990).");
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter 1st date: ");
		fstDate = scan.nextInt();
		System.out.print("Enter 1st month: ");
		fstMonth = scan.nextInt();
		System.out.print("Enter 1st year: ");
		fstYear = scan.nextInt();

		System.out.print("Enter 2nd date: ");
		sndDate = scan.nextInt();
		System.out.print("Enter 2nd month: ");
		sndMonth = scan.nextInt();
		System.out.print("Enter 2nd year: ");
		sndYear = scan.nextInt();

		printer printDate = new printer(fstDate, fstMonth, fstYear, sndDate,
				sndMonth, sndYear);
		engine calDate = new engine(fstDate, fstMonth, fstYear, sndDate,
				sndMonth, sndYear);

		printDate.fstDatePrint();
		printDate.sndDatePrint();
		printDate.presentDate();
		calDate.totalDays();

	}

}
