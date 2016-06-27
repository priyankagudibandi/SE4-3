

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

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

public class ScheduleAdjustUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelCourseName, labelSectionNumber;
	private JTextField textCourseName, textSectionNumber,textFacultyName;
	private JButton bSave, bDelete, bClear, bUpdate;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel label;
	
	
	public ScheduleAdjustUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createForm();
		CSVFileReader.scheduleAdjustCSVReader();
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"COURSE NAME", "FACULTY NAME", "SECTION NUMBER"}));
		spTable = new JScrollPane();
		spTable.setBounds(0, 354, 879, 196);
		spTable.setViewportView(jTable);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				bSave = new JButton("Save");
				bSave.setBounds(82, 170, 81, 23);
				bSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						create();
					}
				});
		
				bClear = new JButton("Clear");
				bClear.setBounds(299, 170, 79, 23);
				bClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cleanFields();
					}
				});
		
				bUpdate = new JButton("Update");
				bUpdate.setBounds(191, 170, 83, 23);
				bUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						update();
						cleanFields();
					}
				});
		
				bDelete = new JButton("Delete");
				bDelete.setBounds(407, 170, 81, 23);
				bDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						delete();
						cleanFields();
					}
				});
		textCourseName = new JTextField();
		textCourseName.setBounds(299, 72, 310, 20);
		
				labelCourseName = new JLabel("COURSE NAME");
				labelCourseName.setBounds(82, 75, 152, 14);
		
				labelSectionNumber = new JLabel("SECTION NUMBER");
				labelSectionNumber.setBounds(82, 100, 152, 14);
				labelSectionNumber.setHorizontalAlignment(SwingConstants.LEFT);
		textSectionNumber = new JTextField();
		textSectionNumber.setBounds(299, 97, 310, 20);
		pTable.setLayout(null);
		pTable.add(labelCourseName);
		pTable.add(labelSectionNumber);
		pTable.add(bSave);
		pTable.add(bUpdate);
		pTable.add(bClear);
		pTable.add(textCourseName);
		pTable.add(textSectionNumber);
		pTable.add(bDelete);
		pTable.add(spTable);
		
		
	       
		lblTestdfatrr = new JLabel("ADJUST SCHEDULE");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		
		pTable.add(lblTestdfatrr);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
					DirectorHomeUI directorHomeUI = new DirectorHomeUI();
					directorHomeUI.displayAdminHomeUI();
					disposeWindow();
			}
		});
		btnHome.setBounds(508, 170, 89, 23);
		pTable.add(btnHome);
		
		JLabel lblFacultyName = new JLabel("FACULTY");
		lblFacultyName.setHorizontalAlignment(SwingConstants.LEFT);
		lblFacultyName.setBounds(82, 127, 152, 14);
		pTable.add(lblFacultyName);
		
		textFacultyName = new JTextField();
		textFacultyName.setBounds(299, 124, 310, 20);
		pTable.add(textFacultyName);
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	public void cleanFields() {
		textCourseName.setText("");
		textSectionNumber.setText("");
	}

	
	
	
	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);
		HashMap<Integer,ScheduleAdjust> scheduleAdjustDataBaseMap = new HashMap<Integer,ScheduleAdjust>();
		scheduleAdjustDataBaseMap = DataManager.getInstance().getScheduleAdjustDataBaseMap();
		ScheduleAdjust scheduleAdjust = null;
		for (int i = 0; i < scheduleAdjustDataBaseMap.size(); i++) {
			scheduleAdjust = scheduleAdjustDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });

			if(scheduleAdjust!=null){
			jTable.setValueAt(scheduleAdjust.getCourseName(), i, 0);
			jTable.setValueAt(scheduleAdjust.getFactultyName(), i, 1);
			jTable.setValueAt(scheduleAdjust.getSectionNumber(),i,2);
			}
		}
	}

	public int getSelectedId() {
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			return selectedRow;
		} else {
			System.err.println("No  id exists in selected row");
			return -1;
		}
	}

	public void create() {
		ScheduleAdjust scheduleAdjust = new ScheduleAdjust();
		scheduleAdjust.setCourseName(textCourseName.getText());
		scheduleAdjust.setFactultyName(textFacultyName.getText());
		scheduleAdjust.setSectionNumber((textSectionNumber).getText());
		
		if (isValidData()) {
			int i = DataManager.getInstance().getScheduleAdjustDataBaseMap().size();
			DataManager.getInstance().getScheduleAdjustDataBaseMap().put(i, scheduleAdjust);
			refreshTable();
			JOptionPane.showMessageDialog(null, "Fore Cast For Degreee " + textCourseName.getText() + " iserted successfully!");
			cleanFields();
		} 
	}

	public void read() {
		if (getSelectedId() >= 0) {
			ScheduleAdjust scheduleAdjust = DataManager.getInstance().getScheduleAdjustDataBaseMap().get(getSelectedId());
			cleanFields();
			textCourseName.setText(scheduleAdjust.getCourseName());
			textSectionNumber.setText(scheduleAdjust.getSectionNumber());
			textFacultyName.setText(scheduleAdjust.getFactultyName());
		}
	}

	
	public void update() {
		if (getSelectedId() >= 0) {
			ScheduleAdjust forecast = new ScheduleAdjust();
			forecast.setCourseName(textCourseName.getText());
			forecast.setFactultyName(textFacultyName.getText());
			forecast.setSectionNumber(textSectionNumber.getText());
			
			if(isValidData()){
				DataManager.getInstance().getScheduleAdjustDataBaseMap().put(getSelectedId(), forecast);
				JOptionPane.showMessageDialog(null, "Fore Cast For Degreee  " + textCourseName.getText() + " updated successfully!");
				refreshTable();
			}
		}
	}
	
	

	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			DataManager.getInstance().getScheduleAdjustDataBaseMap().remove(getSelectedId());
			tableModel.removeRow(selectedRow);
			refreshTable();
		} else {
			JOptionPane.showMessageDialog(null,	"No row to be deleted");
		}
	}

	
	String regex = "[0-9]+";
	
	public boolean isValidData() {
		if(!textSectionNumber.getText().matches(regex)){
			JOptionPane.showMessageDialog(null, "Expected number of students must be number");
			return false;
		}
		else
			return true;
	}
	
	
	public static void displayScheduleAdjustUI(){
		ScheduleAdjustUI ui = new ScheduleAdjustUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	
	
	
	public static void main(String[] args) {
		ScheduleAdjustUI frmForm = new ScheduleAdjustUI();
		 center = new Center(frmForm,850,700);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
