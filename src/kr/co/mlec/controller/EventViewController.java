package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.EventDAO;
import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.EventVO;
import kr.co.mlec.board.vo.NoticeVO;

public class EventViewController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		int no = Integer.parseInt(request.getParameter("noticeNo"));
		
		EventDAO dao = new EventDAO(); 
		
		EventVO event = dao.selectByNo(no);
		
		request.setAttribute("event", event);
		
		String returnAddr = "/jsp/board/eventView.jsp?noticeNo="+no;
		System.out.println(returnAddr);
		
		return returnAddr;
	}

	
}
