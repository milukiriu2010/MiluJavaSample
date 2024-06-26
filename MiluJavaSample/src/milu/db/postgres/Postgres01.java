package milu.db.postgres;

import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.util.Properties;

import milu.db.DriverShim;

// http://www.postgresqltutorial.com/postgresql-jdbc/connecting-to-postgresql-database/
// https://www.tutorialspoint.com/postgresql/postgresql_java.htm
public class Postgres01 {
	public static void main(String args[]) {
		try {
			//step1 load the driver class
			System.out.println( "step1" );
		    //Class.forName("org.postgresql.Driver");
			//Path path = Paths.get("loader/postgres/postgresql-42.2.4.jar");
			Path path = Paths.get("loader/postgres/postgresql-42.7.3.jar");
			URI uri = path.toUri();
			URL url = uri.toURL();
			
			System.out.println( url );
			URL[] urls = { url };
			URLClassLoader loader =	new URLClassLoader( urls );
			Driver d = 
					(Driver)Class.forName
					(
						"org.postgresql.Driver", 
						true, 
						loader
					).getDeclaredConstructor().newInstance();
			DriverManager.registerDriver( new DriverShim(d) );
			
			
		    
			//step2 create  the connection object
			System.out.println( "step2" );
			
		    Connection con = null;
			if ( args.length == 0 )
			{
				System.out.println( "=== no arg ===" );
			    //con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miludb", "milu", "milu");
			    con = DriverManager.getConnection("jdbc:postgresql://192.168.3.29:5432/miludb", "milu", "milu");
			}
			else if ( "ssl".equals(args[0]) == true )
			{
				System.out.println( "=== ssl ===" );
			    //con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miludb?ssl=true", "milu", "milu");
			    con = DriverManager.getConnection("jdbc:postgresql://192.168.3.29:5432/miludb?ssl=true", "milu", "milu");
			}
			else if ( "embed_in_url".equals(args[0]) == true )
			{
				System.out.println( "=== embed_in_url ===" );
			    //con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miludb?user=milu&password=milu" );
			    con = DriverManager.getConnection("jdbc:postgresql://192.168.3.29:5432/miludb?user=milu&password=milu" );
			}
			else if ( "properties".equals(args[0]) == true )
			{
				System.out.println( "=== properties ===" );
				Properties props = new Properties();
				props.setProperty("user", "milu");
				props.setProperty("password", "milu");
			    //con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/miludb", props );
			    con = DriverManager.getConnection("jdbc:postgresql://192.168.3.29:5432/miludb", props );
			}
			
			
		    
			//step3 create the statement object
			System.out.println( "step3" );
		    Statement stmt=con.createStatement();  
				  
			//step4 execute query
			System.out.println( "step4" );
			ResultSet rs=stmt.executeQuery("select * from information_schema.tables order by table_name");  
			//ResultSet rs=stmt.executeQuery("select * from m_npb_team_list order by id");  
			while(rs.next())  
			{
				System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
				//System.out.println(rs.getString("ID")+ " " + rs.getString("HEAD_NAME") );
			}
				  
			//step5 close the connection object
			System.out.println( "step5" );
			con.close();  

		} catch (Exception e) {
		     e.printStackTrace();
		     System.err.println(e.getClass().getName()+": "+e.getMessage());
		     System.exit(0);
		}
		System.out.println("Opened database successfully");
	}
}
