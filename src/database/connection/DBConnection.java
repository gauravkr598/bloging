package database.connection;
import java.sql.*;
public class DBConnection {
		private DBConnection(){}
		private static Connection con=null;
		public  static Connection getConnection() {
			try { 
				 if(con==null) {
				//load class 
				Class.forName("com.mysql.cj.jdbc.Driver");
				//connection
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tech_user","root","admin");
				//System.out.println("Connection stablished");
				 }
			}  catch (SQLException e) {
				e.printStackTrace();
				//System.out.println("Exception in DBConnection");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
			}
			return con;	
		}
}
