import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class CSVFileReader {

	
	public static void courseCSVReader(){
		Course course = null;
		BufferedReader br;
		Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
		courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
		try {
			br = new BufferedReader(new FileReader("TestDataCourses.csv"));
			String line = br.readLine(); // Reading header, Ignoring 
			int i=-1;
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				
				i++;
				course = new Course();
				String[] fields = line.split(","); 
				
				course.setCourseNumber(fields[0].trim());
				course.setCourseName(fields[1].trim());
				course.setCourseDescription(fields[2].trim());
				course.setCreditHours(fields[3].trim());
				course.setCourseCap(Integer.valueOf(fields[4]));
				course.setListOfPreReqCourse(fields[8].trim());
				course.setListOfSemestersOffered(fields[7].trim());
				//System.out.println(i);
				//System.out.println(fields[1]);
				courseDataBaseMap.put(i, course);
				} 
			br.close(); 
			DataManager.getInstance().setCourseDataBaseMap(courseDataBaseMap);
			/*System.out.println("size: "+DataManager.getInstance().getCourseDataBaseMap().size());
			for (int j = 0; j < courseDataBaseMap.size(); j++) {
				System.out.println("***"+courseDataBaseMap.get(j).getCourseName());
			}*/
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	/*private String name;
	private String Title;
	private String maxGradTeachingLoad;
	private String coursesFacultyNumber;
	private String daysToTeach;*/
	public static void facultyCSVReader(){
		Faculty faculty = null;
		BufferedReader br;
		HashMap<Integer,Faculty> facultyDataBaseMap = new HashMap<Integer,Faculty>();
		facultyDataBaseMap = DataManager.getInstance().getFacultyDataBaseMap();
		try {
			br = new BufferedReader(new FileReader("TestDataFaculty.csv"));
			String line = br.readLine(); // Reading header, Ignoring 
			int i=-1;
			while ((line = br.readLine()) != null && !line.isEmpty()) { 
				i++;
				faculty = new Faculty();
				System.out.println(line);
				String[] fields = line.split(","); 
				faculty.setName(fields[0]+" "+fields[1]);
				faculty.setTitle(fields[4]);
				faculty.setDaysToTeach(fields[5]);
				faculty.setMaxGradTeachingLoad(fields[6]);
				faculty.setCoursesFacultyNumber(fields[3]);
				facultyDataBaseMap.put(i, faculty);
				} 
			br.close(); 
			DataManager.getInstance().setFacultyDataBaseMap(facultyDataBaseMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	private String name;
	private String department;
	private String degreeCode;
	private String hoursRequired;
	private String courseRequirement;
	
	public static void DegreeCSVReader(){
		Degree degree = null;
		BufferedReader br;
		HashMap<Integer,Degree> degreeDataBaseMap = new HashMap<Integer,Degree>();
		degreeDataBaseMap = DataManager.getInstance().getDegreeDataBaseMap();
		try {
			br = new BufferedReader(new FileReader("TestDataDegrees.csv"));
			String line = br.readLine(); // Reading header, Ignoring 
			int i=-1;
			while ((line = br.readLine()) != null && !line.isEmpty()) { 
				i++;
				degree = new Degree();
				//System.out.println(line);
				String[] fields = line.split(","); 
				
				degree.setName(fields[2]);
				degree.setDegreeCode(fields[0]);
				degree.setDepartment(fields[2]);
				degree.setHoursRequired(fields[3]);
				degree.setCourseRequirement(fields[3]);
				
				degreeDataBaseMap.put(i, degree);
				} 
			br.close(); 
			DataManager.getInstance().setDegreeDataBaseMap(degreeDataBaseMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void degreeForcastCSVReader(){
		ForeCast foreCast = null;
		BufferedReader br;
		HashMap<Integer,ForeCast> foreCastDegreeDataBaseMap = new HashMap<Integer,ForeCast>();
		foreCastDegreeDataBaseMap = DataManager.getInstance().getForeCastDegreeDataBaseMap();
		
		try {
			br = new BufferedReader(new FileReader("TestDataDegrees.csv"));
			String line = br.readLine(); // Reading header, Ignoring 
			int i=-1;
			while ((line = br.readLine()) != null && !line.isEmpty()) { 
				i++;
				foreCast = new ForeCast();
				String[] fields = line.split(","); 
				
				foreCast.setDegreeCode(fields[0]);
				foreCast.setExpectedNumOfStudents("");
				
				foreCastDegreeDataBaseMap.put(i, foreCast);
				} 
			br.close(); 
			DataManager.getInstance().setForeCastDegreeDataBaseMap(foreCastDegreeDataBaseMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	public static void scheduleAdjustCSVReader(){
		ScheduleAdjust scheduleAdjust = null;
		BufferedReader br;
		HashMap<Integer,ScheduleAdjust> scheduleAdjustDataBaseMap = new HashMap<Integer,ScheduleAdjust>();
		scheduleAdjustDataBaseMap = DataManager.getInstance().getScheduleAdjustDataBaseMap();
		
		try {
			br = new BufferedReader(new FileReader("TestDataCourses.csv"));
			String line = br.readLine();
			int i=-1;
			while ((line = br.readLine()) != null && !line.isEmpty()) { 
				i++;
				scheduleAdjust = new ScheduleAdjust();
				String[] fields = line.split(","); 
				
				scheduleAdjust.setCourseName(fields[1]);
				scheduleAdjust.setFactultyName("");
				scheduleAdjust.setSectionNumber("");
				
				scheduleAdjustDataBaseMap.put(i, scheduleAdjust);
				} 
			br.close(); 
			DataManager.getInstance().setScheduleAdjustDataBaseMap(scheduleAdjustDataBaseMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	public static void roomCSVReader(){
		/*Course course = new Course();
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("TestDataCourses.csv"));
			String line = br.readLine(); // Reading header, Ignoring 
			int i=-1;
			while ((line = br.readLine()) != null && !line.isEmpty()) { 
				i++;
				System.out.println(line);
				String[] fields = line.split(","); 
				
				course.setCourseNumber(fields[0]);
				course.setCourseName(fields[1]);
				course.setCourseDescription(fields[2]);
				course.setCreditHours(fields[3]);
				course.setCourseCap(Integer.valueOf(fields[4]));
				course.setListOfPreReqCourse(fields[8]);
				course.setListOfSemestersOffered(fields[7]);
				
				DataManager.courseDataBaseMap.put(i, course);
				} 
			br.close(); 
			System.out.println("size: "+DataManager.courseDataBaseMap.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} */
	}
	
	
	
	
	
	
	
	
	/* * Java program to read CVS file using BufferedReader and String split() * method */ 
	public static List readCSV() throws FileNotFoundException, IOException {
		List countries = new ArrayList<>(); 
		BufferedReader br = new BufferedReader(new FileReader("TestDataCourses.csv")); 
		String line = br.readLine(); // Reading header, Ignoring 
		while ((line = br.readLine()) != null && !line.isEmpty()) { 
			System.out.println(line);
			String[] fields = line.split(","); 
			String name = fields[0]; String capital = fields[1]; 
			String currency = fields[2]; 
			Country nation = new Country(name, capital, currency); 
			countries.add(nation); 
			} 
		br.close(); 
		return countries; 
		} 

	
	public static void studentCSVReader(){
		Student student = null;
		BufferedReader br;
		HashMap<Integer,Student> studentDataBaseMap = new HashMap<Integer,Student>();
		studentDataBaseMap = DataManager.getInstance().getStudentDataBaseMap();
		try {
			br = new BufferedReader(new FileReader("STU.DUMP.CSV"));
			String line = br.readLine(); // Reading header, Ignoring 
			int i=-1;
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				
				i++;
				student = new Student();
				String[] fields = line.split(","); 
				
				student.setId(fields[0].trim());
				student.setDegree(fields[1].trim());
				student.setTrack(fields[2].trim());
				//student.setGraduationDate(fields[3].trim());
				studentDataBaseMap.put(i, student);
				} 
			br.close(); 
			DataManager.getInstance().setStudentDataBaseMap(studentDataBaseMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	
	public static void studentCourseCSVReader(){
		StudentCourse studentCourse = null;
		BufferedReader br;
		HashMap<Integer,StudentCourse> studentCourseDataBaseMap = new HashMap<Integer,StudentCourse>();
		studentCourseDataBaseMap = DataManager.getInstance().getStudentCourseDataBaseMap();
		try {
			br = new BufferedReader(new FileReader("STC.DUMP.CSV"));
			String line = br.readLine(); // Reading header, Ignoring 
			int i=-1;
			while ((line = br.readLine()) != null && !line.isEmpty()) {
				
				i++;
				studentCourse = new StudentCourse();
				String[] fields = line.split(","); 
				
				studentCourse.setId(fields[0].trim());
				studentCourse.setCourseNumber(fields[1].trim());
				studentCourse.setGrade(fields[3].trim());
				studentCourse.setTerm(fields[4].trim());
				studentCourseDataBaseMap.put(i, studentCourse);
				} 
			br.close(); 
			DataManager.getInstance().setStudentCourseDataBaseMap(studentCourseDataBaseMap);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	
	public static void main(String args[]){
			//readCSV();
			//courseCSVReader();
			facultyCSVReader();
			DegreeCSVReader();
			//RoomCSVReader();
	}
}
