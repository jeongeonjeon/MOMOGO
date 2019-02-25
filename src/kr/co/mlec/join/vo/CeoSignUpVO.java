package kr.co.mlec.join.vo;

public class CeoSignUpVO {
	private int ceoNo;
	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String regDate;
	private String type;
	private String basicAddr;
	private String detailAddr;
	private int storeNo; 
	
	
	public CeoSignUpVO() {
		super();
	}
	
	
	public CeoSignUpVO(int ceoNo, String id, String password, String email, String name, String phone, String regDate,
			String type, int storeNo) {
		super();
		this.ceoNo = ceoNo;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.regDate = regDate;
		this.type = type;
		this.storeNo = storeNo;
	}
	
	public CeoSignUpVO(int ceoNo, String id, String password, String email, String name, String phone, String regDate,
			String type) {
		super();
		this.ceoNo = ceoNo;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.regDate = regDate;
		this.type = type;
	}


	public int getStoreNo() {
		return storeNo;
	}


	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public CeoSignUpVO(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	
	public CeoSignUpVO(String id, String password, String type) {
		super();
		this.id = id;
		this.password = password;
		this.type = type;
	}	

	public CeoSignUpVO(String id, String email, String name, String phone) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.phone = phone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getCeoNo() {
		return ceoNo;
	}

	public void setCeoNo(int ceoNo) {
		this.ceoNo = ceoNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}	
	

	public String getBasicAddr() {
		return basicAddr;
	}

	public void setBasicAddr(String basicAddr) {
		this.basicAddr = basicAddr;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}


	@Override
	public String toString() {
		return "CeoSignUpVO [ceoNo=" + ceoNo + ", id=" + id + ", password=" + password + ", email=" + email + ", name="
				+ name + ", phone=" + phone + ", regDate=" + regDate + ", type=" + type + ", basicAddr=" + basicAddr
				+ ", detailAddr=" + detailAddr + ", storeNo=" + storeNo + "]";
	}

	

	
	
	
}