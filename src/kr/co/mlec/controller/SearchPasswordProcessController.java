package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SearchPasswordProcessController implements Controller {

	   @Override
	   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		   return "jsp/login/searchPasswordProcess.jsp";
	   }
}
