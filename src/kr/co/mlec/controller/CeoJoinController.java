package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.join.dao.CeoSignStoreDAO;
import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.vo.CeoSignStoreVO;
import kr.co.mlec.join.vo.CeoSignUpVO;

public class CeoJoinController implements Controller {
	
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String storeName = request.getParameter("storeName");
		String licenseNo = request.getParameter("licenseNo");
		String storeTel = request.getParameter("storeTel");
		String baseAddr = request.getParameter("baseAddr");
		String detailAddr = request.getParameter("detailAddr");
		String category = request.getParameter("category");
		String deleveryArea1 = request.getParameter("deleveryArea1");
		String deleveryArea2 = request.getParameter("deleveryArea2");
		String deleveryArea3 = request.getParameter("deleveryArea3");
		String deleveryArea4 = request.getParameter("deleveryArea4");
		String deleveryArea5 = request.getParameter("deleveryArea5");
		
		CeoSignUpVO ceoSign = new CeoSignUpVO();
		CeoSignStoreVO ceoStore = new CeoSignStoreVO();
		
		ceoSign.setId(id);
		ceoSign.setPassword(password);
		ceoSign.setEmail(email);
		ceoSign.setName(storeName);
		ceoSign.setPhone(phone);
		ceoStore.setStoreName(storeName);
		ceoStore.setLicenseNo(licenseNo);
		ceoStore.setStoreTel(storeTel);
		ceoStore.setBaseAddr(baseAddr);
		ceoStore.setDetailAddr(detailAddr);
		ceoStore.setCategory(category);
		ceoStore.setDeleveryArea1(deleveryArea1);
		ceoStore.setDeleveryArea2(deleveryArea2);
		ceoStore.setDeleveryArea3(deleveryArea3);
		ceoStore.setDeleveryArea4(deleveryArea4);
		ceoStore.setDeleveryArea5(deleveryArea5);
		
		CeoSignUpDAO ceoDao = new CeoSignUpDAO();
		CeoSignStoreDAO storeDao = new CeoSignStoreDAO();
		
		ceoDao.CeoSignUp(ceoSign);
		storeDao.CeoSignStore(ceoStore);
		
		return "/jsp/login/ceoJoin.jsp";
	}
	
}
