package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.store.dao.StoreDAO;

public class DetailStoreProcessController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String storeNo = request.getParameter("storeNo");
		
		
		StoreDAO dao = new StoreDAO();
		/*dao.insertOrder();*/
		
		
		return "/jsp/store/detailStoreProcess.jsp";
	}

}
