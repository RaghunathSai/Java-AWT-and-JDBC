class StringBufferDemo
{
 public static void main(String ar[ ])
 {
  StringBuffer sb=new StringBuffer("Hello World");
  System.out.println("length="+sb.length());
  System.out.println("capacity="+sb.capacity());
  System.out.println("charAt(6) before="+sb.charAt(6));
  sb.setCharAt(6,'i');
  sb.setLength(8);
  System.out.println("buffer="+sb);
  System.out.println("charAt(6) after="+sb.charAt(6));
 }
}
  