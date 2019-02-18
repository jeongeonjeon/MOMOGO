package kr.co.mlec.controller.join;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.controller.Controller;

public class Ceo_Id_CheckController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "/jsp/join/ceo_id_check.jsp";
	}

}
