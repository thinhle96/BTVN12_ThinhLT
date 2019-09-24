package topica_itlab4.SpringBasic1;

public class Student {
	private int id;
	private String name;
	private String dateOfBirth;
	private String gender;
	
	
	public Student(int id, String name, String dateOfBirth, String gender) {
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
	}

	protected int getId() {
		return id;
	}

	protected void setId(int id) {
		this.id = id;
	}

	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected String getDateOfBirth() {
		return dateOfBirth;
	}

	protected void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	protected String getGender() {
		return gender;
	}

	protected void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + "]";
	}
}
