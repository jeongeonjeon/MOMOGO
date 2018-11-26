package kr.co.mlec.menu.vo;

public class MenuVO {
	
	String menuName ;
	int price       ;
	String menuImage;
	String type     ;
	String detail   ;
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public MenuVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MenuVO(String menuName, int price, String menuImage, String type,String detail) {
		super();
		this.menuName = menuName;
		this.price = price;
		this.menuImage = menuImage;
		this.type = type;
		this.detail = detail;
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
	@Override
	public String toString() {
		return "MenuVO [menuName=" + menuName + ", price=" + price + ", menuImage=" + menuImage + ", type=" + type
				+ "]";
	}

}