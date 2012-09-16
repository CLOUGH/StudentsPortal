package SQLConnector;

import static org.junit.Assert.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


import org.junit.Before;

import org.junit.Test;

public class MySQLConnectorTest {
    /**************************************************************************************
	* Constants to run test
	***************************************************************************************/
	private static String DATABASE_ADDRESS = "mysql://localhost/HRDatabase";
	private static String USERNAME = "root";
	private static String PASSWORD = "gtx@6075";
	private static String NOT_YET_IMPLEMENTENTED = "Test not yet implented";
	
	/**************************************************************************************
	 * Instance variables used throughout the test
	 ***************************************************************************************/
	private Connection test_connection;
	private RrsultSet test_results;,
	
	/**************************************************************************************
	* Test1
	* The system should be able to connect to a database
	***************************************************************************************/
	@Before
	public void setUp() throws Exception {
		test_connection = null;
	}

	@Test
	public void testConnect() {
		// Try open a connection to a database
		try {
			test_connection = MySQLConnector.connect(DATABASE_ADDRESS,USERNAME, PASSWORD);
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
		
		
		/************************************************************************************
		* Test2
		* System should be able to query the database
		**************************************************************************************/
		@Test
		public void testQuery() {
			fail(NOT_YET_IMPLEMENTENTED);
		}
		
		
		/*************************************************************************************
		* Test3
		* System should be able to get a column from the a selected set (query).
		**************************************************************************************/
		@Before
		public void setUp(){
			test_results = null;
			try{
				test_connection = MySQLConnector.connect(DATABASE_ADDRESS,USERNAME, PASSWORD);
			}catch(Exception e){
				fail("Could not setup connection to the database.");
			}
		}
		@Test
		public void testGetRecordData(){
			fail(NOT_YET_IMPLEMENTENTED);
		}
		@After
		public void destroy(){
			try{
				test_connection.close();
		    }catch(Exception e){
			    fail("Could not close the connection to the database.");
		}
	    /*************************************************************************************
		* Test4
		* System should be able to get name of tables in the database
		**************************************************************************************/
		@Test
		public void testGetTableNames(){
			int expected_number_tables=0;
			String[] expected_names = new String[expected_number_tables];
			fail(NOT_YET_IMPLEMENTENTED);
		}
	}

}
