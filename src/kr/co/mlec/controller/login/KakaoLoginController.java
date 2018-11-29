package kr.co.mlec.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.join.vo.PersonalVO;

public class KakaoLoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String type = "personal";
		String id = request.getParameter("id");
		String password   = "null";
		
		String msg ="";
		
		PersonalVO userVO = new PersonalVO(id, password, type);
		
		msg = userVO.getId()+"님 환영합니다.";
		String url = request.getContextPath();
		
		HttpSession session = request.getSession();
		session.setAttribute("userVO", userVO);   
        
        request.setAttribute("msg", msg);
        request.setAttribute("url", url);
        
		
		return "/jsp/login/loginFormProcess.jsp";
	}

}
