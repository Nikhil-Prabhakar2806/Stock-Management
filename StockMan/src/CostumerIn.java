import java.awt.event.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.awt.*;
import javax.swing.*;

public class CostumerIn extends JFrame implements ActionListener {
	
	JLabel nu1 ,nu2,nu3,nu4,nu5,nu6,nu7,nu8;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton r,e;
	Connection con;
	PreparedStatement st;
	public CostumerIn()
	{
		setLayout(null);
		nu1=new JLabel("Enter New Costumer ID");
		nu1.setBounds(100, 80, 400, 40);
		nu1.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu1);
		tf1=new JTextField();
		tf1.setBounds(550, 80, 200, 40);
		add(tf1);
		nu2=new JLabel("Enter New Costumer Name");
		nu2.setBounds(100, 150, 400, 40);
		nu2.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu2);
		tf2=new JTextField();
		tf2.setBounds(550, 150, 200, 40);
		add(tf2);
		nu3=new JLabel("Date");
		nu3.setBounds(100, 220, 400, 40);
		nu3.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu3);
		tf3=new JTextField();
		tf3.setBounds(550, 220, 200, 40);
		add(tf3);
		nu4=new JLabel("City");
		nu4.setBounds(100, 290, 400, 40);
		nu4.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu4);
		tf4=new JTextField();
		tf4.setBounds(550, 290, 200, 40);
		add(tf4);
		nu5=new JLabel("Phone");
		nu5.setBounds(100, 360, 400, 40);
		nu5.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu5);
		tf5=new JTextField();
		tf5.setBounds(550, 360, 200, 40);
		add(tf5);
		r=new JButton("Save");
		r.setBounds(100, 460 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		e=new JButton("Exit");
		e.setBounds(550,460 , 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		add(e);
		e.addActionListener(this);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
	}
	public static void main(String[] args) {
		CostumerIn obj=new CostumerIn();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==r)
		{
			String cid=tf1.getText();
			String cn=tf2.getText();
			String d=tf3.getText();
			String ct=tf4.getText();
			String ph=tf5.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str="insert into costum values(?,?,?,?,?) ";
				st=con.prepareStatement(str);
				st.setString(1,cid);
				st.setString(2,cn);
				st.setString(3,d);
				st.setString(4,ct);
				st.setString(5,ph);
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