package kr.co.mlec.review.vo;

public class ReviewVO {
	
	int reviewNo;
	String id       ;
	String content  ;
	String writeDate;
	int star        ;		
	
	public ReviewVO(int reviewNo, String id, String content, String writeDate, int star) {
		super();
		this.reviewNo = reviewNo;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.star = star;
	}
	
	public ReviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getReviewNo() {
		return reviewNo;
	}
	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
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
		return "ReviewVO [reviewNo=" + reviewNo + ", id=" + id + ", content=" + content + ", writeDate=" + writeDate
				+ ", star=" + star + "]";
	}

}
