
public class ToWords {

	@SuppressWarnings("unused")
	private String unit;
	private String[] hW = { "", "hundred", "thousand", "million", "billion", "trillion" };
	private String[] thW = { "", "", "twenty", "thirty", "fourthy", "fifty", "sixty", "seventy", "eighty", "ninety",
			"" };
	private String[] unitW = { "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
			"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "ninteen" };

	public ToWords() {
	}

	public ToWords(String unit) {
		this.unit = unit;
	}

	public void toWords(String number) {

		stage1(number);

	}

	private void stage1(String number) {

		int length = number.length();
		int th = length / 3;

		if (length - (th * 3) != 0)
			stage2(number.substring(0, length - (th * 3)), th);

		while (th != 0) {
			stage2(number.substring(length - (th * 3), length - (th * 3) + 3), th);
			th--;

		}

	}

	private void stage2(String number, int th) {

		if (th == 0)
			System.out.print(stage3(number) + " ");

		else
			System.out.print(stage3(number) + " " + hW[th] + " ");

	}

	private String stage3(String number) {

		int length = number.length();
		String out = "";

		if (length == 1)
			out = unitW[Integer.parseInt(number)];

		if (length == 2)
			out = thW[Integer.parseInt(number.substring(0, 1))] + unitW[Integer.parseInt(number.substring(1, 2))];

		else if (length == 3)
			out = unitW[Integer.parseInt(number.substring(0, 1))] + " " + hW[1] + " and "
					+ thW[Integer.parseInt(number.substring(1, 2))] + unitW[Integer.parseInt(number.substring(2, 3))];

		return out;
	}

	private String filter(String number) {

		if (number.equals("000"))
			return "";

		if (number.substring(0, 1).equals("00"))
			return number.substring(2);

		else if (number.substring(0, 0).equals("0"))
			return number.substring(1);

		return number;
	}
}
