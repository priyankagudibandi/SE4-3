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
import com.core.swng.app.model.Course;

public class CourseUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelName, labelCourseNumber, labelDescription, labelNumCreditHrs;
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
	private JTextField textListOfPreReqCourse;
	private JTextField textListOfSemestersOffered;

	public CourseUI() {
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"courseName", "courseCode", "courseDescription", "creditHours", "courseCap","listOfPreReqCourse","listOfSemestersOffered" }));
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
		lblListOfSemOffered.setBounds(82, 225, 152, 14);
		pTable.add(lblListOfSemOffered);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		textCourseCapacity = new JTextField();
		textCourseCapacity.setBounds(299, 172, 213, 20);
		pTable.add(textCourseCapacity);
		
		textListOfPreReqCourse = new JTextField();
		textListOfPreReqCourse.setBounds(299, 197, 213, 20);
		pTable.add(textListOfPreReqCourse);
		
		textListOfSemestersOffered = new JTextField();
		textListOfSemestersOffered.setBounds(299, 222, 213, 20);
		pTable.add(textListOfSemestersOffered);
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
		textListOfPreReqCourse.setText("");
		textListOfSemestersOffered.setText("");
	}

	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);

		Course course = null;
		for (int i = 0; i < DataManager.courseDataBaseMap.size(); i++) {
			 course = DataManager.courseDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });

			if(course!=null){
			/*System.out.println(course.getId());
			System.out.println(course.getName());
			System.out.println(course.getCpf());
			System.out.println(course.getPhone());
			System.out.println(course.getEmail());*/
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
	public void create() {
		Course course = new Course();
		
		if (isValidData()) {
			course.setCourseCap(Integer.valueOf(textCourseCapacity.getText()));
			course.setCourseDescription(textDescription.getText());
			course.setCourseName(textName.getText());
			course.setCourseNumber(textCourseNumber.getText());
			course.setCreditHours(textCreditHours.getText());
			course.setListOfPreReqCourse(textListOfPreReqCourse.getText());
			course.setListOfSemestersOffered(textListOfSemestersOffered.getText());
			
			int i = DataManager.courseDataBaseMap.size();
			DataManager.courseDataBaseMap.put(i, course);
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
		if (textName.getText().isEmpty() || textCourseNumber.getText().isEmpty()
				|| textDescription.getText().isEmpty() || textCreditHours.getText().isEmpty())
			return false;
		else
			return true;
	}
	
	
	public void read() {
		if (getSelectedId() >= 0) {
			System.out.println("read() "+getSelectedId());
			Course course = DataManager.courseDataBaseMap.get(getSelectedId());
			System.out.println("course: "+course);
			
			cleanFields();
			textName.setText(course.getCourseName());
			textCourseNumber.setText(course.getCourseNumber());
			textDescription.setText(course.getCourseDescription());
			textCreditHours.setText(course.getCreditHours());
			textCourseCapacity.setText(String.valueOf(course.getCourseCap()));
			textListOfSemestersOffered.setText(course.getListOfSemestersOffered());
			textListOfPreReqCourse.setText(course.getListOfPreReqCourse());
			
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
			course.setListOfPreReqCourse(textListOfPreReqCourse.getText());
			course.setListOfSemestersOffered(textListOfSemestersOffered.getText());
			
			DataManager.courseDataBaseMap.put(getSelectedId(), course);
			JOptionPane.showMessageDialog(null, "course Name " + textName.getText() + " updated successfully!");
			refreshTable();
		}

	}

	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			DataManager.courseDataBaseMap.remove(getSelectedId());
			tableModel.removeRow(selectedRow);
			refreshTable();
		} else {
			JOptionPane.showMessageDialog(null,	"No row to be deleted");
		}
	}

	
	
	
	
	
	public static void main(String[] args) {
		CourseUI frmForm = new CourseUI();
		 center = new Center(frmForm,850,700);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
