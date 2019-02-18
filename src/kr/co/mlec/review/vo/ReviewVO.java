package kr.co.mlec.review.vo;

public class ReviewVO {
	
	String id       ;
	String content  ;
	String writeDate;
	int star        ;
	public ReviewVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ReviewVO(String id, String content, String writeDate, int star) {
		super();
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
		this.star = star;
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
		return "ReviewVO [id=" + id + ", content=" + content + ", writeDate=" + writeDate + ", star=" + star + "]";
	}
}
