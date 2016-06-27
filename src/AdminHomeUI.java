

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AdminHomeUI extends JFrame {
	
	private static JLabel lblHead;  
	private static JButton cmdManageCourseUI;
	private static Center	center;
	
	public AdminHomeUI() {
		
		
		lblHead  =new JLabel("ADMIN HOME");
	    lblHead.setFont(new Font("TimesRoman",Font.BOLD,14));
	    lblHead.setBounds(79,22,123,20);
		
		cmdManageCourseUI = new JButton("MANAGE COURSE");
		cmdManageCourseUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CourseUI.displayCourseUI();
				disposeWindow();
				
			}
		});
		cmdManageCourseUI.setFont(new Font("Serif", Font.PLAIN, 11));
		cmdManageCourseUI.setMnemonic('o');
		cmdManageCourseUI.setBounds(57,65,164,54);

		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		
		pnl.add(lblHead);
		pnl.add(cmdManageCourseUI);

		getContentPane().add(pnl);
		
		JButton btnManageDegreeUI = new JButton("MANAGE DEGREE");
		btnManageDegreeUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreeUI.displayDegreeUI();
				disposeWindow();
			}
		});
		btnManageDegreeUI.setBounds(250, 67, 170, 52);
		pnl.add(btnManageDegreeUI);
		
		JButton btnManageFaultyUI = new JButton("MANAGE FACULTY");
		btnManageFaultyUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyUI.displayFacultyUI();
				disposeWindow();
				
			}
		});
		btnManageFaultyUI.setBounds(449, 67, 196, 52);
		pnl.add(btnManageFaultyUI);
		
		JButton btnManageRoomsUi = new JButton("MANAGE ROOMS");
		btnManageRoomsUi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomUI.displayRoomUI();
				disposeWindow();
			}
		});
		btnManageRoomsUi.setMnemonic('o');
		btnManageRoomsUi.setFont(new Font("Serif", Font.PLAIN, 12));
		btnManageRoomsUi.setBounds(57, 159, 166, 54);
		pnl.add(btnManageRoomsUi);
		
		JButton btnStudentReportUI = new JButton("STUDENT REPORT");
		btnStudentReportUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentReportUI.displayStudentReportUI();
				disposeWindow();
			}
		});
		btnStudentReportUI.setBounds(250, 161, 170, 52);
		pnl.add(btnStudentReportUI);
		
		JButton btnStudentCourseReport = new JButton("STUDENT COURSE REPORT");
		btnStudentCourseReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentCourseReportUI.displayStudentCourseUI();
				disposeWindow();
			}
		});
		btnStudentCourseReport.setBounds(454, 161, 191, 52);
		pnl.add(btnStudentCourseReport);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataManager.getInstance().getLoginStatusCheckMap().remove(AppContstants.USER_TYPE_ARDMIN);
				LoginFormUI.displayLoginFormUI();
				disposeWindow();
				
			}
		});
		btnLogout.setBounds(57, 245, 170, 52);
		pnl.add(btnLogout);
	}	
		
	
	public static void displayAdminHomeUI(){
		AdminHomeUI frmLogin = new AdminHomeUI();
		center = new Center(frmLogin,1000,800);
        frmLogin.setVisible(true);
        frmLogin.setResizable(false);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	/*public static void main(String args[]) {
		AdminHomeUI frmLogin = new AdminHomeUI();
		center = new Center(frmLogin,1000,800);
        frmLogin.setVisible(true);
        frmLogin.setResizable(false);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
}