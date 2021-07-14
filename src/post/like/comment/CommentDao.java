package post.like.comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import signup.login.User;

public class CommentDao {
	Connection con;
	public CommentDao(Connection con) {
		super();
		this.con = con;
	}
	// inset comment value 
		public boolean inserComment(Comment comment) {
			boolean f=false;
			String query="insert into user_comment(user_comment,comment_post_id,user_id,post_user_id) value(?,?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(query);
				ps.setString(1,comment.getUser_comment());
				ps.setInt(2, comment.getComment_post_id());
				ps.setInt(3,comment.getUser_id());
				ps.setInt(4, comment.getPost_user_id());
				ps.executeUpdate();
				f=true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return f;
			
		}
		//count Comment
		public int countCommente(int comment_post_id) {
			int count=0;
			String q="select count(*) from user_comment where comment_post_id=?";
			try {
				PreparedStatement ps=this.con.prepareStatement(q);
				ps.setInt(1,comment_post_id);
				ResultSet set=ps.executeQuery();
				if(set.next()) {
					count=set.getInt("count(*)");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return count;
		}

	// Get all comment
		 public ArrayList<Comment> getAllComment(int comment_post_id){
				ArrayList<Comment> comment=new ArrayList<Comment>();
				String query="select * from user_comment where  comment_post_id = ? ";
				try {
					PreparedStatement ps=con.prepareStatement(query);
					ps.setInt(1,comment_post_id);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						int comment_id=rs.getInt("comment_id");
						int post_user_id=rs.getInt("post_user_id");
						int user_id=rs.getInt("user_id");
						String user_comment=rs.getString("user_comment");
						Timestamp date_time=rs.getTimestamp("date_time");
						Comment comment1=new Comment(comment_id,user_comment,comment_post_id,user_id,post_user_id,date_time);
						comment.add(comment1);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return comment;
			}
			
}
