package kr.co.mlec.controller.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;


public class EventFormController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		
		return "/jsp/board/eventForm.jsp";
	}

	
	
}