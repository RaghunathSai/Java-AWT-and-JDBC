import java.io.*;
class Railway implements Runnable
{
    public int nam,naf,nc;
    public boolean booked=false,cancelled=false;
    Thread t1,t2;
    Railway()
    {
      t1=new Thread();
      t2=new Thread();
      nam=naf=nc=0;
      t1.start();
      t2.start();
    }
    void getinput()throws IOException
    {
      BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
      System.out.println("Enter the no.of adult passengers male first,next female,next number of children :");
      nam=Integer.parseInt(br.readLine());
      naf=Integer.parseInt(br.readLine());
      nc=Integer.parseInt(br.readLine());
    
    }
    synchronized void booking()throws IOException
   {
    booked=false;
    System.out.println("Enter the details for booking:");
    this.getinput();
    System.out.println("Amount to be paid is:"+(((nam+naf)*425)+(nc*350)));
    booked=true;
   }
  synchronized void cancellation()throws IOException
  {
    cancelled=false;
    System.out.println("Enter the details for cancellation:");
    this.getinput();
    System.out.println("Amount to be refunded is:"+(((nam+naf)*325)+(nc*275)));
    cancelled=true;
  }
  Railway r1=new Railway();
  public void run()
  {
    while(!booked)
    {
     try
     {
     
      r1.booking();
      Thread.sleep(1000);
      
     }
     catch(InterruptedException e)
     {
      System.out.println("Interrupted Exception caught in cancellation");
     }
    }
    while(booked==true&&cancelled==false)
    {
     try
     {
     
      r1.booking();
      Thread.sleep(1000);
      
     }
     catch(InterruptedException e)
     {
      System.out.println("Interrupted Exception caught in cancellation");
     }
    }
  }
}
class Demo extends Railway 
{ 
  public static void main(String ar[])throws IOException
  {
    Railway r=new Railway();
  }
}