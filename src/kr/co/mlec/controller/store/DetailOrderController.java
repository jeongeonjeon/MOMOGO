package kr.co.mlec.controller.store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.List;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.menu.vo.MenuVO;
import kr.co.mlec.reply.vo.ReplyVO;
import kr.co.mlec.review.vo.ReviewVO;
import kr.co.mlec.store.dao.StoreDAO;
import kr.co.mlec.store.vo.StoreVO;

public class DetailOrderController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		StoreDAO dao = new StoreDAO();
		
		String type ="";
		type += request.getParameter("type");
		
		
		String storeNo = request.getParameter("storeNo");
		
		List<StoreVO> storeList = dao.detailSelectStore(storeNo);
		List<MenuVO> menuList = dao.detailSelectMenu(storeNo);
		List<ReviewVO> reviewList = dao.detailSelectReview(storeNo);
		
		request.setAttribute("storeList", storeList);
		request.setAttribute("menuList", menuList);
		request.setAttribute("reviewList", reviewList);

		return "/jsp/store/detailOrder.jsp";
	}
	
}
