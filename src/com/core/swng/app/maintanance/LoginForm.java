package com.core.swng.app.maintanance;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginForm extends JFrame {
	
	private static JLabel lblUser, lblPassword, lblUrl, lblHead, lblLine;  
	private static JTextField txtUser, txtPassword, txtUrl, txtUrl2;
	private static JButton cmdConnect;
	private static Center	center;
	
	public LoginForm() {
		
		lblHead  =new JLabel(" Login ");
	    lblHead.setFont(new Font("TimesRoman",Font.BOLD,14));
	    lblHead.setBounds(120,10,80,20);
	    lblLine =new JLabel(" ======");
	    lblLine.setBounds(120,23,80,20);
	    lblLine.setForeground(Color.red);
			
		lblUser = new JLabel("User :");
		lblUser.setFont(new Font("TimesRoman",Font.BOLD,12));
		lblUser.setBounds(45,45,80,20);
		txtUser = new JTextField();
		txtUser.setFont(new Font("TimesRoman",Font.BOLD,12));
		txtUser.setBounds(120,45,150,20);
		
		lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("TimesRoman",Font.BOLD,12));
		lblPassword.setBounds(45,70,80,20);
		txtPassword = new JTextField();
		txtPassword.setFont(new Font("TimesRoman",Font.BOLD,12));
		txtPassword.setBounds(120,70,150,20);
		
		lblUrl = new JLabel("URL :");
		lblUrl.setFont(new Font("TimesRoman",Font.BOLD,12));
		lblUrl.setBounds(45,95,80,20);
		txtUrl = new JTextField("jdbc:odbc:");
		txtUrl.setFont(new Font("TimesRoman",Font.BOLD,12));
		txtUrl.setBounds(120,95,60,20);
		txtUrl.setEditable(false);
		txtUrl2 = new JTextField();
		txtUrl2.setFont(new Font("TimesRoman",Font.BOLD,12));
		txtUrl2.setBounds(180,95,60,20);
		
		cmdConnect = new JButton("Connect");
		cmdConnect.setFont(new Font("TimesRoman",Font.BOLD,12));
		cmdConnect.setMnemonic('o');
		cmdConnect.setBounds(100,140,100,20);

		JPanel pnl = new JPanel();
		pnl.setLayout(null);
		
		pnl.add(lblHead);
		pnl.add(lblLine);
		pnl.add(lblUser);
		pnl.add(txtUser);
		pnl.add(lblPassword);
		pnl.add(txtPassword);
		pnl.add(lblUrl);
		pnl.add(txtUrl);
		pnl.add(txtUrl2);
		pnl.add(cmdConnect);

		getContentPane().add(pnl);
	}	
		
	
	public static void main(String args[]) {
		LoginForm frmLogin = new LoginForm();
		center = new Center(frmLogin,400,300);
        frmLogin.setVisible(true);
        frmLogin.setResizable(false);
        frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}