package kr.co.mlec.review.vo;

public class ReviewVO {
	
	int reviewNo;
	int storeNo;
	int star        ;		
	String id       ;
	String content  ;
	String writeDate;
	int depth		; 
	int parentNo    ;
	


	public ReviewVO(int reviewNo, int storeNo, String id, String content, String writeDate, int star, int depth,
			int parentNo) {
		super();
		this.reviewNo = reviewNo;
		this.storeNo = storeNo;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.star = star;
		this.depth = depth;
		this.parentNo = parentNo;
	}

	public ReviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getParentNo() {
		return parentNo;
	}

	public void setParentNo(int parentNo) {
		this.parentNo = parentNo;
	}

	public int getReviewNo() {
		return reviewNo;
	}


	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}


	public int getStoreNo() {
		return storeNo;
	}


	public void setStoreNo(int storeNo) {
		this.storeNo = storeNo;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}

	@Override
	public String toString() {
		return "ReviewVO [reviewNo=" + reviewNo + ", storeNo=" + storeNo + ", id=" + id + ", content=" + content
				+ ", writeDate=" + writeDate + ", star=" + star + ", depth=" + depth + ", parentNo=" + parentNo + "]";
	}








	
	


}
