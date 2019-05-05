package smart.file.editor.system;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class EditName {

	private String replacementName, stringName, directary;
	private int count;

	protected EditName(String directary, String stringName, String replacementName) {

		this.replacementName = replacementName;
		this.stringName = stringName;
		this.directary = directary;

	}

	// start processing file, and return the number of files affected
	protected int start() {
		readFolder(new File(directary));
		return count;
	}

	private void readFolder(File file) {

		File[] listOfFiles = file.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {

				String name = listOfFiles[i].getName();

				if (name.substring(name.length() - (stringName.length())).equals(stringName))
					renameFile(listOfFiles[i]);

			} else if (listOfFiles[i].isDirectory())
				readFolder(listOfFiles[i]);

		}
	}

	private void renameFile(File file) {

		String name = file.getName();
		String newName = name.substring(0, name.length() - stringName.length()) + replacementName;

		File newFile = new File(file.getParent(), newName);

		try {

			if (Files.move(file.toPath(), newFile.toPath()) != null) {
				count++;
			}

		} catch (IOException e) {
			System.out.println("Error!");
		}

	}

}
