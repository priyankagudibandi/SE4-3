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
import com.core.swng.app.model.Faculty;

public class FacultyUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelName, labelTitle, labelMaxGrad, labelCourses;
	private JTextField textName, textTitle, textMaxGrad, textCourses;
	private JButton bSave, bDelete, bClear, bUpdate;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel labeDay;
	private JLabel label;
	private JTextField textDay;

	public FacultyUI() {
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"Nome", "TITLE", "MAXIMUM GRADUATE TEACHING LOAD BY SEM", "COURSES THAT FACULTY NUMBER IS ABLE TO TEACH","DAY THE CAN PREFER TO TEACH" }));
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
		textName.setBounds(348, 72, 201, 20);
		
				labelName = new JLabel("NAME");
				labelName.setBounds(82, 75, 152, 14);
		
				labelTitle = new JLabel("TITLE");
				labelTitle.setBounds(82, 100, 152, 14);
				labelTitle.setHorizontalAlignment(SwingConstants.LEFT);
		textTitle = new JTextField();
		textTitle.setBounds(348, 97, 201, 20);
		
				labelMaxGrad = new JLabel("MAXIMUM GRADUATE TEACHING LOAD BY SEM");
				labelMaxGrad.setBounds(82, 125, 240, 14);
				labelMaxGrad.setHorizontalAlignment(SwingConstants.LEFT);
		textMaxGrad = new JTextField();
		textMaxGrad.setBounds(348, 122, 201, 20);
		
				labelCourses = new JLabel("COURSES THAT FACULTY NUMBER IS ABLE TO TEACH");
				labelCourses.setBounds(82, 150, 240, 14);
		textCourses = new JTextField();
		textCourses.setBounds(348, 147, 201, 20);
		pTable.setLayout(null);
		pTable.add(labelName);
		pTable.add(labelTitle);
		pTable.add(labelMaxGrad);
		pTable.add(labelCourses);
		pTable.add(bSave);
		pTable.add(bUpdate);
		pTable.add(bClear);
		pTable.add(textCourses);
		pTable.add(textMaxGrad);
		pTable.add(textName);
		pTable.add(textTitle);
		pTable.add(bDelete);
		pTable.add(spTable);
		
		
	       
		lblTestdfatrr = new JLabel("FACULTY INFORMATION");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		
		pTable.add(lblTestdfatrr);
		
		labeDay = new JLabel("DAY THE CAN PREFER TO TEACH");
		labeDay.setBounds(82, 175, 240, 14);
		pTable.add(labeDay);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		textDay = new JTextField();
		textDay.setBounds(348, 172, 201, 20);
		pTable.add(textDay);
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	public void cleanFields() {
		textName.setText("");
		textTitle.setText("");
		textMaxGrad.setText("");
		textCourses.setText("");
		textDay.setText("");
	}

	
	
	public boolean isValidData() {
		if (textName.getText().isEmpty() || textTitle.getText().isEmpty()
				|| textMaxGrad.getText().isEmpty() || textCourses.getText().isEmpty())
			return false;
		else
			return true;
	}

	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);

		Faculty faculty = null;
		for (int i = 0; i < DataManager.facultyDataBaseMap.size(); i++) {
			 faculty = DataManager.facultyDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });

			if(faculty!=null){
			/*System.out.println(faculty.getId());
			System.out.println(faculty.getName());
			System.out.println(faculty.getCpf());
			System.out.println(faculty.getPhone());
			System.out.println(faculty.getEmail());*/
			jTable.setValueAt(faculty.getName(), i, 0);
			jTable.setValueAt(faculty.getTitle(), i, 1);
			jTable.setValueAt(faculty.getMaxGradTeachingLoad(), i, 2);
			jTable.setValueAt(faculty.getCoursesFacultyNumber(), i, 3);
			jTable.setValueAt(faculty.getDaysToTeach(), i, 4);
			}
		}
	}

	public int getSelectedId() {
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			//int slectedRowId = (Integer) jTable.getValueAt(selectedRow, 0);
			return selectedRow;
		} else {
			System.err.println("No  id exists in selected row");
			return -1;
		}
	}

	public void create() {
		Faculty faculty = new Faculty();  //(DataManager.facultyDataBaseMap.size(),textName.getText(), textTitle.getText(),textMaxGrad.getText(), textCourses.getText());
		faculty.setName(textName.getText());
		faculty.setTitle(textTitle.getText());
		faculty.setMaxGradTeachingLoad(textMaxGrad.getText());
		faculty.setCoursesFacultyNumber(textCourses.getText());
		faculty.setDaysToTeach(textDay.getText());
		
		
		if (isValidData()) {
			int i = DataManager.facultyDataBaseMap.size();
			DataManager.facultyDataBaseMap.put(i, faculty);
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
			Faculty faculty = DataManager.facultyDataBaseMap.get(getSelectedId());
			cleanFields();
			textName.setText(faculty.getName());
			textTitle.setText(faculty.getTitle());
			textMaxGrad.setText(faculty.getMaxGradTeachingLoad());
			textCourses.setText(faculty.getCoursesFacultyNumber());
			textDay.setText(faculty.getDaysToTeach());
		}
	}

	
	public void update() {
		if (getSelectedId() >= 0) {
			Faculty faculty = new Faculty(); //(getSelectedId(), textName.getText(),textTitle.getText(), textMaxGrad.getText(), textCourses.getText());
			faculty.setName(textName.getText());
			faculty.setTitle(textTitle.getText());
			faculty.setMaxGradTeachingLoad(textMaxGrad.getText());
			faculty.setCoursesFacultyNumber(textCourses.getText());
			faculty.setDaysToTeach(textDay.getText());
			
			DataManager.facultyDataBaseMap.put(getSelectedId(), faculty);
			JOptionPane.showMessageDialog(null, "User Name " + textName.getText() + " updated successfully!");
			refreshTable();
		}

	}

	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			DataManager.facultyDataBaseMap.remove(getSelectedId());
			tableModel.removeRow(selectedRow);
			refreshTable();
		} else {
			JOptionPane.showMessageDialog(null,	"No row to be deleted");
		}
	}

	
	
	
	
	
	public static void main(String[] args) {
		FacultyUI frmForm = new FacultyUI();
		 center = new Center(frmForm,850,700);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
