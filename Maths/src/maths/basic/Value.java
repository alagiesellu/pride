package maths.basic;

/**
 * Object to hold a value, in a fraction form
 */
public class Value {

	/**
	 * @variable a holds the numerator
	 * @variable b holds the denominator
	 */
	private double a, b;

	/**
	 * Construct a {@code Value} compose of type {@code Value} as both numerator and
	 * denominator
	 * 
	 * @param a
	 *            the numerator of type {@code Value}
	 * @param b
	 *            the denominator of type {@code Value}
	 */
	public Value(Value a, Value b) {

		// divide the values
		Value temp = a.divides(b);

		setA(temp.a);
		setB(temp.b);
	}

	/**
	 * Construct a {@code Value} compose of type {@code Value} as both numerator and
	 * denominator
	 * 
	 * @param a
	 *            the numerator of type {@code Value}
	 * @param b
	 *            the denominator of type {@code double}
	 */
	public Value(Value a, double b) {
		this(a, new Value(b));
	}

	/**
	 * Construct a {@code Value} compose of type {@code Value} as both numerator and
	 * denominator
	 * 
	 * @param a
	 *            the numerator of type {@code double}
	 * @param b
	 *            the denominator of type {@code Value}
	 */
	public Value(double a, Value b) {
		this(new Value(a), b);
	}

	/**
	 * Construct a {@code Value} with no denominator
	 * 
	 * @param a
	 *            the numerator
	 */
	public Value(double a) {
		this(a, 1);
	}

	/**
	 * Construct a {@code Value} with a denominator
	 * 
	 * @param a
	 *            the numerator
	 * @param b
	 *            the denominator
	 */
	public Value(double a, double b) {

		// simplify the fraction
		double[] temp = simplify(a, b);

		setA(temp[0]);
		setB(temp[1]);
	}

	private double[] simplify(double a, double b) {

		// eliminate decimals places
		while (a % 1 != 0 || b % 1 != 0) {
			a *= 10;
			b *= 10;
		}

		// hold the return values
		double[] ret = { a, b };

		// if numerator divisible by the denominator
		if (a % b == 0) {
			ret[0] = a / b;
			ret[1] = 1;
		}

		// if denominator divisible by the numerator
		else if (b % a == 0) {
			ret[0] = 1;
			ret[1] = b / a;
		}

		// remove negation from denominator
		if (ret[1] < 0) {
			ret[0] *= -1;
			ret[1] *= -1;
		}

		// return the values
		return ret;
	}

	public Value add(Value value) {

		double b = this.getB() * value.getB();

		double a = (this.getA() * value.getB()) + (value.getA() * this.getB());

		return new Value(a, b);
	}

	public Value substract(Value value) {

		double b = this.getB() * value.getB();

		double a = (this.getA() * value.getB()) - (value.getA() * this.getB());

		return new Value(a, b);
	}

	public Value multiply(Value value) {

		double a = this.getA() * value.getA();

		double b = this.getB() * value.getB();

		return new Value(a, b);
	}

	public Value divides(Value value) {

		double a = this.getA() * value.getB();

		double b = this.getB() * value.getA();

		return new Value(a, b);
	}

	public double getValue() {
		return a / b;
	}

	public String toString() {

		boolean _a = false;

		if (a % 1 == 0)
			_a = true;

		if (b == 1)
			if (_a)
				return (int) a + "";
			else
				return a + "";

		boolean _b = false;

		if (b % 1 == 0)
			_b = true;

		if (_a && _b)
			return (int) a + "/" + (int) b;

		else if (_a)
			return (int) a + "/" + b;

		else if (_b)
			return a + "/" + (int) b;

		return a + "/" + b;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

}
