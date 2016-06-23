

public class Faculty {
	
	private String name;
	private String Title;
	private String maxGradTeachingLoad;
	private String coursesFacultyNumber;
	private String daysToTeach;
	
	public Faculty() {
	}
	
	
	


	


	public Faculty(String name, String title, String maxGradTeachingLoad,
			String coursesFacultyNumber, String daysToTeach) {
		super();
		this.name = name;
		Title = title;
		this.maxGradTeachingLoad = maxGradTeachingLoad;
		this.coursesFacultyNumber = coursesFacultyNumber;
		this.daysToTeach = daysToTeach;
	}








	public String getTitle() {
		return Title;
	}








	public void setTitle(String title) {
		Title = title;
	}








	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	

	public String getMaxGradTeachingLoad() {
		return maxGradTeachingLoad;
	}


	public void setMaxGradTeachingLoad(String maxGradTeachingLoad) {
		this.maxGradTeachingLoad = maxGradTeachingLoad;
	}


	public String getCoursesFacultyNumber() {
		return coursesFacultyNumber;
	}


	public void setCoursesFacultyNumber(String coursesFacultyNumber) {
		this.coursesFacultyNumber = coursesFacultyNumber;
	}


	public String getDaysToTeach() {
		return daysToTeach;
	}


	public void setDaysToTeach(String daysToTeach) {
		this.daysToTeach = daysToTeach;
	}
	
	
	
	
	
	
}
