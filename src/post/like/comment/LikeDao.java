package post.like.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LikeDao {
	Connection con;
	public LikeDao(Connection con) {
		super();
		this.con = con;
	}
	public boolean insertLike(int post_id,int u_id) {
		boolean f=false;
		try {
			String query="insert into user_like(post_id,u_id) values(?,?)";
			PreparedStatement ps=this.con.prepareStatement(query);
			ps.setInt(1, post_id);
			ps.setInt(2, u_id);
			ps.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public int countLikeOnLike(int post_id) {
		int count=0;
		String q="select count(*) from user_like where post_id=?";
		try {
			PreparedStatement ps=this.con.prepareStatement(q);
			ps.setInt(1,post_id);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				count=set.getInt("count(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	public boolean isLikedByUser(int post_id,int u_id) {
		boolean f=false;
		String q="select * from user_like where post_id=? and u_id=?";
		try {
			PreparedStatement ps=this.con.prepareStatement(q);
			ps.setInt(1, post_id);
			ps.setInt(2, u_id);
			ResultSet set=ps.executeQuery();
			if(set.next()) {
				f=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

	public boolean disLikedByUser(int post_id,int u_id){
		boolean f=false;
		String q="delete * from user_like where post_if=? and u_id=?";
		try {
			PreparedStatement ps=this.con.prepareStatement(q);
			ps.setInt(1, post_id);
			ps.setInt(2, u_id);
			ps.executeUpdate();
			 
				f=true;
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return f;
	}

}
