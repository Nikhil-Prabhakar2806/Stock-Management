
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class ItemsIn extends JFrame implements ActionListener 
{
	
	JLabel nu1 ,nu2,nu3,nu4,nu5,nu6,nu7,nu8;
	JTextField tf1,tf3,tf4,tf5,tf6,tf7;
	JComboBox tf2;
	JButton r,e;
	Connection con;
	PreparedStatement st;
	public ItemsIn()
	{
		setLayout(null);
		nu1=new JLabel("Enter Item ID");
		nu1.setBounds(100, 80, 400, 40);
		nu1.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu1);
		tf1=new JTextField();
		tf1.setBounds(550, 80, 200, 40);
		add(tf1);
		nu2=new JLabel("Enter ItemCat Id");
		nu2.setBounds(100, 150, 400, 40);
		nu2.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu2);
		tf2=new JComboBox();
		tf2.setBounds(550, 150, 200, 40);
		add(tf2);
		nu3=new JLabel("Enter Name");
		nu3.setBounds(100, 220, 400, 40);
		nu3.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu3);
		tf3=new JTextField();
		tf3.setBounds(550, 220, 200, 40);
		add(tf3);
		nu4=new JLabel("Enter Price/Unit");
		nu4.setBounds(100, 290, 400, 40);
		nu4.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu4);
		tf4=new JTextField();
		tf4.setBounds(550, 290, 200, 40);
		add(tf4);
		nu5=new JLabel("Enter Open Quantity");
		nu5.setBounds(100, 360, 400, 40);
		nu5.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu5);
		tf5=new JTextField();
		tf5.setBounds(550, 360, 200, 40);
		add(tf5);
		nu6=new JLabel("Enter Current Quantity");
		nu6.setBounds(100, 430, 400, 50);
		nu6.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu6);
		tf6=new JTextField();
		tf6.setBounds(550, 430, 200, 50);
		add(tf6);
		nu7=new JLabel("Remarks if any");
		nu7.setBounds(100, 500, 400, 50);
		nu7.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu7);
		tf7=new JTextField();
		tf7.setBounds(550, 500, 200, 50);
		add(tf7);
		r=new JButton("Save");
		r.setBounds(100, 560 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		e=new JButton("Exit");
		e.setBounds(550,560 , 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		add(e);
		e.addActionListener(this);
		fillItemCatID();
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
	}
	public static void main(String[] args) {
		ItemsIn obj=new ItemsIn();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==r)
		{
			if (tf1.getText().length()==0 || tf3.getText().length()==0 ||tf4.getText().length()==0 ||tf5.getText().length()==0 ||tf6.getText().length()==0 ||tf1.getText().length()==7 )
			{
				JOptionPane.showMessageDialog(this, "Enter all the fields");
			}
			else
			{
			String iid=tf1.getText();
			String icid=tf2.getSelectedItem().toString();
			String in=tf3.getText();
			int ppu=Integer.parseInt(tf4.getText());
			int oq=Integer.parseInt(tf5.getText());
			int cq=Integer.parseInt(tf6.getText());
			String rem=tf7.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str="insert into itemsn values(?,?,?,?,?,?,?) ";
				st=con.prepareStatement(str);
				st.setString(1,iid);
				st.setString(2,icid);
				st.setString(3,in);
				st.setInt(4,ppu);
				st.setInt(5,oq);
				st.setInt(6,cq);
				st.setString(7,rem);
				int g=st.executeUpdate();
				JOptionPane.showMessageDialog(this, "Record Saved");
				con.commit();
				
				con.close();
				}
			catch(Exception ex) {
				System.out.println(ex.toString());
			}}}
		
		 if (ae.getSource()==e)
			System.exit(1);
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

}