import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

// This class write objects sequentially to a file with class ObjectOutputStream
public class Register extends JFrame {

	private ObjectOutputStream output;
	private RegisterUI registerUI;
	private JButton openFileButton, registerButton, resetButton;

	File openedFile;

	// set up GUI
	public Register() {
		super("Student Register Program");

		// create instance of reusable user interface
		registerUI = new RegisterUI();
		getContentPane().add(registerUI, BorderLayout.CENTER);

		// configure button doTask1 for use in this program
		openFileButton = registerUI.getOpenFileButon();

		// register listener to call openFile when button pressed
		openFileButton.addActionListener(

		// anonymous inner class to handle openButton event
				new ActionListener() {

					// call openFile when button pressed
					public void actionPerformed(ActionEvent event) {
						openFile();
					}
				}); // end call to addActionListener

		// configure button doTask2 for use in this program
		registerButton = registerUI.getAddRecordButton();
		registerButton.setEnabled(false); // disable button before choosing file

		// register listener to call addRecord when button pressed
		registerButton.addActionListener(

		// anonymous inner class to handle enterButton event
				new ActionListener() {

					// call addRecord when button pressed
					public void actionPerformed(ActionEvent event) {
						addRecord();
					}
				}); // end call to addActionListener

		// reset fields button and action listener
		resetButton = registerUI.getResetProgramButton();

		// register listener to call addRecord when button pressed
		resetButton.addActionListener(

		// anonymous inner class to handle enterButton event
				new ActionListener() {

					// call addRecord when button pressed
					public void actionPerformed(ActionEvent event) {

						// clear fields and close file
						registerUI.clearFields();
					}
				}); // end call to addActionListener

		// register window listener to handle window closing event
		addWindowListener(

		// anonymous inner class to handle windowClosing event
		new WindowAdapter() {

			// add current record in GUI to file, then close file
			public void windowClosing(WindowEvent event) {
				if (output != null)
					closeFile();
				System.exit(0);
			}
		}); // end call to addWindowListener

		setSize(600, 250);
		setVisible(true);

	} // end WriteRegisterFile constructor

	// allow user to specify file name
	private void openFile() {
		// display file dialog, so user can choose file to open
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

		int result = fileChooser.showSaveDialog(this);

		// if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION) {
			return;
		}

		openedFile = fileChooser.getSelectedFile(); // get selected file

		// display error if invalid
		if (openedFile == null || openedFile.getName().equals("")) {
			JOptionPane.showMessageDialog(this, "Invalid File Name",
					"Invalid File Name", JOptionPane.ERROR_MESSAGE);
		} else {
			
			// try open file
			try {
				output = new ObjectOutputStream(
						new FileOutputStream(openedFile));
				registerButton.setEnabled(true);
			}

			// process exceptions from opening file
			catch (IOException ioException) {
				JOptionPane.showMessageDialog(this, "Error Opening File",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

		} // end else

	} // end method openFile

	// close file and terminate application
	private void closeFile() {

		// close file
		try {
			output.close();
			System.exit(0);
		}

		// process exceptions from closing file
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "Error closing file", "Error",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}

	} // end method closeFile

	// add record to file
	public void addRecord() {
		Record setRecord;
		String fieldValues[] = registerUI.getFieldValues();

		// output values to file
		try {

			// first validate input before record
			if (validateInput()) {

				// create new record
				setRecord = new Record(Integer.parseInt(fieldValues[0]),
						fieldValues[1], fieldValues[2], fieldValues[3],
						Integer.parseInt(fieldValues[4]),
						Integer.parseInt(fieldValues[5]));

				// output record and flush buffer
				output.writeObject(setRecord);
				output.flush();

				JOptionPane.showMessageDialog(this,
						"Student ID:  " + fieldValues[0] + "\nName:  "
								+ fieldValues[1].toUpperCase() + " "
								+ fieldValues[2].toUpperCase() + "\nFile:  "
								+ openedFile, "Record Successfully Added",
						JOptionPane.INFORMATION_MESSAGE);

				// clear fields
				registerUI.clearFields();
			}
		} // end try

		// process invalid account number or balance format
		catch (NumberFormatException formatException) {
			JOptionPane.showMessageDialog(this,
					"Please fill all the fields correctly", "Invalid Entry",
					JOptionPane.ERROR_MESSAGE);
		}

		// process exceptions from file output
		catch (IOException ioException) {
			JOptionPane.showMessageDialog(this, "Error writing to file",
					"IO Exception", JOptionPane.ERROR_MESSAGE);
			closeFile();

		} // end catch

	}// end method addRecord

	// method to validate input
	private boolean validateInput() {
		String fieldValues[] = registerUI.getFieldValues();
		String id = fieldValues[0];
		String fname = fieldValues[1];
		String lname = fieldValues[2];
		String study = fieldValues[3];
		String year = fieldValues[4];
		String contact = fieldValues[5];

		// all fields should be filled
		if (id.equals("") || lname.equals("") || fname.equals("")
				|| study.equals("") || year.equals("") || contact.equals("")) {
			JOptionPane.showMessageDialog(this, "Please fill all the entries",
					"Invalid Entry", JOptionPane.ERROR_MESSAGE);
			return false;

			// validate ID filed
		} else if (!id.matches("(\\d{8}+|\\d{8}+\\s+)")) {
			JOptionPane.showMessageDialog(this,
					"Student ID should be 8 digits", "Invalid Entry",
					JOptionPane.ERROR_MESSAGE);
			return false;

			// validate First Name filed
		} else if (!fname
				.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+|[a-zA-Z]+\\s+"
						+ "|[a-zA-Z]+\\s[a-zA-Z]+\\s+|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s+"
						+ "|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+"
						+ "|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s+"
						+ "|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+"
						+ "|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s+"
						+ "|[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+\\s[a-zA-Z]+)")) {
			JOptionPane.showMessageDialog(this, "Invalid First Name",
					"Invalid Entry", JOptionPane.ERROR_MESSAGE);
			return false;

			// validate Last Name filed
		} else if (!lname.matches("([a-zA-Z]+\\s+|[a-zA-Z]+)")) {
			JOptionPane.showMessageDialog(this, "Invalid Last Name",
					"Invalid Entry", JOptionPane.ERROR_MESSAGE);
			return false;

			// validate Year filed
		} else if (!study
				.matches("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+|[a-zA-Z]+\\s+"
						+ "|[a-zA-Z]+\\s[a-zA-Z]+\\s+)")) {
			JOptionPane.showMessageDialog(this, "Invalid Field of Study",
					"Invalid Entry", JOptionPane.ERROR_MESSAGE);
			return false;

			// validate Year filed
		} else if (!year.matches("([2][0][0-2][0]+|[2][0][0-2][0]+\\s+"
				+ "|[2][0][0][0-9]+|[2][0][0][0-9]+\\s+"
				+ "|[2][0][1][0-9]+|[2][0][1][0-9]+\\s+"
				+ "|[1][9][9][8-9]+|[1][9][9][8-9]+\\s+)")) {
			JOptionPane.showMessageDialog(this, "Invalid Admission Year",
					"Invalid Entry", JOptionPane.ERROR_MESSAGE);
			return false;
			// validate Contact filed
		} else if (!contact.matches("(\\d{7}+|\\d{7}+\\s+)")) {
			JOptionPane.showMessageDialog(this, "Invalid Contact Number",
					"Invalid Entry", JOptionPane.ERROR_MESSAGE);
			return false;

			// if all correctly filled
		} else {
			return true;
		}

	} // end method validateInput

	public static void main(String args[]) {
		new Register();
	}

} // end class CreateSequentialFile