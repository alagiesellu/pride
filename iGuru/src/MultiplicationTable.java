import javax.swing.JOptionPane;

public class MultiplicationTable {
	private int number;

	public MultiplicationTable(int lim) {
		number = lim;
	}

	public void result() {
		// create an array and filling it.
		int[] counter = new int[number];
		String ansString = "";
		for (int i = 0; i < number; i++) {
			counter[i] = (i + 1);
		}

		String say = "";
		// Multiplication Table Looper to print list heading
		for (int a = 1; a <= number; a++) {
			if (a < 10) {
				say = "|0";
			} else {
				say = "|";
			}
			ansString += say + a + " Times=> ";
			// Multiplication Table Looper to calculate and print result list
			for (int e = 0; e < number; e++) {

				int ans = 0;
				ans = (a * counter[e]);
				if (ans < 10) {
					if (a < 10) {
						ansString += "|0" + a + " x " + counter[e] + " = 00"
								+ ans + "|  ";
					} else {
						ansString += "|" + a + " x " + counter[e] + " = 00"
								+ ans + "|  ";
					}
				} else if (ans < 100) {
					if (a < 10) {

						ansString += "|0" + a + " x " + counter[e] + " = 0"
								+ ans + "|  ";
					} else {
						ansString += "|" + a + " x " + counter[e] + " = 0"
								+ ans + "|  ";
					}
				} else {
					if (a < 10) {
						ansString += "|0" + a + " x " + counter[e] + " = "
								+ ans + "|  ";
					} else {
						ansString += "|" + a + " x " + counter[e] + " = " + ans
								+ "|  ";
					}
				}
			}

			ansString += "\n";

		}

		JOptionPane.showMessageDialog(null, ansString,
				"Multiplication Table", JOptionPane.INFORMATION_MESSAGE);

	}

}