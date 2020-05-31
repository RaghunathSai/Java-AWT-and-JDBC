import java.awt.*;
import java.applet.*;
import java.awt.event.*;
/*<applet code="cal" width=250 height=220>
</applet>*/
public class cal extends Applet implements ActionListener{
	Button b[]=new Button[10];
	Button plus;
	Button minus;
	Button mul;
	Button div;
	Button equal;
	Button mplus;
	Button mminus;
	Button mc;
	Button mr;
	Button ms;
	BorderLayout blo;
	GridLayout glo;
	TextField txt;
	int x,y,z,temp=0;
	char op;
	Panel p=new Panel();
	String status;
	public void init(){
		blo=new BorderLayout(30,30);
		glo=new GridLayout(5,3,5,5);
		txt=new TextField(10);
		setLayout(blo);
		add(txt,BorderLayout.NORTH);
		add(p,BorderLayout.SOUTH);
		p.setLayout(glo);
		for(int i=0;i<10;i++)
		{
			b[i]=new Button(i+"");
			b[i].addActionListener(this);}
		for(int i=0;i<10;i++)
		{p.add(b[i]);}
		mplus  =new Button("M+");
		p.add(mplus);
		mminus=new Button("M-");
		p.add(mminus);
		mr=new Button("MR");
		p.add(mr);
		mc=new Button("MC");
		p.add(mc);
		ms=new Button("MS");
		p.add(ms);
		plus=new Button("+");
		p.add(plus);
		minus=new Button("-");
		p.add(minus);
		mul=new Button("*");
		p.add(mul);
		div=new Button("/");
		p.add(div);
		equal=new Button("=");
		p.add(equal);
		mplus.addActionListener(this);
		mminus.addActionListener(this);
		mc.addActionListener(this);
		mr.addActionListener(this);
		ms.addActionListener(this);
		plus.addActionListener(this);
		minus.addActionListener(this);
		mul.addActionListener(this);
		div.addActionListener(this);
		equal.addActionListener(this);
		p.setBackground(Color.black);
		setBackground(Color.black);
		
	}
	public void actionPerformed(ActionEvent ae)
		{
		if(ae.getSource()==plus)
		{x=Integer.parseInt(txt.getText());
		txt.setText("");
		op='+';
		status=x+"+";
		showStatus(status);}
		else if(ae.getSource()==minus)
		{x=Integer.parseInt(txt.getText());
		txt.setText("");
		op='-';
		status=x+"-";
		showStatus(status);}
		else if(ae.getSource()==mul)
		{x=Integer.parseInt(txt.getText());
		txt.setText("");
		op='*';
		status=x+"*";
		showStatus(status);}
		else if(ae.getSource()==div)
		{x=Integer.parseInt(txt.getText());
		txt.setText("");
		op='/';
		status=x+"/";
		showStatus(status);}
		else if(ae.getSource()==ms)
		{
		showStatus("");
		temp=Integer.parseInt(txt.getText());
		showStatus("Value stored in temp");
		}
		else if(ae.getSource()==mr)
		{
		String s1=String.valueOf(temp);
		txt.setText(s1);
		showStatus("");
		showStatus("temp is displayed");
		}
		else if(ae.getSource()==mplus)
		{
		x=Integer.parseInt(txt.getText());
		String s1=String.valueOf((x+temp));
		txt.setText(s1);
		showStatus("");
		showStatus("added");
		}
		else if(ae.getSource()==mminus)
		{
		x=Integer.parseInt(txt.getText());
		String s1=String.valueOf((x-temp));
		txt.setText(s1);
		showStatus("");
		showStatus("subtracted");
		}
		else if(ae.getSource()==mc)
		{
		temp=0;
		showStatus("");
		showStatus("temp is cleared");
		}
		else if(ae.getSource()==equal)
		{y=Integer.parseInt(txt.getText());
		status+=y+"";
		showStatus(status);
		switch(op)	
		{case '+':
		z=x+y;
		break;
		case '-':
		z=x-y;
		break;
		case '*':
		z=x*y;
		break;
		case '/':
		z=x/y;
		break;}
		txt.setText(z+"");}
		else{txt.setText(txt.getText()+ae.getActionCommand());}}
	public Insets getInsets(){
		return new Insets(20,20,20,20);}
}
		
		