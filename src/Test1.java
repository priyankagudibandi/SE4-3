

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Test1 {
	Map<String, ArrayList<String>> hashMap = new HashMap<String, ArrayList<String>>();
	HashMap<String,ArrayList<String>> courseCodesMap = new LinkedHashMap<String,ArrayList<String>>();

	
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
						addMapValues(keyy,keyy+"-0"+1);
						//generateScheduleBean.setCourseNumber(keyy+"-0"+1);
					}
					else{
						
						j = courseCodesMap.get(course.getCourseNumber()).size();
						int k = j+1;
						if(j<10)
							addMapValues(keyy,keyy+"-0"+k);
						//generateScheduleBean.setCourseNumber(course.getCourseNumber()+"-0"+j);
						else
							addMapValues(keyy,keyy+""+k);
						//generateScheduleBean.setCourseNumber(course.getCourseNumber()+"-"+j);
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
	
	
	
	public  void duplicateStores(){
		// Add data with duplicate keys
		   addValues("A", "a1");
		   addValues("A", "a2");
		   addValues("B", "b");
		   // View data.
		   Iterator it = hashMap.keySet().iterator();
		   ArrayList<String> tempList = null;

		   while (it.hasNext()) {
		      String key = it.next().toString();             
		      tempList = hashMap.get(key);
		      if (tempList != null) {
		         for (String value: tempList) {
		            System.out.println("Key : "+key+ " , Value : "+value);
		         }
		      }
		   }
	}

	private void addValues(String key, String value) {
		   ArrayList tempList = null;
		   if (hashMap.containsKey(key)) {
		      tempList = hashMap.get(key);
		      if(tempList == null)
		         tempList = new ArrayList();
		      tempList.add(value);  
		   } else {
		      tempList = new ArrayList();
		      tempList.add(value);               
		   }
		   hashMap.put(key,tempList);
		}
	
	public static void main(String[] args) {
		
	//	test();
		Test1 test = new Test1();
	//	test.duplicateStores();
	test.test();
		/*HashMap<String,Integer> mapp = new HashMap<String,Integer>();
		
		for (int i = 0; i < 5; i++) {
			
			mapp.put("abc", i);
			System.out.println(mapp.get("abc"));
		}
		
		mapp.put("abc", 1);
		System.out.println(mapp.containsKey("abc"));
		System.out.println(mapp.get("abc"));
		mapp.put("abc", 2);
		System.out.println(mapp.get("abc"));
		*/
	}

}
