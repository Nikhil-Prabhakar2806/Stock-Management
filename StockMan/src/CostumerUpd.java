import java.awt.event.*;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class CostumerUpd extends JFrame implements ActionListener {
	
	JLabel nu1 ,nu2,nu3,nu4,nu5,nu6,nu7;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7;
	JTextArea ta1;
	JButton r,e,b;
	Connection con;
	PreparedStatement st;
	public CostumerUpd()
	{
		setLayout(null);
		nu1=new JLabel("Enter Costumer ID");
		nu1.setBounds(100, 80, 400, 40);
		nu1.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu1);
		tf1=new JTextField();
		tf1.setBounds(550, 80, 200, 40);
		add(tf1);
		r=new JButton("Find");
		r.setBounds(300, 160 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		nu2=new JLabel("Costumer Name");
		nu2.setBounds(100, 240, 400, 40);
		nu2.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu2);
		tf2=new JTextField();
		tf2.setBounds(550, 240, 200, 40);
		add(tf2);
		nu3=new JLabel("Date");
		nu3.setBounds(100, 310, 400, 40);
		nu3.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu3);
		tf3=new JTextField();
		tf3.setBounds(550, 310, 200, 40);
		add(tf3);
		nu4=new JLabel("City");
		nu4.setBounds(100, 380, 400, 40);
		nu4.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu4);
		tf4=new JTextField();
		tf4.setBounds(550, 380, 200, 40);
		add(tf4);
		nu5=new JLabel("Phone");
		nu5.setBounds(100, 450, 400, 40);
		nu5.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu5);
		tf5=new JTextField();
		tf5.setBounds(550, 450, 200, 40);
		add(tf5);
		b=new JButton("Update");
		b.setBounds(100, 530 , 120, 60);
		b.setFont(new Font("Arial",Font.BOLD,20));
		add(b);
		b.addActionListener(this);
		e=new JButton("Exit");
		e.setBounds(300,530 , 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		add(e);
		e.addActionListener(this);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
	}
	public static void main(String[] args) {
		CostumerUpd obj=new CostumerUpd();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		 if (ae.getSource()==r)
		 {
			 String e=tf1.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String str="select costname,dt,city,phone from costum where costid=?";
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
		 if(ae.getSource()==b)
		 {
			 String StoreId=tf1.getText();
				String name=tf2.getText();
				String Address=tf3.getText();
				String gstin=tf4.getText();
				String phone=tf5.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String str="update costum set costname=?,dt=?,city=?,phone=? where costid=?";
					st=con.prepareStatement(str);
					st.setString(1, name);
					st.setString(2, Address);
					st.setString(3, gstin);
					st.setString(4,phone);
					st.setString(5,StoreId);
					int f=st.executeUpdate();
					JOptionPane.showMessageDialog(this, "Record changed");
					con.commit();
					
					con.close();
					}
				catch(Exception ex) {
					System.out.println(ex.toString());
			}
		 }
		 if(ae.getSource()==e)
			 System.exit(1);
		}

	}


		