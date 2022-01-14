import java.util.Date;

public class StudentData {

	private int UID;
	private String name,company,placed,packagee;
	private Date dob;
	
	public StudentData(int UID, String name, Date dob, String placed, String company, String packagee) {
		this.UID=UID;
		this.name=name;
		this.dob=dob;
		this.placed=placed;
		this.company=company;
		this.packagee=packagee;
	}
	
	public int getUID() {
		return UID;
	}
	public String getName() {
		return name;
	}
	public String getPlaced() {
		return placed;
	}
	public String getCompany() {
		return company;
	}
	public String getpackage() {
		return packagee;
	}
	public Date getDOB() {
		return dob;
	}

}
