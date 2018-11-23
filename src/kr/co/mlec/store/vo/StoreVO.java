package kr.co.mlec.store.vo;

public class StoreVO {
	
	int storeNo;
	String category;
	String storeName;
	String imageUrl;
	
	public StoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public StoreVO(int storeNo, String category, String address, String storeName, String imageUrl) {
		super();
		this.storeNo = storeNo;
		this.category = category;
		this.storeName = storeName;
		this.imageUrl = imageUrl;
	}

	public int getStoreNo() {
		return storeNo;
	}
	
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
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
		return "StoreVO [storeNo=" + storeNo + ", category=" + category + ", storeName="
				+ storeName + ", imageUrl=" + imageUrl + "]";
	}
	

}
