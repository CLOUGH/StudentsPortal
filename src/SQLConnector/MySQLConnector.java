package SQLConnector;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnector {
	// Return the connection to the database
	public static Connection connect(String MySQL_address, String MySQL_username, String MySQL_password) throws Exception
	{
		Connection mysql_connection = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		String query = "jdbc:"+MySQL_address+"?"+"user="+MySQL_username+"&password="+MySQL_password;
		mysql_connection= 
			 DriverManager.getConnection(query);
				
		return mysql_connection;
	}
	public static ResultSet query(Connection mysql_connection, String query) throws Exception
	{
		Statement mysql_statement = mysql_connection.createStatement();
		ResultSet result = mysql_statement.executeQuery(query);
		return result;
	}
	
	
}
