package post.like.comment;

import java.sql.Timestamp;

public class Comment {
	private int comment_id;
	private String user_comment;
	private int comment_post_id;
	private int user_id;
	private  int post_user_id;
	private Timestamp date_time;
	public Comment(int comment_id, String user_comment, int comment_post_id, int user_id, int post_user_id,
			Timestamp date_time) {
		super();
		this.comment_id = comment_id;
		this.user_comment = user_comment;
		this.comment_post_id = comment_post_id;
		this.user_id = user_id;
		this.post_user_id = post_user_id;
		this.date_time = date_time;
	}
	public Comment(String user_comment, int comment_post_id, int user_id, int post_user_id) {
		super();
		this.user_comment = user_comment;
		this.comment_post_id = comment_post_id;
		this.user_id = user_id;
		this.post_user_id = post_user_id;
	}
	public Comment() {
		super();
	}
	public int getComment_id() {
		return comment_id;
	}
	public void setComment_id(int comment_id) {
		this.comment_id = comment_id;
	}
	public String getUser_comment() {
		return user_comment;
	}
	public void setUser_comment(String user_comment) {
		this.user_comment = user_comment;
	}
	public int getComment_post_id() {
		return comment_post_id;
	}
	public void setComment_post_id(int comment_post_id) {
		this.comment_post_id = comment_post_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getPost_user_id() {
		return post_user_id;
	}
	public void setPost_user_id(int post_user_id) {
		this.post_user_id = post_user_id;
	}
	public Timestamp getDate_time() {
		return date_time;
	}
	public void setDate_time(Timestamp date_time) {
		this.date_time = date_time;
	}
	
	
}
