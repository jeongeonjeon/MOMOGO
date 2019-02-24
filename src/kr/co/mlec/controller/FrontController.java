package kr.co.mlec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 요청처리는 모두 FrontController가 수행하기 때문에 
 * 다른 java파일들은 Servlet일 필요가 없다!!!
 * 따라서 servlet파일은 FrontController 한개!!!!!
 * 더이상 수정할 필요없음!
 */
public class FrontController extends HttpServlet{
	
	
	HandlerMapping mappings;

	@Override
	public void init(ServletConfig config) throws ServletException{
		String propLocation = config.getInitParameter("propLocation");
		
		mappings  = new HandlerMapping(propLocation);	//�븳踰덈쭔 �닔�뻾
	
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String context = request.getContextPath();
		String uri = request.getRequestURI();

		uri = uri.substring(context.length());
		
		System.out.println("호출된 uri : "+uri);
		
		try {
			
			Controller control = mappings.getController(uri);
			
/*         
//	         HandleMapping 클래스가 하도록 변경!
//	         아래 switch코드의 세부역할을 ListController클래스가 하도록 변경!
	         switch(uri) {
	         case "/board/list.do":
	            System.out.println("게시판 목록처리");
	            control = new ListController();
	            break;
	         case "/board/writeForm.do":
	            System.out.println("새글 등록처리");
	            control = new WriteFormController();
	            break;
	         }
	*/         			
			String callPage = control.handleRequest(request, response);
			
			/* ajax 통신시 request header에 X-Requested-With의 키 값으로 XMLHttpRequest의 value를 담고 있다 
			 * 즉, request에 X-Requested-With가 있으면 ajax란 뜻*/
			if(request.getHeader("X-Requested-With")!=null){
				/* 나중에 ajax를 통한 request를 response 할 때, 여기에 작성 */
			}else {
				if(callPage.startsWith("redirect:")) {
					response.sendRedirect(callPage.substring("redirect:".length()));
				}else {
					
					RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
					//forward시킴
					dispatcher.forward(request, response);
				
				}
			}	
			
		}catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
}
