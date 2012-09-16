package SQLConnector;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import org.junit.Before;

import org.junit.Test;

public class MySQLConnectorTest {

	private Connection test_connection;
	
	@Before
	public void setUp() throws Exception {
		test_connection = null;
	}

	@Test
	public void testConnect() {
		// Try open a connection to a database
		try {			
			test_connection = MySQLConnector.connect("mysql://localhost/HRDatabase","root", "gtx@6075");
			System.out.println("The connection to the database was successful.");
		}catch (ClassNotFoundException e) 
		{
            System.out.println("No JDBC driver is installed");
            fail("NO JDBC driver");
        }catch(SQLException e)        
        {
            System.out.println("Error: adress, user, password.");
            fail("Error: address, user, password.");
        }catch (Exception e) 
        {
        	System.out.println("Error occured while connecting to the database.");
            fail("Error occured while connecting to the database.");
		}
		
		//Try and close the connection	
		try {
			test_connection.close();
			System.out.println("The connection to the database was succefully closed.");
		} catch (Exception e) {				
			System.out.println("Error occured while closing the database.");
			fail("Error occured while closing the database.");				
		}			
	}

}
