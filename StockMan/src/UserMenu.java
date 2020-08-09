import javax.swing.*;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class UserMenu extends JFrame {
	JMenuBar mb;
	JMenu a,b,c,d,e,f,g,h;
	JMenuItem i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14;
	 public UserMenu()
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
		 i1=new JMenuItem("Show");
		 i2=new JMenuItem("Insert");
		 i3=new JMenuItem("Show");
		 i4=new JMenuItem("Insert");
		 i5=new JMenuItem("Show");
		 i6=new JMenuItem("Insert");
		 i7=new JMenuItem("Show");
		 i8=new JMenuItem("Insert");
		 i9=new JMenuItem("Show");
		 i10=new JMenuItem("Insert");
		 i11=new JMenuItem("Show");
		 i12=new JMenuItem("Insert");
		 i13=new JMenuItem("Show");
		 i14=new JMenuItem("Help");
		 a.add(i1);
		 b.add(i2);
		 b.addSeparator();
		 b.add(i3);
		 c.add(i4);
		 c.addSeparator();
		 c.add(i5);
		 d.add(i6);
		 d.addSeparator();
		 d.add(i7);
		 e.add(i8);
		 e.addSeparator();
		 e.add(i9);
		 f.add(i10);
		 f.addSeparator();
		 f.add(i11);
		 g.add(i12);
		 g.addSeparator();
		 g.add(i13);
		 h.add(i14);
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
		UserMenu obj=new UserMenu();
		// TODO Auto-generated method stub

	}

}
