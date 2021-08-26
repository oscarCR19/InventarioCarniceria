
package Main;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static void main(String args[]) {
     Connection c = null;
      Statement stmt = null;
      ResultSet rs;
      try {
         Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/ChirricheDataBase",
            "postgres", "root1234");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
          rs = stmt.executeQuery("select * from carniceria.\"inventarioCentral\"");
         while ( rs.next() ) {
            int id = rs.getInt("idProducto");
            String  name = rs.getString("nombreProducto");
            
            System.out.println( "ID = " + id );
            System.out.println( "NAME = " + name );
            
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
      }
      System.out.println("Operation done successfully");
   }
   
    
            
}
