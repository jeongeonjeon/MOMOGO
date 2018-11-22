package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.PersonalVO;

public class SearchIdProcessController implements Controller {

	   @Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
	      request.setCharacterEncoding("utf-8");
	      
	      String userSelect  = request.getParameter("userSelect");
	      String name        = request.getParameter("name");
	      String phone  	 = request.getParameter("phone");
	      String email 		 = request.getParameter("email");
	      
	      // 개인회원
	      if(userSelect.equals("personal")) {
	    	  PersonalVO personalVO = new PersonalVO();
	    	  personalVO.setName(name);
	    	  personalVO.setPhone(phone);
	    	  personalVO.setEmail(email);
	    	  
	    	  PersonalDAO dao = new PersonalDAO();
	    	  PersonalVO idVO = dao.searchId(personalVO);
	    	  
	    	  
	    	  
	    	  
	      }
	      
	      return "/jsp/login/searchIdProcess.jsp";
	   }

}
