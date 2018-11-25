package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;

public class SearchIdProcessController implements Controller {

	   @Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	      request.setCharacterEncoding("utf-8");
	      
	      String userSelect  = request.getParameter("userSelect");
	      String id			 = request.getParameter("id");
	      String name        = request.getParameter("name");
	      String phone  	 = request.getParameter("phone");
	      String email 		 = request.getParameter("email");
	      
	      String msg ="";
	      String url ="";
	      
	      // 개인회원
	      if(userSelect.equals("personal")) {
	    	  PersonalVO personalVO = new PersonalVO();
	    	  personalVO.setId(id);
	    	  personalVO.setName(name);
	    	  personalVO.setPhone(phone);
	    	  personalVO.setEmail(email);
	    	  
	    	  PersonalDAO dao = new PersonalDAO();
	    	  PersonalVO idVO = dao.searchId(personalVO);
	    	  
	    	  System.out.println("Controller확인"+idVO);
	    	  
	    	  if(idVO != null) {
	    		msg =  "회원님의 아이디는 [ " + idVO.getId() + " ] 입니다.";
	    		url = request.getContextPath()+"/login/loginForm.do";
	    	  } else {
		    	msg = "정보를 잘 못 입력하셨습니다.";
		    	url = request.getContextPath()+"/login/searchId.do";
		      }	    	   	     	 	    	  
	      } 
	      
	      // 사업자회원
	      else if (userSelect.equals("ceo")) {
	    	  CeoSignUpVO ceoSignUpVO = new CeoSignUpVO();
	    	  ceoSignUpVO.setId(id);
	    	  ceoSignUpVO.setName(name);
	    	  ceoSignUpVO.setPhone(phone);
	    	  ceoSignUpVO.setEmail(email);
	    	  
	    	  CeoSignUpDAO dao = new CeoSignUpDAO();
	    	  CeoSignUpVO idVO = dao.searchId(ceoSignUpVO);
	    	  
	    	  if(idVO != null) {
	    		msg =  "회원님의 아이디는 [ " + idVO.getId() + " ] 입니다.";
	    		url = request.getContextPath()+"/login/loginForm.do";
	     	  } else {
		    	msg = "정보를 잘 못 입력하셨습니다.";
		    	url = request.getContextPath()+"/login/searchId.do";
		      }	    	   	    	    	  
	      }	      
	      
	      request.setAttribute("msg", msg);
	      request.setAttribute("url", url);
	      
	      return "/jsp/login/searchIdProcess.jsp";
	   }

}
