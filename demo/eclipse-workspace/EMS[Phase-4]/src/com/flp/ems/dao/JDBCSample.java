package com.flp.ems.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCSample {

	public static void main(String[] args) throws Exception{
		
		Properties prop=new Properties();
		prop.load(new FileInputStream("dbDetails.properties"));
		
		String url=prop.getProperty("jdbc.url");
		String uname=prop.getProperty("jdbc.username");
		String pwd=prop.getProperty("jdbc.password");
		String[] roles={"Developer","Tech Lead","Manager","Business Analyst","Product Owner","Client"};
		String[] dept={"BAPI","CCD","APPLY","ETL","MOBILE"};
		String[] project={".NET","camel","platform","api","acquisition","hadoop"};
			
		
		try(Connection conn=DriverManager.getConnection(url,uname,pwd);){
				
			
			String sql=prop.getProperty("jdbc.insertQuery3");
			try(PreparedStatement ps=conn.prepareStatement(sql);){
						for(int i=0;i<project.length;i++){
						ps.setString(1, "p"+(i+1));
						ps.setString(2, project[i]);
						ps.setString(3, "Good");
						
						switch(i+1){
						case 1:
						ps.setString(4, "d2");
						break;
						case 2:
							ps.setString(4, "d1");
							break;
						case 3:
							ps.setString(4, "d1");
							break;
						case 4:
							ps.setString(4, "d1");
							break;
						case 5:
							ps.setString(4, "d3");
							break;
				
						case 6:
							ps.setString(4, "d4");
					
				
							break;
						}
						System.out.println("Rows effected   "+ps.executeUpdate());
						}
					}
		
		
		/*	try (Statement selectStatement = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE)) {

				String selectQuery = prop.getProperty("jdbc.query.select");
				ResultSet result;
				result = selectStatement.executeQuery(selectQuery);
		
				while (result.next()) {

					 String f = result.getString(1);
			          String i = result.getString(2);
			          String in = result.getString(3);
			          System.out.println( f+" "+ i + " "+ in);
			        		  }
				
				
				result.beforeFirst();
				result.next();
					result.updateString(1, "r1");
					result.updateRow();
					
					result.next();
					result.updateString(1, "r2");
					result.updateRow();
					
				result.beforeFirst();

				
				while (result.next()) {
					 String f = result.getString("roleId");
			          String i = result.getString(2); 
			          String in = result.getString(3);
			          System.out.println( f+" "+ i + " "+ in);
			        		  }

			}
*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		}
		
		
		
		
		
	}
	
}
