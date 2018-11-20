/*package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.member.dao.MemberDAO;
import kr.co.mlec.member.vo.MemberVO;

public class LoginProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		//VO객체 생성 후 초기화
		MemberVO memberVO = new MemberVO();
		memberVO.setId(id);
		memberVO.setPassword(pw);
		
		//DB에서 로그인 수행
		MemberDAO dao = new MemberDAO();
		MemberVO userVO = dao.login(memberVO);
		
		String msg="";
		String url = "";
		if(userVO != null) {
			//로그인 성공
			switch (userVO.getType()) {
			case "S":
				msg = "관리자님 환영합니다.";
				break;

			case "U":
				msg = userVO.getId()+"님 환영합니다.";
				break;
			}
			url = request.getContextPath();
			
			//세션등록
			//세션이 jsp에서는 기본내장객체이지만 servlet은 아니기 때문에 불러와야한다.
			
			HttpSession session = request.getSession();	
			session.setAttribute("userVO", userVO);
			
			
		}else {
			//로그인 실패
			msg = "잘못입력하셨습니다.";
			url = request.getContextPath() + "/login/login.do";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);
		
		return "/jsp/login/loginProcess.jsp";	
	}
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		return "redirect:"+request.getContextPath()+"/login/login.do";	//forward
//		return "/login/login.do";
	}

}
*/