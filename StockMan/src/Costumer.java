import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class Costumer extends JFrame implements ActionListener {
	
	JLabel nu1 ,nu2,nu3,nu4,nu5,nu6,nu7,nu8;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton r,e,l,p;
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	public Costumer()
	{
		setLayout(null);
		nu1=new JLabel("Costumer ID");
		nu1.setBounds(100, 80, 400, 40);
		nu1.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu1);
		tf1=new JTextField();
		tf1.setBounds(550, 80, 200, 40);
		add(tf1);
		nu2=new JLabel("Costumer Name");
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
		r=new JButton("First");
		r.setBounds(100, 460 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		e=new JButton("Next");
		e.setBounds(300,460 , 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		e.addActionListener(this);
		add(e);
		p=new JButton("Previous");
		p.setBounds(500, 460 , 120, 60);
		p.setFont(new Font("Arial",Font.BOLD,20));
		add(p);
		p.addActionListener(this);
		l=new JButton("Last");
		l.setBounds(300,560 , 120, 60);
		l.setFont(new Font("Arial",Font.BOLD,20));
		add(l);
		l.addActionListener(this);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
		getdata();
	}
	public static void main(String[] args) {
		Costumer obj=new Costumer();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		try {
		if (ae.getSource()==r)
		{
				 rs.first();
					tf1.setText(rs.getString(1));
					tf2.setText(rs.getString(2));
					tf3.setText(rs.getString(3));
					tf4.setText(rs.getString(4));
					tf5.setText(rs.getString(5));
			
		}
		
		 if (ae.getSource()==e)
		 {
			 rs.next();
				tf1.setText(rs.getString(1));
				tf2.setText(rs.getString(2));
				tf3.setText(rs.getString(3));
				tf4.setText(rs.getString(4));
				tf5.setText(rs.getString(5));
		 }
		 if (ae.getSource()==p)
		 {
			 rs.previous();
				tf1.setText(rs.getString(1));
				tf2.setText(rs.getString(2));
				tf3.setText(rs.getString(3));
				tf4.setText(rs.getString(4));
				tf5.setText(rs.getString(5));
		 }
		 if (ae.getSource()==l)
		 {
			 rs.last();
				tf1.setText(rs.getString(1));
				tf2.setText(rs.getString(2));
				tf3.setText(rs.getString(3));
				tf4.setText(rs.getString(4));
				tf5.setText(rs.getString(5));
		 }
		}
		catch(Exception e) {}
	}

	public void getdata() 
	{
		
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str="select * from costum";
				st=con.prepareStatement(str,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
				
				rs=st.executeQuery();
				rs.first();
				tf1.setText(rs.getString(1));
				tf2.setText(rs.getString(2));
				tf3.setText(rs.getString(3));
				tf4.setText(rs.getString(4));
				tf5.setText(rs.getString(5));
			}
			catch(Exception e) {System.out.println(e.toString());}
			
	
	}
}