

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DirectorHomeUI extends JFrame {
	
	private static JLabel lblHead;  
	private static JButton cmdManageCourseUI;
	private static Center	center;
	
	public DirectorHomeUI() {
		
		
		lblHead  =new JLabel("ADMIN HOME");
	    lblHead.setFont(new Font("TimesRoman",Font.BOLD,14));
	    lblHead.setBounds(79,22,123,20);
		
		cmdManageCourseUI = new JButton("MANAGE COURSE UI");
		cmdManageCourseUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CourseUI.displayCourseUI();
				disposeWindow();
				
			}
		});
		cmdManageCourseUI.setFont(new Font("Serif", Font.PLAIN, 11));
		cmdManageCourseUI.setMnemonic('o');
		cmdManageCourseUI.setBounds(68,65,153,54);

		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		
		pnl.add(lblHead);
		pnl.add(cmdManageCourseUI);

		getContentPane().add(pnl);
		
		JButton btnManageDegreeUI = new JButton("MANAGE DEGREE UI");
		btnManageDegreeUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DegreeUI.displayDegreeUI();
				disposeWindow();
			}
		});
		btnManageDegreeUI.setBounds(250, 67, 153, 52);
		pnl.add(btnManageDegreeUI);
		
		JButton btnManageFaultyUI = new JButton("MANAGE FACULTY UI");
		btnManageFaultyUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyUI.displayFacultyUI();
				disposeWindow();
				
			}
		});
		btnManageFaultyUI.setBounds(429, 67, 135, 52);
		pnl.add(btnManageFaultyUI);
		
		JButton btnManageRoomsUi = new JButton("MANAGE ROOMS UI");
		btnManageRoomsUi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RoomUI.displayRoomUI();
				disposeWindow();
			}
		});
		btnManageRoomsUi.setMnemonic('o');
		btnManageRoomsUi.setFont(new Font("Serif", Font.PLAIN, 12));
		btnManageRoomsUi.setBounds(68, 159, 155, 54);
		pnl.add(btnManageRoomsUi);
		
		JButton btnStudentReportUI = new JButton("STUDENT REPORT");
		btnStudentReportUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentReportUI.displayStudentReportUI();
				disposeWindow();
			}
		});
		btnStudentReportUI.setBounds(250, 161, 153, 52);
		pnl.add(btnStudentReportUI);
		
		JButton btnManageSchedule = new JButton("STUDENT COURSE");
		btnManageSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentCourseReportUI.displayStudentCourseUI();
				disposeWindow();
			}
		});
		btnManageSchedule.setBounds(434, 161, 130, 52);
		pnl.add(btnManageSchedule);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataManager.getInstance().getLoginStatusCheckMap().remove(AppContstants.USER_TYPE_ARDMIN);
				LoginFormUI.displayLoginFormUI();
				disposeWindow();
				
			}
		});
		btnLogout.setBounds(68, 250, 153, 52);
		pnl.add(btnLogout);
	}	
		
	
	public static void displayAdminHomeUI(){
		DirectorHomeUI frmLogin = new DirectorHomeUI();
		center = new Center(frmLogin,1000,800);
        frmLogin.setVisible(true);
        frmLogin.setResizable(false);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	/*public static void main(String args[]) {
		DirectorHomeUI frmLogin = new DirectorHomeUI();
		center = new Center(frmLogin,1000,800);
        frmLogin.setVisible(true);
        frmLogin.setResizable(false);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
}