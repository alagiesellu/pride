package maths.matrix;

import java.util.Arrays;

import maths.basic.Value;

public class Matrix {

	private Value[][] values;

	public Matrix(Value[][] values) {

		int columnSize = 0;

		// find max column size of the matrix
		for (Value[] value : values)
			if (columnSize < value.length)
				columnSize = value.length;

		this.values = new Value[values.length][columnSize];

		// now set the matrix and fill the empty values with zero
		for (int row = 0; row < this.values.length; row++)
			for (int column = 0; column < columnSize; column++)

				// if empty values exist, fill with zero
				if (values[row].length < column + 1)
					this.values[row][column] = new Value(0);

				// else set matrix value
				else
					this.values[row][column] = values[row][column];
	}

	/**
	 * Insert a value in a matrix
	 * 
	 * @param row
	 *            the row number in the matrix
	 * @param column
	 *            the column number in the matrix
	 * @param value
	 *            the value to insert into the matrix
	 */
	public void insertValue(int row, int column, Value value) {
		values[row][column] = value;
	}

	public String toString() {

		String data = "";

		for (int row = 0; row < values.length; row++) {
			data += Arrays.toString(values[row]);
			data += "\n";
		}

		return data;
	}

	public int getRow() {
		return values.length;
	}

	public int getColumn() {
		return values[0].length;
	}

	public Value[][] getValues() {
		return values;
	}

	public void setValues(Value[][] values) {
		this.values = values;
	}

}
