package kr.co.mlec.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.controller.Controller;

public class NoticeListController implements Controller{
	
	//handleRequest는 실제 servlet2.5버전에서 사용한 이름. 현재는 아님
	@Override
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		NoticeDAO dao = new NoticeDAO();
		
		int pageNo;
		
		if(request.getParameter("page")==null || request.getParameter("page").length() == 0){
			pageNo = 1;
		}else{
			pageNo = Integer.parseInt(request.getParameter("page"));
		}
		
		List<NoticeVO> list = dao.selectAllNotice(pageNo);
		
		request.setAttribute("list", list);
		
		return "/jsp/board/noticeList.jsp";
		
	}

}
