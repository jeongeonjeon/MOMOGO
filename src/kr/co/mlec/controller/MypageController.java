package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.PersonalVO;

public class MypageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("MyPageController");
		
		request.setCharacterEncoding("utf-8");		
		
		HttpSession session = request.getSession();
		PersonalVO userVO = (PersonalVO)session.getAttribute("userVO");
		
		PersonalDAO dao = new PersonalDAO();
		PersonalVO personal = dao.selectById(userVO.getId());
		
		request.setAttribute("personal", personal);
		
		return "/jsp/mypage/mypage.jsp";
	}
	
}
