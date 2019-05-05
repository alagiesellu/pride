import javax.swing.JOptionPane;

public class WeightUnit {

	private double value1;
	private double value2;
	private String type;

	public WeightUnit(String typ, double amount1, double amount2) {
		value1 = amount1;
		value2 = amount2;
		type = typ;

	}

	public void result() {

		// kg - pound Converter
		if (type.equals("1")) {
			if (value1 == 0) {
				double ans = value2 * 0.4536;
				JOptionPane.showMessageDialog(null, "Result " + value2
						+ " pound = " + ans + " kg.", "sCal",
						JOptionPane.PLAIN_MESSAGE);

			} else if (!(value1 == 0)) {
				double ans = value1 / 0.4536;
				JOptionPane.showMessageDialog(null, "Result " + value1
						+ " kg = " + ans + " pound.", "sCal",
						JOptionPane.PLAIN_MESSAGE);

			}

			// kg - ton Converter
		} else if (type.equals("2")) {
			if (value1 == 0) {
				double ans = value2 * 1000;
				JOptionPane.showMessageDialog(null, "Result " + value2
						+ " ton = " + ans + " kg.", "sCal",
						JOptionPane.PLAIN_MESSAGE);

			} else if (!(value1 == 0)) {
				double ans = value1 / 1000;
				JOptionPane.showMessageDialog(null, "Result " + value1
						+ " kg = " + ans + " ton.", "sCal",
						JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
