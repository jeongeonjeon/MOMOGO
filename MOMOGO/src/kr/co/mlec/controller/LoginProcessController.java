package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.board.dao.LoginDAO;
import kr.co.mlec.board.vo.LoginVO;

public class LoginProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id		 = request.getParameter("id");
		String password  = request.getParameter("password");
		
		
		
		LoginVO loginVO = new LoginVO();
		loginVO.setId(id);
		loginVO.setPassword(password);
		
		LoginDAO dao = new LoginDAO();
		LoginVO userVO = dao.login(loginVO);
		
		String msg = "";
		String url = "";
		if(userVO != null) {
			// 로그인 성공
			switch(userVO.getType()) {
			case "S" :
				msg = userVO.getId() + "관리자님 환영";
				break;
			case "U" :
				msg = userVO.getId() + "사용자님 환영";
				break;
			}
			url = request.getContextPath();
			
			//아이디와 비번정보를 세션에등록
			HttpSession session = request.getSession();
			session.setAttribute("userVO", userVO); // 자바에서는  세션영역을 얻어올수 없어서 request로 얻어와서 이렇게 코드로 써주어야한다.
			
		} else {
			// 로그인 실패
			msg = "잘못입력함";
			url = request.getContextPath() + "/login/login.do";
		}
		
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/jsp/login/loginProcess.jsp";
	}

/*	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LoginProcessController 실행....");
		return "redirect:" + request.getContextPath() + "/login/login.do"; //redirect기술
		return "/login/login.do"; //forward기술 
		
		redirect기술과 forward기술의 차이점을 알아야함
	}
*/

}
