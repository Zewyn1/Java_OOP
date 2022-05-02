import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class MyFrame extends JFrame {
	Connection conn = null;
	PreparedStatement state = null;
	ResultSet result = null;
	int id = -1;
	JPanel upPanel = new JPanel();
	JPanel midPanel = new JPanel();
	JPanel downPanel = new JPanel();
	JLabel fnameL = new JLabel("Name");
	JLabel lnameL = new JLabel("LastName");
	JLabel sexL = new JLabel("Sex");
	JLabel ageL = new JLabel("Age");
	JLabel salaryL = new JLabel("Salary");
	JTextField fnameT = new JTextField();
	JTextField lnameT = new JTextField();
	JTextField ageT = new JTextField();
	JTextField salaryT = new JTextField();
	String[] item = {"Male", "Female"};
	JComboBox<String> sexCombo = new JComboBox<String>(item);
	JComboBox<String> personCombo=new JComboBox<String>();
	JButton addB = new JButton("Add");
	JButton delB = new JButton("Delete");
	JButton ediB = new JButton("Ëdit");
	JButton serB= new JButton("Search");
	JButton refB = new JButton("Refresh");
	JTable table = new JTable();
	JScrollPane scroll = new JScrollPane(table);
	JButton newB = new JButton("New");
	public MyFrame() {
		this.setSize(400, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new GridLayout(3, 1));
		//UpPanel
		upPanel.setLayout(new GridLayout(5, 2));
		upPanel.add(fnameL);
		upPanel.add(fnameT);
		upPanel.add(lnameL);
		upPanel.add(lnameT);
		upPanel.add(sexL);
		upPanel.add(sexCombo);
		upPanel.add(ageL);
		upPanel.add(ageT);
		upPanel.add(salaryL);
		upPanel.add(salaryT);
		this.add(upPanel);
		//MidPanel
		midPanel.add(addB);
		midPanel.add(delB);
		midPanel.add(ediB);
		midPanel.add(serB);
		midPanel.add(refB);
		midPanel.add(personCombo);
		this.add(midPanel);
		//DownPanel
		scroll.setPreferredSize(new Dimension(350, 150));
		downPanel.add(scroll);
		addB.addActionListener(new AddAction());
		table.addMouseListener(new MouseAction());
		refreshTable();
		refreshComboPerson();
		this.setVisible(true);
		this.add(downPanel);
		delB.addActionListener(new DeleteAction());
		ediB.addActionListener(new EditAction());
		serB.addActionListener(new SearchAction());
		refB.addActionListener(new RefreshAction());
		downPanel.add(newB);
		newB.addActionListener(new NewAction());
	}

	public void refreshTable() {
		conn = DBConnection.getConnection();
		try {
			state = conn.prepareStatement("select * from person");
			result = state.executeQuery();
			table.setModel(new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void refreshComboPerson(){
		String sql="select id, fname, lname from person";
		conn=DBConnection.getConnection();
		String item="";
		try {
			state=conn.prepareStatement(sql);
			result=state.executeQuery();
			personCombo.removeAllItems();
			while(result.next()){
				item=result.getObject(1).toString()+"."+result.getObject(2).toString()+" "+result.getObject(3).toString();
				personCombo.addItem(item);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void clearForm() {
		fnameT.setText("");
		lnameT.setText("");
		sexCombo.setSelectedIndex(0);
		ageT.setText("");
		salaryT.setText("");
	}
	class AddAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			String sql = "Insert into person(fname,lname,sex,age,salary)" + "values(?,?,?,?,?)";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, fnameT.getText());
				state.setString(2, lnameT.getText());
				state.setString(3, sexCombo.getSelectedItem().toString());
				state.setInt(4, Integer.parseInt(ageT.getText()));
				state.setFloat(5, Float.parseFloat(salaryT.getText()));
				state.execute();
				refreshTable();
				refreshComboPerson();
				clearForm();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	class UpdateAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			String sql = "Update person set fname=?,lname=?,sexCombo=?,age=?,salary=?" + "where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1, fnameT.getText());
				state.setString(2, lnameT.getText());
				state.setString(3, sexCombo.getSelectedItem().toString());
				state.setInt(4, Integer.parseInt(ageT.getText()));
				state.setFloat(5, Float.parseFloat(salaryT.getText()));
				state.setInt(6, Integer.parseInt(table.getValueAt(table.getSelectedRow(), 0).toString()));
				state.execute();
				refreshTable();
				clearForm();
			}
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}
	class MouseAction implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			id = Integer.parseInt(table.getValueAt(row, 0).toString());
			fnameT.setText(table.getValueAt(row, 1).toString());
			lnameT.setText(table.getValueAt(row, 2).toString());
			if (table.getValueAt(row, 3).toString().equals("Male")) {
				sexCombo.setSelectedIndex(0);
			} else {
				sexCombo.setSelectedIndex(1);
			}
			ageT.setText(table.getValueAt(row, 4).toString());
			salaryT.setText(table.getValueAt(row, 5).toString());
		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {

		}

		@Override
		public void mouseEntered(MouseEvent e) {

		}

		@Override
		public void mouseExited(MouseEvent e) {

		}
	}

	class DeleteAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			String sql = "delete from person where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setInt(1, id);
				state.execute();
				refreshTable();
				clearForm();
				id = -1;
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	class EditAction implements ActionListener{


		@Override
		public void actionPerformed(ActionEvent e) {


			conn = DBConnection.getConnection();
			String sql = "update person set fname =?, lname=?, sex=?, age=?, salary=? where id=?";
			try {
				state = conn.prepareStatement(sql);
				state.setString(1,fnameT.getText());
				state.setString(2,lnameT.getText());
				state.setString(3,sexCombo.getSelectedItem().toString());
				state.setInt(4,Integer.parseInt(ageT.getText()));
				state.setFloat(5,Float.parseFloat(salaryT.getText()));
				state.setInt(6,id);



				state.execute();
				clearForm();
				refreshTable();
				//System.out();_
			}catch(SQLException s) {
				s.printStackTrace();
			}


		}
	}
	class SearchAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			conn = DBConnection.getConnection();
			String sql = "select * from person where fname like '%" + fnameT.getText() + "%'";
			try {
				state = conn.prepareStatement(sql);
				result = state.executeQuery();
				table.setModel(new MyModel(result));
			} catch (SQLException ex) {
				ex.printStackTrace();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	class RefreshAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			refreshTable();
		}
	}
	class NewAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			//open new frame
			new NewFrame();
		}
	}
}
