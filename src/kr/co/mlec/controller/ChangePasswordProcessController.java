package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;

public class ChangePasswordProcessController implements Controller {

	   @Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		  
		  request.setCharacterEncoding("utf-8");
		  
		  String userSelect = request.getParameter("userSelect");
		  String id 		= request.getParameter("id");
		  String password	= request.getParameter("password");
		  
		  String msg ="";
		  String url ="";
		  
		  // 개인회원
		  if(userSelect.equals("personal")) {
			  PersonalVO personal = new PersonalVO();
			  personal.setId(id);
			  personal.setPass(password);
			  
			  PersonalDAO dao = new PersonalDAO();
			  dao.changePw(personal);
			  
			  msg = personal.getId() + "님의 비밀번호가 변경되었습니다.";
			  url = request.getContextPath()+"/login/loginForm.do";
		  }		  
		  
		  // 사업자회원
		  else if(userSelect.equals("ceo")) {
			  CeoSignUpVO ceoSignUp = new CeoSignUpVO();
			  ceoSignUp.setId(id);
			  ceoSignUp.setPassword(password);
			  
			  CeoSignUpDAO dao = new CeoSignUpDAO();
			  dao.changePw(ceoSignUp);	
			  
			  msg = ceoSignUp.getId() + "님의 비밀번호가 변경되었습니다.";
			  url = request.getContextPath()+"/login/loginForm.do";
		  }
		  
	      request.setAttribute("msg", msg);
	      request.setAttribute("url", url);
	     		   
		  return "/jsp/login/changePasswordProcess.jsp";
	   }

}
