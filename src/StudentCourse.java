

public class StudentCourse {
	
	
	private String id;
	private String courseNumber;
	private String Grade;
	private String Term;

	public StudentCourse(String id, String courseNumber, String grade,
			String term) {
		super();
		this.id = id;
		this.courseNumber = courseNumber;
		Grade = grade;
		Term = term;
	}

	public StudentCourse() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public String getTerm() {
		return Term;
	}

	public void setTerm(String term) {
		Term = term;
	}

	

	
	
	
}
