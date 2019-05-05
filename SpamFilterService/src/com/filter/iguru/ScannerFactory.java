package com.filter.iguru;

public class ScannerFactory {

	// use getScanner method to get object of type SpamScanner
	public SpamScanner getScanner(String mailType) {
		if (mailType == null) {
			return null;
		}

		// if With Subject
		if (!mailType.equalsIgnoreCase("NULL")) {
			return new WithSubject();

			// if without Subject
		} else if (mailType.equalsIgnoreCase("NULL")) {
			return new WithoutSubject();

		}

		return null;
	}
}
