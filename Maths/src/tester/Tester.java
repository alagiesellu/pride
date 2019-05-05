package tester;

import algorithm.matrix.reduction.RowReduction;
import maths.basic.Value;
import maths.matrix.Matrix;

public class Tester {

	public static void main(String[] args) {

		// Equation 1: a - 2b + c = 0
		// Equation 2: 2b - 8c = 8
		// Equation 3: -4a + 5b +9c = -9

		Value[][] values = { { new Value(1,2), new Value(3), new Value(-2,3), new Value(0) },
				{ new Value(3,2), new Value(4), new Value(-2), new Value(-1) },
				{ new Value(1,5), new Value(-6), new Value(4,8), new Value(-1,2) } };

		RowReduction redox = new RowReduction(new Matrix(values));

		System.out.println(redox.getMatrix().toString());

		// Solution { 29, 16, 3 }
	}
}