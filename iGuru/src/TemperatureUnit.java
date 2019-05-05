import javax.swing.JOptionPane;

public class TemperatureUnit {

	private double value;
	private String type;

	public TemperatureUnit(String typ, double amount) {
		value = amount;
		type = typ;

	}

	public void result() {

		// if Celcius type chosen
		if (type.equals("1")) {
			double fahrenheit = ((value * 9) / 5) + 32;
			JOptionPane.showMessageDialog(null, "Result\n"+value + "℃  = " + fahrenheit + "℉.", "Celcius",
					JOptionPane.PLAIN_MESSAGE);


			// if Fahrenheits type chosen
		} else if (type.equals("2")) {
			double celcius = ((value - 32) * 5) / 9;

			JOptionPane.showMessageDialog(null, "Result\n"+value + "℉  = " + celcius + "℃.", "Fahrenheits",
					JOptionPane.PLAIN_MESSAGE);


		}

	}
}
