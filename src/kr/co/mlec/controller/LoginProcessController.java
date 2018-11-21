package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String userSelect = request.getParameter("userSelect");
		String id		  = request.getParameter("id");
		String password   = request.getParameter("password");
		
		if(userSelect == "personal") {
			
		}
		

		return "/jsp/login/loginProcess.jsp";	
	}
	

}

