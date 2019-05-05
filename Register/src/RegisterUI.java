import java.awt.*;
import javax.swing.*;

// this class create a GUI for the register class
public class RegisterUI extends JPanel {

	// GUI components; protected for future subclass access
	protected JLabel info1, info2;
	protected JLabel labels[];
	protected JTextField fields[];
	protected JButton openFileButton, addRecordButton, resetButton;
	protected JPanel PanelWest, PanelEast, PanelNorth, PanelSouth;

	// label text for GUI
	protected final static String names[] = { " Student ID", " First Name",
			" Last Name", " School", " Admission Year", " Contact Number" };

	final int size = 6; // number of fields and labels in GUI components

	// Set up GUI
	public RegisterUI() {
		labels = new JLabel[size];
		fields = new JTextField[size];

		// create labels
		info1 = new JLabel(
				"  Choose a file and enter student details to register a student.");
		info2 = new JLabel(
				"  To search for student records, just fill the Student ID field.");

		for (int count = 0; count < labels.length; count++) {
			labels[count] = new JLabel(names[count]);
		}

		// create text fields
		for (int count = 0; count < fields.length; count++) {
			fields[count] = new JTextField(40);
		}

		// create all the panels to layout, and colored
		PanelNorth = new JPanel();
		PanelNorth.setBackground(Color.GRAY);
		PanelNorth.setLayout(new GridLayout(3, 1));

		PanelWest = new JPanel();
		PanelWest.setBackground(Color.LIGHT_GRAY);
		PanelWest.setLayout(new GridLayout(size, 1));

		PanelEast = new JPanel();
		PanelEast.setBackground(Color.LIGHT_GRAY);
		PanelEast.setLayout(new GridLayout(size, 1));

		PanelSouth = new JPanel();
		PanelSouth.setBackground(Color.LIGHT_GRAY);

		// create the buttons; no labels or event handlers
		openFileButton = new JButton();
		openFileButton.setText("Open File");
		openFileButton.setBackground(Color.GRAY);

		addRecordButton = new JButton();
		addRecordButton.setText("Add Record");
		addRecordButton.setBackground(Color.GRAY);

		resetButton = new JButton();
		resetButton.setText("Reset");
		resetButton.setBackground(Color.GRAY);

		// attach info and buttons to panels
		PanelNorth.add(info1);
		PanelNorth.add(info2);
		PanelSouth.add(openFileButton);
		PanelSouth.add(addRecordButton);
		PanelSouth.add(resetButton);

		// attach the labels and fields to panels using for loop
		for (int count = 0; count < size; count++) {
			PanelWest.add(labels[count]);
			PanelEast.add(fields[count]);
		}

		// set layout of this container and attach panels to it
		setLayout(new BorderLayout());
		setBackground(Color.LIGHT_GRAY);
		add(PanelNorth, BorderLayout.NORTH);
		add(PanelWest, BorderLayout.WEST);
		add(PanelEast, BorderLayout.EAST);
		add(PanelSouth, BorderLayout.SOUTH);

	} // end constructor

	// return reference to generic task button openFileButon
	public JButton getOpenFileButon() {
		return openFileButton;
	}

	// return reference to generic task button addRecordFile
	public JButton getAddRecordButton() {
		return addRecordButton;
	}

	// return reference to generic task button searchRecordFile
	public JButton getResetProgramButton() {
		return resetButton;
	}

	// return reference to fields array of JTextFields
	public JTextField[] getFields() {
		return fields;
	}

	// clear content of text fields
	public void clearFields() {
		for (int count = 0; count < size; count++) {
			fields[count].setText("");
		}
	}

	// get array of Strings with current text field contents
	public String[] getFieldValues() {
		String values[] = new String[size];

		for (int count = 0; count < size; count++) {
			values[count] = fields[count].getText();
		}

		return values;
	}

} // end class BankUI