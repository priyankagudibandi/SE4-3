

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginFormUI extends JFrame {
	
	private static JLabel lblUserName, lblPassword, lblUserType, lblHead;  
	private static JTextField txtUserName, txtPassword;
	private static JButton cmdConnect;
	private static Center	center;
	private static JComboBox selectComboBox;
	
	public LoginFormUI() {
		
		lblHead  =new JLabel("USER LOGIN");
	    lblHead.setFont(new Font("TimesRoman",Font.BOLD,14));
	    lblHead.setBounds(152,24,123,20);
			
		lblUserName = new JLabel("USER NAME");
		lblUserName.setFont(new Font("TimesRoman",Font.BOLD,12));
		lblUserName.setBounds(152,70,80,20);
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("TimesRoman",Font.BOLD,12));
		txtUserName.setBounds(273,70,191,20);
		
		lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("TimesRoman",Font.BOLD,12));
		lblPassword.setBounds(152,101,80,20);
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("TimesRoman",Font.BOLD,12));
		txtPassword.setBounds(273,101,191,20);
		
		lblUserType = new JLabel("USER TYPE");
		lblUserType.setFont(new Font("TimesRoman",Font.BOLD,12));
		lblUserType.setBounds(152,131,80,20);
		
		cmdConnect = new JButton("LOGIN");
		cmdConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				if(isValidData())
				     login();
			}
		});
		
		cmdConnect.setFont(new Font("TimesRoman",Font.BOLD,12));
		cmdConnect.setMnemonic('o');
		cmdConnect.setBounds(152,195,100,25);

		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		
		pnl.add(lblHead);
		pnl.add(lblUserName);
		pnl.add(txtUserName);
		pnl.add(lblPassword);
		pnl.add(txtPassword);
		pnl.add(lblUserType);
		pnl.add(cmdConnect);

		getContentPane().add(pnl);
		
		String choiceString [] = {"Admin","Director"};	
		//JComboBox selectComboBox = new JComboBox(choiceString);
		
		selectComboBox = new JComboBox(choiceString);
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"Admin,Director"}));
		selectComboBox.setBounds(273, 132, 191, 20);
		pnl.add(selectComboBox);
	}	
		
	
	
	public boolean isValidData() {
		if(txtUserName.getText().equals("")){
			JOptionPane.showMessageDialog(null, "User Name Can not be empty.");
			return false;
		}
		if(txtUserName.getText().length()<4){
			JOptionPane.showMessageDialog(null, "User Name must be atleast 4 char length.");
			return false;
		}
		if(txtPassword.getText().equals("")){
			JOptionPane.showMessageDialog(null, "Password Can not be empty.");
			return false;
		}
		if(txtPassword.getText().length()<4){
			JOptionPane.showMessageDialog(null, "Password must be atleast 4 char length");
			return false;
		}
		
		if(!txtUserName.getText().equals("user")){
			JOptionPane.showMessageDialog(null, "Enter user name as user");
			return false;
		}
		if(!txtPassword.getText().equals("user")){
			JOptionPane.showMessageDialog(null, "Enter password as user");
			return false;
		}
		
		//if(txtUserName.getText().equals("Admin"))
		
		else
			return true;
	}
	
	public void login() {
		
		if(selectComboBox.getSelectedItem().equals(AppContstants.USER_TYPE_ARDMIN)){
			DataManager.getInstance().getLoginStatusCheckMap().put(AppContstants.USER_TYPE_ARDMIN, AppContstants.LOGIN_STATUS_TRUE);
			AdminHomeUI.displayAdminHomeUI();
			this.dispose();
		}
			
		if(selectComboBox.getSelectedItem().equals(AppContstants.USER_TYPE_DIRECTOR)){
			DataManager.getInstance().getLoginStatusCheckMap().put(AppContstants.USER_TYPE_DIRECTOR, AppContstants.LOGIN_STATUS_TRUE);
			DirectorHomeUI directorHomeUI = new DirectorHomeUI();
			directorHomeUI.displayAdminHomeUI();
			this.dispose();
		}
	}
	
	
	
	public static void displayLoginFormUI(){
		LoginFormUI frmLogin = new LoginFormUI();
		center = new Center(frmLogin,1000,800);
        frmLogin.setVisible(true);
        frmLogin.setResizable(false);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void hideLoginFormUI(){
		LoginFormUI frmLogin = new LoginFormUI();
		 frmLogin.setVisible(false);
		 frmLogin.dispose(); //Destroy the JFrame object
		// JFrame.dispatchEvent(new WindowEvent(JFrame, WindowEvent.WINDOW_CLOSING));
		// frame.s
	}
	
	public static void main(String args[]) {
		LoginFormUI frmLogin = new LoginFormUI();
		center = new Center(frmLogin,1000,800);
        frmLogin.setVisible(true);
        frmLogin.setResizable(false);
        //frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}