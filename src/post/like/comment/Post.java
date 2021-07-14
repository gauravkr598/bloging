package post.like.comment;

import java.sql.Timestamp;

public class Post {
	private int postId;
	private String userTitle;
	private  int catId;
	private String pCode;
	private String userImage;
	private Timestamp dateTime;
	private int Id;
	public Post(int postId, String userTitle, int catId, String pCode, String userImage, Timestamp dateTime, int id) {
		super();
		this.postId = postId;
		this.userTitle = userTitle;
		this.catId = catId;
		this.pCode = pCode;
		this.userImage = userImage;
		this.dateTime = dateTime;
		this.Id = id;
	}
	public Post() {
		super();
	}
	public Post(String userTitle, int catId, String pCode, String userImage, int id) {
		super();
		this.userTitle = userTitle;
		this.catId = catId;
		this.pCode = pCode;
		this.userImage = userImage;
		Id = id;
	}
	
	public Post(int id) {
		super();
		Id = id;
	}
	
	public Post(int postId, String userTitle, int catId, String pCode, String userImage, Timestamp dateTime) {
		super();
		this.postId = postId;
		this.userTitle = userTitle;
		this.catId = catId;
		this.pCode = pCode;
		this.userImage = userImage;
		this.dateTime = dateTime;
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public String getUserTitle() {
		return userTitle;
	}
	public void setUserTitle(String userTitle) {
		this.userTitle = userTitle;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getpCode() {
		return pCode;
	}
	public void setpCode(String pCode) {
		this.pCode = pCode;
	}
	public String getUserImage() {
		return userImage;
	}
	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	 
}
