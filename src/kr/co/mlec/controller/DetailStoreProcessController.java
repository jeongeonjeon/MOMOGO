package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.store.dao.StoreDAO;

public class DetailStoreProcessController implements Controller{
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String storeNo = request.getParameter("storeNo");
		String[] foodName = request.getParameterValues("food_name");
		
		StoreDAO dao = new StoreDAO();
		
		int seqNo = dao.selectNo();
		
		dao.insertMyOrder(id, seqNo, storeNo);
		
		for(int i=0;i<foodName.length;i++) {
			dao.insertOrder(seqNo,foodName[i]);
		}
		
		
		return "/jsp/store/detailStoreProcess.jsp";
	}

}
