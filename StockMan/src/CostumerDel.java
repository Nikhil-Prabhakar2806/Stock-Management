import java.awt.event.*;
import java.sql.*;
import java.awt.*;
import javax.swing.*;

public class CostumerDel extends JFrame implements ActionListener {
	
	JLabel nu1 ,nu2,nu3,nu4;
	JTextField tf1,tf2,tf3,tf4;
	JTextArea ta1;
	JButton r,e;
	Connection con;
	PreparedStatement st;
	
	public CostumerDel()
	{
		setLayout(null);
		nu1=new JLabel("Enter Costumer Id");
		nu1.setBounds(100, 80, 400, 50);
		nu1.setFont(new Font("Calibri",Font.BOLD,24));
		add(nu1);
		tf1=new JTextField();
		tf1.setBounds(550, 80, 200, 50);
		add(tf1);
		r=new JButton("Delete");
		r.setBounds(100, 160 , 120, 60);
		r.setFont(new Font("Arial",Font.BOLD,20));
		add(r);
		r.addActionListener(this);
		e=new JButton("Exit");
		e.setBounds(300,160 , 120, 60);
		e.setFont(new Font("Arial",Font.BOLD,20));
		add(e);
		e.addActionListener(this);
		setSize(1000, 1000);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("My Frame");
	}
	public static void main(String[] args) {
		CostumerDel obj=new CostumerDel();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==r)
		{
			if (ae.getSource()==r)
			{
				String e=tf1.getText();
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","manager");
					String str="delete from costum where costid=?";
					st=con.prepareStatement(str);
					st.setString(1,e);
					int g=st.executeUpdate();
					JOptionPane.showMessageDialog(this, "Record Deleted");
					con.commit();
					
					con.close();
					}
				catch(Exception ex) {
					System.out.println(ex.toString());
				}}
		

		}
		if (ae.getSource()==e)
				System.exit(1);
		}

	}


		