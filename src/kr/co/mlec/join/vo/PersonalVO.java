package kr.co.mlec.join.vo;

public class PersonalVO {
	private String id; 
	private String pass; 
	private String name; 
	private String email; 
	private String phone;
	private String type;
	private String regDate;
	
	public PersonalVO() {
		super();
	}	

	public PersonalVO(String id, String pass) {
		super();
		this.id = id;
		this.pass = pass;
	}
	
	public PersonalVO(String id, String pass, String type) {
		super();
		this.id = id;
		this.pass = pass;
		this.type = type;
	}
	
	

	public PersonalVO(String id, String pass, String name, String email, String phone, String type, String regDate) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.type = type;
		this.regDate = regDate;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}	

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "PersonalVO [id=" + id + ", pass=" + pass + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", type=" + type + ", regDate=" + regDate + "]";
	}
	
	
}