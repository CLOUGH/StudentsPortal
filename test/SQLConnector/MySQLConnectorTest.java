package SQLConnector;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

//import org.junit.After;
import org.junit.Before;
//import org.junit.Ignore;
import org.junit.Test;

public class MySQLConnectorTest {
    /**************************************************************************************
	* Constants to run test
	***************************************************************************************/
	private static String DATABASE_ADDRESS = "mysql://localhost/HRDatabase";
	private static String USERNAME = "root";
	private static String PASSWORD = "gtx@6075";
	private static String QUERY = "SELECT 1";
	
	/**************************************************************************************
	 * Instance variables used throughout the test
	 ***************************************************************************************/
	private Connection test_connection;
	private ResultSet test_results;
	private ResultSetMetaData test_metadata;
	
	/**************************************************************************************
	* Test1
	* The system should be able to connect to a database
	***************************************************************************************/
	@Before
	public void setUp() throws Exception {
		test_connection = MySQLConnector.connect(DATABASE_ADDRESS,USERNAME, PASSWORD);
		test_results = null;
		test_metadata = null;
	}

	@Test
	public void testConnect() throws Exception{
		 assertNotNull(test_connection);
		 test_connection.createStatement().executeQuery("SELECT 1");
	}
		
	/************************************************************************************
	* Test2
	* System should be able to query the database
	**************************************************************************************/
	@Test
	public void testQuery() throws Exception{
		
		//Test if any results were return
		test_results = MySQLConnector.query(test_connection, QUERY);
		assertNotNull(test_results);		
		//Test if any columns are in selection
		test_metadata = test_results.getMetaData();
		assertTrue(test_metadata.getColumnCount()>0);
	}
	
	
	/*************************************************************************************
	* Test3
	* System should be able to get a data from a column in a selected set (query).
	**************************************************************************************/
	@Test
	public void testGetRecordData() throws Exception{
		String data = null;
		String test_query = "SELECT * From personal_information where firstName= 'Warren'";
		test_results = MySQLConnector.query(test_connection,test_query);
		while(test_results.next())
		{
			data = test_results.getString("firstName");
		}		
		assertEquals("Warren",data);
	}
}
