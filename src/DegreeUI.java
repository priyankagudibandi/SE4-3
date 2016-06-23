

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

public class DegreeUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelName, labelDepartment, labelDegreeCode, labelHoursRequired;
	private JTextField textName, textDepartment, textDegreeCode, textHoursRequired;
	private JButton bSave, bDelete, bClear, bUpdate;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel lbelCourseRequirement;
	private JLabel label;
	private JTextField textCourseRequirement;
	private JButton btnHome;

	public DegreeUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createForm();
		CSVFileReader.DegreeCSVReader();
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"NAME", "DEPARTMENT", "DEGREE CODE","HOURS REQUIRED","COURSE REQUIREMENT"}));
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
		
				labelDepartment = new JLabel("DEPARTMENT");
				labelDepartment.setBounds(82, 100, 152, 14);
				labelDepartment.setHorizontalAlignment(SwingConstants.LEFT);
		textDepartment = new JTextField();
		textDepartment.setBounds(299, 97, 213, 20);
		
				labelDegreeCode = new JLabel("DEGREE CODE");
				labelDegreeCode.setBounds(82, 125, 152, 14);
				labelDegreeCode.setHorizontalAlignment(SwingConstants.LEFT);
		textDegreeCode = new JTextField();
		textDegreeCode.setBounds(299, 122, 213, 20);
		
				labelHoursRequired = new JLabel("HOURS REQUIRED");
				labelHoursRequired.setBounds(82, 150, 152, 14);
		textHoursRequired = new JTextField();
		textHoursRequired.setBounds(299, 147, 213, 20);
		pTable.setLayout(null);
		pTable.add(labelName);
		pTable.add(labelDepartment);
		pTable.add(labelDegreeCode);
		pTable.add(labelHoursRequired);
		pTable.add(bSave);
		pTable.add(bUpdate);
		pTable.add(bClear);
		pTable.add(textHoursRequired);
		pTable.add(textDegreeCode);
		pTable.add(textName);
		pTable.add(textDepartment);
		pTable.add(bDelete);
		pTable.add(spTable);
		
		
	       
		lblTestdfatrr = new JLabel("DEGREE PLAN");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		
		pTable.add(lblTestdfatrr);
		
		lbelCourseRequirement = new JLabel("COURSE REQUIREMENT");
		lbelCourseRequirement.setBounds(82, 175, 152, 14);
		pTable.add(lbelCourseRequirement);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		textCourseRequirement = new JTextField();
		textCourseRequirement.setBounds(299, 172, 213, 20);
		pTable.add(textCourseRequirement);
		
		btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
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
		btnHome.setBounds(539, 261, 89, 23);
		pTable.add(btnHome);
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	public void cleanFields() {
		textName.setText("");
		textDepartment.setText("");
		textDegreeCode.setText("");
		textHoursRequired.setText("");
		textCourseRequirement.setText("");
	}

	
	
	public boolean isValidData() {
		if (textName.getText().isEmpty() || textDepartment.getText().isEmpty()
				|| textDegreeCode.getText().isEmpty() || textHoursRequired.getText().isEmpty())
			return false;
		else
			return true;
	}

	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);

		Degree degree = null;
		HashMap<Integer,Degree> degreeDataBaseMap = new HashMap<Integer,Degree>();
		degreeDataBaseMap = DataManager.getInstance().getDegreeDataBaseMap();
		for (int i = 0; i < degreeDataBaseMap.size(); i++) {
			degree = degreeDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });

			if(degree!=null){
			jTable.setValueAt(degree.getName(), i, 0);
			jTable.setValueAt(degree.getDepartment(), i, 1);
			jTable.setValueAt(degree.getDegreeCode(), i, 2);
			jTable.setValueAt(degree.getCourseRequirement(), i, 3);
			jTable.setValueAt(degree.getHoursRequired(), i, 4);
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
		Degree degree = new Degree(); //(DataManager.degreeDataBaseMap.size(),textName.getText(), textCpf.getText(),textPhone.getText(), textEmail.getText());
		degree.setCourseRequirement(textCourseRequirement.getText());
		degree.setDegreeCode(textDegreeCode.getText());
		degree.setDepartment(textDepartment.getText());
		degree.setHoursRequired(textHoursRequired.getText());
		degree.setName(textName.getText());
		
		
		if (isValidData()) {
			int i = DataManager.getInstance().getDegreeDataBaseMap().size();
			DataManager.getInstance().getDegreeDataBaseMap().put(i, degree);
			refreshTable();
			JOptionPane.showMessageDialog(null, "degree Name " + textName.getText() + " iserted successfully!");
			cleanFields();
		} else {
			JOptionPane
			.showMessageDialog(null, "Usuário não pode ser inserido. Verifique os campos e tente novamente!");
		}

	}

	public void read() {
		if (getSelectedId() >= 0) {
			System.out.println("read() "+getSelectedId());
			Degree degree = DataManager.getInstance().getDegreeDataBaseMap().get(getSelectedId());
			System.out.println("degree: "+degree);
			cleanFields();
			textName.setText(degree.getName());
			textDepartment.setText(degree.getDepartment());
			textDegreeCode.setText(degree.getDegreeCode());
			textHoursRequired.setText(degree.getHoursRequired());
			textCourseRequirement.setText(degree.getCourseRequirement());
			
		}
	}

	
	public void update() {
		if (getSelectedId() >= 0) {
			Degree degree = new Degree();  //(getSelectedId(), textName.getText(),textDepartment.getText(), textDegreeCode.getText(), textHoursRequired.getText());
			degree.setName(textName.getText());
			degree.setDegreeCode(textDegreeCode.getText());
			degree.setDepartment(textDepartment.getText());
			degree.setHoursRequired(textHoursRequired.getText());
			degree.setCourseRequirement(textCourseRequirement.getText());
			
			
			
			
			DataManager.getInstance().getDegreeDataBaseMap().put(getSelectedId(), degree);
			JOptionPane.showMessageDialog(null, "degree Name " + textName.getText() + " updated successfully!");
			refreshTable();
		}

	}

	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			DataManager.getInstance().getDegreeDataBaseMap().remove(getSelectedId());
			tableModel.removeRow(selectedRow);
			refreshTable();
		} else {
			JOptionPane.showMessageDialog(null,	"No row to be deleted");
		}
	}

	
	public static void displayDegreeUI(){
		DegreeUI ui = new DegreeUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	public static void main(String[] args) {
		DegreeUI frmForm = new DegreeUI();
		 center = new Center(frmForm,1000,800);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
