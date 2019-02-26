package kr.co.mlec.controller.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;

public class PersonalProfileUpdateController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		PersonalVO personalVO = new PersonalVO();
		
		String name = request.getParameter("name");
		String password	= request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		personalVO.setName(name);
		personalVO.setPass(password);
		personalVO.setPhone(phone);
		personalVO.setEmail(email);
		
		PersonalDAO personalDao = new PersonalDAO();
		int updateResult = personalDao.updateInfo(personalVO);
		
		if(updateResult==1) {
			HttpSession session= request.getSession();
			PersonalDAO dao = new PersonalDAO();
			PersonalVO userVO = dao.login(personalVO);
			session.setAttribute("userVO", userVO);      
            session.setAttribute("personalVO", userVO);
		}
		
		return "/jsp/mypage/personalMypage.jsp";
	}
}
