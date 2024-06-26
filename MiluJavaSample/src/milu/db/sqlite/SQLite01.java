package milu.db.sqlite;

import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*; 


import milu.db.DriverShim;

public class SQLite01 {
	public static void main(String args[]){  
		try{  
			//step1 load the driver class
			System.out.println( "step1" );
			// jdk 20 deprecated
			//URL url = new URL("file:loader/sqlite/sqlite-jdbc-3.23.1.jar");
			//URL url = new URL("jar:file:loader/sqlite/sqlite-jdbc-3.23.1.jar!/");
			
			//Path path = Paths.get("loader/sqlite/sqlite-jdbc-3.23.1.jar");
			//URI uri = path.toUri();
			//URL url = uri.toURL();
			
			Path path = Paths.get("loader/sqlite/sqlite-jdbc-3.45.1.0.jar");
			URI uri = path.toUri();
			URL url = uri.toURL();
			
			System.out.println( url );
			URL[] urls = { url };
			URLClassLoader loader =	new URLClassLoader( urls );
			Driver d = 
					(Driver)Class.forName
					(
						"org.sqlite.JDBC", 
						true, 
						loader
					).getDeclaredConstructor().newInstance();
			DriverManager.registerDriver( new DriverShim(d) );
			
			  
			//step2 create  the connection object
			System.out.println( "step2" );
			Connection con = null;
			String urljdbc = 
				"jdbc:sqlite:F:\\myjava\\MiluJavaSample.git\\MiluJavaSample\\db\\sqlite\\ex1.db";
			System.out.println( urljdbc );
			con = DriverManager.getConnection( urljdbc );
			
			//step3 create the statement object
			System.out.println( "step3" );
			Statement stmt=con.createStatement();  
			  
			//step4 execute query
			System.out.println( "step4" );
			ResultSet rs=stmt.executeQuery("select * from sqlite_master");
			//ResultSet rs=stmt.executeQuery("select * from information_schema.schemata");
			while(rs.next())  
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				//System.out.println(rs.getString("id"));
			}
			  
			//step5 close the connection object
			System.out.println( "step5" );
			con.close();  
		  
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  
	}
}
