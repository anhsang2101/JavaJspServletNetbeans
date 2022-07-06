package Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectDB {
    public static final String connectionURL = "jdbc:sqlserver://SANG\\SQLEXPRESS:1433;databaseName=JavaWeb;user=sa;password=1234";
    
 
    public ConnectDB() {
    	try {
            // connnect to database 
            Connection conn = getConnection();
            
            // close connection
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
 
       
	
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionURL);
			return con;
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Where is driver?");
			System.out.println(e.toString());
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		
		return null;
	}
    
     public static void main(String args[]) {
        new ConnectDB();
    }
    
}
