class Q
 { 
     int n;
     int queue[ ]=new int[3],rear=-1,front=-1;
     boolean full=false,empty=false; 
     synchronized void get() 
     {     
        while(empty)       
        try 
        {
           wait();   
         } 
         catch(InterruptedException e)
         {
           System.out.println("InterruptedException caught");
         } 
        System.out.println("Got: " + queue[front]);
        if(front==rear)
        {
           rear=-1;
           front=-1;
           empty=true;
         }
         else
          front+=1;
       if(rear<queue.length-1)
         full= false;
        notify(); 
      } 
     synchronized void put(int n) 
     {   
       while(full)   
       try 
       {
          wait();     
        }
        catch(InterruptedException e) 
        {
           System.out.println("InterruptedException caught");
        } 
       rear+=1;
       if(front==-1)
        front++;
       queue[rear]=n;
       
       System.out.println("Put: " + n);
       empty= false; 
        notify();
       }
     } 
   class Producer implements Runnable 
   {   
       Q q; 
       Producer(Q q) 
       {
           this.q = q;
           new Thread(this, "Producer").start();
       } 
      public void run()
      { 
         int i = 0; 
         while(true) 
         { 
           try
           {
             q.put(i++);
              if(i==q.queue.length)
                i=0;
               Thread.sleep(500); 
           }
           catch(InterruptedException e)
           {
              System.out.println(e);
           }
         }   
       }
     } 
   class Consumer implements Runnable
   {
       Q q; 
      Consumer(Q q) 
      {
           this.q = q;     new Thread(this, "Consumer").start();
      } 
      public void run() 
      {
          while(true)
          {  
             try
             {     
                   q.get();
                   Thread.sleep(1000);
             }
            catch(InterruptedException e)
            { System.out.println(e); }
          } 
       }
     } 
    class DemoThread 
    {   
       public static void main(String args[]) 
       {
            Q q = new Q();
            new Producer(q);     
            new Consumer(q); 
           System.out.println("Press Control-C to stop.");
        }
     }