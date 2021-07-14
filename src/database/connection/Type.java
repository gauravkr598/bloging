package database.connection;

public class Type {
	private int typeId;
	private String userType;
	private int Id;
	public Type(int typeId, String userType, int id) {
		super();
		this.typeId = typeId;
		this.userType = userType;
		this.Id = id;
	}
	public Type() {
		super();
	}
	public int getTypeId() {
		return typeId;
	}
	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	
}
