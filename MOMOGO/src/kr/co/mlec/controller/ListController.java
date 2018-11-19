package kr.co.mlec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.BoardDAO;
import kr.co.mlec.board.vo.BoardVO;


public class ListController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
				throws Exception {
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> list = dao.selectAllBoard();
		
		request.setAttribute("list", list);
	
	return "/jsp/board/list.jsp";	//forword,include, xml는 / 가 locallhost:8888/Mission-Web-MVC01을 의미 
	}
}

























