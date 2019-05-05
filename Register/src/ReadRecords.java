import java.io.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

// this program read records from a file sequentially and display the contents 
public class ReadRecords extends JFrame {

	private JTextArea recordDisplayArea;
	private JButton openButton, loadRecordButton;
	private JPanel buttonPanel;

	private ObjectInputStream input;
	private FileInputStream fileInput;
	private File fileName;

	// set up GUI
	public ReadRecords() {
		super("Read Records Program");

		Container container = getContentPane();

		buttonPanel = new JPanel(); // set up panel for buttons
		buttonPanel.setBackground(Color.LIGHT_GRAY);

		// create and configure button to open file
		openButton = new JButton("Open File");
		openButton.setBackground(Color.GRAY);
		buttonPanel.add(openButton);

		// register openButton listener
		openButton.addActionListener(

		// anonymous inner class to handle openButton event
				new ActionListener() {

					// open file for processing
					public void actionPerformed(ActionEvent event) {
						openFile();
					}

				} // end anonymous inner class

				); // end call to addActionListener

		// create and configure button to get accounts with credit balances
		loadRecordButton = new JButton("Load Records");
		loadRecordButton.setBackground(Color.GRAY);
		buttonPanel.add(loadRecordButton);

		// register openButton listener
		loadRecordButton.addActionListener(

		// anonymous inner class to handle openButton event
				new ActionListener() {

					// open file for processing
					public void actionPerformed(ActionEvent event) {
						readRecords();
					}

				} // end anonymous inner class

				); // end call to addActionListener

		// set up display area
		recordDisplayArea = new JTextArea();
		JScrollPane scroller = new JScrollPane(recordDisplayArea);

		// attach components to content pane
		container.add(scroller, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.SOUTH);

		loadRecordButton.setEnabled(false);// disable zeroButton

		// register window listener
		addWindowListener(

		// anonymous inner class for windowClosing event
		new WindowAdapter() {

			// close file and terminate program
			public void windowClosing(WindowEvent event) {
				closeFile();
				System.exit(0);
			}

		} // end anonymous inner class

		); // end call to addWindowListener

		String heading;
		heading = String.format("%s\t%s\t%s\t%s\t%s\t%s%s\t%s\t%s\t%s\t%s\t%s",
				"STUDENT ID", "ADMISSION", "CONTACT", "FIELD OF", "LAST",
				"FIRST\n", "NUMBER", "YEAR", "NUMBER", "STUDY", "NAME",
				"NAME\n");

		recordDisplayArea.setText("STUDENT REGISTER RECORDS:\n"
				+ "___________________________________________________"
				+ "________________________________________________\n"
				+ heading
				+ "___________________________________________________"
				+ "________________________________________________\n");

		setSize(600, 250);
		setVisible(true);

	} // end CreditInquiry constructor

	// enable user to choose file to open
	private void openFile() {
		// display dialog, so user can choose file
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int result = fileChooser.showOpenDialog(this);

		// if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			return;

		fileName = fileChooser.getSelectedFile(); // obtain selected file

		// display error if file name invalid
		if (fileName == null || fileName.getName().equals(""))
			JOptionPane.showMessageDialog(this, "Invalid File Name",
					"Invalid File Name", JOptionPane.ERROR_MESSAGE);

		// open file
		try {

			// close file from previous operation
			if (input != null)
				input.close();

			fileInput = new FileInputStream(fileName);
			input = new ObjectInputStream(fileInput);
			loadRecordButton.setEnabled(true);
		}

		// catch problems manipulating file
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "File does not exist",
					"Invalid File Name", JOptionPane.ERROR_MESSAGE);
		}

	} // end method openFile

	// close file
	private void closeFile() {

		try {
			if (input != null)
				input.close();
		}

		// process exception from closing file
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "Error closing file", "Error",
					JOptionPane.ERROR_MESSAGE);

			System.exit(1);
		}

	} // end method closeFile

	// read records from file and display only records of appropriate type
	private void readRecords() {
		Record record;

		// read records
		try {

			if (input != null)
				input.close();

			fileInput = new FileInputStream(fileName);
			input = new ObjectInputStream(fileInput);

			// input the values from the file
			while (true) {

				// read through Record
				record = (Record) input.readObject();

				String row;
				row = String.format("%s\t%s\t%s\t%s\t%s\t%s",
						record.getStudentID(), record.getYear(),
						record.getContact(), record.getStudy().toUpperCase(),
						record.getLastName().toUpperCase(), record
								.getFirstName().toUpperCase() + "\n");

				// append into recordDisplayArea
				recordDisplayArea.append(row);
			}

		} // end try

		// close file when end-of-file reached
		catch (EOFException eofException) {
			closeFile();
		}

		// display error if cannot read object because class not found
		catch (ClassNotFoundException classNotFound) {
			JOptionPane.showMessageDialog(this, "Unable to create object",
					"Class Not Found", JOptionPane.ERROR_MESSAGE);
		}

		// display error if cannot read because problem with file
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "Error reading from file",
					"Error", JOptionPane.ERROR_MESSAGE);
		}

	} // end method readRecords

	public static void main(String args[]) {
		new ReadRecords();
	}

} // end class CreditInquiry