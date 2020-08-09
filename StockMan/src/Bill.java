
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.awt.*;
import javax.swing.*;

public class Bill extends JFrame implements ActionListener 
{
	
	JLabel nu1 ,nu2,nu3,nu4,nu5,nu6,nu7,nu8;
	JTextField tf4,tf5,tf6,tf7;
	JComboBox tf1,tf2;
	JButton r,e;
	Connection con;
	PreparedStatement st;
	public Bill()
	{
		setLayout(null);
		nu1=new JLabel("Enter CostId ID");
		nu1.setBounds(100, 80, 400, 40);
		nu1.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu1);
		tf1=new JComboBox();
		tf1.setBounds(550, 80, 200, 40);
		add(tf1);
		nu2=new JLabel("Enter Item Id");
		nu2.setBounds(100, 150, 400, 40);
		nu2.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu2);
		tf2=new JComboBox();
		tf2.setBounds(550, 150, 200, 40);
		add(tf2);
		nu4=new JLabel("Enter Quantity");
		nu4.setBounds(100, 290, 400, 40);
		nu4.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu4);
		tf4=new JTextField();
		tf4.setBounds(550, 290, 200, 40);
		add(tf4);
		r=new JButton("Save");
		r.setBounds(100, 400 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		e=new JButton("Exit");
		e.setBounds(550,400 , 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		add(e);
		e.addActionListener(this);
		nu7=new JLabel("Total Price");
		nu7.setBounds(100, 500, 400, 50);
		nu7.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu7);
		tf7=new JTextField();
		tf7.setBounds(550, 500, 200, 50);
		add(tf7);
		setSize(1000, 1000);
		fillItemID();
		fillCostumID();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
	}
	public static void main(String[] args) {
		Bill obj=new Bill();
	}
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==r)
		{
			String cid=tf1.getSelectedItem().toString();
			String iid=tf2.getSelectedItem().toString();
			if (getStock(iid)<=0)
			{
				JOptionPane.showMessageDialog(this, "No stock Available");
			}
			else
			{
			int price=getPrice(iid);
			int qnt=Integer.parseInt(tf4.getText());
			int tp=price*qnt;
			tf7.setText("$ "+String.valueOf(tp));
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str="insert into bill values(?,?,?,?,?) ";
				st=con.prepareStatement(str);
				st.setString(1,cid);
				st.setString(2,iid);
				st.setInt(3,price);
				st.setInt(4,qnt);
				st.setInt(5,tp);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Saved");
				updateStock(qnt, iid);
				con.commit();
				
				con.close();
				}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}
			}
			}	
		 if (ae.getSource()==e)
			System.exit(1);
	}
	public void fillItemID()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String str="select itemid from itemsn";
			st=con.prepareStatement(str);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				tf2.addItem(rs.getString(1));
			}
		}
		catch(Exception e) {}
	}
	public void fillCostumID()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String str="select costid from costum";
			st=con.prepareStatement(str);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				tf1.addItem(rs.getString(1));
			}
		}
		catch(Exception e) {}
	}

	public void updateStock(int q,String iid)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String str="update itemsn set currq=currq-? where itemid=?";
			st=con.prepareStatement(str);
			st.setInt(1,q);
			st.setString(2,iid);
			int g=st.executeUpdate();
			JOptionPane.showMessageDialog(this, "Stock Updated Record Saved");
			con.commit();
			
			con.close();
			}
		catch(Exception ex) {
			System.out.println(ex.toString());
		}
	}
	public int getPrice(String iid)
	{
		int p=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String str="select pricepunit from itemsn where itemid=?";
			st=con.prepareStatement(str);
			st.setString(1, iid);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				p=rs.getInt(1);
			}
			
		}
		catch(Exception e) {}
		return p;
	}
	public int getStock(String iid)
	{
		int p=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String str="select currq from itemsn where itemid=?";
			st=con.prepareStatement(str);
			st.setString(1, iid);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				p=rs.getInt(1);
			}
			
		}
		catch(Exception e) {}
		return p;
	}

}