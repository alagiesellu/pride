package tester;

import maths.basic.Value;

public class Tester2 {

	public static void main(String[] args) {

		Value value1 = new Value(0.25), value2 = new Value(2);

		Value value = new Value(value1, value2);

		System.out.println(value.toString());
	}
}
