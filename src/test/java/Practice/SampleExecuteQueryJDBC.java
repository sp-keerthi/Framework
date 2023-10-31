package Practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteQueryJDBC {

	public static void main(String[] args) throws SQLException
	{
		  Driver driver = new Driver();
		
		//Step 1 : register the driver
		DriverManager.registerDriver(driver);
		
		//step 2 : get connection with database
		
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "tiger");
		
		//step 3: issue create statment
		
		Statement state = con.createStatement();
		
		//step 4 : execute query
		
		ResultSet result = state.executeQuery("select * from empinfo");
	    while(result.next())
	    {
	    	String value = result.getString(1)+" "+result.getString(2)+" "+result.getInt(3);
	    	System.out.println(value);
	    }
		
		//step 5: close database
	    con.close();
	}
}
