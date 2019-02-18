package kr.co.mlec.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.controller.Controller;

public class NoticeUpdateProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("noticeUadateProcess");
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("noticeNo"));
		
		NoticeDAO dao = new NoticeDAO();
		NoticeVO notice = dao.selectByNo(no);
		
		notice.setTitle(request.getParameter("title"));
		notice.setContent(request.getParameter("content"));
		
	 	
	 	System.out.println(notice.toString());
	 			
	 	dao.updateNotice(notice);;
	 	
	 	return "/jsp/board/noticeUpdateProcess.jsp";
		
	}

}
