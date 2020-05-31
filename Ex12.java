import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.sql.*;


class MyWindow extends Frame implements WindowListener
{
	MyWindow()
	{
		addWindowListener(this);
		setTitle("My First Window");
		setSize(600,650);
		setLayout(null);
		setVisible(true);
	}
	public void windowClosed(WindowEvent e)
	{}
	public void windowOpened(WindowEvent e)
	{}
	public void windowActivated(WindowEvent e)
	{}
	public void windowDeactivated(WindowEvent e)
	{}
	public void windowIconified(WindowEvent e)
	{}
	public void windowDeiconified(WindowEvent e)
	{}
	public void windowClosing(WindowEvent e)
	{
		setVisible(false);
		System.exit(0);	
	}
}
class MyStudentForm extends MyWindow implements ActionListener
{
	Label[] l = new Label[12];
	Panel[] p = new Panel[12];
	TextField name,rno,email;
	Choice degree, branch, yos, dd,mm,yy;
	TextArea address, summary;
	Checkbox hobby1,hobby2,hobby3;
	Checkbox male,female;
	CheckboxGroup gender;
	List extra;
	Button bsummary,badd,bclear,bsearch,bupdate;
	Button bnext, bprevious, bfirst, blast;
	
	String strno,stname,stgender,stemail,stdegree,stbranch,styos,stdob,staddress,sthobby,stextra;

	//Database related objects
	Connection conn;
    PreparedStatement ps;
    Statement st,stShow;
    ResultSet rs,rsShow;
	
	
	MyStudentForm()
	{
		

		l[0] = new Label("Register No");
		l[1] = new Label("Name");
		l[2] = new Label("Gender");
		l[3] = new Label("Degree");		
		l[4] = new Label("Branch");
		l[5] = new Label("Year of Study");
		l[6] = new Label("Date of Birth");
		l[7] = new Label("Address");
		l[8] = new Label("Email Id");
		l[9] = new Label("Hobby");
		l[10] = new Label("Extra Curricular Activities");
		l[11] = new Label("You Entered");
		
		
		for(int i=0;i<12;i++)
		{
			p[i] = new Panel();
		}
		
		rno = new TextField(20);
		name = new TextField(20);
		email= new TextField(20);
		
		degree = new Choice();
		degree.add("B.Tech.");
		degree.add("M.Tech.");
		degree.add("M.C.A");
		
		branch = new Choice();
		branch.add("CSE");
		branch.add("IT");
		branch.add("ICT");
		
		yos = new Choice();
		yos.add("I");
		yos.add("II");
		yos.add("III");
		yos.add("IV");
		
		dd = new Choice();
		for(int i=1;i<=31;i++)
		{
			dd.add(""+i);
		}
		
		mm = new Choice();
		mm.add("January");
		mm.add("February");
		mm.add("March");
		mm.add("April");
		mm.add("May");
		mm.add("June");
		mm.add("July");
		mm.add("August");
		mm.add("September");
		mm.add("October");
		mm.add("November");
		mm.add("December");
		
		yy = new Choice();
		for(int i=2019;i>=1975;i--)
		{
			yy.add(""+i);
		}
		
		address = new TextArea(5,20);
		summary = new TextArea(10,50);
		
		hobby1 = new Checkbox("Programming");
		hobby2 = new Checkbox("Programming");
		hobby3 = new Checkbox("Programming");
		
		gender = new CheckboxGroup();	
		male = new Checkbox("Male",gender,true);
		female = new Checkbox("Female",gender,false);
		
		extra = new List(4,true);
		extra.add("Web Design");
		extra.add("Game Design");
		extra.add("Mobile Application Development");
		
		for(int i=0;i<12;i++)
		{
			p[i].add(l[i]);
		}
		
		p[0].add(rno);
		p[1].add(name);
		p[2].add(male);	p[2].add(female);
		p[3].add(degree);
		p[4].add(branch);
		p[5].add(yos);
		p[6].add(dd);	p[6].add(mm);	p[6].add(yy);
		p[7].add(address);
		p[8].add(email);
		p[9].add(hobby1);		p[9].add(hobby2);		p[9].add(hobby3);
		p[10].add(extra);
		p[11].add(summary);
		
		Panel mainpan = new Panel();
		mainpan.setLayout(new FlowLayout());
		mainpan.setBounds(30,50,500,600);
		for(int i=0;i<11;i++)
		{
			mainpan.add(p[i]);
		}
		
		bsummary = new Button("Summary");
		bupdate = new Button("Update");
		bclear = new Button("Clear");
		badd = new Button("Add");
		bsearch = new Button("Search");
		bnext = new Button(">");
		bprevious = new Button("<");
		bfirst = new Button("<<");
		blast = new Button(">>");
		
		

		bsummary.addActionListener(this);
		bupdate.addActionListener(this);
		bclear.addActionListener(this);
		badd.addActionListener(this);
		bsearch.addActionListener(this);
		bnext.addActionListener(this);
		bprevious.addActionListener(this);
		bfirst.addActionListener(this);
		blast.addActionListener(this);
		
		Panel py = new Panel();
		py.add(bsummary);
		py.add(bclear);
		py.add(bsearch);
		py.add(badd);
		py.add(bupdate);
		
		mainpan.add(py);
		
		mainpan.add(summary);
		
		Panel px = new Panel();
		px.add(bfirst);
		px.add(bprevious);
		px.add(bnext);
		px.add(blast);
		
		mainpan.add(px);
		
		
		add(mainpan);
	
		ConnectToDatabase();
	}

	void ConnectToDatabase()
	{
		try
		{     
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			String url = "jdbc:derby:mydatabase;create=true";
			String username = "xx";
			String password = "xx";
			conn = DriverManager.getConnection(url, username, password);
			
			st = conn.createStatement();
			st.executeUpdate("create table stud (rno char(10), name char(25), gender char(6), degree char(10), branch char(20), yos char(4), dob char(20), addr char(50), email char(20),hobby char(100), extra char(100))");
		}
		catch(Exception e)
		{
			System.out.println(e);
			//summary.setText(e.get);
		}
	}
	void GetFormDetails()
	{
		strno = rno.getText();
		stname = name.getText();
		staddress = address.getText();
		stemail = email.getText();
		stdegree = degree.getSelectedItem();
		stbranch= branch.getSelectedItem();
		styos = yos.getSelectedItem();
		stdob = dd.getSelectedItem()+"/"+mm.getSelectedItem()+"/"+yy.getSelectedItem();
		
		 if(male.getState()==true)
			stgender = male.getLabel();
    	else 
			stgender = female.getLabel();
		
		String s[] = extra.getSelectedItems();
		stextra="";
		for(int i=0;i<s.length;i++)
			stextra = stextra+s[i]+",";

		sthobby = "";
		if(hobby1.getState()==true)
				sthobby = sthobby + hobby1.getLabel()+", ";
 		if(hobby2.getState()==true)
				sthobby = sthobby + hobby2.getLabel()+", ";
		if(hobby3.getState()==true)
				sthobby = sthobby + hobby3.getLabel()+", ";
		
		
	}
	void InsertNewRecord()
	{
		try
		{
			GetFormDetails();
			ps = conn.prepareStatement("INSERT INTO STUD VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?)");
			
			ps.setString(1,strno);
			ps.setString(2,stname);
			ps.setString(3,stgender);
			ps.setString(4,stdegree);			
			ps.setString(5,stbranch);
			ps.setString(6,styos);
			ps.setString(7,stdob);
			ps.setString(8,staddress);		
			ps.setString(9,stemail);
			ps.setString(10,sthobby);
			ps.setString(11,stextra);
			
			ps.executeUpdate();
			
			System.out.println("Updated Successfully...");
			summary.setText("Updated Successfully...");
  
		}
		catch(Exception e1) 
		{
			System.out.println("EXCEPTION"+e1);
		}
	}
	void UpdateSummary()
	{
			summary.setText("");
			summary.append("Registration Number: "+strno+"\n");
			summary.append("Name:"+stname+"\n");
			summary.append("Address:"+staddress+"\n");
			summary.append("email ID:"+stemail+"\n");
			summary.append("Student's gender:"+stgender+"\n");
			summary.append("Student's hobby:"+sthobby+"\n");
			summary.append("Student's degree: "+stdegree+"\n");
			summary.append("Student's branch: "+stbranch+"\n");
			summary.append("Student's year of study: "+styos+"\n");
			summary.append("Student's DoB: "+stdob+"\n");
			summary.append("Student is also interested and pariticpates in: "+stextra+"\n");
	}
	public void actionPerformed(ActionEvent ae)
	{
		try
		{
		String Cmd = ae.getActionCommand();

		if(Cmd.equals("Summary"))
		{
			GetFormDetails();
			UpdateSummary();
		}
		else if(Cmd.equals("Clear"))
		{
			ClearForm();
		}
		else if(Cmd.equals("Add"))
		{
			ClearForm();			
		}
		else if(Cmd.equals("Update"))
		{
			InsertNewRecord();
			
		}
		else if(Cmd.equals("Search"))
		{
			strno = rno.getText();
			rs = st.executeQuery("select * from stud where rno ='"+strno+"'");
			if (rs.next())
			{
				SummaryDetails(rs);
			}
			else
			{
				summary.setText("No Records Found...");
			}
		}
		else if(Cmd.equals("<<"))
		{
			stShow = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_UPDATABLE);
			rsShow = stShow.executeQuery("select * from stud");
			if(rsShow.first())
			{
				SummaryDetails(rsShow);
			}
			else
			{
				summary.setText("No Records Found...");
			}
		}
		else if(Cmd.equals(">>"))
		{
			stShow = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,  ResultSet.CONCUR_UPDATABLE);
			rsShow = stShow.executeQuery("select * from stud");
			if(rsShow.last())
			{
				SummaryDetails(rsShow);
			}
			else
			{
				summary.setText("No Records Found...");
			}
		}
		else if(Cmd.equals(">"))
		{
			
			if(rsShow!=null && rsShow.next())
			{
				SummaryDetails(rsShow);
			}
			else
			{
				summary.setText("No Records Found...");
			}
		}
		else if(Cmd.equals("<"))
		{
			
			if(rsShow!=null && rsShow.previous())
			{
				SummaryDetails(rsShow);
			}
			else
			{
				summary.setText("No Records Found...");
			}
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void SummaryDetails(ResultSet rs)
	{
		try
		{
				//rs.next();
				strno = rs.getString(1);
				stname = rs.getString(2);
				stgender = rs.getString(3);
				stdegree = rs.getString(4);			
				stbranch = rs.getString(5);
				styos = rs.getString(6);
				stdob = rs.getString(7);
				staddress = rs.getString(8);		
				stemail = rs.getString(9);
				sthobby = rs.getString(10);
				stextra = rs.getString(11);
				UpdateSummary();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	void ClearForm()
	{
		name.getText();	
		rno.getText();
		email.getText();
		address.getText();
		
		rno.setText("");
		name.setText("");
		email.setText("");
		address.setText("");
		
		hobby1.setState(false);
		hobby2.setState(false);
		hobby3.setState(false);
		
		degree.select(0);
		branch.select(0);
		yos.select(0);
		yy.select(0);
		mm.select(0);
		dd.select(0);
		
		male.setState(true);
		
		for(int i=0;i<extra.getItemCount();i++)
			extra.deselect(i);
		
	}

}


public class Ex12
{
	public static void main(String[] arg)
	{
		new MyStudentForm();

		
	}
}