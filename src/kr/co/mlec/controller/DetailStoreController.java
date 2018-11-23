package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;
import kr.co.mlec.store.dao.StoreDAO;
import kr.co.mlec.store.vo.StoreVO;

public class DetailStoreController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String address = request.getParameter("storeNo");
		
		return "/jsp/store/detailStore.jsp";
	}
}