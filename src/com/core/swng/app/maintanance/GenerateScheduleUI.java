package com.core.swng.app.maintanance;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.core.swng.app.data.DataManager;
import com.core.swng.app.model.UserBean;

public class GenerateScheduleUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelName, labelCpf, labelPhone, labelEmail;
	private JTextField textName, textCpf, textPhone, textEmail;
	private JButton bSave, bDelete, bClear, bUpdate;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel label;
	private JTextField textCapacity;
	private JTextField txtListOfPreReqCourse;
	private JTextField txtListOfSemestersOffered;

	public GenerateScheduleUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createForm();
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"Id", "Nome", "CPF", "Telefone", "Email" }));
		spTable = new JScrollPane();
		spTable.setBounds(0, 354, 879, 196);
		spTable.setViewportView(jTable);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				bSave = new JButton("Save");
				bSave.setBounds(82, 261, 81, 23);
				bSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						create();
					}
				});
		
				bClear = new JButton("Clear");
				bClear.setBounds(319, 261, 79, 23);
				bClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cleanFields();
					}
				});
		
				bUpdate = new JButton("Update");
				bUpdate.setBounds(206, 261, 83, 23);
				bUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						update();
						cleanFields();
					}
				});
		
				bDelete = new JButton("Delete");
				bDelete.setBounds(431, 261, 81, 23);
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
		
				labelCpf = new JLabel("NUMBER");
				labelCpf.setBounds(82, 100, 152, 14);
				labelCpf.setHorizontalAlignment(SwingConstants.LEFT);
		textCpf = new JTextField();
		textCpf.setBounds(299, 97, 213, 20);
		
				labelPhone = new JLabel("DESCRIPTION");
				labelPhone.setBounds(82, 125, 152, 14);
				labelPhone.setHorizontalAlignment(SwingConstants.LEFT);
		textPhone = new JTextField();
		textPhone.setBounds(299, 122, 213, 20);
		
				labelEmail = new JLabel("NO OF CREDIT HOURS");
				labelEmail.setBounds(82, 150, 152, 14);
		textEmail = new JTextField();
		textEmail.setBounds(299, 147, 213, 20);
		pTable.setLayout(null);
		pTable.add(labelName);
		pTable.add(labelCpf);
		pTable.add(labelPhone);
		pTable.add(labelEmail);
		pTable.add(bSave);
		pTable.add(bUpdate);
		pTable.add(bClear);
		pTable.add(textEmail);
		pTable.add(textPhone);
		pTable.add(textName);
		pTable.add(textCpf);
		pTable.add(bDelete);
		pTable.add(spTable);
		
		
	       
		lblTestdfatrr = new JLabel("COURSE INFORMATION");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		
		pTable.add(lblTestdfatrr);
		
		lblNewLabel = new JLabel("CAPACITY");
		lblNewLabel.setBounds(82, 175, 152, 14);
		pTable.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("LIST OF PREREQUISITE COURSE");
		lblNewLabel_1.setBounds(82, 200, 152, 14);
		pTable.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("LIST OF SEMESTERS OFFERED");
		lblNewLabel_2.setBounds(82, 225, 152, 14);
		pTable.add(lblNewLabel_2);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		textCapacity = new JTextField();
		textCapacity.setBounds(299, 172, 213, 20);
		pTable.add(textCapacity);
		
		txtListOfPreReqCourse = new JTextField();
		txtListOfPreReqCourse.setBounds(299, 197, 213, 20);
		pTable.add(txtListOfPreReqCourse);
		
		txtListOfSemestersOffered = new JTextField();
		txtListOfSemestersOffered.setBounds(299, 222, 213, 20);
		pTable.add(txtListOfSemestersOffered);
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	public void cleanFields() {
		textName.setText("");
		textCpf.setText("");
		textPhone.setText("");
		textEmail.setText("");
	}

	
	
	public boolean isValidData() {
		if (textName.getText().isEmpty() || textCpf.getText().isEmpty()
				|| textPhone.getText().isEmpty() || textEmail.getText().isEmpty())
			return false;
		else
			return true;
	}

	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);

		UserBean user = null;
		for (int i = 0; i < DataManager.usersDataBaseIndexMap.size(); i++) {
			 user = DataManager.usersDataBaseIndexMap.get(i);
			tableModel.addRow(new Object[] { 1 });

			if(user!=null){
			/*System.out.println(user.getId());
			System.out.println(user.getName());
			System.out.println(user.getCpf());
			System.out.println(user.getPhone());
			System.out.println(user.getEmail());*/
			jTable.setValueAt(user.getId(), i, 0);
			jTable.setValueAt(user.getName(), i, 1);
			jTable.setValueAt(user.getCpf(), i, 2);
			jTable.setValueAt(user.getPhone(), i, 3);
			jTable.setValueAt(user.getEmail(), i, 4);
			}
		}
	}

	public int getSelectedId() {
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			int slectedRowId = (Integer) jTable.getValueAt(selectedRow, 0);
			return slectedRowId;
		} else {
			System.err.println("No  id exists in selected row");
			return -1;
		}
	}

	public void create() {
		UserBean user = new UserBean(DataManager.usersDataBaseIndexMap.size(),textName.getText(), textCpf.getText(),textPhone.getText(), textEmail.getText());

		if (isValidData()) {
			int i = DataManager.usersDataBaseIndexMap.size();
			DataManager.usersDataBaseIndexMap.put(i, user);
			refreshTable();
			JOptionPane.showMessageDialog(null, "User Name " + textName.getText() + " iserted successfully!");
			cleanFields();
		} else {
			JOptionPane
			.showMessageDialog(null, "Usuário não pode ser inserido. Verifique os campos e tente novamente!");
		}

	}

	public void read() {
		if (getSelectedId() >= 0) {
			UserBean user = DataManager.usersDataBaseIndexMap.get(getSelectedId());
			cleanFields();
			textName.setText(user.getName());
			textCpf.setText(user.getCpf());
			textPhone.setText(user.getPhone());
			textEmail.setText(user.getEmail());
		}
	}

	
	public void update() {
		if (getSelectedId() >= 0) {
			UserBean user = new UserBean(getSelectedId(), textName.getText(),textCpf.getText(), textPhone.getText(), textEmail.getText());
			DataManager.usersDataBaseIndexMap.put(getSelectedId(), user);
			JOptionPane.showMessageDialog(null, "User Name " + textName.getText() + " updated successfully!");
			refreshTable();
		}

	}

	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			DataManager.usersDataBaseIndexMap.remove(getSelectedId());
			tableModel.removeRow(selectedRow);
			refreshTable();
		} else {
			JOptionPane.showMessageDialog(null,	"No row to be deleted");
		}
	}

	
	
	
	
	
	public static void main(String[] args) {
		GenerateScheduleUI frmForm = new GenerateScheduleUI();
		 center = new Center(frmForm,850,700);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
