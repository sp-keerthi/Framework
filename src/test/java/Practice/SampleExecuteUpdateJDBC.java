package Practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SampleExecuteUpdateJDBC {

	public static void main(String[] args) throws SQLException  {
		// TODO Auto-generated method stub

		  Driver driver = new Driver();
			
			//Step 1 : register the driver
			DriverManager.registerDriver(driver);
			
			//step 2 : get connection with database
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/empdb", "root", "tiger");
			
			//step 3: issue create statement
			
			Statement state = con.createStatement();
			
			//step 4 : execute query -provide table name
			
			String query = " insert empinfo(name,address,id)values('kiran','london',5);";
			int result = state.executeUpdate(query);
			if(result==1)
			{
				System.out.println("data added successfully");
			}
			
			//Step 5: close db
			con.close();
			
	}

}
