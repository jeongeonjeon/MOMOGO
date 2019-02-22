package kr.co.mlec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * �슂泥�泥섎━�뒗 紐⑤몢 FrontController媛� �닔�뻾�븯湲� �븣臾몄뿉 
 * �떎瑜� java�뙆�씪�뱾�� Servlet�씪 �븘�슂媛� �뾾�떎!!!
 * �뵲�씪�꽌 servlet�뙆�씪�� FrontController �븳媛�!!!!!
 * �뜑�씠�긽 �닔�젙�븷 �븘�슂�뾾�쓬!
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
		
		System.out.println("�샇異쒕맂 uri : "+uri);
		
		try {
			
			Controller control = mappings.getController(uri);
			
/*			
//			HandleMapping �겢�옒�뒪媛� �븯�룄濡� 蹂�寃�!
//			�븘�옒 switch肄붾뱶�쓽 �꽭遺��뿭�븷�쓣 ListController�겢�옒�뒪媛� �븯�룄濡� 蹂�寃�!
			switch(uri) {
			case "/board/list.do":
				System.out.println("寃뚯떆�뙋 紐⑸줉泥섎━");
				control = new ListController();
				break;
			case "/board/writeForm.do":
				System.out.println("�깉湲� �벑濡앹쿂由�");
				control = new WriteFormController();
				break;
			}
*/			
			String callPage = control.handleRequest(request, response);
			
			if(callPage.startsWith("redirect:")) {
				response.sendRedirect(callPage.substring("redirect:".length()));
			}else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
				//forward�떆�궡
				dispatcher.forward(request, response);
			
			}	
			
		}catch (Exception e) {
			throw new ServletException(e);
		}
		
	}
}
