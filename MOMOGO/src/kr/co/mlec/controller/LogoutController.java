package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//세션 삭제
		HttpSession session = request.getSession();
		session.invalidate();
		return	"/jsp/login/logout.jsp";
	}	
	
}
