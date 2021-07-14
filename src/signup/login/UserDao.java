package signup.login;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.mysql.cj.xdevapi.Result;

import database.connection.Type;

 
public class UserDao {
	private Connection con;
	
//===========constractor........................................................................  
	public UserDao(Connection con) {
		super();
		this.con = con;
	}
	
//call user class===set data to database inset data  =========================================================================================================
			public boolean saveUserFunction(User user) {
				boolean f=false;
			try {
				//user database 
				String query=("insert into  user_tech(user_name,user_email,user_gender,user_password) values(?,?,?,?)");
				PreparedStatement ps=this.con.prepareStatement(query); 
				ps.setString(1, user.getUserName());
				ps.setString(2, user.getUserEmail());
				ps.setString(3, user.getUserGender());
				ps.setString(4, user.getUserPassword());
				ps.executeUpdate();
				 f=true;
			}catch(Exception e) {
				e.printStackTrace();
			}
			return f;
			
		}
	
	
//Get userEmail and Passwords== from database==================================================================================
		public User getEmailAndPassword(String user_email,String user_password) {
			User user=null;
			try {
				String query="select * from user_tech where user_email=? and user_password=?";
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1, user_email);
				ps.setString(2, user_password);
				ResultSet set=ps.executeQuery();
				if(set.next()) {
					user=new User();
					// data from databse 
					 
					// data set to user  object
					String userName=set.getString("user_name");
					user.setUserName(userName);
					user.setUserEmail(set.getString("user_email"));
					user.setUserPassword(set.getString("user_password"));
					user.setUserGender(set.getString("user_gender"));
					user.setId(set.getInt("Id"));
					user.setProfileImage(set.getString("profile_image"));
					user.setDateTime(set.getTimestamp("date_time"));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return user;	
		}
		
//Update data . in database ...................................................................................................
		public boolean updateUser(User user) {
			boolean f=false;
			System.out.println("hii"+user.getProfileImage());
		    try {
			//user database 
			String query=("update user_tech set user_name=? , user_email=? , user_gender=?,user_password=?, profile_image=? where Id=?");
			PreparedStatement ps=this.con.prepareStatement(query); 
			ps.setString(1, user.getUserName());
			ps.setString(2, user.getUserEmail());
			ps.setString(3, user.getUserGender());
			ps.setString(4, user.getUserPassword());
			ps.setString(5, user.getProfileImage());
			System.out.println(user.getProfileImage());
			System.out.println(user.getUserName());
			ps.setInt(6, user.getId());
			ps.executeUpdate();
			 f=true;
		    }catch(Exception e) {
			e.printStackTrace();
		    }
		    return f;
		
	}
//============================================================================================================		
//==============Get user Name by postId======================================================================
		public User getUserByPostId(int Id) {
			User user=null;
			String query="select * from user_tech where Id=?";
			try {
				PreparedStatement ps=this.con.prepareStatement(query);
				ps.setInt(1, Id);
				ResultSet set=ps.executeQuery();
				if(set.next()) {
					user=new User();
					String userName=set.getString("user_name");
					user.setUserName(userName);
					user.setUserEmail(set.getString("user_email"));
					user.setUserPassword(set.getString("user_password"));
					user.setUserGender(set.getString("user_gender"));
					user.setId(set.getInt("Id"));
					user.setProfileImage(set.getString("profile_image"));
					user.setDateTime(set.getTimestamp("date_time"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return user;
			
		}
//==================================Get User Type ==================================================================
		public ArrayList<Type> getAllUserType(){
			ArrayList<Type> list=new ArrayList<Type>();
			String query="select * from user_type ";
			try {
				PreparedStatement ps=this.con.prepareStatement(query);
				ResultSet set=ps.executeQuery();
				while(set.next()) {
					int typeId=set.getInt("type_id");
					String userType=set.getString("user_type");
					int Id=set.getInt("Id");
					Type type=new Type(typeId,userType,Id);
					list.add(type);
					System.out.println(type);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		
///Count all user ===================================================================================================
		public HashMap<String,Integer> getAllUser() {
			HashMap<String,Integer> map=null;
			//grt all the post
			try {
				PreparedStatement ps=this.con.prepareStatement("select count(*) from user_tech");
				ResultSet set=ps.executeQuery();
				while(set.next()) {
					 
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			return map;
		}
}
