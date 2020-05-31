import java.awt.*;
import java.awt.event.*;
public class Studresponse extends Frame implements ActionListener
{   Button b1;TextArea t5;Label l1,l2,l3,l4,l5,l6,l7,l8,l9,p1,p2,p3; TextField t1,t2,t3,t4;Checkbox c1,c2,c4,c5,c6;CheckboxGroup cg;Choice d1,d2,d3,d4,d5,d6;int i;List k1;
    Studresponse()
    {  
setLayout(new FlowLayout());
l1 = new Label("Reg. no"); 
       t1 = new TextField(18);   l2 = new Label("Name");
       t2 = new TextField(18);    l3 = new Label("Address");
       t3 = new TextField(18);      l4 = new Label("Email ID");
       t4 = new TextField(18);
       l5 = new Label("Gender");
       cg = new CheckboxGroup();
       c1 = new Checkbox("Male",cg,false);
       c2 = new Checkbox("Female",cg,false);
       l6 = new Label("Degree");       
       d1 = new Choice();
       l7 = new Label("Branch");
       d2 = new Choice();
l8 = new Label("Year of Study");
       d3 = new Choice();
       l9 = new Label("Date of Birth");
       d4 = new Choice();
       d5 = new Choice();
       d6 = new Choice();
p1 = new Label("Hobbies");
       c4 = new Checkbox("Stamp Collection");
       c5 = new Checkbox("Reading Novels");
       c6 = new Checkbox("Playing Tennis");
       k1 = new List(3,true);
       p2 = new Label("Extra Curricular Activities");
       p3 = new Label("Entered details");
       t5 = new TextArea("",10,40);
       b1 = new Button("Submit");
	  // Label l10;
	   //l10= new Label("\n Department");
       add(l1);
       add(t1);
       add(l2);
       add(t2);
       add(l3);
       add(t3);
	   //add(l10);
       add(l4);
       add(t4);
       add(l5);
       add(c1);
       add(c2);
       d1.addItem("B.tech");
       d1.addItem("M.tech");
       add(l6);
       add(d1);
       d2.addItem("CSE");
       d2.addItem("Civil");
       d2.addItem("Mech");
       d2.addItem("Elec");
       add(l7);
       add(d2);
       d3.addItem("1");
       d3.addItem("2");
       d3.addItem("3");
       d3.addItem("4");
       d3.addItem("5");
       add(l8);
       add(d3);
       for(i=1;i<=31;i++)
       	d4.addItem(toString(i));
       d5.addItem("January");
       d5.addItem("February");
       d5.addItem("March");
       d5.addItem("April");
       d5.addItem("May");
       d5.addItem("June");
       d5.addItem("July");
       d5.addItem("August");
       d5.addItem("September");
       d5.addItem("Ocotber");
       d5.addItem("November");
       d5.addItem("December");
       for(i=1995;i<=2014;i++)
       d6.addItem(toString(i));
       add(l9);
       add(d4);
       add(d5);
       add(d6);
       add(p1);
       add(c4);
       add(c5);
       add(c6);
       k1.add("Basketball");
       k1.add("Football");
       k1.add("Volleyball");
       k1.add("Tennis");
       k1.add("Cricket");
       k1.add("Dance");
       k1.add("Singing");
       k1.add("Theatre");
       add(p2);
       add(k1);
       add(t5);
       add(b1);
       b1.addActionListener(this);
              
       setVisible(true);
       setSize(500,500);
       MyAdap mw = new MyAdap(this);
      addWindowListener(mw);
    }
public void actionPerformed(ActionEvent e)
    {
    	t5.append("registration number is"+t1.getText()+"\n");
                  t5.append("Name is"+t2.getText()+"\n");
                  t5.append("Address is"+t3.getText()+"\n");
                  t5.append("email ID is"+t4.getText()+"\n");
                
t5.append("Student's gender is"+cg.getSelectedCheckbox().getLabel()+"\n");
if(c4.getState()==true)t5.append("Student's hobby is"+c4.getLabel()+"\n");
                	if(c5.getState()==true)t5.append("Student's hobby is"+c5.getLabel()+"\n");
                	if(c6.getState()==true)t5.append("Student's hobby is"+c6.getLabel()+"\n");
                	t5.append("Student is in degree"+d1.getSelectedItem()+"\n");
                	t5.append("Student is in branch"+d2.getSelectedItem()+"\n");
                	t5.append("Student is in year"+d3.getSelectedItem()+"\n");
t5.append("Student is in year"+d4.getSelectedItem()+"/"+d5.getSelectedItem()+"/"+d6.getSelectedItem()+"\n");
String s[] = k1.getSelectedItems();
for(i=0;i<s.length;i++)
  t5.append("Student is also interested and pariticpates in"+s[i]+"\n");
      }
        String toString(int k)
    {return ""+k+"";}
    public static void main(String args[])
    {  Studresponse l = new Studresponse(); }
}
class MyAdap extends WindowAdapter
{      Studresponse lk1;
    MyAdap(Studresponse a)
    {  lk1 = a; }
    public void windowClosing(WindowEvent w)
   {  lk1.setVisible(false);  System.exit(0);
   }
}




