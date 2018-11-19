package kr.co.mlec.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//사이트 경로 과정 
/*
1. 클라이언트가  대표 서블릿인 FrontController에게 요청한다. =>예시)클라이언트는 FrontController에게  board/list.do 요청함, 
2. FrontController은 클라이언트의 요청정보를 받고 중간에 어떤 jsp파일로 응답해야하는지 알려줄 수 있는  Controller에게 다시 클라이언트의  요청정보를 보낸다. 
	=>다시 FrontController는 ListController에게 board/list.do를 요청함 
 	* FrontController가 요청한것을 바로처리하지 않고 중간에 Controller가 껴서 응답해야하는 jsp파일을 알려주는 이유는 
 	  FrontController가 모든 jsp파일을 다 알 수 없으니 중간에 여러개의 Controller를 분류해 다시 요청하는 것이다. 
3. FrontController에게 정보를 받은 ListController은 클라이언트에게 응답해야하는 jsp 정보를 FrontController에게 알려줍니다. 
4. FrontController는 클라이언트에게 응답해주어야하는 jsp파일에게 일을 하라고 시킵니다.
5. 해당하는 jsp파일이 클라이언트에게 요청했던 화면을 뿌려줍니다. =>최종적으로 클라이언트에게 응답을 수행함
*/


public class FrontController extends HttpServlet  {
	
	private HandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException{
		
		String propLocation = config.getInitParameter("propLocation");
		
		mappings = new HandlerMapping(propLocation);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)	//서블릿에서 얻어온 클라이언트의 요청 정보 
					throws IOException, ServletException {

		String context = request.getContextPath();	//localhost:8888/Mission-Web-MVC01를 의미

		String uri = request.getRequestURI();	//localhost:8888/Mission-Web-MVC01/*.do 
		uri = uri.substring(context.length());	//substring => context가 가지고 있는 localhost:8888/Mission-Web-MVC01 길이 만큼 자르겠다.
		
		System.out.println("호출된 uri : " + uri);	//최종적으로 *.do 만 남게된다.
		
		
	//	
	try {
				
				Controller control = mappings.getController(uri);
				String callPage = control.handleRequest(request, response); //forward시킬 jsp파일에 대한정보
				
				if(callPage.startsWith("redirect: ")) {
					response.sendRedirect(callPage.substring("redirect: ".length()));
			
				} else {
					RequestDispatcher dispatcher = request.getRequestDispatcher(callPage);
					dispatcher.forward(request, response);
				}
				
			} catch(Exception e) {
				throw new ServletException(e);
			}
			
	
		}
	}





