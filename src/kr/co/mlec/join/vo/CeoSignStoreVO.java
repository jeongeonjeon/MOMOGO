package kr.co.mlec.join.vo;

import java.util.List;

public class CeoSignStoreVO {
	int storeNo;
	String ceo_id;
	String storeName;
	String licenseNo;
	String storeTel;
	String baseAddr;
	String detailAddr;
	String category;
	String deleveryArea1;
	String deleveryArea2;
	String deleveryArea3;
	String deleveryArea4;
	String deleveryArea5;
	
	
	
	public CeoSignStoreVO() {
		super();
	}

	public CeoSignStoreVO(int storeNo, String ceo_id, String storeName, String licenseNo, String storeTel, String baseAddr,
			String detailAddr, String category, String deleveryArea1, String deleveryArea2, String deleveryArea3,
			String deleveryArea4, String deleveryArea5) {
		super();
		this.storeNo = storeNo;
		this.ceo_id = ceo_id;
		this.storeName = storeName;
		this.licenseNo = licenseNo;
		this.storeTel = storeTel;
		this.baseAddr = baseAddr;
		this.detailAddr = detailAddr;
		this.category = category;
		this.deleveryArea1 = deleveryArea1;
		this.deleveryArea2 = deleveryArea2;
		this.deleveryArea3 = deleveryArea3;
		this.deleveryArea4 = deleveryArea4;
		this.deleveryArea5 = deleveryArea5;
	}

	public int getStoreNo() {
		return storeNo;
	}

	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}

	public String getCeo_id() {
		return ceo_id;
	}

	public void setCeo_id(String ceo_id) {
		this.ceo_id = ceo_id;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(String licenseNo) {
		this.licenseNo = licenseNo;
	}

	public String getStoreTel() {
		return storeTel;
	}

	public void setStoreTel(String storeTel) {
		this.storeTel = storeTel;
	}

	public String getBaseAddr() {
		return baseAddr;
	}

	public void setBaseAddr(String baseAddr) {
		this.baseAddr = baseAddr;
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

	public String getDeleveryArea1() {
		return deleveryArea1;
	}

	public void setDeleveryArea1(String deleveryArea1) {
		this.deleveryArea1 = deleveryArea1;
	}

	public String getDeleveryArea2() {
		return deleveryArea2;
	}

	public void setDeleveryArea2(String deleveryArea2) {
		this.deleveryArea2 = deleveryArea2;
	}

	public String getDeleveryArea3() {
		return deleveryArea3;
	}

	public void setDeleveryArea3(String deleveryArea3) {
		this.deleveryArea3 = deleveryArea3;
	}

	public String getDeleveryArea4() {
		return deleveryArea4;
	}

	public void setDeleveryArea4(String deleveryArea4) {
		this.deleveryArea4 = deleveryArea4;
	}

	public String getDeleveryArea5() {
		return deleveryArea5;
	}

	public void setDeleveryArea5(String deleveryArea5) {
		this.deleveryArea5 = deleveryArea5;
	}

	@Override
	public String toString() {
		return "CeoSignStoreVO [storeNo=" + storeNo + ", ceo_id=" + ceo_id + ", storeName=" + storeName + ", licenseNo="
				+ licenseNo + ", storeTel=" + storeTel + ", baseAddr=" + baseAddr + ", detailAddr=" + detailAddr
				+ ", category=" + category + ", deleveryArea1=" + deleveryArea1 + ", deleveryArea2=" + deleveryArea2
				+ ", deleveryArea3=" + deleveryArea3 + ", deleveryArea4=" + deleveryArea4 + ", deleveryArea5="
				+ deleveryArea5 + "]";
	}


	
	

}
