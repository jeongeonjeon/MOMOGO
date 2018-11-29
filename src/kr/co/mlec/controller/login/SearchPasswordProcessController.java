package kr.co.mlec.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;

public class SearchPasswordProcessController implements Controller {

	   @Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		      request.setCharacterEncoding("utf-8");
		      
		      
		      String userSelect  = request.getParameter("userSelect");
		      String id			 = request.getParameter("id");
		      String name        = request.getParameter("name");
		      String phone  	 = request.getParameter("phone");
		      
		      String msg ="";
		      String url ="";
		      
		      System.out.println("searchPass");
		      
		      // 개인회원
		      if(userSelect.equals("personal")) {
		    	  PersonalVO personalVO = new PersonalVO();
		    	  personalVO.setId(id);
		    	  personalVO.setName(name);
		    	  personalVO.setPhone(phone);
		    	  
		    	  PersonalDAO dao = new PersonalDAO();
		    	  PersonalVO pwVO = dao.searchPw(personalVO);
		    	  
		    	  System.out.println("Controller확인"+pwVO);
		    	  
		    	  if(pwVO != null) {
		    		msg = "[ " + pwVO.getId() +" ]님의 아이디가 확인되었습니다.";
		    		url = request.getContextPath()+"/login/changePassword.do";
		    	  } else {
			    	msg = "정보를 잘 못 입력하셨습니다.";
			    	url = request.getContextPath()+"/login/searchPassword.do";
			      }	    	   	     	 	    	  
		      } 
		      
		      // 사업자회원
		      else if (userSelect.equals("ceo")) {
		    	  CeoSignUpVO ceoSignUpVO = new CeoSignUpVO();
		    	  ceoSignUpVO.setId(id);
		    	  ceoSignUpVO.setName(name);
		    	  ceoSignUpVO.setPhone(phone);
		    	  
		    	  CeoSignUpDAO dao = new CeoSignUpDAO();
		    	  CeoSignUpVO pwVO = dao.searchPw(ceoSignUpVO);
		    	  
		    	  if(pwVO != null) {
		    		msg = "[ " + pwVO.getId() +" ]님의 아이디가 확인되었습니다.";
		    		url = request.getContextPath()+"/login/changePassword.do";
		     	  } else {
			    	msg = "정보를 잘 못 입력하셨습니다.";
			    	url = request.getContextPath()+"/login/searchPassword.do";
			      }	    	   	    	    	  
		      }	      
		      System.out.println("searchPass2");
		      
		      request.setAttribute("msg", msg);
		      request.setAttribute("url", url);
		      request.setAttribute("id", id);

		   return "/jsp/login/searchPasswordProcess.jsp";
	   }
}
