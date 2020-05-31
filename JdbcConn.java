import java.sql.*;

public class JdbcConn {
   public static void main(String[] args) {
      try {
         Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
      } catch(ClassNotFoundException e) {
         System.out.println("Class not found "+ e);
      }
      System.out.println("JDBC Class found");
      int no_of_rows = 0;
      
      try {
         Connection con = DriverManager.getConnection (
            "jdbc:derby:Stud;create=true");  
         Statement st = con.createStatement();
         st.executeUpdate("CREATE TABLE Stud(Reg.no INT,Name Char(30))");
         ResultSet rs = stmt.executeQuery ("SELECT * FROM Stud");
         while (rs.next()) {
            no_of_rows++;
         }
         System.out.println("There are "+ no_of_rows + " record in the table");
      } catch(SQLException e){
         System.out.println("SQL exception occured" + e);
      }
   }
}