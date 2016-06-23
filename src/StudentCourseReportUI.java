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

public class StudentCourseReportUI extends JFrame {
	private JPanel pForm, pTable;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel label;
	String listOfPreReqCourses [] ={"Admin","Director"}; //new String[1000];  //{"Admin","Director"};
	List<String> listOfPreReqCoursesList = new ArrayList<String>();
	private JButton btnNewButton;

	public StudentCourseReportUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		CSVFileReader.studentCourseCSVReader();
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"ID", "COURSE CODE", "GRADE", "TERM"}));
		spTable = new JScrollPane();
		spTable.setBounds(0, 120, 879, 196);
		spTable.setViewportView(jTable);  
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		pTable.setLayout(null);
		pTable.add(spTable);
	       
		lblTestdfatrr = new JLabel("STUDENT COURSE REPORT");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 268, 14);
		pTable.add(lblTestdfatrr);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		btnNewButton = new JButton("Home");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setBounds(446, 80, 89, 29);
		pTable.add(btnNewButton);
		
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);
		StudentCourse studentCourse = null;
		
		HashMap<Integer,StudentCourse> studentCourseDataBaseMap = new HashMap<Integer,StudentCourse>();
		studentCourseDataBaseMap = DataManager.getInstance().getStudentCourseDataBaseMap();
		
		for (int i = 0; i < studentCourseDataBaseMap.size(); i++) {
			studentCourse = studentCourseDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });
			if(studentCourse!=null){
			jTable.setValueAt(studentCourse.getId(), i, 0);
			jTable.setValueAt(studentCourse.getCourseNumber(), i, 1);
			jTable.setValueAt(studentCourse.getGrade(), i, 2);
			jTable.setValueAt(studentCourse.getTerm(), i, 3);
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

	
	public static void displayStudentCourseUI(){
		StudentCourseReportUI ui = new StudentCourseReportUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	/*public static void main(String[] args) {
		StudentCourseReportUI frmForm = new StudentCourseReportUI();
		 center = new Center(frmForm,1000,800);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
