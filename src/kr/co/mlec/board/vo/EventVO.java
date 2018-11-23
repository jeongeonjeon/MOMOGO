package kr.co.mlec.board.vo;

public class EventVO {

	private int eventNo;
	private String title;
	private String writer;
	private String content;
	private int viewCnt;
	private String regDate;
	
	public int getEventNo() {
		return eventNo;
	}

	public void setEventNo(int eventNo) {
		this.eventNo = eventNo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public EventVO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EventVO(String title, String writer) {
		super();
		this.title = title;
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public EventVO(int eventNo, String title, String writer, String content, int viewCnt, String regDate) {
		super();
		this.eventNo = eventNo;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.viewCnt = viewCnt;
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "NoticeVO [eventNo=" + eventNo + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", viewCnt=" + viewCnt + ", regDate=" + regDate + "]";
	}

	
	

	
}
