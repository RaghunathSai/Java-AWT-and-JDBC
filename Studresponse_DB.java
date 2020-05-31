import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Studresponse_DB extends Frame implements ActionListener
{   Button b1,b2,b3,b4,b5,search;
String s=new String("");
String s2;int flag=0;
TextArea t5;
Label l1,l2,l3,l4,l5,l6,l7,l8,l9,p1,p2,p3; 
TextField t1,t2,t3,t4;
Checkbox c1,c2,c4,c5,c6;
CheckboxGroup cg;
Choice d1,d2,d3,d4,d5,d6;
int i;
List k1;
 Connection conn;
     PreparedStatement ps;
     Statement st;
     ResultSet rs1,rs2;
        Studresponse_DB()
    {  l1 = new Label("Reg. no");
       t1 = new TextField(18);
       l2 = new Label("Name");
       t2 = new TextField(18);
       l3 = new Label("Address");
       t3 = new TextField(18);
       l4 = new Label("Email ID");
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
       t5 = new TextArea("",20,60);
       b1 = new Button("    insert     ");
 b2 = new Button("<<");
      b3 = new Button("<");
 b4 = new Button(">");
 b5 = new Button(">>");  
search=new Button("    search    ");
       add(l1);add(t1);
       add(l2);add(t2);
       add(l3);add(t3);
       add(l4);add(t4);
       add(l5);add(c1);
       add(c2);
       d1.addItem("B.tech");
       d1.addItem("M.tech");
       add(l6);add(d1);
       d2.addItem("CSE");
       d2.addItem("Civil");
       d2.addItem("Mech");
       d2.addItem("Elec");
       add(l7); add(d2);
       d3.addItem("1");
       d3.addItem("2");
       d3.addItem("3");
       d3.addItem("4");
       d3.addItem("5");
       add(l8); add(d3);
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
       add(l9);add(d4);add(d5);
       add(d6);add(p1);add(c4);
       add(c5);add(c6);
       k1.add("Basketball");
       k1.add("Football");
       k1.add("Volleyball");
       k1.add("Tennis");
       k1.add("Cricket");
       k1.add("Dance");
       k1.add("Singing");
       k1.add("Theatre");
       add(p2);add(k1);
       add(t5);add(b1);
add(search);
add(b2);add(b3);
add(b4);add(b5);
       b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);
b5.addActionListener(this);
search.addActionListener(this);
              setLayout(new FlowLayout());
       setVisible(true);
       setSize(600,600);
       MyAdap mw = new MyAdap(this);
      addWindowListener(mw);
dbFn(); 
    }
void dbFn(){
try{     
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
     String url = "jdbc:derby:student_cse_Dsec;create=true";
 //String url = "jdbc:derby:student_cse_Dsec";
     String username = "xx";
     String password = "xx";
     conn = DriverManager.getConnection(url);
     //st = conn.createStatement();
 st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
st.executeUpdate("DROP TABLE STUD");
//make it in single line
 st.executeUpdate("CREATE TABLE STUD (REGNO INT, NAME CHAR(25), HOBY CHAR(50), GENDER CHAR(6), DEGREE CHAR(6),BRANCH CHAR(6), YEAROFSTUDY CHAR(4),DOB CHAR(20),ADDRESS CHAR(75),EXTRACURICULAR CHAR(50),EMAIL CHAR(25) )");
     ps = conn.prepareStatement("INSERT INTO STUD VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?)");
rs1=st.executeQuery("select * from STUD");
}
catch(Exception e){
System.out.println(e);
}
}
void insert(){
flag=0;
try{
t5.setText("");
s="";                  
                 s2=t1.getText();
                  if(s2.length()!=9){flag=1;t5.append("Registration number not 9 digits"+"\n");}
                  s2=t2.getText();
	if(s2.equals(""))
                 {flag=1;t5.append("name cannot be empty"+"\n");}               
    if(flag==0){ 
ps.setInt(1, Integer.parseInt(t1.getText())); 
System.out.println("1"+t1.getText()); 
ps.setString(2, t2.getText() );
System.out.println("2"+t2.getText());
if(c4.getState()==true)
s=s+c4.getLabel()+"\n";
if(c5.getState()==true)
s=s+c5.getLabel()+"\n";
if(c6.getState()==true)
s=s+c6.getLabel()+"\n";
 ps.setString(3, s ); 
System.out.println("3"+s);  
s="";
if(c1.getState()==true)
s=s+c1.getLabel();
else 
s=s+c2.getLabel();  
ps.setString(4, s );  
System.out.println("4"+s);
ps.setString(5,d1.getSelectedItem()); 
System.out.println("5"+d1.getSelectedItem());
ps.setString(6,d2.getSelectedItem());    
System.out.println("6"+d2.getSelectedItem());       	
ps.setString(7,d3.getSelectedItem());  
System.out.println("7"+d3.getSelectedItem());
s=""; 
s=s+d4.getSelectedItem()+"/"+d5.getSelectedItem()+"/"+d6.getSelectedItem();
ps.setString(8 ,s);  
System.out.println("8"+s);
ps.setString(9,t3.getText() );
System.out.println("9"+t3.getText());
s="";
String s1[] = k1.getSelectedItems();
for(i=0;i<s1.length;i++)
 s=s+s1[i]+"\n";
 ps.setString(10,s );   
System.out.println("10"+s);
ps.setString(11,t4.getText());
System.out.println("11"+t4.getText());
ps.executeUpdate();
//rs1.close();
rs1=st.executeQuery("select * from STUD");
     }
}catch(Exception e1) {System.out.println("EXCEPTION"+e1);}
}
void display_nav(int i)
{t5.setText("");
try{
     if(i==1)
   rs1.first();
else if(i==2){   
if (!rs1.previous())
   rs1.last();
}
   else if(i==3){
if (!rs1.next())
rs1.first();
}
 else if(i==4)
   rs1.last();
       t5.append("Registration number is :"+rs1.getInt(1));
       t5.append("\nStudent name is :"+rs1.getString(2));
       t5.append("\n"+rs1.getString(2) +"hobbies :"+rs1.getString(3));
      t5.append("\n"+rs1.getString(2) +"is:"+rs1.getString(4));
t5.append("\n"+rs1.getString(2)+" studying in:"+rs1.getString(5)+"  "+rs1.getString(6)+" "+rs1.getString(7)+" year");
t5.append("\n"+rs1.getString(2) +"DOB is:"+rs1.getString(8));
t5.append("\n"+rs1.getString(2) +"address is:"+rs1.getString(9));
t5.append("\n"+rs1.getString(2) +"ECA:"+rs1.getString(10));
t5.append("\n"+rs1.getString(2) +"email id is:"+rs1.getString(11));
     
}catch(Exception e){
System.out.println(e);
}
}
void display( ){
	try
{   
     int i=Integer.parseInt (t1.getText());
System.out.println(i);
     rs2 = st.executeQuery("select * from STUD where REGNO ="+i);     
   if(rs2.next())   {
     t5.setText("");
    t5.append("Registration number is :"+rs2.getInt(1));
       t5.append("\nStudent name is :"+rs2.getString(2));
       t5.append("\n"+rs2.getString(2) +"hobbies :"+rs2.getString(3));
      t5.append("\n"+rs2.getString(2) +"is:"+rs2.getString(4));
t5.append("\n"+rs2.getString(2)+" studying in:"+rs2.getString(5)+"  "+rs2.getString(6)+" "+rs2.getString(7)+" year");
t5.append("\n"+rs2.getString(2) +"DOB is:"+rs2.getString(8));
t5.append("\n"+rs2.getString(2) +"address is:"+rs2.getString(9));
t5.append("\n"+rs2.getString(2) +"ECA:"+rs2.getString(10));
t5.append("\n"+rs2.getString(2) +"email id is:"+rs2.getString(11));
     rs2.close();
     }
}     
     catch(Exception e){
System.out.println(e);
}
}
    public void actionPerformed(ActionEvent e)    {
try{
if(e.getSource()==b1){
insert();
}
if(e.getSource()==search){
display();
}
if (e.getSource() == b2) {
display_nav(1);
}
if (e.getSource() == b3){
  display_nav(2);
}
if (e.getSource() == b4)
 {display_nav(3);}
else if (e.getSource()==b5)
{
display_nav(4);
}
}
catch(Exception ex){
System.out.println(ex);
}				
    }    
    String toString(int k)
    {return ""+k+"";}
    public static void main(String args[])
    {  Studresponse_DB l = new Studresponse_DB(); }
}
class MyAdap extends WindowAdapter{
     Studresponse_DB lk1;
    MyAdap(Studresponse_DB a)
    {  lk1 = a; }
    public void windowClosing(WindowEvent w)
   {  
try{
lk1.st.close();
lk1.conn.close();
lk1.rs1.close();
//lk1.rs2.close();
lk1.setVisible(false);  System.exit(0);    
}
catch(Exception e)
{
System.out.println(e);
}
   }
}