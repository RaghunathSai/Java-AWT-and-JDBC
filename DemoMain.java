// A correct implementation of a producer and consumer. 
class Q
 { 
     
     int queue[ ]=new int[3];
    int front=-1,rear=-1;
    boolean full=false,empty=true;
    synchronized void get()
    {    
        while(empty)      
        { try 
         {         wait();       }
        catch(InterruptedException e) 
        {         System.out.println("InterruptedException caught");       }  }
       System.out.println("Got: " + queue[front++]);   
      if(front==3&&rear==2)
      {
        empty=true;
        full=false;
        rear=-1;
        front=-1;
      }
       notify();
   } 
 
  synchronized void put(int n) 
  { 
      while(full)   
      {  try {         wait();       }
        catch(InterruptedException e)
          {         System.out.println("InterruptedException caught");       } } 
     queue[++rear] = n;         
    if(rear==2)
    {
      full=true;
      empty=false;
    }      
     System.out.println("Put: " + queue[rear]); 
    if(front==-1)
     front++;
     notify();   
 }
 } 
 
class Producer implements Runnable
 { 
     Q q; 
 
  Producer(Q q)
  {     this.q = q;     
        new Thread(this, "Producer").start();   
} 
 
  public void run() 
 {     int i = 0; 
    while(true) 
    {       q.put(i++);     }
   }
 } 
 
class Consumer implements Runnable 
{   Q q; 
 
  Consumer(Q q)
  {     this.q = q;    
       new Thread(this, "Consumer").start();   } 
 
  public void run() 
  {     while(true) {       q.get();     }   
   }
 } 
 
class DemoMain
 {   public static void main(String args[])
     {     Q q = new Q();     
         new Producer(q);     
         new Consumer(q); 
        System.out.println("Press Control-C to stop.");   
   }
 }