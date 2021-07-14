package post.like.comment;

public class Category {
	private int catId;
	private String userName;
	private String discription;
	public Category(int catId, String userName, String discription) {
		super();
		this.catId = catId;
		this.userName = userName;
		this.discription = discription;
	}
	public Category() {
		super();
	}
	public Category(String userName, String discription) {
		super();
		this.userName = userName;
		this.discription = discription;
	}
	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	
}
