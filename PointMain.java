import java.io.*;
import java.util.*;

class Point
{
		private double x,y;
		
		public Point()
		{
			this.x=0;
			this.y=0;
		}
		
		public Point(double x,double y)
		{
			this.x = x;
			this.y = y;
		}
		
		public Point(Point p)
		{
			this.x = p.x;
			this.y = p.y;
		}
		
		public double findDistance(Point p)
		{
			double d;
			double x1,y1,x2,y2;
			
			x1 = this.x;			
			y1 = this.y;
			
			x2 = p.x;
			y2 = p.y;
			
			d = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
			
			return d;
			
		}
		public double findDistance(double x, double y)
		{
			double d;
			double x1,y1,x2,y2;
			
			x1 = this.x;			
			y1 = this.y;
			
			x2 = x;
			y2 = y;
			
			d = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
			
			return d;
			
		}
		public String getPoint()
		{
			return("("+x+","+y+")");
		}
}

class PointMain
{
	public static void main(String[] arg) throws IOException
	{
		Scanner in = new Scanner(System.in);
		
		int op;
		 double x,y,dist;
		ArrayList<Point> p = new ArrayList<Point>();
		
		
		do
		{
			System.out.println("\n\n1. Add a new Point....\n2. Find Distance...\n3. Show All Points\n4. Exit...");
			System.out.print("\nEnter Your Option: " );
			op = Integer.parseInt(in.nextLine());
			switch(op)
			{
				case 1:
								System.out.print("\nEnter Point (x,y):" );
								x = Double.parseDouble(in.nextLine());
								y = Double.parseDouble(in.nextLine());
			
								p.add(new Point(x,y));
								break;
				case 2:
								for(int i=0;i<p.size();i++)
								{		
									for(int j=i+1;j<p.size();j++)
									{
										dist = p.get(i).findDistance(p.get(j));
										System.out.println("\nDistance between "+p.get(i).getPoint()+" and "+ p.get(j).getPoint()+" is: "+dist);
									}
								}
								break;
				case 3:
								System.out.println("The Points are: ");
								for(Point p1:p)
								{	
									System.out.println(p1.getPoint());
								}
								break;
				case 4:
								System.out.println("\n\nThank you...\n\n");
								break;
				default:
								System.out.println("\nInvalid Option...");
								
			}
		}while(op!=4);
	}
}
		
