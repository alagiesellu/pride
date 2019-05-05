import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;

public class ft {

	private static String src = null, // source folder path, for flash drive where recite in computer.
			type = "", // extension or filename ending you interested in.
			sleep = ""; // sleep time in seconds. Time program should wait before copying again. Default
						// is 60 seconds
	private static int sleepTime = 0; // time to sleep between copies

	public static void main(String[] args) {

		File desFile = null; // destination folder to store files

		try {
			BufferedReader configFileReader = new BufferedReader(
					new FileReader("config"));
			String line;
			while ((line = configFileReader.readLine()) != null) {

				if (!line.startsWith("#")) {

					if (line.startsWith("src:"))// fetch src value
						src = line.substring("src:".length());

					if (line.startsWith("ty:"))// fetch ty value
						type = line.substring("ty:".length());

					if (line.startsWith("ds:"))// fetch ds value, and initialize destination file
						desFile = new File(line.substring("ds:".length()));

					if (line.startsWith("sleep:"))// fetch sleep value
						sleep = line.substring("sleep:".length());

				}
			}
			configFileReader.close();

			// if these two values not set in config file, then exit system.
			if (src == null || desFile == null)
				System.exit(0);

		} catch (Exception e) {
			// System.out.println(e.toString());
		}

		// set sleepTime time from config value or default 60
		// because sleep input from config, so should be carefully parsed
		while (!sleep.equals("" + sleepTime) && sleepTime < 60)
			sleepTime++; // keep on incrementing until sleep time found, else set to 60

		try {

			// copyFile after every sleep time, no end
			while (true) {
				copyFile(new File(src), desFile);
				Thread.sleep(sleepTime * 1000);
			}

		} catch (Exception e) {
			// System.out.println(e.toString());
		}

	}

	private static void copyFile(File srcFolder, File desFile) {

		// if desFile didn't exists then create
		if (!desFile.exists())
			desFile.mkdir();

		// get a list of files in from the srcPath and loop through
		for (File srcFile : srcFolder.listFiles()) {

			srcFile.setReadable(true);
			File desFileCopy = new File(desFile.getPath() + "/" + srcFile.getName());

			// if it's a directory recursively visit it
			if (srcFile.isDirectory())
				copyFile(srcFile, desFileCopy);

			// else it's not a directory, but file
			else {

				// if file name contain ty part looking for
				if (srcFile.getName().contains(type))
					try {
						// if (don't exist) => copy the file
						if (!desFileCopy.exists()) {

							Files.copy(srcFile.toPath(), desFileCopy.toPath());

						}
						// else ( exist )
						else {

							// if (exist but modified)
							if (srcFile.lastModified() > desFileCopy.lastModified()) {

								File oldStore = new File(desFileCopy.toPath().toString() + "~");

								if (!oldStore.exists())
									oldStore.mkdir();

								/**
								 * when file modified, rename it into folder that keep modified, file will be
								 * copied again after recursion
								 */
								desFileCopy.renameTo(new File(oldStore.getPath() + "/" + desFileCopy.lastModified()));

							} // end (exist but modified)

						} // end else ( exist )

					} catch (IOException e) {
						// System.out.println(e.toString());
					}
			}

		}

	}

}
