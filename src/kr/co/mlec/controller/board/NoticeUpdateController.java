package kr.co.mlec.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.controller.Controller;

public class NoticeUpdateController  implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("noticeUadate");
		
		int no = Integer.parseInt(request.getParameter("noticeNo"));
		
		NoticeDAO dao = new NoticeDAO(); 
		
		NoticeVO notice = dao.selectByNo(no);
		
		request.setAttribute("notice", notice);
		
		System.out.println(notice.toString());
		
		return "/jsp/board/noticeUpdate.jsp";
		
	}

}
