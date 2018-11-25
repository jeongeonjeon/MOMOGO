package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import kr.co.mlec.store.dao.StoreDAO;
import kr.co.mlec.store.vo.StoreVO;

public class StoreListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		StoreDAO dao = new StoreDAO();
		
		String address = request.getParameter("address");
		String category = request.getParameter("category");
		
		List<StoreVO> list = dao.selectCategoryStore(address, category); 
		
		request.setAttribute("list", list);
		

		return "/jsp/store/storeList.jsp";
	}
}