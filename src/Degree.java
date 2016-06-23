

public class Degree {

	private String name;
	private String department;
	private String degreeCode;
	private String hoursRequired;
	private String courseRequirement;
	
	
	private String track;
	private int classCap;
	
	
	public Degree() {
	}


	public Degree(String name, String department, String degreeCode,
			String hoursRequired, String courseRequirement, String track,
			int classCap) {
		this.name = name;
		this.department = department;
		this.degreeCode = degreeCode;
		this.hoursRequired = hoursRequired;
		this.courseRequirement = courseRequirement;
		this.track = track;
		this.classCap = classCap;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDepartment() {
		return department;
	}


	public void setDepartment(String department) {
		this.department = department;
	}


	public String getDegreeCode() {
		return degreeCode;
	}


	public void setDegreeCode(String degreeCode) {
		this.degreeCode = degreeCode;
	}


	public String getHoursRequired() {
		return hoursRequired;
	}


	public void setHoursRequired(String hoursRequired) {
		this.hoursRequired = hoursRequired;
	}


	public String getCourseRequirement() {
		return courseRequirement;
	}


	public void setCourseRequirement(String courseRequirement) {
		this.courseRequirement = courseRequirement;
	}


	public String getTrack() {
		return track;
	}


	public void setTrack(String track) {
		this.track = track;
	}


	public int getClassCap() {
		return classCap;
	}


	public void setClassCap(int classCap) {
		this.classCap = classCap;
	}
	
	
	
	
	
	
}
