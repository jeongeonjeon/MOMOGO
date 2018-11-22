package kr.co.mlec.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.mlec.join.dao.CeoSignUpDAO;
import kr.co.mlec.join.dao.PersonalDAO;
import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;


public class LoginProcessController implements Controller {

   @Override
   public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
      request.setCharacterEncoding("utf-8");
      
      String userSelect = request.getParameter("userSelect");
      String id        = request.getParameter("id");
      String password   = request.getParameter("password");
      
      String msg ="";
      String url ="";
      
      // 개인회원
      if(userSelect.equals("personal")) {
         PersonalVO personalVO = new PersonalVO();
         personalVO.setId(id);
         personalVO.setPass(password);
         
         PersonalDAO dao = new PersonalDAO();
         PersonalVO userVO = dao.login(personalVO);
         
         if(userVO != null) {
            // 개인회원 로그인 성공
            switch(userVO.getType()) {
            case "S":
               msg = "관리자님 환영합니다.";
               break;
            case "U" :
               msg = userVO.getId()+"님 환영합니다.";
               break;
            }

            url = request.getContextPath();
            
            // 세션 등록
            HttpSession session = request.getSession();
            session.setAttribute("userVO", userVO);         
         } else {
             //로그인 실패
            msg = "아이디 혹은 패스워드를 잘 못 입력하셨습니다.";
            url = request.getContextPath()+"/login/loginForm.do";
         }  
         
      } 
      
      // 사업자회원
      else if (userSelect.equals("ceo")) {
         CeoSignUpVO ceoSignUpVO = new CeoSignUpVO();
         ceoSignUpVO.setId(id);
         ceoSignUpVO.setPassword(password);
         
         CeoSignUpDAO dao = new CeoSignUpDAO();
         CeoSignUpVO userVO = dao.login(ceoSignUpVO);
         
         if(userVO != null) {
            // 개인회원 로그인 성공
            switch(userVO.getType()) {
            case "S":
               msg = "관리자님 환영합니다.";
               break;
            case "U" :
               msg = userVO.getId()+"님 환영합니다.";
               break;
            }

            url = request.getContextPath();
            
            // 세션 등록
            HttpSession session = request.getSession();
            session.setAttribute("userVO", userVO);      
         } else {
             //로그인 실패
            msg = "아이디 혹은 패스워드를 잘 못 입력하셨습니다.";
            url = request.getContextPath()+"/login/loginForm.do";
         }          
         
      }     
      
      request.setAttribute("msg", msg);
      request.setAttribute("url", url);
      
      System.out.println("성공");
      
      return "/jsp/login/loginProcess.jsp";
      
   }
}