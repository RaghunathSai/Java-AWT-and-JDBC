import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.*;
public class Details extends Frame implements ActionListener
{
  int i=0;
  String name,gender,s2,reg;
  Button submit,b1,b2,b3,b4;
  Label l1,l2,l3,l4;
  TextField t1,t2;
   TextArea t3,t4;
  CheckboxGroup cg;
  Checkbox c1,c2;
  Connection conn;
  Statement st;
  PreparedStatement ps;
  ResultSet rs;
  Details()
  {
    try
    {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      String url="jdbc:derby:My_DB;create=true";
      conn=DriverManager.getConnection(url);
      st=conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
      st.executeUpdate("DROP TABLE STUD");
      st.executeUpdate("CREATE TABLE STUD(Number int,Regno int,Name Varchar(25),Gender Varchar(6))");
      ps=conn.prepareStatement("INSERT INTO STUD VALUES(?,?,?,?)");
    }
    catch(Exception e)
    {
      e.printStackTrace();
    }
   submit =new Button("Submit");
   b1=new Button("<<");
   b2=new Button("<");
   b3=new Button(">");
   b4=new Button(">>");
   l1=new Label("Name");
   l2=new Label("Reg.No");
   l3=new Label("Gender");
   t1=new TextField(20);
   t2=new TextField(20);
   t3=new TextArea(10,20);
   t4=new TextArea(10,20);
   cg=new CheckboxGroup();
   c1=new Checkbox("Male",cg,false);
   c2=new Checkbox("Female",cg,false);
   add(l1);
   add(t1);
   add(l2);
   add(t2);
   add(l3);
   add(c1);
   add(c2);
   add(submit);
   add(t3);
   add(b1);
   add(b2);
   add(b3);
   add(b4);
   add(t4);
   submit.addActionListener(this);
   b1.addActionListener(this);
   b2.addActionListener(this);
   b3.addActionListener(this);
   b4.addActionListener(this);
   setSize(500,500);
   setVisible(true);
   setLayout(new FlowLayout());
   MyAdap mw=new MyAdap(this);
   addWindowListener(mw);
  }
  public void actionPerformed(ActionEvent ae)
  {
     if(ae.getSource()==submit)
    {
       ++i;
       name=t1.getText();
       reg=t2.getText();
       String s="Name is :"+t1.getText()+"\n"+"Register number is:"+t2.getText()+"\n"+"Gender is:"+"\r\n";
        if(c1.getState()==true)
        {
           s+="Male"+"\r\n";
           gender="male";
        }
        if(c2.getState()==true)
        {
           s+="Female"+"\r\n";
           gender="female";
        }
       t3.append(s);
       try
       {
         ps.setInt(1,i);
         ps.setInt(2,Integer.parseInt(reg));
         ps.setString(3,name);
         ps.setString(4,gender);
         ps.executeUpdate();
       }
       catch(Exception e)
       {
         e.printStackTrace();
       }
    }
    if(ae.getSource()==b1)
    {
      try
      {
        rs=st.executeQuery("Select * from STUD");
        rs.first();
        s2="Reg no is"+rs.getInt(2)+"\n"+"Name is :"+rs.getString(3)+"\n"+"Gender is :"+rs.getString(4)+"\n";
        t4.append(s2);
        rs.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    if(ae.getSource()==b2)
    {
       try
      { 
        rs=st.executeQuery("Select * from STUD");
        rs.first();
        rs.next();
        s2="Reg no is"+rs.getInt(2)+"\n"+"Name is :"+rs.getString(3)+"\n"+"Gender is :"+rs.getString(4)+"\n";
        t4.append(s2);
        rs.close();
      }
      catch(Exception e)
      {
        e.printStackTrace();
      }
    }
    if(ae.getSource()==b3)
    {
      try
      {
         rs=st.executeQuery("Select * from STUD");
        rs.last();
        rs.previous();
        s2="Reg no is "+rs.getInt(2)+"\n"+"Name is :"+rs.getString(3)+"\n"+"Gender is :"+rs.getString(4)+"\n";
        t4.append(s2);
        rs.close();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
    }
    if(ae.getSource()==b4)
    {
      try
      {
          rs=st.executeQuery("Select * from STUD");
        rs.last();
        s2="Reg no is"+rs.getInt(2)+"\n"+"Name is :"+rs.getString(3)+"\n"+"Gender is :"+rs.getString(4)+"\n";
        t4.append(s2);
        rs.close();
      }
      catch(Exception e)
      {
         e.printStackTrace();
      }    
    }
  } 
  public static void main(String ar[ ])throws Exception
  {
   Details d=new Details();
  }
}
class MyAdap extends WindowAdapter
{
  Details d1;
  MyAdap(Details d2)
  {
    d1=d2;
  }
  public void windowClosing(WindowEvent we)
  {
   d1.setVisible(false);
   System.exit(0); 
  }
} 