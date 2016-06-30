

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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class GenerateScheduleUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelSectionFill, labelSectionOverage,statusLabel11111;
	private JTextField textSectionFill, textSectionOverage;
	private JButton buttonGetSchedule, bClear;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel lblListOfSemOffered;
	private JLabel label;
	String listOfPreReqCourses [] ={"Admin","Director"}; //new String[1000];  //{"Admin","Director"};
	List<String> listOfPreReqCoursesList = new ArrayList<String>();
	private String textSemestersOffered;
	private String selectListOfPreReqCourses="";
	JRadioButton rdbtnFall,rdbtnAbcd,rdbtnSummer;
	private JList list;
	public GenerateScheduleUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		CSVFileReader.courseCSVReader();
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"SEMESTER", "COURSE NAME", "SECTION NUMBER", "FACULTY"}));
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
		textSectionFill = new JTextField();
		textSectionFill.setBounds(299, 116, 213, 20);
		
		labelSectionFill = new JLabel("SECTION FILL %");
		labelSectionFill.setBounds(82, 119, 152, 14);
		
		labelSectionOverage = new JLabel("SECTION OVERAGE %");
		labelSectionOverage.setBounds(82, 144, 152, 14);
		labelSectionOverage.setHorizontalAlignment(SwingConstants.LEFT);
		textSectionOverage = new JTextField();
		textSectionOverage.setBounds(299, 141, 213, 20);
		pTable.setLayout(null);
		pTable.add(labelSectionFill);
		pTable.add(labelSectionOverage);
		pTable.add(buttonGetSchedule);
		pTable.add(bClear);
		pTable.add(textSectionFill);
		pTable.add(textSectionOverage);
		pTable.add(spTable);
	       
		lblTestdfatrr = new JLabel("GENERATE SCHEDULE");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		pTable.add(lblTestdfatrr);
		
		lblListOfSemOffered = new JLabel("LIST OF SEMESTERS OFFERED");
		lblListOfSemOffered.setBounds(82, 94, 152, 14);
		pTable.add(lblListOfSemOffered);
		
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
		
		
		
		
		//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		
		rdbtnFall = new JRadioButton("fall");
		rdbtnFall.setBounds(300, 90, 54, 23);
		pTable.add(rdbtnFall);
		
		rdbtnAbcd = new JRadioButton("spring");
		rdbtnAbcd.setBounds(374, 90, 64, 23);
		pTable.add(rdbtnAbcd);
		
		rdbtnSummer = new JRadioButton("summer");
		rdbtnSummer.setBounds(450, 90, 109, 23);
		pTable.add(rdbtnSummer);
		
		buttonGroup.add(rdbtnFall);
		buttonGroup.add(rdbtnAbcd);
		buttonGroup.add(rdbtnSummer);
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	public void cleanFields() {
		textSectionFill.setText("");
		textSectionOverage.setText("");
		rdbtnFall.setSelected(false);
		rdbtnAbcd.setSelected(false);
		rdbtnSummer.setSelected(false);
	}

	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);
		GenerateScheduleBean generateScheduleBean = null;
		
		HashMap<Integer,GenerateScheduleBean> generatedScheduleDataBaseMap = new LinkedHashMap<Integer,GenerateScheduleBean>();
		generatedScheduleDataBaseMap = DataManager.getInstance().getGeneratedScheduleDataBaseMap();
		
		for (int i = 0; i < generatedScheduleDataBaseMap.size(); i++) {
			generateScheduleBean = generatedScheduleDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });
			if(generateScheduleBean!=null){
			jTable.setValueAt(generateScheduleBean.getSemester(), i, 0);
			jTable.setValueAt(generateScheduleBean.getCourseName(), i, 1);
			jTable.setValueAt(generateScheduleBean.getCourseNumber(), i, 2);
			jTable.setValueAt(generateScheduleBean.getFacultyName(), i, 3);
			}
		}
	}

	public int getSelectedId() {
		int selectedRow = jTable.getSelectedRow();
		System.out.println("selectedRow: "+selectedRow);
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
		Course course = new Course();
		Semester semester = new Semester();
		GenerateScheduleBean generateScheduleBean = null;
		
		HashMap<Integer,GenerateScheduleBean> generatedScheduleDataBaseMap = new LinkedHashMap<Integer,GenerateScheduleBean>();
		generatedScheduleDataBaseMap = DataManager.getInstance().getGeneratedScheduleDataBaseMap();
		System.out.println("**********************generatedScheduleDataBaseMap: "+generatedScheduleDataBaseMap.size());
		
		HashMap<Integer,Semester> semesterDataBaseMap = new HashMap<Integer,Semester>();
		semesterDataBaseMap = DataManager.getInstance().getSemesterDataBaseMap();
		
		 Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
		 courseDataBaseMap =  DataManager.getInstance().getCourseDataBaseMap();
		
		if (isValidData()) {
			if(rdbtnFall.isSelected())
			textSemestersOffered = AppContstants.SEMESTER_TYPE_FALL;
			if(rdbtnAbcd.isSelected())  
			textSemestersOffered = AppContstants.SEMESTER_TYPE_SPRING;
			if(rdbtnSummer.isSelected()) 
			textSemestersOffered = AppContstants.SEMESTER_TYPE_SUMMER;
			
			
			course.setCourseName(textSectionFill.getText());
			course.setCourseNumber(textSectionOverage.getText());
			
			List<GenerateScheduleBean> generateScheduleBeanFallList= new ArrayList<GenerateScheduleBean>();
			List<GenerateScheduleBean> generateScheduleBeanSpringList = new ArrayList<GenerateScheduleBean>();
			List<GenerateScheduleBean> generateScheduleBeanSummerList = new ArrayList<GenerateScheduleBean>();
			
			
			for (int i = 0; i < courseDataBaseMap.size(); i++) {
				course = 	courseDataBaseMap.get(i);
				if(course ==null){
					continue;
				}
				generateScheduleBean= new GenerateScheduleBean();
				if(course.getOfferedFall().equals(AppContstants.YES)){
					generateScheduleBean.setSemester(AppContstants.SEMESTER_TYPE_FALL);
					generateScheduleBean.setCourseName(course.getCourseName());
					generateScheduleBean.setCourseNumber(course.getCourseNumber());
					generateScheduleBean.setFacultyName(course.getFacultyName());
					
					if(generateScheduleBeanFallList.size()<25){
					generateScheduleBeanFallList.add(generateScheduleBean);
					generatedScheduleDataBaseMap.put(generatedScheduleDataBaseMap.size(), generateScheduleBean);
					}
				}
				
				if(course.getOfferedSpring().equals(AppContstants.YES)){
					generateScheduleBean.setSemester(AppContstants.SEMESTER_TYPE_SPRING);
					generateScheduleBean.setCourseName(course.getCourseName());
					generateScheduleBean.setCourseNumber(course.getCourseNumber());
					generateScheduleBean.setFacultyName(course.getFacultyName());
					
					if(generateScheduleBeanSpringList.size()<25){
						generateScheduleBeanSpringList.add(generateScheduleBean);
						generatedScheduleDataBaseMap.put(generatedScheduleDataBaseMap.size(), generateScheduleBean);
					}
				}
				if(course.getOfferedSummer().equals(AppContstants.YES)){
					generateScheduleBean.setSemester(AppContstants.SEMESTER_TYPE_SUMMER);
					generateScheduleBean.setCourseName(course.getCourseName());
					generateScheduleBean.setCourseNumber(course.getCourseNumber());
					generateScheduleBean.setFacultyName(course.getFacultyName());
					
					if(generateScheduleBeanSummerList.size()<25){
						generateScheduleBeanSummerList.add(generateScheduleBean);
						generatedScheduleDataBaseMap.put(generatedScheduleDataBaseMap.size(), generateScheduleBean);
					}
				}
			}
			
			//int i =0;
			for (GenerateScheduleBean generateScheduleBean2 : generateScheduleBeanFallList) {
				generatedScheduleDataBaseMap.put(generatedScheduleDataBaseMap.size(), generateScheduleBean2);
			}
			for (GenerateScheduleBean generateScheduleBean2 : generateScheduleBeanSpringList) {
				generatedScheduleDataBaseMap.put(generatedScheduleDataBaseMap.size(), generateScheduleBean2);
			}
			for (GenerateScheduleBean generateScheduleBean2 : generateScheduleBeanSummerList) {
				generatedScheduleDataBaseMap.put(generatedScheduleDataBaseMap.size(), generateScheduleBean2);
			}
			
			
			
			//generatedScheduleDataBaseMap.put(courseDataBaseMap.size(), generateScheduleBean);
			System.out.println("************generateScheduleBeanFallList "+generateScheduleBeanFallList.size());
			System.out.println("************generateScheduleBeanSpringList " +generateScheduleBeanSpringList.size());
			System.out.println("************generateScheduleBeanSummerList" +generateScheduleBeanSummerList.size());
			System.out.println("************"+generatedScheduleDataBaseMap.size());
			refreshTable();
			//JOptionPane.showMessageDialog(null, "course Name " + textSectionFill.getText() + " iserted successfully!");
			cleanFields();
		} 
	}

	
	public boolean isValidData() {
		if(!rdbtnFall.isSelected()&& !rdbtnAbcd.isSelected() && !rdbtnSummer.isSelected()){
			JOptionPane.showMessageDialog(null, "Select Semester!");
			return false;
		}
		if(!textSectionFill.getText().matches(regex)){
			JOptionPane.showMessageDialog(null, "Capacity must be number!");
			return false;
		}
		if(!textSectionOverage.getText().matches(regex)){
			JOptionPane.showMessageDialog(null, "Capacity must be number!");
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
			textSectionFill.setText(course.getCourseName());
			textSectionOverage.setText(course.getCourseNumber());
			
			
			if(!course.getListOfSemestersOffered().isEmpty()&& course.getListOfSemestersOffered().equals(AppContstants.SEMESTER_TYPE_FALL))
				rdbtnFall.setSelected(true);
				if(!course.getListOfSemestersOffered().isEmpty()&& course.getListOfSemestersOffered().equals(AppContstants.SEMESTER_TYPE_SPRING))
					rdbtnAbcd.setSelected(true);
					if(!course.getListOfSemestersOffered().isEmpty()&& course.getListOfSemestersOffered().equals(AppContstants.SEMESTER_TYPE_SUMMER))
						rdbtnSummer.setSelected(true);
		}
	}

	
	public static void displayGenerateScheduleUI(){
		GenerateScheduleUI ui = new GenerateScheduleUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	public static void main(String[] args) {
		GenerateScheduleUI frmForm = new GenerateScheduleUI();
		 center = new Center(frmForm,1000,800);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
