package com.core.swng.app.maintanance;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

import com.core.swng.app.data.DataManager;
import com.core.swng.app.model.UserBean;

public class GUI1 extends JFrame {
	private JPanel pForm, pTable;
	private JLabel labelName, labelCpf, labelPhone, labelEmail;
	private JTextField textName, textCpf, textPhone, textEmail;
	private JButton bSave, bDelete, bClear, bUpdate;
	private JScrollPane spTable;
	private JTable jTable;

	public GUI1() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		createForm();
		pack();
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
		spTable.setViewportView(jTable);
		jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				
				bSave = new JButton("Save");
				bSave.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						create();
					}
				});
		
				bClear = new JButton("Clear");
				bClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						cleanFields();
					}
				});
		
				bUpdate = new JButton("Update");
				bUpdate.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						update();
						cleanFields();
					}
				});
		
				bDelete = new JButton("Delete");
				bDelete.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						delete();
						cleanFields();
					}
				});
		textName = new JTextField();
		
				labelName = new JLabel("Name: ");
				labelName.setHorizontalAlignment(SwingConstants.RIGHT);
		
				labelCpf = new JLabel("CPF: ");
				labelCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		textCpf = new JTextField();
		
				labelPhone = new JLabel("Phone: ");
				labelPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		textPhone = new JTextField();
		
				labelEmail = new JLabel("Email ");
				labelEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		textEmail = new JTextField();
		GroupLayout gl_pTable = new GroupLayout(pTable);
		gl_pTable.setHorizontalGroup(
			gl_pTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pTable.createSequentialGroup()
					.addGap(50)
					.addGroup(gl_pTable.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pTable.createSequentialGroup()
							.addGroup(gl_pTable.createParallelGroup(Alignment.LEADING)
								.addComponent(labelName)
								.addComponent(labelCpf)
								.addComponent(labelPhone)
								.addComponent(labelEmail))
							.addGap(35))
						.addGroup(Alignment.LEADING, gl_pTable.createSequentialGroup()
							.addComponent(bSave, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
							.addGap(35)))
					.addGroup(gl_pTable.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pTable.createSequentialGroup()
							.addGap(9)
							.addComponent(bUpdate, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(bClear, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE))
						.addComponent(textEmail)
						.addComponent(textPhone)
						.addComponent(textName)
						.addComponent(textCpf, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))
					.addGap(46)
					.addComponent(bDelete, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(362, Short.MAX_VALUE))
				.addComponent(spTable, GroupLayout.DEFAULT_SIZE, 879, Short.MAX_VALUE)
		);
		gl_pTable.setVerticalGroup(
			gl_pTable.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pTable.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pTable.createParallelGroup(Alignment.BASELINE)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(labelName))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pTable.createParallelGroup(Alignment.LEADING)
						.addComponent(labelCpf)
						.addComponent(textCpf, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pTable.createParallelGroup(Alignment.LEADING)
						.addComponent(labelPhone)
						.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pTable.createParallelGroup(Alignment.LEADING)
						.addComponent(labelEmail)
						.addComponent(textEmail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(32)
					.addGroup(gl_pTable.createParallelGroup(Alignment.BASELINE)
						.addComponent(bSave)
						.addComponent(bDelete)
						.addComponent(bUpdate)
						.addComponent(bClear))
					.addGap(85)
					.addComponent(spTable, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pTable.setLayout(gl_pTable);
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

}
