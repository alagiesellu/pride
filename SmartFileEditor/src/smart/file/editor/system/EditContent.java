package smart.file.editor.system;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EditContent {

	private String replacementContent, stringContent, directary, fileExtension;
	private int count;

	protected EditContent(String directary, String stringContent, String replacementContent, String fileExtension) {

		this.replacementContent = replacementContent;
		this.stringContent = stringContent;
		this.fileExtension = fileExtension;
		this.directary = directary;

	}

	// start processing file, and return the number of files affected
	protected int start() {
		changeFileContent(new File(directary));
		return count;
	}

	private void changeFileContent(File file) {

		File folder = new File(file.getPath());
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {

				String name = listOfFiles[i].getName();

				if (name.substring(name.length() - fileExtension.length()).equals(fileExtension))
					replaceContent(listOfFiles[i]);

			} else if (listOfFiles[i].isDirectory())
				changeFileContent(listOfFiles[i]);

		}

	}

	// this method developed thanks to stackoverflow.com
	private void replaceContent(File file) {

		BufferedReader reader = null;
		try {

			reader = new BufferedReader(new FileReader(file));

		} catch (FileNotFoundException e) {
			System.out.println("Error!");
		}

		String line = "", oldtext = "";
		try {

			while ((line = reader.readLine()) != null) {
				oldtext += line + "\r\n";
			}

		} catch (IOException e) {
			System.out.println("Error!");
		}

		try {

			reader.close();

		} catch (IOException e) {
			System.out.println("Error!");
		}

		String replacedText = oldtext.replaceAll(stringContent, replacementContent);

		FileWriter writer = null;

		try {

			writer = new FileWriter(file);

		} catch (IOException e) {
			System.out.println("Error!");
		}

		try {

			writer.write(replacedText);
			count++;

		} catch (IOException e) {
			System.out.println("Error!");
		}

		try {

			writer.close();

		} catch (IOException e) {
			System.out.println("Error!");
		}
	}

}
