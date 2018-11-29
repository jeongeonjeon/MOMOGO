package kr.co.mlec.controller.mypage;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.controller.Controller;
import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;

public class CeoMypageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");		
		
		HttpSession session = request.getSession();
		CeoSignUpVO userVO = (CeoSignUpVO)session.getAttribute("userVO");
		
		CeoSignUpDAO dao = new CeoSignUpDAO();
		CeoSignUpVO ceo = new CeoSignUpVO();
		ceo = dao.selectById(userVO.getId());
		request.setAttribute("ceo", ceo);
			
		
		return "/jsp/mypage/ceoMypage.jsp";
	}

}
