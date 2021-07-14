package database.connection;

import java.sql.Connection;
public class CheckDatabase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con=DBConnection.getConnection();
		System.out.println(con);
		 
	}

}
