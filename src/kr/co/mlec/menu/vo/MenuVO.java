package kr.co.mlec.menu.vo;

public class MenuVO {
	
	int ceoNo		;
	int price       ;
	String menuName ;
	String menuImage;
	String type     ;
	String detail   ;
	
	public int getCeoNo() {
		return ceoNo;
	}
	public void setCeoNo(int ceoNo) {
		this.ceoNo = ceoNo;
	}
	public String getMenuName() {
		return menuName;
	}
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getMenuImage() {
		return menuImage;
	}
	public void setMenuImage(String menuImage) {
		this.menuImage = menuImage;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	@Override
	public String toString() {
		return "MenuVO [ceoNo=" + ceoNo + ", menuName=" + menuName + ", price=" + price + ", menuImage=" + menuImage
				+ ", type=" + type + ", detail=" + detail + "]";
	}
}
