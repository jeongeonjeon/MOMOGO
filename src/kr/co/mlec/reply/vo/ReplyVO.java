package kr.co.mlec.reply.vo;

public class ReplyVO {
	
	int replyNo; 
	int reviewNo;
	String id; 
	String content; 
	String writeDate;
	
	
	public ReplyVO(int replyNo, int reviewNo, String id, String content, String writeDate) {
		super();
		this.replyNo = replyNo;
		this.reviewNo = reviewNo;
		this.id = id;
		this.content = content;
		this.writeDate = writeDate;
	}


	public ReplyVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getReplyNo() {
		return replyNo;
	}


	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
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


	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", reviewNo=" + reviewNo + ", id=" + id + ", content=" + content
				+ ", writeDate=" + writeDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
