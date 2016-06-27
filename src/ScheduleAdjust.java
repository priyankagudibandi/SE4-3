

public class ScheduleAdjust {

	private String courseName;
	private String sectionNumber;
	private String factultyName;
	
	
	
	public ScheduleAdjust() {
	}

	public ScheduleAdjust(String courseName, String sectionNumber,
			String factultyName) {
		super();
		this.courseName = courseName;
		this.sectionNumber = sectionNumber;
		this.factultyName = factultyName;
	}


	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getSectionNumber() {
		return sectionNumber;
	}



	public void setSectionNumber(String sectionNumber) {
		this.sectionNumber = sectionNumber;
	}



	public String getFactultyName() {
		return factultyName;
	}



	public void setFactultyName(String factultyName) {
		this.factultyName = factultyName;
	}

	

	
	
	
}
