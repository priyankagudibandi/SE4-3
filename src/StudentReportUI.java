import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentReportUI extends JFrame {
	private JPanel pForm, pTable;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel label;
	String listOfPreReqCourses [] ={"Admin","Director"}; //new String[1000];  //{"Admin","Director"};
	List<String> listOfPreReqCoursesList = new ArrayList<String>();

	public StudentReportUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		CSVFileReader.studentCSVReader();
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"ID", "courseCode", "courseDescription"}));
		spTable = new JScrollPane();
		spTable.setBounds(0, 154, 879, 196);
		spTable.setViewportView(jTable);  
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pTable.setLayout(null);
		pTable.add(spTable);
	       
		lblTestdfatrr = new JLabel("STUDENT REPORT");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		pTable.add(lblTestdfatrr);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		btnHome = new JButton("HOME");
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
		btnHome.setBounds(763, 93, 89, 23);
		pTable.add(btnHome);
		
		/*System.out.println(DataManager.getInstance().getCourseDataBaseMap().size());
		Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
		courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
		
		for (int i = 0; i < courseDataBaseMap.size(); i++) {
			 Course course = courseDataBaseMap.get(i);
			 listOfPreReqCoursesList.add(course.getCourseName());
		}
		
		System.out.println(listOfPreReqCoursesList.size());
		
		String[] myArray = new String[listOfPreReqCoursesList.size()];
		
		listOfPreReqCoursesList.toArray(myArray);
		System.out.println(myArray.length);*/
		
		
		
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	
	
	
	
	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);
		Student student = null;
		
		HashMap<Integer,Student> studentDataBaseMap = new HashMap<Integer,Student>();
		studentDataBaseMap = DataManager.getInstance().getStudentDataBaseMap();
		for (int i = 0; i < studentDataBaseMap.size(); i++) {
			student = studentDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });
			if(student!=null){
			jTable.setValueAt(student.getId(), i, 0);
			jTable.setValueAt(student.getTrack(), i, 1);
			jTable.setValueAt(student.getDegree(), i, 2);
			//jTable.setValueAt(student.getCreditHours(), i, 3);
			
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
	private JButton btnHome;

	
	
	
	
	public void read() {
		if (getSelectedId() >= 0) {
			Map<Integer,Course> courseDataBaseMap = new HashMap<Integer,Course>();
			courseDataBaseMap = DataManager.getInstance().getCourseDataBaseMap();
			Course course = courseDataBaseMap.get(getSelectedId());
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

	
	public static void displayStudentReportUI(){
		StudentReportUI ui = new StudentReportUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	/*public static void main(String[] args) {
		StudentReportUI frmForm = new StudentReportUI();
		 center = new Center(frmForm,1000,800);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
