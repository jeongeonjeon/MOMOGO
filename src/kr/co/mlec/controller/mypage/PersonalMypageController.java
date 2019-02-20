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
		
		if(request.getMethod().equals("GET")) {
			//GET방식으로 접근시 데이터 변경 없음
		}else {
			//POST 방식으로 접근시 파라미터 맵핑 후 데이터 변경
			String name = request.getParameter("name");
			String password	= request.getParameter("password");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			
			personal.setName(name);
			personal.setPass(password);
			personal.setPhone(phone);
			personal.setEmail(email);
			dao.updateInfo(personal);
			
			personal = dao.selectById(userVO.getId());
		}
		
		List<OrderVO> orderList = dao.mypageSelectOrder(personal.getId());
		
		request.setAttribute("orderList", orderList);
		request.setAttribute("personal", personal);
		
		return "/jsp/mypage/personalMypage.jsp";
	}
	
}
