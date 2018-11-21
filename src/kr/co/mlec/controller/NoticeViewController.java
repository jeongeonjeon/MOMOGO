package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.NoticeVO;

public class NoticeViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		int no = Integer.parseInt(request.getParameter("noticeNo"));
		
		NoticeDAO dao = new NoticeDAO(); 
		
		NoticeVO notice = dao.selectByNo(no);
		
		request.setAttribute("notice", notice);
		
		String returnAddr = "/jsp/board/noticeView.jsp?noticeNo="+no;
		System.out.println(returnAddr);
		
		return returnAddr;
	}

	
}
