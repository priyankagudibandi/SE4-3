

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
		
		
		lblHead  =new JLabel("DIRECTOR HOME");
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
		btnManageDegreeUI.setBounds(261, 67, 153, 52);
		pnl.add(btnManageDegreeUI);
		
		JButton btnManageFaultyUI = new JButton("MANAGE FACULTY UI");
		btnManageFaultyUI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FacultyUI.displayFacultyUI();
				disposeWindow();
				
			}
		});
		btnManageFaultyUI.setBounds(456, 67, 153, 52);
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
		btnStudentReportUI.setBounds(261, 161, 153, 52);
		pnl.add(btnStudentReportUI);
		
		JButton btnManageSchedule = new JButton("STUDENT COURSE");
		btnManageSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentCourseReportUI.displayStudentCourseUI();
				disposeWindow();
			}
		});
		btnManageSchedule.setBounds(461, 161, 148, 52);
		pnl.add(btnManageSchedule);
		
		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DataManager.getInstance().getLoginStatusCheckMap().remove(AppContstants.USER_TYPE_ARDMIN);
				LoginFormUI.displayLoginFormUI();
				disposeWindow();
				
			}
		});
		btnLogout.setBounds(261, 330, 153, 60);
		pnl.add(btnLogout);
		
		JButton btnUpdateForecast = new JButton("UPDATE FORECAST");
		btnUpdateForecast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ForeCastUI.displayForeCastUI();
				disposeWindow();
				
			}
		});
		btnUpdateForecast.setBounds(68, 244, 153, 60);
		pnl.add(btnUpdateForecast);
		
		JButton btnNewButton = new JButton("SCHEDULE ADJUST");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ScheduleAdjustUI.displayScheduleAdjustUI();
				disposeWindow();
				
			}
		});
		btnNewButton.setBounds(261, 244, 153, 60);
		pnl.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("GENERATE SCHEDULE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenerateScheduleUI.displayGenerateScheduleUI();
				disposeWindow();
				
			}
		});
		btnNewButton_1.setBounds(456, 244, 153, 60);
		pnl.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("TEST SCHEDULE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GenerateTestScheduleUI.displayGenerateTestScheduleUI();
				disposeWindow();
				
			}
		});
		btnNewButton_2.setBounds(72, 330, 149, 60);
		pnl.add(btnNewButton_2);
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
}