import java.io.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*<applet code ="Tank2" width=400 height=400>
  </applet code>*/

public class Tank2 extends Applet implements Runnable,ActionListener
{
  Button Start,Stop,Resume,Suspend;
  boolean stopflag=false,suspendflag=false;
  int height=0;
  Thread t;
  public void init()
  {
   Start=new Button("Start");
   Stop=new Button("Stop");
   Resume=new Button("Resume");
   Suspend=new Button("Suspend");
   Start.addActionListener(this);
   Suspend.addActionListener(this);
   Stop.addActionListener(this);
   Resume.addActionListener(this);
   add(Start);
   add(Stop);
   add(Resume);
   add(Suspend);
   Suspend.setEnabled(false);
   Stop.setEnabled(false);
   Resume.setEnabled(false);  
  }
  public void run()
  {
    try
    {
     while(!stopflag)
     {
      if(!suspendflag)
      {
       height+=10;
      }
      if(height>200) 
        height=0;
      repaint();
      Thread.sleep(1000);
     }
    }
    catch(InterruptedException e)
    {
     e.printStackTrace();
    }
  }
  public void actionPerformed(ActionEvent ae)
  {
   t=new Thread(this);
   if(ae.getSource()==Start)
   {
     Stop.setEnabled(true);
     Suspend.setEnabled(true);
     Resume.setEnabled(false);
     height=0;
     stopflag=false;
     t.start();
     
   }
   if(ae.getSource()==Stop)
   {
    Start.setEnabled(true);
    Suspend.setEnabled(false);
    Resume.setEnabled(false);
    stopflag=true;
    height=-10;
   }
   if(ae.getSource()==Suspend)
   {
    Stop.setEnabled(false);
    Start.setEnabled(false);
    Resume.setEnabled(true);
    suspendflag=true;
   }
   if(ae.getSource()==Resume)
   {
    Stop.setEnabled(true);
    Start.setEnabled(false);
    Suspend.setEnabled(true);
    suspendflag=false;
   }
    
  }
  public void paint(Graphics g)
  {
   g.drawLine(100,300,300,300);
   g.drawLine(100,300,100,100);
   g.drawLine(300,300,300,100);
   g.setColor(Color.BLUE);
   g.fillRect(100,300-height,200,height);
     
  }
 }