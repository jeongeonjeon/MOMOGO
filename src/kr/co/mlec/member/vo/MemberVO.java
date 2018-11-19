package kr.co.mlec.member.vo;

public class MemberVO {
	private String id;
	private String password;
	private String email;
	private String name;
	private String phone;
	private String storeName;
	private String licenseNum;
	private String basicAddr;
	private String detailAddr;
	private String category;
	private String deliveryArea;
	
	public MemberVO() {
		super();
	}
	
	public MemberVO(String id, String password, String email, String name, String phone, String storeName,
			String licenseNum, String basicAddr, String detailAddr, String category, String deliveryArea) {
		super();
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.phone = phone;
		this.storeName = storeName;
		this.licenseNum = licenseNum;
		this.basicAddr = basicAddr;
		this.detailAddr = detailAddr;
		this.category = category;
		this.deliveryArea = deliveryArea;
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

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLicenseNum() {
		return licenseNum;
	}

	public void setLicenseNum(String licenseNum) {
		this.licenseNum = licenseNum;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDeliveryArea() {
		return deliveryArea;
	}

	public void setDeliveryArea(String deliveryArea) {
		this.deliveryArea = deliveryArea;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", password=" + password + ", email=" + email + ", name=" + name + ", phone="
				+ phone + ", storeName=" + storeName + ", licenseNum=" + licenseNum + ", basicAddr=" + basicAddr
				+ ", detailAddr=" + detailAddr + ", category=" + category + ", deliveryArea=" + deliveryArea + "]";
	}
	
}
