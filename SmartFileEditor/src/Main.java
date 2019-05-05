import smart.file.editor.system.FileEditor;

/*
 * 
 * */
public class Main {

	public static void main(String[] args) {

		String directary = "/var/www/html/Tajnid";

		String searchString = "config.php";
		String searchExtension = ".php";

		String stringName = ".html";
		String replacementName = ".php";
		String stringContent = ".html\"";
		String replacementContent = ".php\"";
		String fileExtension = ".php";

		FileEditor editor = new FileEditor(directary);

		System.out.println("FILE EDITING COMPLETED" + "\n" + "Directary Path " + "\t\t\t: " + directary);

		// comment out the method call you don't need

		/**
		 * change File Permission (permission, ownerOnly)
		 */
		editor.changePermission(true, false);

		/**
		 * replace file extension
		 */
		editor.changeFileName(stringName, replacementName);

		/**
		 * replace certain file content
		 */
		editor.changeFileContent(stringContent, replacementContent, fileExtension);

		/**
		 * search for specific string in file with given extension
		 */
		editor.search(searchString, searchExtension);

	}

}
