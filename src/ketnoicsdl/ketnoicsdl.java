package ketnoicsdl;
 
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
 
/**
 * This program demonstrates how to establish database connection to Microsoft
 * SQL Server.
 * @author www.codejava.net
 *
 */
public class ketnoicsdl {
 
	public Connection getConnect() {
	 try {

      	String dbURL = "jdbc:sqlserver://localhost;databaseName=quanlisanpham" ;
          String user = "sa";
          String pass = "123456";
          System.out.println(" KẾT NỐI THÀNH CÔNG  ");
          return DriverManager.getConnection(dbURL, user, pass);

      }
      catch (SQLException e) 
      {
      	System.out.println(" KẾT NỐI KHÔNG THÀNH CÔNG  ");
  }
	return null;
}
}