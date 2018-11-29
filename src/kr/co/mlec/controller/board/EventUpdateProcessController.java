package kr.co.mlec.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.EventDAO;
import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.EventVO;
import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.controller.Controller;

public class EventUpdateProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("noticeUadateProcess");
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("noticeNo"));
		
		EventDAO dao = new EventDAO();
		EventVO event = dao.selectByNo(no);
		
		event.setTitle(request.getParameter("title"));
		event.setContent(request.getParameter("content"));
		
	 	
	 	System.out.println(event.toString());
	 			
	 	dao.updateEvent(event);;
	 	
	 	return "/jsp/board/eventUpdateProcess.jsp";
		
	}

}
