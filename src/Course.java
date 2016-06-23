

public class Course {

	private String courseNumber;
	private String courseName;
	private String courseDescription;
	private String creditHours;
	private int courseCap;
	private String listOfPreReqCourse;
	private String listOfSemestersOffered;
	
	/*private String OfferedFall;
	private String offeredSpring;
	private String offeredSummer;
	private String teachers;
	*/
	
	
	
	
	public Course() {
	}
	public Course(String courseNumber, String courseName,
			String courseDescription, String creditHours, int courseCap,
			String listOfPreReqCourse, String listOfSemestersOffered) {
		super();
		this.courseNumber = courseNumber;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
		this.creditHours = creditHours;
		this.courseCap = courseCap;
		this.listOfPreReqCourse = listOfPreReqCourse;
		this.listOfSemestersOffered = listOfSemestersOffered;
	}
	public String getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(String courseNumber) {
		this.courseNumber = courseNumber;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getCreditHours() {
		return creditHours;
	}
	public void setCreditHours(String creditHours) {
		this.creditHours = creditHours;
	}
	public int getCourseCap() {
		return courseCap;
	}
	public void setCourseCap(int courseCap) {
		this.courseCap = courseCap;
	}
	public String getListOfPreReqCourse() {
		return listOfPreReqCourse;
	}
	public void setListOfPreReqCourse(String listOfPreReqCourse) {
		this.listOfPreReqCourse = listOfPreReqCourse;
	}
	public String getListOfSemestersOffered() {
		return listOfSemestersOffered;
	}
	public void setListOfSemestersOffered(String listOfSemestersOffered) {
		this.listOfSemestersOffered = listOfSemestersOffered;
	}
	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + courseCap;
		result = prime
				* result
				+ ((courseDescription == null) ? 0 : courseDescription
						.hashCode());
		result = prime * result
				+ ((courseName == null) ? 0 : courseName.hashCode());
		result = prime * result
				+ ((courseNumber == null) ? 0 : courseNumber.hashCode());
		result = prime * result
				+ ((creditHours == null) ? 0 : creditHours.hashCode());
		result = prime
				* result
				+ ((listOfPreReqCourse == null) ? 0 : listOfPreReqCourse
						.hashCode());
		result = prime
				* result
				+ ((listOfSemestersOffered == null) ? 0
						: listOfSemestersOffered.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		if (courseCap != other.courseCap)
			return false;
		if (courseDescription == null) {
			if (other.courseDescription != null)
				return false;
		} else if (!courseDescription.equals(other.courseDescription))
			return false;
		if (courseName == null) {
			if (other.courseName != null)
				return false;
		} else if (!courseName.equals(other.courseName))
			return false;
		if (courseNumber == null) {
			if (other.courseNumber != null)
				return false;
		} else if (!courseNumber.equals(other.courseNumber))
			return false;
		if (creditHours == null) {
			if (other.creditHours != null)
				return false;
		} else if (!creditHours.equals(other.creditHours))
			return false;
		if (listOfPreReqCourse == null) {
			if (other.listOfPreReqCourse != null)
				return false;
		} else if (!listOfPreReqCourse.equals(other.listOfPreReqCourse))
			return false;
		if (listOfSemestersOffered == null) {
			if (other.listOfSemestersOffered != null)
				return false;
		} else if (!listOfSemestersOffered.equals(other.listOfSemestersOffered))
			return false;
		return true;
	}
	
	
	
	


	
	
	
	
	
}