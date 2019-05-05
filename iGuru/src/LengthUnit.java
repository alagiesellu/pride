import javax.swing.JOptionPane;

public class LengthUnit {

	private double value1;
	private double value2;
	private String type;

	public LengthUnit(String typ, double amount1, double amount2) {
		value1 = amount1;
		value2 = amount2;
		type = typ;

	}

	public void result() {

		// km - mile Converter
		if (type.equals("1")) {
			if (value1 == 0) {
				double ans = value2 * 1.6093;

				JOptionPane.showMessageDialog(null, "Result" + value2
						+ " mile = " + ans + " km.", "km - mile Converter",
						JOptionPane.PLAIN_MESSAGE);

			} else if (!(value1 == 0)) {
				double ans = value1 / 1.6093;
				JOptionPane.showMessageDialog(null, "Result" + value1
						+ " km = " + ans + " mile.", "km - mile Converter",
						JOptionPane.PLAIN_MESSAGE);
			}
			// m - yard Converter
		} else if (type.equals("2")) {
			if (value1 == 0) {
				double ans = value2 * 0.9144;
				JOptionPane.showMessageDialog(null, "Result" + value2
						+ " yard = " + ans + " m.", "m - yard Converter",
						JOptionPane.PLAIN_MESSAGE);

			} else if (!(value1 == 0)) {
				double ans = value1 / 0.9144;
				JOptionPane.showMessageDialog(null, "Result" + value1 + " m = "
						+ ans + " yard.", "m - yard Converter", JOptionPane.PLAIN_MESSAGE);

			}
			// m - foot Converter
		} else if (type.equals("3")) {
			if (value1 == 0) {
				double ans = value2 * 0.3048;
				JOptionPane.showMessageDialog(null, "Result" + value2
						+ " foot = " + ans + " m.", "m - foot Converter",
						JOptionPane.PLAIN_MESSAGE);

			} else if (!(value1 == 0)) {
				double ans = value1 / 0.3048;
				JOptionPane.showMessageDialog(null, "Result" + value1 + " m = "
						+ ans + " foot.", "m - foot Converter", JOptionPane.PLAIN_MESSAGE);

			}
			// cm - inch Converter
		} else if (type.equals("4")) {
			if (value1 == 0) {
				double ans = value2 * 2.54;
				JOptionPane.showMessageDialog(null, "Result" + value2
						+ " inch = " + ans + " cm.", "cm - inch Converter",
						JOptionPane.PLAIN_MESSAGE);

			} else if (!(value1 == 0)) {
				double ans = value1 / 2.54;
				JOptionPane.showMessageDialog(null, "Result" + value1
						+ " cm = " + ans + " inch.", "cm - inch Converter",
						JOptionPane.PLAIN_MESSAGE);

			}
		}
	}
}