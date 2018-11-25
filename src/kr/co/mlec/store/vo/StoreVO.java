package kr.co.mlec.store.vo;

public class StoreVO {
	
	int storeNo;
	String category;
	String storeName;
	String storeImage;
	
	String storeTel; 
	String address ;
	String start   ;
	String end     ;
	public StoreVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreVO(int storeNo, String category, String storeName, String storeImage, String storeTel, String address,
			String start, String end) {
		super();
		this.storeNo = storeNo;
		this.category = category;
		this.storeName = storeName;
		this.storeImage = storeImage;
		this.storeTel = storeTel;
		this.address = address;
		this.start = start;
		this.end = end;
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
	public String getStoreImage() {
		return storeImage;
	}
	public void setStoreImage(String storeImage) {
		this.storeImage = storeImage;
	}
	public String getStoreTel() {
		return storeTel;
	}
	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStart() {
		return start;
	}
	public void setStart(String start) {
		this.start = start;
	}
	public String getEnd() {
		return end;
	}
	public void setEnd(String end) {
		this.end = end;
	}
	@Override
	public String toString() {
		return "StoreVO [storeNo=" + storeNo + ", category=" + category + ", storeName=" + storeName + ", storeImage="
				+ storeImage + ", storeTel=" + storeTel + ", address=" + address + ", start=" + start + ", end=" + end
				+ "]";
	}
	
	

}
