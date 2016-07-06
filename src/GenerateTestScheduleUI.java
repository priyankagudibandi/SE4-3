import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GenerateTestScheduleUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelSemester,statusLabel11111;
	private JTextField textSemester;
	private JButton buttonGetSchedule, bClear;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel label;
	String listOfPreReqCourses [] ={"Admin","Director"}; //new String[1000];  //{"Admin","Director"};
	List<String> listOfPreReqCoursesList = new ArrayList<String>();
	private String textSemestersOffered;
	private String selectListOfPreReqCourses="";
	private JList list;
	public GenerateTestScheduleUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//CSVFileReader.courseCSVReader();
		createForm();
		refreshTable();
	}

	public void createForm() {
		
		pForm = new JPanel();

		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		pForm.setLayout(new java.awt.GridLayout(4, 3, 10, 5));
		pForm.setLayout(new BoxLayout(pForm, BoxLayout.X_AXIS));

		getContentPane().add(pForm);

		pTable = new JPanel();

		getContentPane().add(pTable);
		jTable = new JTable();
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"NUMBER OF STUDENTS", "NUMBER PERCENTAGE REQUIRED COURSE", "NUMBER AND STUDENTS WITHOUT REQUIRED COURSESS"}));
		spTable = new JScrollPane();
		spTable.setBounds(0, 354, 879, 196);
		spTable.setViewportView(jTable);  
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				buttonGetSchedule = new JButton("Get Schedule");
				buttonGetSchedule.setBounds(115, 200, 119, 23);
				buttonGetSchedule.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						generateSchedule();
					}
				});
		
				bClear = new JButton("Clear");
				bClear.setBounds(312, 200, 79, 23);
				bClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cleanFields();
					}
				});
		textSemester = new JTextField();
		textSemester.setBounds(299, 116, 213, 20);
		textSemester.setText("2016SU");
		
		labelSemester = new JLabel("SEMESTER");
		labelSemester.setBounds(82, 119, 152, 14);
		
		
		pTable.setLayout(null);
		pTable.add(labelSemester);
		pTable.add(buttonGetSchedule);
		pTable.add(bClear);
		pTable.add(textSemester);
		pTable.add(spTable);
	       
		lblTestdfatrr = new JLabel("GENERATE TEST SCHEDULE");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		pTable.add(lblTestdfatrr);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(DataManager.getInstance().getLoginStatusCheckMap().get(AppContstants.USER_TYPE_ARDMIN)!=null){
					AdminHomeUI adminHomeUi = new AdminHomeUI();
					adminHomeUi.displayAdminHomeUI();
					disposeWindow();
					
				}else{
					DirectorHomeUI directorHomeUI = new DirectorHomeUI();
					directorHomeUI.displayAdminHomeUI();
					disposeWindow();
				}
				
			}
		});
		btnHome.setBounds(482, 200, 89, 23);
		pTable.add(btnHome);
		
		
		//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		
		Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
		courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
		
		for (int i = 0; i < courseDataBaseMap.size(); i++) {
			 Course course = courseDataBaseMap.get(i);
			 listOfPreReqCoursesList.add(course.getCourseName());
		}
		final String[] myArray = new String[listOfPreReqCoursesList.size()];
		listOfPreReqCoursesList.toArray(myArray);
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	public void cleanFields() {
		textSemester.setText("");
	}

	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);
		GenerateTestScheduleBean generateTestScheduleBean = null;
		
		HashMap<Integer,GenerateTestScheduleBean> generatedTestScheduleDataBaseMap = new LinkedHashMap<Integer,GenerateTestScheduleBean>();
		generatedTestScheduleDataBaseMap = DataManager.getInstance().getGeneratedTestScheduleDataBaseMap();
		
		System.out.println(generatedTestScheduleDataBaseMap.size());
		
		for (int i = 0; i < generatedTestScheduleDataBaseMap.size(); i++) {
			generateTestScheduleBean = generatedTestScheduleDataBaseMap.get(0);
			
			System.out.println(generateTestScheduleBean.getNumberAndPercentageWithoutReqCourses());
			tableModel.addRow(new Object[] { 1 });
			if(generateTestScheduleBean!=null){
			//jTable.setValueAt(generateTestScheduleBean.getNumberOfStudents(), i, 0);
			jTable.setValueAt(272, i, 0);
			jTable.setValueAt(generateTestScheduleBean.getNumberAndPercentageWithReqCourses(), i, 1);
			jTable.setValueAt(generateTestScheduleBean.getNumberAndPercentageWithoutReqCourses(), i, 2);
			}
		}
	}

	public int getSelectedId() {
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			return selectedRow;
		} else {
			System.err.println("No  id exists in selected row");
			return -1;
		}
	}
	
	String regex = "[0-9]+";
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	
	
	
	
	public void generateSchedule() {
		DataUtil dataUtil = new DataUtil();
		dataUtil.test();
		StudentCourse studentCourse = new StudentCourse();
		Semester semester = new Semester();
		GenerateTestScheduleBean generateTestScheduleBean = null;
		
		
		HashMap<Integer,Student> studentDataBaseMap = new HashMap<Integer,Student>();
		studentDataBaseMap = DataManager.getInstance().getStudentDataBaseMap();
		
		if(studentDataBaseMap ==null){
			CSVFileReader.studentCSVReader();
		}
	  studentDataBaseMap  = DataManager.getInstance().getStudentDataBaseMap();
		
		HashMap<Integer,StudentCourse> studentCourseDataBaseMap = new HashMap<Integer,StudentCourse>();
		studentCourseDataBaseMap = DataManager.getInstance().getStudentCourseDataBaseMap();
		
		
		
		if(studentCourseDataBaseMap.size()==0){
			CSVFileReader.studentCourseCSVReader();
		}
		
		
		HashMap<Integer,GenerateTestScheduleBean> generatedTestScheduleDataBaseMap = new LinkedHashMap<Integer,GenerateTestScheduleBean>();
		generatedTestScheduleDataBaseMap = DataManager.getInstance().getGeneratedTestScheduleDataBaseMap();
		
		generatedTestScheduleDataBaseMap.clear();
		
		if (isValidData()) {
			
			HashMap<String,String> objectsMap = new LinkedHashMap<String,String>();
			objectsMap = DataManager.getInstance().getKeycodesObjectsMap();
			
			HashMap<String,String> objectsNotReqMap = new LinkedHashMap<String,String>();
			objectsMap = DataManager.getInstance().getKeycodesObjectsMap();
			
			String key = "";   //id+course
			String value ="";  //sem+course
			
			for (int i = 0; i < studentCourseDataBaseMap.size(); i++) {
				studentCourse = 	studentCourseDataBaseMap.get(i);
				if(studentCourse !=null){
					if (studentCourse.getSemester().equals(textSemester.getText())){
						key= studentCourse.getId()+"#"+studentCourse.getCourseName();
						value = studentCourse.getSemester()+"#"+studentCourse.getCourseName();
						objectsMap.put(key, value);
					}else{
						key= studentCourse.getId()+"#"+studentCourse.getCourseName();
						value = studentCourse.getSemester()+"#"+studentCourse.getCourseName();
						objectsNotReqMap.put(key, value);
					}
					
				}
			
				}//end for
			
			generateTestScheduleBean = new GenerateTestScheduleBean();
			generateTestScheduleBean.setSemester(textSemester.getText());
			generateTestScheduleBean.setNumberOfStudents(DataManager.getInstance().getStudentDataBaseMap().size());
			generateTestScheduleBean.setNumberAndPercentageWithReqCourses(objectsMap.size());
			generateTestScheduleBean.setNumberAndPercentageWithoutReqCourses(objectsNotReqMap.size());
			
			generatedTestScheduleDataBaseMap.put(0, generateTestScheduleBean);
			
			DataManager.getInstance().setGeneratedTestScheduleDataBaseMap(generatedTestScheduleDataBaseMap);
		}
			
		refreshTable();
		cleanFields();
			
			
	}

	
	public boolean isValidData() {
		if(textSemester.getText().equals("")){
			JOptionPane.showMessageDialog(null, "please enter semester");
			return false;
		}
		else
			return true;
	}
	
	
	public void read() {
		if (getSelectedId() >= 0) {
			Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
			courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
			Course course = courseDataBaseMap.get(getSelectedId());
			
			cleanFields();
			textSemester.setText(course.getCourseName());
		}
	}

	
	public static void displayGenerateTestScheduleUI(){
		GenerateTestScheduleUI ui = new GenerateTestScheduleUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	public static void main(String[] args) {
		GenerateTestScheduleUI frmForm = new GenerateTestScheduleUI();
		 center = new Center(frmForm,1000,800);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
