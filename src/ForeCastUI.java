

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

public class ForeCastUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelDegreeCode, labelExpectedNoOfStudents;
	private JTextField textDegreeCode, textExpectedNoOfStudents;
	private JButton bSave, bDelete, bClear, bUpdate;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel label;

	public ForeCastUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createForm();
		CSVFileReader.degreeForcastCSVReader();
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"DEGREE PLAN", "EXPECTED NO OF STUDENTS"}));
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
		textDegreeCode = new JTextField();
		textDegreeCode.setBounds(299, 72, 310, 20);
		
				labelDegreeCode = new JLabel("DEGREE CODE");
				labelDegreeCode.setBounds(82, 75, 152, 14);
		
				labelExpectedNoOfStudents = new JLabel("EXPECTED NO OF STUDENTS");
				labelExpectedNoOfStudents.setBounds(82, 100, 152, 14);
				labelExpectedNoOfStudents.setHorizontalAlignment(SwingConstants.LEFT);
		textExpectedNoOfStudents = new JTextField();
		textExpectedNoOfStudents.setBounds(299, 97, 310, 20);
		pTable.setLayout(null);
		pTable.add(labelDegreeCode);
		pTable.add(labelExpectedNoOfStudents);
		pTable.add(bSave);
		pTable.add(bUpdate);
		pTable.add(bClear);
		pTable.add(textDegreeCode);
		pTable.add(textExpectedNoOfStudents);
		pTable.add(bDelete);
		pTable.add(spTable);
		
		
	       
		lblTestdfatrr = new JLabel("UPDATE FORECAST");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		
		pTable.add(lblTestdfatrr);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnHome.setBounds(508, 170, 89, 23);
		pTable.add(btnHome);
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	public void cleanFields() {
		textDegreeCode.setText("");
		textExpectedNoOfStudents.setText("");
	}

	
	
	
	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);
		HashMap<Integer,ForeCast> foreCastDegreeDataBaseMap = new HashMap<Integer,ForeCast>();
		foreCastDegreeDataBaseMap = DataManager.getInstance().getForeCastDegreeDataBaseMap();
		ForeCast forecast = null;
		for (int i = 0; i < foreCastDegreeDataBaseMap.size(); i++) {
			 forecast = foreCastDegreeDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });

			if(forecast!=null){
			jTable.setValueAt(forecast.getDegreeCode(), i, 0);
			jTable.setValueAt(forecast.getExpectedNumOfStudents(), i, 1);
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
		ForeCast forecast = new ForeCast();
		forecast.setDegreeCode(textDegreeCode.getText());
		forecast.setExpectedNumOfStudents(textExpectedNoOfStudents.getText());
		
		if (isValidData()) {
			int i = DataManager.getInstance().getForeCastDegreeDataBaseMap().size();
			DataManager.getInstance().getForeCastDegreeDataBaseMap().put(i, forecast);
			refreshTable();
			JOptionPane.showMessageDialog(null, "Fore Cast For Degreee " + textDegreeCode.getText() + " iserted successfully!");
			cleanFields();
		} else {
			JOptionPane
			.showMessageDialog(null, "Usuário não pode ser inserido. Verifique os campos e tente novamente!");
		}

	}

	public void read() {
		if (getSelectedId() >= 0) {
			ForeCast forecast = DataManager.getInstance().getForeCastDegreeDataBaseMap().get(getSelectedId());
			cleanFields();
			textDegreeCode.setText(forecast.getDegreeCode());
			textExpectedNoOfStudents.setText(forecast.getExpectedNumOfStudents());
		}
	}

	
	public void update() {
		if (getSelectedId() >= 0) {
			ForeCast forecast = new ForeCast();
			forecast.setDegreeCode(textDegreeCode.getText());
			forecast.setExpectedNumOfStudents(textExpectedNoOfStudents.getText());
			
			if(isValidData()){
				DataManager.getInstance().getForeCastDegreeDataBaseMap().put(getSelectedId(), forecast);
				JOptionPane.showMessageDialog(null, "Fore Cast For Degreee  " + textDegreeCode.getText() + " updated successfully!");
				refreshTable();
			}
			
			
		}

	}
	
	

	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			DataManager.getInstance().getForeCastDegreeDataBaseMap().remove(getSelectedId());
			tableModel.removeRow(selectedRow);
			refreshTable();
		} else {
			JOptionPane.showMessageDialog(null,	"No row to be deleted");
		}
	}

	
	String regex = "[0-9]+";
	public boolean isValidData() {
		if(!textExpectedNoOfStudents.getText().matches(regex)){
			JOptionPane.showMessageDialog(null, "Expected number of students must be number");
			return false;
		}
		else
			return true;
	}
	
	
	public static void displayForeCastUI(){
		ForeCastUI ui = new ForeCastUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	
	
	
	public static void main(String[] args) {
		ForeCastUI frmForm = new ForeCastUI();
		 center = new Center(frmForm,850,700);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
