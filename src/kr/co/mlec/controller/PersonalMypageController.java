package kr.co.mlec.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.PersonalVO;
import kr.co.mlec.order.vo.OrderVO;
import kr.co.mlec.store.vo.StoreVO;

public class PersonalMypageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");		
		
		HttpSession session = request.getSession();
		PersonalVO userVO = (PersonalVO)session.getAttribute("userVO");
		
		PersonalDAO dao = new PersonalDAO();
		PersonalVO personal = new PersonalVO();
		personal = dao.selectById(userVO.getId());
		
		request.setAttribute("personal", personal);

		
		String id = userVO.getId();
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		personal.setName(name);
		personal.setPass(pass);
		personal.setPhone(phone);
		personal.setEmail(email);
		
		List<OrderVO> orderList = dao.mypageSelectOrder(id);
		request.setAttribute("orderList", orderList);
		
		return "/jsp/mypage/personalMypage.jsp";
	}
	
}
