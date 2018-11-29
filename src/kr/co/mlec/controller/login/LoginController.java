package kr.co.mlec.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("로그인컨트롤러");
		//로그인되어있을 땐 로그인 페이지에 접근하지 못하도록 막음(메인으로 감)
		if(request.getSession().getAttribute("userVO") != null) {
			return "redirect:"+request.getContextPath();
		}
		return "/jsp/login/login.jsp";
	}
	
}
