package kr.co.mlec.store.vo;

public class StoreVO {
	
	String category;
	String address;
	String storeName;
	String imageUrl;
	public StoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreVO(String category, String address, String storeName, String imageUrl) {
		super();
		this.category = category;
		this.address = address;
		this.storeName = storeName;
		this.imageUrl = imageUrl;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "StoreVO [category=" + category + ", address=" + address + ", storeName=" + storeName + ", imageUrl="
				+ imageUrl + "]";
	}
	

}
