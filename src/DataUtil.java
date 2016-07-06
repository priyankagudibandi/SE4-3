

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DataUtil {
	HashMap<String,ArrayList<String>> courseCodesMap = new LinkedHashMap<String,ArrayList<String>>();
	HashMap<String,String> keycodesObjectsMap = new LinkedHashMap<String,String>();
	
	//Key : CENG 5013 , Value : CENG 5013-01
	private void addMapValues(String key, String value,String courseName) {
		   ArrayList tempList = null;
		   if (courseCodesMap.containsKey(key)) {
		      tempList = courseCodesMap.get(key);
		      if(tempList == null)
		         tempList = new ArrayList();
		      tempList.add(value); 
		      keycodesObjectsMap.put(courseName, key+"#"+value);
		   } else {
		      tempList = new ArrayList();
		      tempList.add(value);
		      keycodesObjectsMap.put(courseName, key+"#"+value);
		   }
		   courseCodesMap.put(key,tempList);
		   
		}
	
	
	public void test(){
		CSVFileReader.courseCSVReader();
		Course course = new Course();
		GenerateScheduleBean generateScheduleBean = null;

		Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
		courseDataBaseMap =  DataManager.getInstance().getCourseDataBaseMap();
		
		String keyy="";
		String courseName;
		int j=0;
		 for (int i = 0; i < courseDataBaseMap.size(); i++) {
				course = 	courseDataBaseMap.get(i);
					
					keyy = course.getCourseNumber().trim();
					courseName =course.getCourseName();
					
					if(!courseCodesMap.containsKey(keyy)){
						addMapValues(keyy,keyy+"-0"+1,courseName);
					}
					else{
						j = courseCodesMap.get(course.getCourseNumber()).size();
						int k = j+1;
						if(j<10)
							addMapValues(keyy,keyy+"-0"+k,courseName);
						else
							addMapValues(keyy,keyy+""+k,courseName);
					}
		 }
		 
		 DataManager.getInstance().setKeycodesObjectsMap(keycodesObjectsMap);
		/* for (String key : keycodesObjectsMap.keySet()) {
			 System.out.println(key+"...."+keycodesObjectsMap.get(key));
		 }*/
	}
	
	public static void main(String[] args) {
		DataUtil test = new DataUtil();
		test.test();
	}

}
