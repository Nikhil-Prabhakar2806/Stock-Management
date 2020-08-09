
import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.awt.*;
import javax.swing.*;

public class StockIn extends JFrame implements ActionListener {
	
	JLabel nu1 ,nu2,nu3,nu4,nu5,nu6,nu7,nu8;
	JTextField tf3,tf4,tf5,tf6,tf7;
	JComboBox tf1,tf2;
	JButton r,e;
	Connection con;
	PreparedStatement st;
	public StockIn()
	{
		setLayout(null);
		nu1=new JLabel("Enter Item ID");
		nu1.setBounds(100, 80, 400, 40);
		nu1.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu1);
		tf1=new JComboBox();
		tf1.setBounds(550, 80, 200, 40);
		add(tf1);
		nu2=new JLabel("Enter ItemCat Id");
		nu2.setBounds(100, 150, 400, 40);
		nu2.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu2);
		tf2=new JComboBox();
		tf2.setBounds(550, 150, 200, 40);
		add(tf2);
		nu3=new JLabel("Enter Supplier Id");
		nu3.setBounds(100, 220, 400, 40);
		nu3.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu3);
		tf3=new JTextField();
		tf3.setBounds(550, 220, 200, 40);
		add(tf3);
		nu4=new JLabel("Date");
		nu4.setBounds(100, 290, 400, 40);
		nu4.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu4);
		tf4=new JTextField();
		tf4.setBounds(550, 290, 200, 40);
		add(tf4);
		nu5=new JLabel("Enter Quantity");
		nu5.setBounds(100, 360, 400, 40);
		nu5.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu5);
		tf5=new JTextField();
		tf5.setBounds(550, 360, 200, 40);
		add(tf5);
		nu7=new JLabel("Remarks if any");
		nu7.setBounds(100, 430, 400, 50);
		nu7.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu7);
		tf7=new JTextField();
		tf7.setBounds(550, 430, 200, 50);
		add(tf7);
		r=new JButton("Save");
		r.setBounds(100, 490 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		e=new JButton("Exit");
		e.setBounds(550,490, 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		add(e);
		e.addActionListener(this);
		setSize(1000, 1000);
		fillItemID();
		fillItemCatID();
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
	}
	public static void main(String[] args) {
		StockIn obj=new StockIn();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==r)
		{
			String iid=tf1.getSelectedItem().toString();
			String icid=tf2.getSelectedItem().toString();
			String Spid=tf3.getText();
			String dt=tf4.getText();
			int oq=Integer.parseInt(tf5.getText());
			String rem=tf7.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str="insert into stockin values(?,?,?,?,?,?) ";
				st=con.prepareStatement(str);
				st.setString(1,iid);
				st.setString(2,icid);
				st.setString(3,Spid);
				st.setString(4,dt);
				st.setInt(5,oq);
				st.setString(6,rem);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Saved");
				updateStock(oq, iid);
				con.commit();
				
				con.close();
				}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}}
		
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
				tf1.addItem(rs.getString(1));
			}
		}
		catch(Exception e) {}
	
	}
	public void fillItemCatID()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String str="select itemcatid from itmcat";
			st=con.prepareStatement(str);
			ResultSet rs=st.executeQuery();
			while(rs.next())
			{
				tf2.addItem(rs.getString(1));
			}
		}
		catch(Exception e) {}
	
	}
	public void updateStock(int q,String iid)
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
			String str="update itemsn set currq=currq+? where itemid=?";
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

}