import javax.swing.JOptionPane;

public class CurrencyUnit {
	private double amount;
	private String currency;

	public CurrencyUnit(double val, String typ) {
		amount = val;
		currency = typ;
	}

	public void result() {

		// if currency in Dalasi
		if (currency.equals("1")) {
			double USD = (amount / 47.16);
			double CFA = (amount / 0.0719);
			double EURO = (amount / 53.76);
			double BP = (amount / 73.10);
			JOptionPane
					.showMessageDialog(
							null,
							"GMD"
									+ amount
									+ " TO OTHER CURRENCIES ARE:"
									+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾"
									+ "\nUnited States Dollar           =   $ "
									+ USD
									+ "\nWest African CFA Franc         =   CFA "
									+ CFA
									+ "\nEuropian Euro                  =   € "
									+ EURO
									+ "\nBritish Pounds Sterling        =   ￡ "
									+ BP, "Gambian Dalasi",
							JOptionPane.PLAIN_MESSAGE);

			// if currency in US Dollar
		} else if (currency.equals("2")) {
			double GMD = (amount * 47.16);
			double CFA = (amount);
			double EURO = (amount);
			double BP = (amount);
			JOptionPane
					.showMessageDialog(
							null,
							"$"
									+ amount
									+ " TO OTHER CURRENCIES ARE:"
									+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾"
									+ "\nGambian Dalasi                 =   GMD "
									+ GMD
									+ "\nWest African CFA Franc         =   CFA "
									+ CFA
									+ "\nEuropian Euro                  =   € "
									+ EURO
									+ "\nBritish Pounds Sterling        =   ￡ "
									+ BP, "United States Dollar", JOptionPane.PLAIN_MESSAGE);

			// if currency in CFA FRANC
		} else if (currency.equals("3")) {
			double USD = (amount);
			double GMD = (amount * 0.0719);
			double EURO = (amount);
			double BP = (amount);
			JOptionPane
					.showMessageDialog(
							null,
							"CFA"
									+ amount
									+ " TO OTHER CURRENCIES ARE:"
									+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾"
									+ "\nUnited States Dollar           =   $ "
									+ USD
									+ "\nGambian Dalasi                 =   GMD "
									+ GMD
									+ "\nEuropian Euro                  =   € "
									+ EURO
									+ "\nBritish Pounds Starling        =   ￡ "
									+ BP, "West African CFA Franc", JOptionPane.PLAIN_MESSAGE);
			System.out.println();

			// if currency in EURO
		} else if (currency.equals("4")) {
			double USD = (amount);
			double CFA = (amount);
			double GMD = (amount * 53.76);
			double BP = (amount);
			JOptionPane
					.showMessageDialog(
							null,
							"€"
									+ amount
									+ " TO OTHER CURRENCIES ARE:"
									+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾"
									+ "\nUnited States Dollar           =   $ "
									+ USD
									+ "\nWest African CFA Franc         =   CFA "
									+ CFA
									+ "\nGambian Dalasi                 =   GMD "
									+ GMD
									+ "\nBritish Pounds Sterling        =   ￡ "
									+ BP, "Europian Euro", JOptionPane.PLAIN_MESSAGE);

			// if currency in POUNDS STARLING
		} else if (currency.equals("5")) {
			double USD = (amount);
			double CFA = (amount);
			double EURO = (amount);
			double GMD = (amount * 73.10);
			JOptionPane
					.showMessageDialog(
							null,
							"￡"
									+ amount
									+ " TO OTHER CURRENCIES ARE:"
									+ "\n‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾‾"
									+ "\nUnited States Dollar           =   $ "
									+ USD
									+ "\nWest African CFA Franc         =   CFA "
									+ CFA
									+ "\nEuropian Euro                  =   € "
									+ EURO
									+ "\nGambian Dalasi                 =   GMD "
									+ GMD, "British Pounds Sterling", JOptionPane.PLAIN_MESSAGE);
		}
	}
}
