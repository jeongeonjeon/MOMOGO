package kr.co.mlec.controller.mypage;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.ceo.dao.CeoDAO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.menu.vo.MenuVO;

public class CeoMypageController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");		
		
		HttpSession session = request.getSession();
		CeoSignUpVO userVO = (CeoSignUpVO)session.getAttribute("userVO");
		
		/* 사업자 정보 변경시 데이터 새로 가져옴*/
		CeoSignUpDAO dao = new CeoSignUpDAO();
		CeoSignUpVO ceo = new CeoSignUpVO();
		ceo = dao.selectById(userVO.getId());
		request.setAttribute("ceo", ceo);
		
		/* 메뉴 추가시 dao에서 메뉴정보 가져와서 request 영역에 올림 */
		CeoDAO cDAO = new CeoDAO();
		System.out.println("ceoNo:"+userVO.getCeoNo());
		List<MenuVO> lists = cDAO.selectAllMenu(userVO.getCeoNo());
		request.setAttribute("menuList", lists);
		
		for(MenuVO m : lists) {
			System.out.println("DB에서 가져온 메뉴 :"+m.toString());
		}
		
		return "/jsp/mypage/ceoMypage.jsp";
	}

}
