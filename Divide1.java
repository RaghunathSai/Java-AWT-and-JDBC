import java.util.*;
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
class Divide1 extends Frame implements ActionListener
{
   Button submit;
   TextField t1;
    TextArea t2;
    Divide1()
    {
      submit=new Button("Submit");
      t1=new TextField(15);
      t2=new TextArea(10,10);
      submit.addActionListener(this);
      setSize(500,500);
      setVisible(true);
      add(t1);
      add(submit);
      add(t2);
      setLayout(new FlowLayout());
      MyAdap mw=new MyAdap(this);
      addWindowListener(mw);
    }
    public void actionPerformed(ActionEvent ae)
    {
       if(ae.getSource()==submit)
       {
          try
          {
             convert();
          }
        catch(Exception e)
        {
          String s="Number format exception caught ";
          t2.append(s);
        }
       }     
          
    }
    public void convert()
    {
       
         int i=Integer.parseInt(t1.getText());
     
       
    }
    public static void main(String ar[ ])
    {
      Divide1 d=new Divide1();
    }
}
class MyAdap extends WindowAdapter
{
   Divide1 d1;
   MyAdap(Divide1 d2)
   {
     d1=d2;
   }
   public void windowClosing(WindowEvent we)
   {
     d1.setVisible(false);
     System.exit(0);
   }
} 