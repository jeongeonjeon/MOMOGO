package kr.co.mlec.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.EventDAO;
import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.EventVO;
import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.controller.Controller;

public class EventUpdateController  implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("noticeUadate");
		
		int no = Integer.parseInt(request.getParameter("noticeNo"));
		
		EventDAO dao = new EventDAO(); 
		
		EventVO event = dao.selectByNo(no);
		
		request.setAttribute("event", event);
		
		System.out.println(event.toString());
		
		return "/jsp/board/eventUpdate.jsp";
		
	}

}
