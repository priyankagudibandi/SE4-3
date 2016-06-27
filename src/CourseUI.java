

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
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

public class CourseUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelName, labelCourseNumber, labelDescription, labelNumCreditHrs,statusLabel11111;
	private JTextField textName, textCourseNumber, textDescription, textCreditHours;
	private JButton bSave, bDelete, bClear, bUpdate;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel lblcourseCapacity;
	private JLabel lblListOfPreQ;
	private JLabel lblListOfSemOffered;
	private JLabel label;
	private JTextField textCourseCapacity;
	String listOfPreReqCourses [] ={"Admin","Director"}; //new String[1000];  //{"Admin","Director"};
	List<String> listOfPreReqCoursesList = new ArrayList<String>();
	private String textSemestersOffered;
	private String selectListOfPreReqCourses="";
	JRadioButton rdbtnFall,rdbtnAbcd,rdbtnSummer;
	private JList list;
	public CourseUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		CSVFileReader.courseCSVReader();
		 //listOfPreReqCourses [] ={"Admin","Director"}; //new String[1000];  //{"Admin","Director"};
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"courseName", "courseCode", "courseDescription", "creditHours", "courseCap","listOfPreReqCourse","listOfSemestersOffered" }));
		spTable = new JScrollPane();
		spTable.setBounds(0, 354, 879, 196);
		spTable.setViewportView(jTable);  
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				bSave = new JButton("Save");
				bSave.setBounds(82, 320, 81, 23);
				bSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						create();
					}
				});
		
				bClear = new JButton("Clear");
				bClear.setBounds(315, 320, 79, 23);
				bClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cleanFields();
					}
				});
		
				bUpdate = new JButton("Update");
				bUpdate.setBounds(200, 320, 83, 23);
				bUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						update();
						cleanFields();
					}
				});
		
				bDelete = new JButton("Delete");
				bDelete.setBounds(431, 320, 81, 23);
				bDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						delete();
						cleanFields();
					}
				});
		textName = new JTextField();
		textName.setBounds(299, 72, 213, 20);
		
				labelName = new JLabel("NAME");
				labelName.setBounds(82, 75, 152, 14);
		
				labelCourseNumber = new JLabel("NUMBER");
				labelCourseNumber.setBounds(82, 100, 152, 14);
				labelCourseNumber.setHorizontalAlignment(SwingConstants.LEFT);
		textCourseNumber = new JTextField();
		textCourseNumber.setBounds(299, 97, 213, 20);
		
				labelDescription = new JLabel("DESCRIPTION");
				labelDescription.setBounds(82, 125, 152, 14);
				labelDescription.setHorizontalAlignment(SwingConstants.LEFT);
		textDescription = new JTextField();
		textDescription.setBounds(299, 122, 213, 20);
		
				labelNumCreditHrs = new JLabel("NO OF CREDIT HOURS");
				labelNumCreditHrs.setBounds(82, 150, 152, 14);
		textCreditHours = new JTextField();
		textCreditHours.setBounds(299, 147, 213, 20);
		pTable.setLayout(null);
		pTable.add(labelName);
		pTable.add(labelCourseNumber);
		pTable.add(labelDescription);
		pTable.add(labelNumCreditHrs);
		pTable.add(bSave);
		pTable.add(bUpdate);
		pTable.add(bClear);
		pTable.add(textCreditHours);
		pTable.add(textDescription);
		pTable.add(textName);
		pTable.add(textCourseNumber);
		pTable.add(bDelete);
		pTable.add(spTable);
	       
		lblTestdfatrr = new JLabel("COURSE INFORMATION");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		pTable.add(lblTestdfatrr);
		
		lblcourseCapacity = new JLabel("CAPACITY");
		lblcourseCapacity.setBounds(82, 175, 152, 14);
		pTable.add(lblcourseCapacity);
		
		lblListOfPreQ = new JLabel("LIST OF PREREQUISITE COURSE");
		lblListOfPreQ.setBounds(82, 200, 152, 14);
		pTable.add(lblListOfPreQ);
		
		lblListOfSemOffered = new JLabel("LIST OF SEMESTERS OFFERED");
		lblListOfSemOffered.setBounds(82, 295, 152, 14);
		pTable.add(lblListOfSemOffered);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		textCourseCapacity = new JTextField();
		textCourseCapacity.setBounds(299, 172, 213, 20);
		pTable.add(textCourseCapacity);
		
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
		btnHome.setBounds(542, 320, 89, 23);
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
		
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(299, 203, 213, 80);
		pTable.add(scrollPane_1);
		
		listComboSelection = new JList();
		listComboSelection.setVisibleRowCount(4);
		scrollPane_1.setViewportView(listComboSelection);
		
		
		listComboSelection.setModel(new AbstractListModel() {
			
			
			
			
			
			
			
			
		//String[] values = new String[] {"item1,", "item2, ", "item3, ", "item4, ", "item5, ", "item6"};
		//	String[] myArray = new String[listOfPreReqCoursesList.size()];
			//listOfPreReqCoursesList.toArray(myArray);
			
			
			public int getSize() {
				return myArray.length;
			}
			public Object getElementAt(int index) {
				return myArray[index];
			}
		});
		
		
		
		
		//&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
		
		rdbtnFall = new JRadioButton("fall");
		rdbtnFall.setBounds(299, 290, 54, 23);
		pTable.add(rdbtnFall);
		
		rdbtnAbcd = new JRadioButton("spring");
		rdbtnAbcd.setBounds(377, 290, 64, 23);
		pTable.add(rdbtnAbcd);
		
		rdbtnSummer = new JRadioButton("summer");
		rdbtnSummer.setBounds(441, 290, 109, 23);
		pTable.add(rdbtnSummer);
		
		/*ButtonGroup bg=new ButtonGroup();  
		bg.add(rdbtnFall);
		bg.add(rdbtnAbcd);  
		bg.add(rdbtnSummer);  */
		
		
		
		
	
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	
	
	
	public void cleanFields() {
		textName.setText("");
		textCourseNumber.setText("");
		textDescription.setText("");
		textCreditHours.setText("");
		textCourseCapacity.setText("");
		rdbtnFall.setSelected(false);
		rdbtnAbcd.setSelected(false);
		rdbtnSummer.setSelected(false);
		//selectListOfPreReqCoursesComboBox.getSelectedItem().setText("");
	//	textListOfSemestersOffered.setText("");
	}

	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);

		Course course = null;
		Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
		courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
		
		for (int i = 0; i < courseDataBaseMap.size(); i++) {
			 course = courseDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });
			if(course!=null){
			jTable.setValueAt(course.getCourseName(), i, 0);
			jTable.setValueAt(course.getCourseNumber(), i, 1);
			jTable.setValueAt(course.getCourseDescription(), i, 2);
			jTable.setValueAt(course.getCreditHours(), i, 3);
			jTable.setValueAt(course.getCourseCap(), i, 4);
			jTable.setValueAt(course.getListOfPreReqCourse(), i, 5);
			jTable.setValueAt(course.getListOfSemestersOffered(), i, 6);
			}
		}
		
		
	}

	public int getSelectedId() {
		int selectedRow = jTable.getSelectedRow();
		System.out.println("selectedRow: "+selectedRow);
		if (selectedRow >= 0) {
			//System.out.println("jTable.getValueAt(selectedRow, 0);  "+jTable.getValueAt(selectedRow, 0));
			//int slectedRowId = (Integer) jTable.getValueAt(selectedRow, 0);
			return selectedRow;
		} else {
			System.err.println("No  id exists in selected row");
			return -1;
		}
	}
	
	String regex = "[0-9]+";
	private JScrollPane scrollPane;
	private JList listComboSelection;
	private JScrollPane scrollPane_1;
	
	public void create() {
		Course course = new Course();
		Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
		courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
		
		StringBuffer radiosbtnsselectd = new StringBuffer("123");
		if (isValidData()) {
			if(rdbtnFall.isSelected())
				radiosbtnsselectd.append(AppContstants.SEMESTER_TYPE_FALL+",");
			if(rdbtnAbcd.isSelected())  
				radiosbtnsselectd.append(AppContstants.SEMESTER_TYPE_SPRING+",");
			if(rdbtnSummer.isSelected()) 
				radiosbtnsselectd.append(AppContstants.SEMESTER_TYPE_WINTER+",");
			textSemestersOffered = radiosbtnsselectd.substring(0,radiosbtnsselectd.length()-1);
			
			
			course.setCourseCap(Integer.valueOf(textCourseCapacity.getText()));
			course.setCourseDescription(textDescription.getText());
			course.setCourseName(textName.getText());
			course.setCourseNumber(textCourseNumber.getText());
			course.setCreditHours(textCreditHours.getText());
			
			Object obj[] = listComboSelection.getSelectedValues();
			StringBuffer sbf = new StringBuffer("");
			for (int i = 0; i < obj.length; i++) {
				sbf.append((String) obj[i]);
				sbf.append(",");
			}
			if(sbf.length()>2)
			selectListOfPreReqCourses = sbf.substring(0,sbf.length()-1).toString();
			course.setListOfPreReqCourse(selectListOfPreReqCourses);
			course.setListOfSemestersOffered(textSemestersOffered);
			
			int i = courseDataBaseMap.size();
			courseDataBaseMap.put(i, course);
			DataManager.getInstance().setCourseDataBaseMap(courseDataBaseMap);
			
			refreshTable();
			JOptionPane.showMessageDialog(null, "course Name " + textName.getText() + " iserted successfully!");
			cleanFields();
		} 

	}

	
	public boolean isValidData() {
		if(!textCourseCapacity.getText().matches(regex)){
			JOptionPane.showMessageDialog(null, "Capacity must be number!");
			return false;
		}
		if(textName.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "please enter name");
			return false;
		}
		if(textCourseNumber.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "please enter course number");
			return false;
		}
		if (textDescription.getText().isEmpty() || textCreditHours.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "please enter description and credit hours");
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
			textName.setText(course.getCourseName());
			textCourseNumber.setText(course.getCourseNumber());
			textDescription.setText(course.getCourseDescription());
			textCreditHours.setText(course.getCreditHours());
			textCourseCapacity.setText(String.valueOf(course.getCourseCap()));
			
			
			if(!course.getListOfSemestersOffered().isEmpty()&& course.getListOfSemestersOffered().equals(AppContstants.SEMESTER_TYPE_FALL))
				rdbtnFall.setSelected(true);
				if(!course.getListOfSemestersOffered().isEmpty()&& course.getListOfSemestersOffered().equals(AppContstants.SEMESTER_TYPE_SPRING))
					rdbtnAbcd.setSelected(true);
					if(!course.getListOfSemestersOffered().isEmpty()&& course.getListOfSemestersOffered().equals(AppContstants.SEMESTER_TYPE_WINTER))
						rdbtnSummer.setSelected(true);
			//textListOfSemestersOffered.setText(course.getListOfSemestersOffered());
			//selectListOfPreReqCoursesComboBox.setText(course.getListOfPreReqCourse());
		}
	}

	
	public void update() {
		if (getSelectedId() >= 0) {
			Course course = new Course();
			//Course course = new Course(getSelectedId(), textName.getText(),textCourseNumber.getText(), textDescription.getText(), textCreditHours.getText());
			course.setCourseCap(Integer.valueOf(textCourseCapacity.getText()));
			course.setCourseDescription(textDescription.getText());
			course.setCourseName(textName.getText());
			course.setCourseNumber(textCourseNumber.getText());
			course.setCreditHours(textCreditHours.getText());
			
			Object obj[] = listComboSelection.getSelectedValues();
			StringBuffer sbf = new StringBuffer("");
			for (int i = 0; i < obj.length; i++) {
				sbf.append((String) obj[i]);
				sbf.append(",");
			}
			if(sbf.length()>2)
			selectListOfPreReqCourses = sbf.substring(0,sbf.length()-1).toString();
			course.setListOfPreReqCourse(selectListOfPreReqCourses);
			
			//course.setListOfPreReqCourse((String)selectListOfPreReqCoursesComboBox.getSelectedItem());
			
			if(rdbtnFall.isSelected()) 
			textSemestersOffered = AppContstants.SEMESTER_TYPE_FALL;
			if(rdbtnAbcd.isSelected())
			textSemestersOffered = AppContstants.SEMESTER_TYPE_SPRING;
			if(rdbtnSummer.isSelected())
			textSemestersOffered = AppContstants.SEMESTER_TYPE_WINTER;
			course.setListOfSemestersOffered(textSemestersOffered);
			
			
			Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
			courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
			
			courseDataBaseMap.put(getSelectedId(), course);
			DataManager.getInstance().setCourseDataBaseMap(courseDataBaseMap);
			
			JOptionPane.showMessageDialog(null, "course Name " + textName.getText() + " updated successfully!");
			refreshTable();
		}

	}

	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			
			Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
			courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
			
			courseDataBaseMap.remove(getSelectedId());
			DataManager.getInstance().setCourseDataBaseMap(courseDataBaseMap);
			
			tableModel.removeRow(selectedRow);
			refreshTable();
		} else {
			JOptionPane.showMessageDialog(null,	"No row to be deleted");
		}
	}

	
	public static void displayCourseUI(){
		CourseUI ui = new CourseUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	public static void main(String[] args) {
		CourseUI frmForm = new CourseUI();
		 center = new Center(frmForm,1000,800);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
