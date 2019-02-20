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

public class DetailStoreController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		StoreDAO dao = new StoreDAO();
		
		String type ="";
		type += request.getParameter("type");
		
		System.out.println(type);
		
		if(type.equals("review")) {
			String storeNo = request.getParameter("storeNo");
			String star = request.getParameter("star");
			String id = request.getParameter("id");
			String replyText = request.getParameter("replyText");
			String depth = request.getParameter("depth"); 
			String parentNo = request.getParameter("parentNo");
			
			
			dao.insertReview(Integer.parseInt(storeNo),Integer.parseInt(star),id,replyText,Integer.parseInt(depth), Integer.parseInt(parentNo));
			
			
			return "/jsp/store/ajax.json";
		}
		
		if(type.equals("review2")) {
			String storeNo = request.getParameter("storeNo");
			String id = request.getParameter("id");
			String replyText = request.getParameter("replyText");
			String depth = request.getParameter("depth"); 
			String parentNo = request.getParameter("parentNo");
			
			
			dao.insertReview(Integer.parseInt(storeNo),id,replyText,Integer.parseInt(depth), Integer.parseInt(parentNo));
			
			return "/jsp/store/ajax.json";
		}
		
		if(type.equals("order")) {
			String storeNum = request.getParameter("storeNum");
			String foodName = request.getParameter("foodName");
			String price = request.getParameter("price");
			
			return "/jsp/store/ajax.json";
		}
		
		
		
		String storeNo = request.getParameter("storeNo");
		
		List<StoreVO> storeList = dao.detailSelectStore(storeNo);
		List<MenuVO> menuList = dao.detailSelectMenu(storeNo);
		List<ReviewVO> reviewList = dao.detailSelectReview(storeNo);
		
		request.setAttribute("storeList", storeList);
		request.setAttribute("menuList", menuList);
		request.setAttribute("reviewList", reviewList);

		return "/jsp/store/detailStore.jsp";
	}
	
}
