import java.io.*;
import java.awt.*;
import java.awt.event.*;
class InvalidInput extends Exception
{
  String des;
  public InvalidInput()
  {
    des="Invalid input ";
  }
  public InvalidInput(String s)
  {
    des=s;
  }
  public String toString()
  {
   return des;
  }
}
class Divide extends Frame implements ActionListener
{
 TextField t1,t2;
  TextArea t3,t4;
   Button divide,reset;
   int did,div,qo,re;
  Divide()
  {
   t1=new TextField(20);
   t2=new TextField(20);
   t3=new TextArea(15,15);
   t4=new TextArea(15,15);
   divide=new Button("Divide");
   reset=new Button("Reset");
   divide.addActionListener(this);
   reset.addActionListener(this);
   add(t1);
   add(t2);
   add(divide);
   add(t3);
   add(t4);
   add(reset);
   setSize(300,300);
   setLayout(new FlowLayout());
   setVisible(true);
   MyAdap mw=new MyAdap(this);
   addWindowListener(mw);
  }
  public void actionPerformed(ActionEvent ae)
  {
   
   boolean flag=true;
   if(ae.getSource()==divide)
   {
    
     try
     {
       convert2();
     }
     catch(Exception e)
     {
       t4.append("Invalid input in divisor"+"\n");
      flag=false; 
     }
     if(div==0)
     {
       t4.append("Division  Not allowed"+"\n");
       flag=false;
     }
      try
     {
       convert();
     }
     catch(InvalidInput e)
     {
       t4.append("Invaild input in dividend"+"\n");
        flag=false;   
     }
      if(flag)
     {
       qo=(did/div);
        re=(did%div);
        t3.setText("Quotient is:"+qo+"\n"+"Remainder is :"+re);    
     }
   }
   if(ae.getSource()==reset)
   {
      t1.setText(" ");
      t2.setText(" ");
      t3.setText(" ");
      t4.setText(" ");
   }
 }
 public void convert()throws InvalidInput
{
   try
   { did=Integer.parseInt(t1.getText()); }
   catch(Exception e)
   {
    throw new InvalidInput();
   }
 
}
public void convert2()
{
   div=Integer.parseInt(t2.getText());
}
 public static void main(String ar[ ])throws IOException
 {
   Divide d=new Divide();
 }
}
class MyAdap extends WindowAdapter
{
  Divide d2;
  MyAdap(Divide d3)
  {
    d2=d3;
  }
  public void windowClosing(WindowEvent we)
  {
    d2.setVisible(false);
    System.exit(0);
  }
}
