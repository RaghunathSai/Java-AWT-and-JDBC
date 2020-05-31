import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Formatter;
import java.util.Locale;
class SuperMarket
{
  String cust_name;
  int cust_type;
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  SuperMarket()
  {
    cust_type=0;
    System.out.println("            JVR Super Market            ");
    System.out.println("              Quality&Service              ");
  }
  void input()throws IOException
  {
    System.out.print("Enter Customer Name:");
    cust_name=br.readLine();
    System.out.println();
    System.out.print("Enter 1 for walk in ,2 for Regular ,3 for Loyal type of customer:");
    cust_type=Integer.parseInt(br.readLine());
  }
  String item_list[ ]={"1.Soap","2.Shampoo","3.WashingSoap","4.ToothPaste","5.ToothBrush","6.Dal","7.Rice","8.ToorDal","9.Chocolates","10.Biscuits","11.Milk","12.Curd","13.Cheese","14.Sweets","15.BakeryItems"};  
  double price_list[ ]={30,75,40,55,25,70,40,60,85,50,30,35,105,250,55};
  double quantity[ ]=new double[15];
  boolean taxable[ ]={true,true,true,true,true,false,false,false,false,false,true,false,true,false,true}; 
  // tax rate=0.125
  double price[ ]=new double[15];
  double taxamount[ ]=new double[15];
  double gst=0.0;
  double rebate=0.0;
  double total=0.0;
  double dis=0.0;
  void getquantity()throws IOException
  {
    System.out.println("Enter the quantity or number of items required as per the item");
    gst=0.0;
    for(int i=0;i<15;i++)
    {
      System.out.print(item_list[i]+" :");
      quantity[i]=Integer.parseInt(br.readLine());

      price[i]=quantity[i]*price_list[i];
      total+=price[i];

      if(taxable[i]==true)
       taxamount[i]=(price[i]*0.125);

      else
       taxamount[i]=0.0;


     gst=gst+(taxamount[i]);
    }
   System.out.println("gst ="+gst);
    if(cust_type==2)
    {
      dis=gst*0.1;
       gst=gst-dis;  
    }
    System.out.println("gst ="+gst);     
   if(cust_type==3)
   {
      dis=gst*0.1;
       gst=gst-dis;
     rebate=total*0.05;
      
   }
   System.out.println("gst ="+gst);
 }
  void display()
  {
    double sum=0.0;
    
    System.out.printf("%80s\n","JVR Super Market");
    System.out.printf("%80s\n","Quality&Service");
    System.out.println();
    System.out.println();
    System.out.println();
    String item_list1[ ]={"Soap","Shampoo","WashingSoap","ToothPaste","ToothBrush","Dal","Rice","ToorDal","Chocolates","Biscuits","Milk","Curd","Cheese","Sweets","BakeryItems"};
    System.out.println("Customer Name="+cust_name);
    System.out.println();
    System.out.println();
    System.out.printf("%5s %15s %20s %12s %25s %23s %22s\n","S.No ","Item Name","Quantity","Price","Taxable or Not","Tax","MRP");
    System.out.println();
    for(int i=0;i<15;i++)
    {
     
      if(taxable[i]==true)
      {
          String b="T";
          double t=(price[i]+taxamount[i]);
          sum=sum+t;
          System.out.printf( "%-10d %-25s %-10.2f %-25.2f %-25s %-25.4f %-25.4f\n",(i+1),item_list1[i],quantity[i],price[i],b,taxamount[i],t);
       }
     else
    {
          String a="NT";
          double t1=(price[i]+taxamount[i]);
          sum=sum+t1;
          System.out.printf( "%-10d %-25s %-10.2f %-25.2f %-25s %-25.4f %-25.4f \n",(i+1),item_list1[i],quantity[i],price[i],a,taxamount[i],t1);
     }
    
    System.out.println();
   
   }
   System.out.println();
   System.out.println();   
   System.out.println();
   sum=sum-dis;
   System.out.println("GST =  "+gst);
   System.out.println("Rebate=  "+rebate);   
   System.out.println("The amount to be paid= "+sum);
   Double cash;
   Scanner sc=new Scanner(System.in);
   System.out.println("enter the cash to pay");
   cash=sc.nextDouble();
   System.out.println("change:"+(cash-sum));  
 }  
}
class SuperMarketDemo
{
  public static void main(String ar[ ])throws IOException
  {
     BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    SuperMarket sd=new SuperMarket();
    int choice=1;
    do
   {
     sd.input();
     sd.getquantity();
     sd.display();
     System.out.printf("%80s","HAVE A NICE DAY !");
     System.out.println();
     System.out.println();
     System.out.println("    Enter 0 if there are no customers else press 1:    ");
     choice=Integer.parseInt(br.readLine());
   
    }while(choice!=0); 
  }
}