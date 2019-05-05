package algorithm.matrix.reduction;

import java.util.Arrays;

import maths.basic.Value;
import maths.matrix.Matrix;

public class RowReduction {

	private Matrix matrix;

	public RowReduction(Matrix matrix) {
		this.setMatrix(matrix);

		reduce();
	}

	private void reduce() {

		// first interchange to remove free variables from pivot points
		interchangeRows();

		// value to store multiples to be used in row reductions
		Value multiple;

		// go through column by column
		for (int column = 0; column < matrix.getColumn() - 1; column++) {

			// simple row reduce the pivot row
			rowReduce(column);

			System.out.println("Row: " + Arrays.toString(matrix.getValues()[column]));

			// go through row by row first
			for (int row = 0; row < matrix.getRow(); row++) {

				// if not pivot row, complex row reduce
				if (column != row) {

					// get multiple value
					multiple = new Value(0).substract(matrix.getValues()[row][column])
							.divides(matrix.getValues()[column][column]);

					System.out.println("Multiple: " + multiple.toString());

					// reduce row with pivot row and multiple value
					rowReduce(row, column, multiple);
				}
			}
			System.out.println();
		}
	}

	private void interchangeRows() {

		// go through the pivot points
		for (int column = 0; column < matrix.getColumn() - 1; column++) {

			int nextIndex;

			if (matrix.getValues()[column][column].getValue() == 0) {

				nextIndex = column + 1;

				if (column == matrix.getRow() - 1)
					nextIndex = column - 1;

				Value[] currentRow = getValues(matrix.getValues()[column]),
						nextRow = getValues(matrix.getValues()[nextIndex]);

				for (int i = 0; i < currentRow.length; i++) {
					matrix.insertValue(column, i, nextRow[i]);
					matrix.insertValue(nextIndex, i, currentRow[i]);
				}
			}
		}
	}

	private Value[] getValues(Value[] values) {

		Value[] ans = new Value[values.length];

		for (int i = 0; i < values.length; i++)
			ans[i] = values[i];

		return ans;
	}

	/**
	 * Divide a row by a nonzero value(value in pivot)
	 * 
	 * @param row
	 *            row to be reduced
	 */
	private void rowReduce(int row) {

		// get value in pivot
		Value ans, value = matrix.getValues()[row][row];

		// for each value in a row
		for (int column = 0; column < matrix.getColumn(); column++) {

			// divide by value in pivot
			ans = matrix.getValues()[row][column].divides(value);

			// replace in matrix
			matrix.insertValue(row, column, ans);
		}
	}

	/**
	 * Multiple another row by a value and then add to the row being reduced
	 * 
	 * @param row
	 *            row to be reduced
	 * @param multipleRow
	 *            the row to multiply by
	 * @param multiplyValue
	 *            the value to multiply the multiple row by
	 */
	private void rowReduce(int row, int multipleRow, Value multipleValue) {

		Value ans;

		// for each value in a row
		for (int column = 0; column < matrix.getColumn(); column++) {

			// multiply multiple value with multiple row
			ans = multipleValue.multiply(matrix.getValues()[multipleRow][column]);

			// then add to the row being reduced
			ans = ans.add(matrix.getValues()[row][column]);

			// replace in matrix
			matrix.insertValue(row, column, ans);
		}

	}

	/**
	 * Get the matrix object
	 * 
	 * @return matrix
	 */
	public Matrix getMatrix() {
		return matrix;
	}

	/**
	 * @param matrix
	 *            the matrix to set to
	 */
	public void setMatrix(Matrix matrix) {
		this.matrix = matrix;
	}

}
