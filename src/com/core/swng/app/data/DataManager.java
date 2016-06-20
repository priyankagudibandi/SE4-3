package com.core.swng.app.data;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import com.core.swng.app.model.Course;
import com.core.swng.app.model.Degree;
import com.core.swng.app.model.Faculty;
import com.core.swng.app.model.Room;
import com.core.swng.app.model.Semester;
import com.core.swng.app.model.Student;
import com.core.swng.app.model.University;
import com.core.swng.app.model.UserBean;

public class DataManager {
	
public static HashMap<String,UserBean> userDataBaseMap = new HashMap<String,UserBean>();
public static HashMap<Integer,UserBean> usersDataBaseIndexMap = new HashMap<Integer,UserBean>();

public  static List<UserBean> personsDataBaseList = new LinkedList<UserBean>();
public static List<UserBean> personsList = new LinkedList<UserBean>();




public static HashMap<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
public static HashMap<Integer,Room> roomsDataBaseMap = new HashMap<Integer,Room>();
public static HashMap<Integer,Degree> degreeDataBaseMap = new HashMap<Integer,Degree>();
public static HashMap<Integer,Faculty> facultyDataBaseMap = new HashMap<Integer,Faculty>();
public static HashMap<Integer,Semester> semesterDataBaseMap = new HashMap<Integer,Semester>();
public static HashMap<Integer,Student> studentDataBaseMap = new HashMap<Integer,Student>();
public static HashMap<Integer,University> universityDataBaseMap = new HashMap<Integer,University>();






}
