package post.like.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PostDao {
	Connection con;

	public PostDao(Connection con) {
		super();
		this.con = con;
	}
//=================Get data from databse for Cotegory......=====================================================
	public ArrayList<Category> getAllCategory(){
		ArrayList<Category> list=new ArrayList<Category>();
		 try {
			 String query="select * from user_cat";
			 PreparedStatement ps=this.con.prepareStatement(query);
			 ResultSet set=ps.executeQuery();
			 while(set.next()) {
				 int catId=set.getInt("cat_id");
				 String userName=set.getString("user_name");
				 String discription=set.getString("user_descripter");
				 Category cat=new Category(catId,userName,discription);
				 list.add(cat);
				// System.out.println(cat);
			 }
			  
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		return list;
	}
//====================data insert in data base=================================================
	public boolean savePostData(Post post) {
		boolean f=false;
		try {
			String query="insert into user_post(user_title,cat_id,p_code,p_image,Id) values(?,?,?,?,?)";
			PreparedStatement ps=this.con.prepareStatement(query);
			ps.setString(1,post.getUserTitle());
			ps.setInt(2,post.getCatId());
			ps.setString(3,post.getpCode());
			ps.setString(4,post.getUserImage());
			ps.setInt(5,post.getId());
			ps.executeUpdate();
			f=true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
//================================............Get post in list  ....................==============================
	
	public ArrayList<Post> getAllPost() {
		ArrayList<Post> list=new ArrayList<Post>();
		//grt all the post
		try {
			PreparedStatement ps=this.con.prepareStatement("select * from user_post order by post_id desc");
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				int postId=set.getInt("post_id");
				String userTitle=set.getString("user_title");
				int catId=set.getInt("cat_id");
				String pCode=set.getString("p_code");
				String userImage=set.getString("p_image");
				Timestamp dateTime=set.getTimestamp("p_datetime");
				int Id=set.getInt("Id");
				Post post=new Post(postId,userTitle,catId,pCode,userImage,dateTime,Id);
				list.add(post);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
//================================............Get post by Id ....................==============================
	public List getAllPostById(int catId) {
		List<Post> list=new ArrayList<>();
		//get all the post by id
		try {
			PreparedStatement ps=this.con.prepareStatement("select * from user_post where cat_id=?");
			ps.setInt(1, catId);
			ResultSet set=ps.executeQuery();
			while(set.next()) {
				int postId=set.getInt("post_id");
				String userTitle=set.getString("user_title");
				String pCode=set.getString("p_code");
				String userImage=set.getString("p_image");
				Timestamp dateTime=set.getTimestamp("p_datetime");
				int Id=set.getInt("Id");
				Post post=new Post(postId,userTitle,catId,pCode,userImage,dateTime,Id);
				list.add(post);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
  //============================================================================================================  
	public Post getAllPostByPostId(int post_id) {
		Post post=null;
		String query="select * from user_post where post_id=?";
		try {
			PreparedStatement ps=this.con.prepareStatement(query);
			ps.setInt(1, post_id);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				int postId=set.getInt("post_id");
				String userTitle=set.getString("user_title");
				int catId=set.getInt("cat_id");
				String pCode=set.getString("p_code");
				String userImage=set.getString("p_image");
				Timestamp dateTime=set.getTimestamp("p_datetime");
				int Id=set.getInt("Id");
				  post=new Post(postId,userTitle,catId,pCode,userImage,dateTime,Id);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return post;
		
	}
	// user details by post id
	public ArrayList<Post> getUserDetailsByPostId(int Id){
		ArrayList<Post> postp=new ArrayList<Post>();
		String query="select post_id,user_title,cat_id,p_code,p_image,p_datetime from user_post where  Id = ? order by post_id desc";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1,Id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int postId=rs.getInt("post_id");
				String userTitle=rs.getString("user_title");
				int catId=rs.getInt("cat_id");
				String pCode=rs.getString("p_code");
				String userImage=rs.getString("p_image");
				Timestamp dateTime=rs.getTimestamp("p_datetime");
				Post post=new Post(postId,userTitle,catId,pCode,userImage,dateTime);
				postp.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postp;
	}

}
