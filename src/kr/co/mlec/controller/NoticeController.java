package kr.co.mlec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.NoticeVO;

public class NoticeController implements Controller{
	
	//handleRequest는 실제 servlet2.5버전에서 사용한 이름. 현재는 아님
	@Override
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		NoticeDAO dao = new NoticeDAO();
		List<NoticeVO> list = dao.selectAllNotice();
		
		request.setAttribute("list", list);
		
		return "/jsp/board/notice.jsp";
		
	}

}
