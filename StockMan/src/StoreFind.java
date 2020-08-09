import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.*;
import javax.swing.*;

public class StoreFind extends JFrame implements ActionListener {
	
	JLabel nu1 ,nu2,nu3,nu4,nu5,nu6,nu7;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JButton r,e;
	Connection con;
	PreparedStatement st;
	public StoreFind()
	{
		setLayout(null);
		nu5=new JLabel("Enter Store ID");
		nu5.setBounds(100, 80, 400, 50);
		nu5.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu5);
		r=new JButton("Find");
		r.setBounds(300, 160 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		tf1=new JTextField();
		tf1.setBounds(550, 80, 200, 50);
		add(tf1);
		nu2=new JLabel("Store Name");
		nu2.setBounds(100, 250, 400, 40);
		nu2.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu2);
		tf2=new JTextField();
		tf2.setBounds(550, 250, 200, 40);
		add(tf2);
		nu3=new JLabel("Address");
		nu3.setBounds(100, 320, 400, 40);
		nu3.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu3);
		tf3=new JTextField();
		tf3.setBounds(550, 320, 200, 40);
		add(tf3);
		nu4=new JLabel("GSTIN");
		nu4.setBounds(100, 390, 400, 40);
		nu4.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu4);
		tf4=new JTextField();
		tf4.setBounds(550, 390, 200, 40);
		add(tf4);
		nu5=new JLabel("Phone");
		nu5.setBounds(100, 460, 400, 40);
		nu5.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu5);
		tf5=new JTextField();
		tf5.setBounds(550, 460, 200, 40);
		add(tf5);
		nu6=new JLabel("Email");
		nu6.setBounds(100, 530, 400, 50);
		nu6.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu6);
		tf6=new JTextField();
		tf6.setBounds(550, 530, 200, 50);
		add(tf6);
		nu7=new JLabel("Pan");
		nu7.setBounds(100, 600, 400, 50);
		nu7.setFont(new Font("Calibiri",Font.BOLD,24));
		add(nu7);
		tf7=new JTextField();
		tf7.setBounds(550, 600, 200, 50);
		add(tf7);
		e=new JButton("Exit");
		e.setBounds(300,680 , 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		add(e);
		e.addActionListener(this);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
	}
	public static void main(String[] args) {
		StoreFind obj=new StoreFind();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==r)
		{
			String e=tf1.getText();
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
				String str="select name,address,gstin,phone,email,pan from Store where StoreId=?";
				st=con.prepareStatement(str);
				st.setString(1,e);
				ResultSet rs=st.executeQuery();
				//tf1.setText(String.valueOf(z));
				if (rs.next())
				{

					tf2.setText(rs.getString(1));
					tf3.setText(rs.getString(2));
					tf4.setText(rs.getString(3));
					tf5.setText(rs.getString(4));
					tf6.setText(rs.getString(5));
					tf7.setText(rs.getString(6));
				}
				else
				{
				JOptionPane.showMessageDialog(this, "No Record Found");
				}
				con.commit();
				
				con.close();
				}
			catch(Exception ex) {
				System.out.println(ex.toString());
		}
		}
		if (ae.getSource()==e)
				System.exit(1);
		}

	}