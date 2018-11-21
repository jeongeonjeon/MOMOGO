package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.login.PersonalDAO;
import kr.co.mlec.login.PersonalVO;

public class PersonalSignupProcess implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		PersonalVO person = new PersonalVO();
		
		person.setId(request.getParameter("id"));
		person.setPass(request.getParameter("pass"));
		person.setEmail(request.getParameter("email"));
		person.setName(request.getParameter("name"));
		person.setPhone(request.getParameter("phone"));
		
		PersonalDAO dao = new PersonalDAO();
		
		dao.Personal_Signup(person);
		
		return "/jsp/join/personalSignupProcess.jsp";
	}
	
	
}
