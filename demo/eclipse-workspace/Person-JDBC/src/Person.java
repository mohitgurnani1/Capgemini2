import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Person {
	public static void main(String args[]) throws IOException, SQLException {
		Properties prop = new Properties();
		FileInputStream fln = new FileInputStream("dbDetails.properties");
		prop.load(fln);
		String driver = prop.getProperty("jdbc.driver");
		String url = prop.getProperty("jdbc.url");
		Connection dbConnection;
		dbConnection = DriverManager.getConnection(url);
		System.out.println((dbConnection != null));
		String insertQuery = prop.getProperty("jdbc.query.insert");

		/*
	 try (Statement selectStatement = dbConnection.createStatement()) {
		String selectQuery = prop.getProperty("jdbc.query.select");
		ResultSet result;
		result = selectStatement.executeQuery(selectQuery);
		while (result.next()) {
				String message = result.getString(1);
				System.out.println(message);
			}
		}*/

	/*	try (PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery)) {
			String msg = "Roshita";
			int age = 23;
			int id = 1;
			insertStatement.setString(1, msg);
			insertStatement.setInt(2, age);
			insertStatement.setInt(3, id);
			insertStatement.executeUpdate();
		}
		try (PreparedStatement insertStatement = dbConnection.prepareStatement(insertQuery)) {
			String msg = "Shweta";
			int age = 25;
			int id = 2;
			insertStatement.setString(1, msg);
			insertStatement.setInt(2, age);
			insertStatement.setInt(3, id);
			insertStatement.executeUpdate();
		}
*/
		try (Statement selectStatement = dbConnection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
				ResultSet.CONCUR_UPDATABLE)) {

			String selectQuery = prop.getProperty("jdbc.query.select");
			ResultSet result;
			result = selectStatement.executeQuery(selectQuery);
			//result.beforeFirst();
			while (result.next()) {

				 String f = result.getString("Name");
		          String i = result.getString(2);
		          String in = result.getString(3);
		          System.out.println( f+" "+ i + " "+ in);
		        		  }
			result.beforeFirst();
			result.next();
				result.updateString(1, "Rosh");
				result.updateRow();
				
				result.next();
				result.updateString(1, "Shweta");
				result.updateRow();
				
			result.beforeFirst();

			
			while (result.next()) {
				 String f = result.getString("Name");
		          String i = result.getString(2);
		          String in = result.getString(3);
		          System.out.println( f+" "+ i + " "+ in);
		        		  }
		}

	}

}
