package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;

public class LeaveMemberProcessController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");

		String userSelect = request.getParameter("userSelect");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		String msg = "";
		String url = "";

		System.out.println("searchPass");

		// 개인회원
		if (userSelect.equals("personal")) {

			PersonalVO personalVO = new PersonalVO();
			personalVO.setId(id);
			personalVO.setPass(password);

			PersonalDAO dao = new PersonalDAO();
			PersonalVO userVO = dao.login(personalVO);

			if (userVO != null) {
				dao.leaveMember(id);

				msg = "[ " + userVO.getId() + " ]님 탈퇴되었습니다.";
				url = request.getContextPath();
			} else {
				msg = "정보를 잘 못 입력하셨습니다.";
				url = request.getContextPath() + "/login/leaveMember.do";
			}
		}

		// 사업자회원
		else if (userSelect.equals("ceo")) {

			CeoSignUpVO ceoSignUpVO = new CeoSignUpVO();
			ceoSignUpVO.setId(id);
			ceoSignUpVO.setPassword(password);

			CeoSignUpDAO dao = new CeoSignUpDAO();
			CeoSignUpVO userVO = dao.login(ceoSignUpVO);

			if (userVO != null) {
				dao.leaveMember(id);

				msg = "[ " + userVO.getId() + " ]님 탈퇴되었습니다.";
				url = request.getContextPath();
			} else {
				msg = "정보를 잘 못 입력하셨습니다.";
				url = request.getContextPath() + "/login/leaveMember.do";
			}
		}
		System.out.println("searchPass2");

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/jsp/login/leaveMemberProcess.jsp";
	}

}