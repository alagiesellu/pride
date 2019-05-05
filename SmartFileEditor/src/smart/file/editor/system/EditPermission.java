package smart.file.editor.system;

import java.io.File;

public class EditPermission {

	private String directary;
	private boolean permission, ownerOnly;
	private int count;

	protected EditPermission(String directary, boolean permission, boolean ownerOnly) {

		this.directary = directary;
		this.permission = permission;
		this.ownerOnly = ownerOnly;

	}

	protected int start() {
		changePermission(new File(directary), permission, ownerOnly);
		return count;
	}

	private void changePermission(File folder, boolean permission, boolean ownerOnly) {

		folder.setReadable(permission, ownerOnly);
		folder.setWritable(permission, ownerOnly);
		folder.setExecutable(permission, ownerOnly);

		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].setReadable(permission, ownerOnly) && listOfFiles[i].setWritable(permission, ownerOnly)
					&& listOfFiles[i].setExecutable(permission, ownerOnly))
				count++;

			if (listOfFiles[i].isDirectory())
				changePermission(listOfFiles[i], permission, ownerOnly);

		}

	}
}
