import java.awt.*;
import java.io.*;
import java.awt.event.*;

public class StudentResponse2 extends Frame implements ActionListener
{
  Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
  Button b1;
  TextArea t5,t6;
  TextField t1,t2,t3,t4;
  String s=new String(" ");
  String s2;
  int i,flag=0;
 
  CheckboxGroup cg;
  Checkbox c1,c2,c3,c4,c5;
  Choice ch1,ch2,ch3,ch4,ch5,ch6;
  List li1;

  StudentResponse2()
  {
   b1=new Button("Submit");

   l1=new Label("Register No");
   l2=new Label("Hobby");
   l3=new Label("Name");
   l4=new Label("Extra Curricular Activities");
   l5=new Label("Gender");
   l6=new Label("Degree");
   l7=new Label("Branch");
   l8=new Label("Year Of Study");
   l9=new Label("Date Of Birth");
   l10=new Label("Address");
   l11=new Label("E-Mail");
   l12=new Label("You Entered");

   t1=new TextField(18);
   t2=new TextField(25);
   t3=new TextField(40);
   t4=new TextField(20);
   t5=new TextArea(20,50);
   t6=new TextArea(5,30);
   
   ch1=new Choice();
   ch2=new Choice();
   ch3=new Choice();
   ch4=new Choice();
   ch5=new Choice();
   ch6=new Choice();

   c1=new Checkbox("Stamp Collection");
   c2=new Checkbox("Reading Novels");
   c3=new Checkbox("Playing Tennis");
   cg=new CheckboxGroup();
   c4=new Checkbox("Male",cg,false);
   c5=new Checkbox("Female",cg,false);
   
   li1=new List(3,true);
   
   add(l1);
   add(t1);

   add(l2);
   add(c1);
   add(c2);
   add(c3);
   
   add(l3);
   add(t2);

   add(l4);
   li1.addItem("Tennis");
   li1.addItem("Football");
   li1.addItem("BasketBall");
   li1.addItem("Cricket");
   li1.addItem("Volley Ball");
   add(li1);

   add(l5);
   add(c4);
   add(c5);

   add(l6);
   ch1.addItem("B.Tech");
   ch1.addItem("M.Tech");
   ch1.addItem("B.sc");
   add(ch1);

   add(l7);
   ch2.addItem("CSE");
   ch2.addItem("IT");
   ch2.addItem("ECE");
   add(ch2);

   add(l8);
   ch3.addItem("1");
   ch3.addItem("2");
   ch3.addItem("3");
   ch3.addItem("4");
   add(ch3);

   add(l9);
   for(int i=1;i<32;i++)
    ch4.addItem(toString(i));
   add(ch4);
   ch5.addItem("January");
   ch5.addItem("February");
   ch5.addItem("March");
   ch5.addItem("April");
   ch5.addItem("May");
   ch5.addItem("June");
   ch5.addItem("July");
   ch5.addItem("August");
   ch5.addItem("September");
   ch5.addItem("October");
   ch5.addItem("November");
   ch5.addItem("December"); 
   add(ch5);
   for(int i=1995;i<=2014;i++)
    ch6.addItem(toString(i));
   add(ch6);

   add(l10);
   add(t3);

   add(l11);
   add(t4);

   add(l12);
   add(t5);
  
   add(t6);
     
   b1.addActionListener(this);
   add(b1);
   setLayout(new FlowLayout());
   setVisible(true);
   setSize(500,500);
   MyAdap mw=new MyAdap(this);
   addWindowListener(mw);
  }
  public void actionPerformed(ActionEvent ae)
  {
    flag=0;
    FileWriter fw;
    try
    {
      fw=new FileWriter("Student.txt");
      t5.setText(" ");
      s="";
      s=s+"Registration number is:"+t1.getText()+"\r\n";
      s2=t1.getText();
      if(s2.length()!=9)
      {
       flag=1;
       t6.append("Registration number must be greater than 8 digits "+"\n");
      }
      s2=t2.getText();
      if(s2.equals(""))
      {
       flag=1;
        t6.append("Name cannot be null"+"\n");
      }
      s=s+"Name is:"+t2.getText()+"\r\n";
      s=s+"Address is:"+t3.getText()+"\r\n";
      s=s+"Email id"+t4.getText()+"\r\n";
      if(c4.getState()==true)
       s=s+"Student gender is"+c4.getLabel()+"\r\n";
     else
      s=s+"Student gender is "+c5.getLabel()+"\r\n";
      if(c1.getState()==true)
      s=s+"Student Hobby is"+c1.getLabel()+"\r\n";
      if(c2.getState()==true)
       s=s+"Student Hobby is"+c2.getLabel()+"\r\n";
       if(c3.getState()==true)
        s=s+"Student Hobby is"+c3.getLabel()+"\r\n";
        s=s+"Student is studying in "+ch1.getSelectedItem()+"\r\n";
        s=s+"Student is in branch "+ch2.getSelectedItem()+"\r\n";
        s=s+"Student's year of study is "+ch3.getSelectedItem()+"\r\n";
        s=s+"Student's date of birth is "+ch4.getSelectedItem()+"/"+ch5.getSelectedItem()+"/"+ch6.getSelectedItem()+"\r\n";
     String s1[ ]=li1.getSelectedItems();
     for(i=0;i<s1.length;i++)
     s=s+"Student is interested in "+s1[i]+"\r\n";
     if(flag==0)
     {
       t5.setText(s); 
       fw.write(s);
       fw.close();
    }
  }
  catch(IOException e)
   {
     System.out.println("IOException");
   }
 }
   String toString(int k)
   { return ""+k+"";}
   public static void main(String ar[ ])
   {
    StudentResponse2 sr=new StudentResponse2();
   }
}
class MyAdap extends WindowAdapter
{
  StudentResponse2 sr2;  
  MyAdap(StudentResponse2 sr3)
  {
     sr2=sr3;
  }
  public void windowClosing(WindowEvent w)
  {
   sr2.setVisible(false);
   System.exit(0);
  }
}
