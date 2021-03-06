package kr.co.mlec.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.EventDAO;
import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.controller.Controller;

public class EventDeleteProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		System.out.println("delete");
		int no = Integer.parseInt(request.getParameter("noticeNo"));
		
		EventDAO dao = new EventDAO(); 
		dao.deleteEvent(no);
		
		
		return "/jsp/board/eventDeleteProcess.jsp";
	}

	
}
