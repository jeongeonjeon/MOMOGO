package kr.co.mlec.controller.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.controller.Controller;
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
		
		return "/jsp/mypage/personalMypage.jsp";
	}
	
}
