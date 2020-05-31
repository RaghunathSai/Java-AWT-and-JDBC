import java.awt.*;
import java.applet.*;
import java.awt.event.*;

/*<appletcode="Stuapp" width=250 height=250>
  </applet> */
public class Stuapp extends Applet implements ActionListener
{
  Button q1,q2,q3,b;
  TextArea t1;
  Checkbox c[ ]=new Checkbox[12];
  CheckboxGroup cg;
  String s=new String("");
  int correct=0; 
  public void init()
  {
     b=new Button("Submit");
   q1=new Button("Question1");
   q2=new Button("Question2");
   q3=new Button("Question3");
    b.addActionListener(this);
    q1.addActionListener(this);
    q2.addActionListener(this);
    q3.addActionListener(this);
   t1=new TextArea(10,20);
   cg=new CheckboxGroup();
    c[0]=new Checkbox("DELHI",cg,false);
    c[1]=new Checkbox("BOMBAY   ",cg,false);
    c[2]=new Checkbox(" HYD  ",cg,false);
    c[3]=new Checkbox("MADRAS   ",cg,false);
    c[4]=new Checkbox(" PM  ",cg,false);
    c[5]=new Checkbox(" CM  ",cg,false);
    c[6]=new Checkbox(" PRESIDENT  ",cg,false);
    c[7]=new Checkbox("  NONE ",cg,false);
    c[8]=new Checkbox(" INT   ",cg,false);
    c[9]=new Checkbox(" CHAR  ",cg,false);
    c[10]=new Checkbox("  STRING ",cg,false);
    c[11]=new Checkbox("  BOOL ",cg,false);
    add(t1);
    add(q1);add(c[0]);add(c[1]);add(c[2]);add(c[3]);
    add(q2);add(c[4]);add(c[5]);add(c[6]);add(c[7]);
    add(q3);add(c[8]);add(c[9]);add(c[10]);add(c[11]);
    add(b);
   
  }
  public void actionPerformed(ActionEvent ae)
  {
    if(ae.getSource()==q1)
     t1.append("Ques 1: Capital of india?");
    if(ae.getSource()==q2)
     t1.append("Ques 2:Powerful person in india?");
    if(ae.getSource()==q3)
     t1.append("Ques 3: what is datatype of 5?");    
    if(c[0].getState()==true)
    correct++;
    if(c[4].getState()==true)
    correct++;
    if(c[8].getState()==true)
    correct++;
   if(ae.getSource()==b)
    s="No.of Correct answers are:"+toString(correct);
       repaint();
  }
  public void paint(Graphics g)
  {
    g.drawString(s,10,10);
  }
  public String toString(int m)
  {
   return ""+m+"";
  }
}

