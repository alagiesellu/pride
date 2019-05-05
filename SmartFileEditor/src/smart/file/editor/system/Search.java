package smart.file.editor.system;

/**
 * NOW THE NEXT JOB IS TO RETURN RESULTS AS AN ARRAY OF OBJECTS
 * 
 * EX: {'file_name','file_path','line_number','line_content'}
 * */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Search {

	private String directary, searchString, fileExtension;
	private int count;

	protected Search(String directary, String searchString, String fileExtension) {

		this.directary = directary;
		this.searchString = searchString;
		this.fileExtension = fileExtension;
	}

	protected int start() {
		search(new File(directary));
		return count;
	}

	private void search(File file) {

		System.out.println("\tFile Name" + "\t\t" + "File Path" + "\t\t" + "Line Number" + "\t" + "Line Content");

		File folder = new File(file.getPath());
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {

				String name = listOfFiles[i].getName();

				if (fileExtension.equalsIgnoreCase("ALL")
						|| name.substring(name.length() - fileExtension.length()).equals(fileExtension))
					searchString(listOfFiles[i]);

			} else if (listOfFiles[i].isDirectory())
				search(listOfFiles[i]);

		}
	}

	private void searchString(File file) {

		try {
			Scanner scanner = new Scanner(file);

			int lineNumber = 1;

			try {
				while (scanner.hasNextLine()) {
					String lineContent = scanner.nextLine();
					if (lineContent.contains(searchString)) {
						count++;

						System.out.printf("%d \t %s \t\t %s \t %d \t %s \n", count, file.getName(), file.getPath(),
								lineNumber, lineContent);
					}

					lineNumber++;
				}

			} finally {
				scanner.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
