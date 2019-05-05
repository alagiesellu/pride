package com.filter.iguru;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WithSubject implements SpamScanner {

	private double spamScore;
	private final double spamScoreLimit = 5;

	// path for file with common spam words
	private String path = "/home/sellu/Documents/Edu/OO A&D/Web Services/spam words";

	@Override
	public void scan(String subject, String msg) throws FileNotFoundException {

		Scanner input = new Scanner(new File(path));

		try {

			while (input.hasNextLine()) {

				String line = input.nextLine();

				// scan mail message for spam
				if (msg.toLowerCase().contains(line.toLowerCase())) {
					spamScore += 1;
				}

				// scan mail subject for spam
				// higher score if subject contain spam
				if (subject.toLowerCase().contains(line.toLowerCase())) {

					spamScore += 2;
				}

			}
		} finally {
			input.close();
		}

	}

	@Override
	public String result() {
		if (spamScore < spamScoreLimit)
			return "RESULT: Pass" + "\nSUBJECT: True" + "\nSPAM SCORE: " + spamScore;
		else
			return "RESULT: Fail" + "\nSUBJECT: True" + "\nSPAM SCORE: " + spamScore;
	}
}
