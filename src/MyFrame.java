import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class MyFrame extends JFrame {
	Connection conn=null;
	PreparedStatement state=null;
	ResultSet result=null;
	int id=-1;
	JPanel upPanel=new JPanel();
	JPanel midPanel=new JPanel();
	JPanel downPanel=new JPanel();
	JLabel fnameL=new JLabel("Name");
	JLabel lnameL=new JLabel("LastName");
	JLabel sexL=new JLabel("Sex");
	JLabel ageL=new JLabel("Age");
	JLabel salaryL=new JLabel("Salary");
	JTextField fnameT=new JTextField();
	JTextField lnameT=new JTextField();
	JTextField ageT=new JTextField();
	JTextField salaryT=new JTextField();
	String[] item= {"Male","Female"};
	JComboBox<String> sexCombo=new JComboBox<String>(item);
	JButton addB=new JButton("Add");
	JButton delB=new JButton("Delete");
	JButton ediB=new JButton("Ëdit");
	JTable table=new JTable();
	JScrollPane scroll=new JScrollPane(table);
public MyFrame() {
	
	this.setSize(400,600);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	this.setLayout(new GridLayout(3,1));
	//UpPanel
	upPanel.setLayout(new GridLayout(5,2));
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
	this.add(midPanel);
	//DownPanel
	scroll.setPreferredSize(new Dimension(350,150));
	downPanel.add(scroll);
	addB.addActionListener(new AddAction());
	refreshTable();
	this.setVisible(true);
	this.add(downPanel);
	}
	public void refreshTable() {
	conn=DBConnection.getConnection();
		try {
			state=conn.prepareStatement("select * from person");
			result=state.executeQuery();
			table.setModel(new MyModel(result));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
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
class AddAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		conn=DBConnection.getConnection();
		String sql="Insert into person(fname,lname,sex,age,salary)"+ "values(?,?,?,?,?)";
		try {
			state=conn.prepareStatement(sql);
			state.setString(1,fnameT.getText());
			state.setString(2,lnameT.getText());
			state.setString(3,sexCombo.getSelectedItem().toString());
			state.setInt(4,Integer.parseInt(ageT.getText()));
			state.setFloat(5,Float.parseFloat(salaryT.getText()));
			state.execute();
			refreshTable();
			clearForm();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
}
}
