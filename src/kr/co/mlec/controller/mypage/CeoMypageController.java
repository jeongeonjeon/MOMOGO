package kr.co.mlec.controller.mypage;

import java.util.ArrayList;
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
		
		/* lists의 menuVO에서 type에 따른 분류작업 */
		List<String> menuNames=new ArrayList<>();
		for(MenuVO m : lists) {
			if(!menuNames.contains(m.getType())) {
				menuNames.add(m.getType());
			}
		}
		/* ceoMypage.jsp에서 menuNames과 lists를 비교하여 분류할 것임*/
		request.setAttribute("menuNames", menuNames);
		request.setAttribute("menuList", lists);
		
		return "/jsp/mypage/ceoMypage.jsp";
	}

}
