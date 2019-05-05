import java.io.Serializable;

// this class represents one record of information.
public class Record implements Serializable {

	private int studentID, year, contact;
	private String lname, fname, study;

	// initialize a record
	public Record(int id, String lname, String fname, String study, int year,
			int contact) {
		setStudentID(id);
		setFirstName(lname);
		setLastName(fname);
		setStudy(study);
		setYear(year);
		setContact(contact);
	}

	// set student ID number
	public void setStudentID(int id) {
		studentID = id;
	}

	// get student ID number
	public int getStudentID() {
		return studentID;
	}

	// set name
	public void setLastName(String nam) {
		lname = nam;
	}

	// get name
	public String getLastName() {
		return lname;
	}

	// set name
	public void setFirstName(String nam) {
		fname = nam;
	}

	// get name
	public String getFirstName() {
		return fname;
	}

	// set study field
	public void setStudy(String sdy) {
		study = sdy;
	}

	// get study field
	public String getStudy() {
		return study;
	}

	// set admission year
	public void setYear(int yr) {
		year = yr;
	}

	// get admission year
	public int getYear() {
		return year;
	}

	// set contact number
	public void setContact(int con) {
		contact = con;
	}

	// get contact number
	public int getContact() {
		return contact;
	}

} // end class RegisterRecord