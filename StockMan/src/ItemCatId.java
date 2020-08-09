/*SQL> create table ItmCat
  2  ( itemcatid varchar(20),
  3  icatnme varchar(20),
  4  description varchar(20),
  5  remarks varchar(20));*/


import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.awt.*;
import javax.swing.*;

public class ItemCatId extends JFrame implements ActionListener {
	
	JLabel nu1 ,nu2,nu3,nu4,nu5,nu6,nu7,nu8;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton r,e;
	Connection con;
	PreparedStatement st;
	public ItemCatId()
	{
		setLayout(null);
		nu1=new JLabel("Enter Item Category ID");
		nu1.setBounds(100, 80, 400, 40);
		nu1.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu1);
		tf1=new JTextField();
		tf1.setBounds(550, 80, 200, 40);
		add(tf1);
		nu2=new JLabel("Enter Item Category Name");
		nu2.setBounds(100, 150, 400, 40);
		nu2.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu2);
		tf2=new JTextField();
		tf2.setBounds(550, 150, 200, 40);
		add(tf2);
		nu3=new JLabel("Enter Description");
		nu3.setBounds(100, 220, 400, 40);
		nu3.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu3);
		tf3=new JTextField();
		tf3.setBounds(550, 220, 200, 40);
		add(tf3);
		nu7=new JLabel("Remarks if any");
		nu7.setBounds(100, 290, 400, 50);
		nu7.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu7);
		tf7=new JTextField();
		tf7.setBounds(550, 290, 200, 50);
		add(tf7);
		r=new JButton("Save");
		r.setBounds(100, 360 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		e=new JButton("Exit");
		e.setBounds(550,360 , 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		add(e);
		e.addActionListener(this);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
	}
	public static void main(String[] args) {
		ItemCatId obj=new ItemCatId();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==r)
		{
			String icid=tf1.getText();
			String cn=tf2.getText();
			String des=tf3.getText();
			String rem=tf7.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str="insert into itmcat values(?,?,?,?) ";
				st=con.prepareStatement(str);
				st.setString(1,icid);
				st.setString(2,cn);
				st.setString(3,des);
				st.setString(4,rem);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Saved");
				con.commit();
				
				con.close();
				}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}}
		
		 if (ae.getSource()==e)
			System.exit(1);
	}

}