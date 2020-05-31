import java.io.*;
class ArrayThread
{
  int t[ ];
  boolean sorted;
  ArrayThread(int s[ ])
  {
    t=s;
  }
   public synchronized void sort()
   {
     for(int i=0;i<t.length;i++)
     {
       for(int j=i+1;j<t.length;j++)
       {
         int temp=t[i];
         t[i]=t[j];
         t[j]=temp;
       }
     }
    sorted = true;
    notify();
   }
   
   public synchronized float average()
   {
      if(!sorted)
      {
         try
         {
            wait(3000);
         }
         catch(Exception e)
         {
           System.out.println(e);
         }
      }
       float avg=(t[0]+t[t.length-1])/2.0f;
       return avg;
   }
}
class SortThread extends Thread
{
   ArrayThread a;
  SortThread(ArrayThread at1)
  {
    a=at1;
  }
   public void run()
   {
     a.sort();
   }
  
}
class AvgThread extends Thread
{
   ArrayThread a;
  AvgThread(ArrayThread at1)
  {
   a=at1;
  }
  public void run()
  {
   System.out.println(a.average());
  }
}
class Threadtest
{
 public static void main(String ar[ ])throws IOException
{
  int a[ ]={21,23,1,47,15,54
};
   ArrayThread k=new ArrayThread(a);
   SortThread st=new SortThread(k);
   AvgThread at=new AvgThread(k);
   st.start();
   at.start();  
  System.out.println("priority of sort thread ="+st.getPriority()); 
  System.out.println("priority of average thread ="+at.getPriority());
 
 } 
}
