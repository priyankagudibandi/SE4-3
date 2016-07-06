

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test {
	HashMap<String,ArrayList<String>> courseCodesMap = new LinkedHashMap<String,ArrayList<String>>();
	HashMap<String,String> codesMap = new LinkedHashMap<String,String>();

	
	private void addMapValues(String key, String value) {
		   ArrayList tempList = null;
		   if (courseCodesMap.containsKey(key)) {
		      tempList = courseCodesMap.get(key);
		      if(tempList == null)
		         tempList = new ArrayList();
		      tempList.add(value);  
		   } else {
		      tempList = new ArrayList();
		      tempList.add(value);               
		   }
		   courseCodesMap.put(key,tempList);
		}
	
	
	public void test(){
		CSVFileReader.courseCSVReader();
		Course course = new Course();
		Semester semester = new Semester();
		GenerateScheduleBean generateScheduleBean = null;

		Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
		 courseDataBaseMap =  DataManager.getInstance().getCourseDataBaseMap();
		
		 System.out.println("$$$$$$"+courseDataBaseMap.size());
		 
		String keyy="";
		int j=0;
		 for (int i = 0; i < courseDataBaseMap.size(); i++) {
				course = 	courseDataBaseMap.get(i);
				
				generateScheduleBean= new GenerateScheduleBean();
				//if(course.getOfferedFall().equals(AppContstants.YES)){
					generateScheduleBean.setSemester(AppContstants.SEMESTER_TYPE_FALL);
					generateScheduleBean.setCourseName(course.getCourseName());
					
					keyy = course.getCourseNumber().trim();
					//System.out.println(keyy);
					
					if(!courseCodesMap.containsKey(keyy)){
						codesMap.put(keyy, keyy+"-0"+1);
						addMapValues(keyy+1,keyy+"-0"+1);
						//generateScheduleBean.setCourseNumber(keyy+"-0"+1);
					}
					else{
						
						j = courseCodesMap.get(course.getCourseNumber()).size();
						int k = j+1;
						if(j<10){
							codesMap.put(keyy, keyy+"-0"+1);
							addMapValues(keyy,keyy+"-0"+k);
						//generateScheduleBean.setCourseNumber(course.getCourseNumber()+"-0"+j);
						}else{
							addMapValues(keyy,keyy+""+k);
						//generateScheduleBean.setCourseNumber(course.getCourseNumber()+"-"+j);
					}
					}
				//}
		 }
		 
		 System.out.println("____"+courseCodesMap.size());
		 Iterator it = courseCodesMap.keySet().iterator();
		   ArrayList<String> tempList = null;
		 while (it.hasNext()) {
		      String key = it.next().toString();             
		      tempList = courseCodesMap.get(key);
		      if (tempList != null) {
		         for (String value: tempList) {
		            System.out.println("Key : "+key+ " , Value : "+value);
		         }
		      }
		   }
	}
	
	public static void main(String[] args) {
		Test test = new Test();
		test.test();
	}

}
