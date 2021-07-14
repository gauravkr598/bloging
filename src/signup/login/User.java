package signup.login;

import java.sql.Timestamp;

public class User {
	private int Id;
	private String userName;
	private String userEmail;
	private String userGender;
	private String userPassword;
	private String profileImage;
	private Timestamp dateTime;
	public User(int id, String userName, String userEmail, String userGender, String userPassword, String profileImage,
			Timestamp dateTime) {
		super();
		Id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userPassword = userPassword;
		this.profileImage = profileImage;
		this.dateTime = dateTime;
	}
	public User(int id, String userName, String userEmail, String userGender, String userPassword,
			String profileImage) {
		super();
		Id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userPassword = userPassword;
		this.profileImage = profileImage;
	}
	public User(String userName, String userEmail, String userGender, String userPassword, String profileImage) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userGender = userGender;
		this.userPassword = userPassword;
		this.profileImage = profileImage;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserGender() {
		return userGender;
	}
	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
	public Timestamp getDateTime() {
		return dateTime;
	}
	public void setDateTime(Timestamp dateTime) {
		this.dateTime = dateTime;
	}
	
}
