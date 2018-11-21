package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.NoticeVO;

public class NoticeFormProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		NoticeVO notice = new NoticeVO();
		
		notice.setTitle(request.getParameter("title"));
		notice.setWriter(request.getParameter("writer"));
		notice.setContent(request.getParameter("content"));
		
		NoticeDAO dao = new NoticeDAO();
		
		int noticeNo = dao.selectNo();
	 	notice.setNoticeNo(noticeNo);
	 			
		dao.insertNotice(notice);			
		
		return "/jsp/board/noticeFormProcess.jsp";
	}

}
