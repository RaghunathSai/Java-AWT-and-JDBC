import java.awt.*;
import java.awt.event.*;
import java.io.*;
class Date extends Frame implements ActionListener
{
   Button b1,b2;
   Choice ch1,ch2,ch3;
   TextArea t1;
    Label l1;
   Date()
   {
    b1=new Button("Submit");
    b2=new Button("Reset");
    b1.addActionListener(this);
    b2.addActionListener(this);
    ch1=new Choice();
    ch2=new Choice();
    ch3=new Choice();
    t1=new TextArea(10,20);
    l1=new Label("Select Date");
    add(l1);
    for(int i=1;i<32;i++)
    ch1.addItem(toString(i));
   for(int i=2010;i<2021;i++)
    ch2.addItem(toString(i));
  ch3.addItem("January");
  ch3.addItem("February");
  ch3.addItem("March");
  ch3.addItem("April");
  ch3.addItem("May");
  ch3.addItem("June");
  ch3.addItem("July");
  ch3.addItem("August");
  ch3.addItem("September");
  ch3.addItem("October");
  ch3.addItem("November");
  ch3.addItem("December");
  add(ch1);
  add(ch2);
  add(ch3);
  add(b1);
  add(b2);
  add(t1);
  setLayout(new GridLayout(4,2));
  setVisible(true);
  setSize(500,500);
   MyAdap mw=new MyAdap(this);
  addWindowListener(mw); 
  }
 public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==b1)
    {
      
      String s1,s2;
      int dd,yr;
      dd=Integer.parseInt(ch1.getSelectedItem());
      yr=Integer.parseInt(ch2.getSelectedItem());
      s1=String.valueOf(ch3.getSelectedItem());
      s2=("Date is:"+dd+"Month is:"+s1+"Year is :"+yr+"\r\n");
      t1.setText(s2);
     
    }
    if(ae.getSource()==b2)
      t1.setText(" ");

  }
  public String toString(int k)
  {
   return ""+k+"";
  } 
 /* public Insets getInsets()
  {
    return new Insets(10,10,10,10);
  }*/
  public static void main(String ar[ ])throws IOException
  {
    Date d=new Date();
  }
}
class MyAdap extends WindowAdapter
{
  Date d1;
  MyAdap(Date d2)
  {
    d1=d2;
  }
  public void windowClosing(WindowEvent we)
  {
    d1.setVisible(false);
    System.exit(0);
  }
}
