package smart.file.editor.system;

/**
 * 
 * */
public class FileEditor {

	private String directary;

	public FileEditor(String directary) {

		this.directary = directary;

	}

	private String getDirectary() {
		return directary;
	}

	// change specified content in a file
	public void changeFileContent(String stringContent, String replacementContent, String fileExtension) {

		long start = System.currentTimeMillis();

		EditContent contentClass = new EditContent(getDirectary(), stringContent, replacementContent, fileExtension);

		int result = contentClass.start();

		long diff = System.currentTimeMillis() - start;

		System.out.println("File Content Changing Time" + "\t: " + diff + " milliseconds" + "\n"
				+ "File Content Change Count \t: " + result);

	}

	// change specified file extension
	public void changeFileName(String stringName, String replacementName) {

		long start = System.currentTimeMillis();

		EditName nameClass = new EditName(getDirectary(), stringName, replacementName);

		int result = nameClass.start();

		long diff = System.currentTimeMillis() - start;

		System.out.println("File Name Changing Time" + "\t\t: " + diff + " milliseconds" + "\n"
				+ "File Name Change Count \t\t: " + result);

	}

	// change file and folder permission
	public void changePermission(boolean permission, boolean ownerOnly) {

		long start = System.currentTimeMillis();

		EditPermission permissionClass = new EditPermission(getDirectary(), permission, ownerOnly);

		int result = permissionClass.start();

		long diff = System.currentTimeMillis() - start;

		System.out.println("File Permission Changing Time" + "\t: " + diff + " milliseconds" + "\n"
				+ "File Permission Change Count \t: " + result);

	}

	// search for a String with from specific file, extension
	public void search(String searchString, String fileExtension) {

		long start = System.currentTimeMillis();

		Search searchClass = new Search(getDirectary(), searchString, fileExtension);

		int result = searchClass.start();
		long diff = System.currentTimeMillis() - start;

		System.out.println("Search In File Time" + "\t: " + diff + " milliseconds" + "\n" + "File Search Results For '"
				+ searchString + "' : " + result);

	}

}
