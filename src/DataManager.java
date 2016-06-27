

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class DataManager {
	
	private static volatile DataManager dataManagerInstance = new DataManager();
	 
    // private constructor
    private DataManager() {
    }
 
    public static DataManager getInstance() {
        return dataManagerInstance;
    }
	
public static HashMap<String,UserBean> userDataBaseMap = new HashMap<String,UserBean>();
public static HashMap<Integer,UserBean> usersDataBaseIndexMap = new HashMap<Integer,UserBean>();

public  static List<UserBean> personsDataBaseList = new LinkedList<UserBean>();
public static List<UserBean> personsList = new LinkedList<UserBean>();






public  Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
public  HashMap<Integer,Room> roomsDataBaseMap = new HashMap<Integer,Room>();
public  HashMap<Integer,Degree> degreeDataBaseMap = new HashMap<Integer,Degree>();
public  HashMap<Integer,Faculty> facultyDataBaseMap = new HashMap<Integer,Faculty>();
public  HashMap<Integer,Semester> semesterDataBaseMap = new HashMap<Integer,Semester>();
public  HashMap<Integer,Student> studentDataBaseMap = new HashMap<Integer,Student>();
public  HashMap<Integer,StudentCourse> studentCourseDataBaseMap = new HashMap<Integer,StudentCourse>();

public  HashMap<Integer,University> universityDataBaseMap = new HashMap<Integer,University>();

public  HashMap<String,String> loginStatusCheckMap = new HashMap<String,String>();
public  HashMap<Integer,ForeCast> foreCastDegreeDataBaseMap = new HashMap<Integer,ForeCast>();
public  HashMap<Integer,ScheduleAdjust> scheduleAdjustDataBaseMap = new HashMap<Integer,ScheduleAdjust>();


public Map<Integer, Course> getCourseDataBaseMap() {
	return courseDataBaseMap;
}

public void setCourseDataBaseMap(Map<Integer, Course> courseDataBaseMap) {
	this.courseDataBaseMap = courseDataBaseMap;
}

public static HashMap<String, UserBean> getUserDataBaseMap() {
	return userDataBaseMap;
}

public static void setUserDataBaseMap(HashMap<String, UserBean> userDataBaseMap) {
	DataManager.userDataBaseMap = userDataBaseMap;
}

public static HashMap<Integer, UserBean> getUsersDataBaseIndexMap() {
	return usersDataBaseIndexMap;
}

public static void setUsersDataBaseIndexMap(
		HashMap<Integer, UserBean> usersDataBaseIndexMap) {
	DataManager.usersDataBaseIndexMap = usersDataBaseIndexMap;
}

public static List<UserBean> getPersonsDataBaseList() {
	return personsDataBaseList;
}

public static void setPersonsDataBaseList(List<UserBean> personsDataBaseList) {
	DataManager.personsDataBaseList = personsDataBaseList;
}

public static List<UserBean> getPersonsList() {
	return personsList;
}

public static void setPersonsList(List<UserBean> personsList) {
	DataManager.personsList = personsList;
}

public HashMap<Integer, Room> getRoomsDataBaseMap() {
	return roomsDataBaseMap;
}

public void setRoomsDataBaseMap(HashMap<Integer, Room> roomsDataBaseMap) {
	this.roomsDataBaseMap = roomsDataBaseMap;
}

public HashMap<Integer, Degree> getDegreeDataBaseMap() {
	return degreeDataBaseMap;
}

public void setDegreeDataBaseMap(HashMap<Integer, Degree> degreeDataBaseMap) {
	this.degreeDataBaseMap = degreeDataBaseMap;
}

public HashMap<Integer, Faculty> getFacultyDataBaseMap() {
	return facultyDataBaseMap;
}

public void setFacultyDataBaseMap(HashMap<Integer, Faculty> facultyDataBaseMap) {
	this.facultyDataBaseMap = facultyDataBaseMap;
}

public HashMap<Integer, Semester> getSemesterDataBaseMap() {
	return semesterDataBaseMap;
}

public void setSemesterDataBaseMap(
		HashMap<Integer, Semester> semesterDataBaseMap) {
	this.semesterDataBaseMap = semesterDataBaseMap;
}

public HashMap<Integer, Student> getStudentDataBaseMap() {
	return studentDataBaseMap;
}

public void setStudentDataBaseMap(HashMap<Integer, Student> studentDataBaseMap) {
	this.studentDataBaseMap = studentDataBaseMap;
}

public HashMap<Integer, University> getUniversityDataBaseMap() {
	return universityDataBaseMap;
}

public void setUniversityDataBaseMap(
		HashMap<Integer, University> universityDataBaseMap) {
	this.universityDataBaseMap = universityDataBaseMap;
}

public HashMap<String, String> getLoginStatusCheckMap() {
	return loginStatusCheckMap;
}

public void setLoginStatusCheckMap(HashMap<String, String> loginStatusCheckMap) {
	this.loginStatusCheckMap = loginStatusCheckMap;
}

public HashMap<Integer, StudentCourse> getStudentCourseDataBaseMap() {
	return studentCourseDataBaseMap;
}

public void setStudentCourseDataBaseMap(
		HashMap<Integer, StudentCourse> studentCourseDataBaseMap) {
	this.studentCourseDataBaseMap = studentCourseDataBaseMap;
}

public HashMap<Integer, ForeCast> getForeCastDegreeDataBaseMap() {
	return foreCastDegreeDataBaseMap;
}

public void setForeCastDegreeDataBaseMap(
		HashMap<Integer, ForeCast> foreCastDegreeDataBaseMap) {
	this.foreCastDegreeDataBaseMap = foreCastDegreeDataBaseMap;
}

public static DataManager getDataManagerInstance() {
	return dataManagerInstance;
}

public static void setDataManagerInstance(DataManager dataManagerInstance) {
	DataManager.dataManagerInstance = dataManagerInstance;
}

public HashMap<Integer, ScheduleAdjust> getScheduleAdjustDataBaseMap() {
	return scheduleAdjustDataBaseMap;
}

public void setScheduleAdjustDataBaseMap(
		HashMap<Integer, ScheduleAdjust> scheduleAdjustDataBaseMap) {
	this.scheduleAdjustDataBaseMap = scheduleAdjustDataBaseMap;
}


}
