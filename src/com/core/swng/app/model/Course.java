package com.core.swng.app.model;

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
	
	
	
	


	
	
	
	
	
}