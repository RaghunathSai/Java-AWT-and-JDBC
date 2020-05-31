import java.util.*;
class Tc{
	int n;
	boolean valueset =true;
	Tc(){
		n=0;
	}
	synchronized void bookTicktes(){ System.out.println("before");
		 while(!valueset)
		 try {    
                                            
			     wait(); 
                                            System.out.println("after");

			}catch(Exception e){
					 System.out.println("InterruptedException caught"); 
				}
				System.out.println("enter no of tickets to be booked");
				Scanner sc=new Scanner(System.in);
				int nc=sc.nextInt();
				n=n+nc;
		System.out.println(n+"  tickets booked sucessfully  ");
		valueset=false;
		notify();
	}
	synchronized void cancleTicktes(){
			 while(valueset)
		 try {    
			     wait(); 
			}catch(Exception e){
				 System.out.println("InterruptedException caught"); 
					}
		System.out.println("enter no of tickets to be Cancled");
			Scanner sc=new Scanner(System.in);
			int nc=sc.nextInt();
			n=n-nc;
		System.out.println(n+"  tickets present now sucessfully  ");
		valueset=true;
		notify();
		}
	}
class Booking implements Runnable{
	Tc c;
	Booking(Tc tc1){
		this.c=tc1;
		new Thread(this,"Booking").start();
	}
	public void run(){
		while(true){
		
			c.bookTicktes();
		}
		}
}
class Canceling implements Runnable{
	Tc c;
	Canceling(Tc tc2){
		this.c=tc2;
		new Thread(this,"Cancle").start();
	}
	public void run(){
		while(true){
		
			c.cancleTicktes();
		}
		}
}
class Customer{
	String name;
	Tc c1;
	Booking book;
	Canceling cancel;
	Customer(String name){
		this.name=name;
	}
	Customer(){name="";}
	void startTransaction(){
		c1=new Tc();
		book=new Booking(c1);
		cancel=new Canceling(c1);
	}
}
class Demo1{
	public static void main(String args[]){
		System.out.println("jfjhjjh");
		Customer c=new Customer();
		c.startTransaction();
	}
}
		




























	
	
	