import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.*;
public class AdminMenu extends JFrame implements ActionListener {
	JMenuBar mb;
	JMenu a,b,c,d,e,f,g,h;
	JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19,i20,i21,i22,i23,i24,i25,i26,i27,i28,i29;
	 public AdminMenu()
	 {
		 mb=new JMenuBar();
		 a=new JMenu("Store");
		 b=new JMenu("Item Category");
		 c=new JMenu("Supplier");
		 d=new JMenu("Items");
		 e=new JMenu("Stock");
		 f=new JMenu("GST");
		 g=new JMenu("Billing");
		 h=new JMenu("Help");
		 i1=new JMenuItem("Insert");
		 i2=new JMenuItem("Update");
		 i3=new JMenuItem("Delete");
		 i4=new JMenuItem("Show");
		 i5=new JMenuItem("Insert");
		 i6=new JMenuItem("Update");
		 i7=new JMenuItem("Delete");
		 i8=new JMenuItem("Show");
		 i9=new JMenuItem("Insert");
		 i10=new JMenuItem("Update");
		 i11=new JMenuItem("Delete");
		 i12=new JMenuItem("Show");
		 i13=new JMenuItem("Insert");
		 i14=new JMenuItem("Update");
		 i15=new JMenuItem("Delete");
		 i16=new JMenuItem("Show");
		 i17=new JMenuItem("Insert");
		 i18=new JMenuItem("Update");
		 i19=new JMenuItem("Delete");
		 i20=new JMenuItem("Show");
		 i21=new JMenuItem("Insert");
		 i22=new JMenuItem("Update");
		 i23=new JMenuItem("Delete");
		 i24=new JMenuItem("Show");
		 i25=new JMenuItem("Insert");
		 i26=new JMenuItem("Update");
		 i27=new JMenuItem("Delete");
		 i28=new JMenuItem("Show");
		 i29=new JMenuItem("Help");
		 a.add(i1);
		 i1.addActionListener(this);
		 a.addSeparator();
		 a.add(i2);
		 i2.addActionListener(this);
		 a.addSeparator();
		 a.add(i3);
		 a.addSeparator();
		 a.add(i4);
		 b.add(i5);
		 b.addSeparator();
		 b.add(i6);
		 b.addSeparator();
		 b.add(i7);
		 b.addSeparator();
		 b.add(i8);
		 c.add(i9);
		 c.addSeparator();
		 c.add(i10);
		 c.addSeparator();
		 c.add(i11);
		 c.addSeparator();
		 c.add(i12);
		 d.add(i13);
		 d.addSeparator();
		 d.add(i14);
		 d.addSeparator();
		 d.add(i15);
		 d.addSeparator();
		 d.add(i16);
		 e.add(i17);
		 e.addSeparator();
		 e.add(i18);
		 e.addSeparator();
		 e.add(i19);
		 e.addSeparator();
		 e.add(i20);
		 f.add(i21);
		 f.addSeparator();
		 f.add(i22);
		 f.addSeparator();
		 f.add(i23);
		 f.addSeparator();
		 f.add(i24);
		 g.add(i25);
		 g.addSeparator();
		 g.add(i26);
		 g.addSeparator();
		 g.add(i27);
		 g.addSeparator();
		 g.add(i28);
		 h.add(i29);
		 mb.add(a);
		 mb.add(b);
		 mb.add(c);
		 mb.add(d);
		 mb.add(e);
		 mb.add(f);
		 mb.add(g);
		 mb.add(h);
		 setJMenuBar(mb);
		 setSize(1000, 1000);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			setTitle("My Frame");
	 }
	public static void main(String[] args) {
		AdminMenu obj=new AdminMenu();
		// TODO Auto-generated method stub

	}
	@Override
	public void actionPerformed(ActionEvent ae) {
	try {
		if (ae.getSource()==i1)
		{
			new StoreIn();
		}
		if (ae.getSource()==i2)
		{
			new StoreUpd();
		}
		if (ae.getSource()==i3)
		{
			new StoreDel();
		}
		if (ae.getSource()==i4)
		{
			new StoreFind();
		}
	}
	catch (Exception e) {
		System.out.println(e.toString());
	}
	}
}
