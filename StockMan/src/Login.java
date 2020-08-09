import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
	JLabel jl,jl1;
	JTextField tf;
	JPasswordField pf1;
	JButton b,b1,b2;
	Connection con;
	PreparedStatement st;
	ResultSet rs;
	public Login()
	{
		setLayout(null);
		jl=new JLabel("Enter Username");
		jl.setBounds(100, 80, 250, 50);
		jl.setFont(new Font("Arial",Font.BOLD,20));
		add(jl);
		tf=new JTextField();
		tf.setBounds(350, 80, 100, 50);
		add(tf);
		jl1=new JLabel("Enter Password");
		jl1.setBounds(100, 150, 250, 50);
		jl1.setFont(new Font("Arial",Font.BOLD,20));
		add(jl1);
		pf1=new JPasswordField();
		pf1.setBounds(350,150,100,50);
		add(pf1);
		b=new JButton("Proceed");
		b.setBounds(100, 250, 150, 60);
		b.setFont(new Font("Arial",Font.BOLD,20));
		add(b);
		b.addActionListener(this);
		b1=new JButton("Cancel");
		b1.setBounds(350, 250, 150, 60);
		b1.setFont(new Font("Arial",Font.BOLD,20));
		add(b1);
		b1.addActionListener(this);
		b2=new JButton("Add new User");
		b2.setBounds(100, 350, 250, 60);
		b2.setFont(new Font("Arial",Font.BOLD,20));
		add(b2);
		b2.addActionListener(this);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
		
	}

	public static void main(String[] args) {
		Login obj=new Login();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		 if (ae.getSource()==b)
		 {
			 	 String un=tf.getText();
			 	 String up=pf1.getText();
					try {
						Class.forName("oracle.jdbc.driver.OracleDriver");
						con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
						String str="select * from userlog where userid=? and userpswd=?";
						st=con.prepareStatement(str);
						st.setString(1, un);
						st.setString(2, up);
						ResultSet rs=st.executeQuery();
						//tf1.setText(String.valueOf(z));
						if (rs.next())
						{
							JOptionPane.showMessageDialog(this, "Login Success");
							if (rs.getString(1).equalsIgnoreCase("admin"))
							{
								new AdminMenu();
							// admin 	
							}
							else
							{
							new UserMenu();
							}
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
		 if (ae.getSource()==b1)
		 {
			 System.exit(1);
		 }
		 if (ae.getSource()==b2)
		 {
			new UserIn(); 
		 }
	}
}