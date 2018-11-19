package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//userVO 로그인정보가 null이면 없는 정보이니 다시 "/jsp/login/login.jsp"로 돌아간다.
		if(request.getSession().getAttribute("userVO") != null) {
			return "redirect: " + request.getContextPath();
		}
		return "/jsp/login/login.jsp";
	}
	
}
