

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

public class RoomUI extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelBuilding, labelRoomNumber, labelCapacity;
	private JTextField textBuilding, textRoomNumber, textCapacity;
	private JButton bSave, bDelete, bClear, bUpdate;
	private JScrollPane spTable;
	private JTable jTable;
	private static Center center;
	private JLabel lblTestdfatrr;
	private JLabel label;
	private JButton btnHome;

	public RoomUI() {
		setTitle("OKLAHOMA CHRISTIAN UNIVERSITY");
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createForm();
		CSVFileReader.roomCSVReader();
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
		jTable.setModel(new DefaultTableModel(new Object[5][5], new String[] {"BUILDING", "ROOM NUMBER", "ROOM CAPACITY"}));
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
		textBuilding = new JTextField();
		textBuilding.setBounds(299, 72, 213, 20);
		
				labelBuilding = new JLabel("BUILDING");
				labelBuilding.setBounds(82, 75, 152, 14);
		
				labelRoomNumber = new JLabel("ROOM NUMBER");
				labelRoomNumber.setBounds(82, 100, 152, 14);
				labelRoomNumber.setHorizontalAlignment(SwingConstants.LEFT);
		textRoomNumber = new JTextField();
		textRoomNumber.setBounds(299, 97, 213, 20);
		
				labelCapacity = new JLabel("CAPACITY");
				labelCapacity.setBounds(82, 125, 152, 14);
				labelCapacity.setHorizontalAlignment(SwingConstants.LEFT);
		textCapacity = new JTextField();
		textCapacity.setBounds(299, 122, 213, 20);
		pTable.setLayout(null);
		pTable.add(labelBuilding);
		pTable.add(labelRoomNumber);
		pTable.add(labelCapacity);
		pTable.add(bSave);
		pTable.add(bUpdate);
		pTable.add(bClear);
		pTable.add(textCapacity);
		pTable.add(textBuilding);
		pTable.add(textRoomNumber);
		pTable.add(bDelete);
		pTable.add(spTable);
		
		
	       
		lblTestdfatrr = new JLabel("ROOM PLAN");
		lblTestdfatrr.setFont(new Font("TimesRoman",Font.BOLD,16));
		lblTestdfatrr.setBounds(82, 17, 207, 14);
		
		pTable.add(lblTestdfatrr);
		
		label = new JLabel("");
		label.setBounds(166, 200, 46, 14);
		pTable.add(label);
		
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
		btnHome.setBounds(541, 261, 89, 23);
		pTable.add(btnHome);
		jTable.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				read();
			}
		});
	}

	public void cleanFields() {
		textBuilding.setText("");
		textRoomNumber.setText("");
		textCapacity.setText("");
	}

	
	
	public boolean isValidData() {
		if (textBuilding.getText().isEmpty() || textRoomNumber.getText().isEmpty()
				|| textCapacity.getText().isEmpty())
			return false;
		else
			return true;
	}

	
	
	public void refreshTable() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		tableModel.setNumRows(0);

		Room room = null;
		HashMap<Integer,Room> roomsDataBaseMap = new HashMap<Integer,Room>();
		roomsDataBaseMap = DataManager.getInstance().getRoomsDataBaseMap();
		
		for (int i = 0; i < roomsDataBaseMap.size(); i++) {
			 room = roomsDataBaseMap.get(i);
			tableModel.addRow(new Object[] { 1 });

			if(room!=null){
			/*System.out.println(room.getId());
			System.out.println(room.getName());
			System.out.println(room.getCpf());
			System.out.println(room.getPhone());
			System.out.println(room.getEmail());*/
			jTable.setValueAt(room.getBuilding(), i, 0);
			jTable.setValueAt(room.getCapacity(), i, 1);
			jTable.setValueAt(room.getRoomNumber(), i, 2);
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
		//UserBean room = new UserBean(UserDataManager.roomsDataBaseMap.size(),textName.getText(), textCpf.getText(),textPhone.getText());
		Room room = new Room();
		room.setBuilding(textBuilding.getText());
		room.setCapacity(textCapacity.getText());
		room.setRoomNumber(textRoomNumber.getText());
		if (isValidData()) {
			int i = DataManager.getInstance().getRoomsDataBaseMap().size();
			DataManager.getInstance().getRoomsDataBaseMap().put(i, room);
			refreshTable();
			JOptionPane.showMessageDialog(null, "room Name " + textBuilding.getText() + " iserted successfully!");
			cleanFields();
		} else {
			JOptionPane
			.showMessageDialog(null, "Usuário não pode ser inserido. Verifique os campos e tente novamente!");
		}

	}

	public void read() {
		if (getSelectedId() >= 0) {
			Room room = DataManager.getInstance().getRoomsDataBaseMap().get(getSelectedId());
			cleanFields();
			textBuilding.setText(room.getBuilding());
			textRoomNumber.setText(room.getCapacity());
			textCapacity.setText(room.getRoomNumber());
		}
	}

	
	public void update() {
		if (getSelectedId() >= 0) {
			Room room = new Room(); //new UserBean(getSelectedId(), textBuilding.getText(),textRoomNumber.getText(), textCapacity.getText(), textEmail.getText());
			room.setBuilding(textBuilding.getText());
			room.setCapacity(textCapacity.getText());
			room.setRoomNumber(textRoomNumber.getText());
			DataManager.getInstance().getRoomsDataBaseMap().put(getSelectedId(), room);
			JOptionPane.showMessageDialog(null, "room Name " + textBuilding.getText() + " updated successfully!");
			refreshTable();
		}

	}

	public void delete() {
		DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
		int selectedRow = jTable.getSelectedRow();
		if (selectedRow >= 0) {
			DataManager.getInstance().getRoomsDataBaseMap().remove(getSelectedId());
			tableModel.removeRow(selectedRow);
			refreshTable();
		} else {
			JOptionPane.showMessageDialog(null,	"No row to be deleted");
		}
	}

	
	public static void displayRoomUI(){
		RoomUI ui = new RoomUI();
		center = new Center(ui,1000,800);
		ui.setVisible(true);
		ui.setResizable(false);
		ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void disposeWindow(){
		this.dispose();
	}
	
	/*public static void main(String[] args) {
		RoomUI frmForm = new RoomUI();
		 center = new Center(frmForm,1000,800);
        frmForm.setVisible(true);
        frmForm.setResizable(false);
        frmForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }*/
}
