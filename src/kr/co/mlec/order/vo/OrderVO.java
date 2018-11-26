package kr.co.mlec.order.vo;

public class OrderVO {
	
	int orderNo;
	String menu;
	String id;
	int storeNo;
	String regDate;
	String status;
	String storeName;
	
	public OrderVO(int orderNo, String menu, String id, int storeNo, String regDate, String status, String storeName) {
		super();
		this.orderNo = orderNo;
		this.menu = menu;
		this.id = id;
		this.storeNo = storeNo;
		this.regDate = regDate;
		this.status = status;
		this.storeName = storeName;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}
	public String getMenu() {
		return menu;
	}
	public void setMenu(String menu) {
		this.menu = menu;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getStoreNo() {
		return storeNo;
	}
	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}
	@Override
	public String toString() {
		return "OrderVO [orderNo=" + orderNo + ", menu=" + menu + ", id=" + id + ", storeNo=" + storeNo + ", regDate="
				+ regDate + ", status=" + status + "]";
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public OrderVO(int orderNo, String menu, String id, int storeNo, String regDate, String status) {
		super();
		this.orderNo = orderNo;
		this.menu = menu;
		this.id = id;
		this.storeNo = storeNo;
		this.regDate = regDate;
		this.status = status;
	}
	public OrderVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
