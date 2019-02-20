package kr.co.mlec.controller.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.ceo.dao.CeoDAO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;

public class CeoProfileUpdateController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		CeoSignUpVO ceoVO=new CeoSignUpVO();
		ceoVO.setId(request.getParameter("id"));
		ceoVO.setName(request.getParameter("name"));
		ceoVO.setPassword(request.getParameter("password"));
		ceoVO.setPhone(request.getParameter("phone"));
		ceoVO.setEmail(request.getParameter("email"));
		
		CeoDAO ceoDao=new CeoDAO();
		int updateResult = ceoDao.updateCeoProfile(ceoVO);
		
		if(updateResult==1) {
			HttpSession session= request.getSession();
			CeoSignUpDAO dao = new CeoSignUpDAO();
			CeoSignUpVO userVO = dao.login(ceoVO);
			session.setAttribute("userVO", userVO);      
            session.setAttribute("ceoVO", userVO);
		}
		return "/jsp/mypage/ceoMypage.jsp";
	}

}
