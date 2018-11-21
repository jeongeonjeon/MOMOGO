package kr.co.mlec.join.vo;

public class PersonalVO {
	private String id; 
	private String pass; 
	private String name; 
	private String email; 
	private int phone;
	private String userType;
	
	public PersonalVO() {
	
	}
	
	public PersonalVO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	
	public PersonalVO(String id, String pass, String userType) {
		super();
		this.id = id;
		this.pass = pass;
		this.userType = userType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}


	
	
	
	
	
}
