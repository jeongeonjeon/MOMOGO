package kr.co.mlec.controller.update;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.controller.Controller;

public class CeoAddMenuController implements Controller{

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		/* multipart/form data를 받아오기 위한 객체*/
		MultipartRequest multi=null;
		/* 이미지가 저장될 서버경로 */
		String uploadDir = request.getRealPath("/img/menuImg");
		/* posted 되는 데이터 크기*/
		int maxSize = 20*1024*1024;//파일 최대크기 20MB
		System.out.println("request content type :"+request.getContentType());
		multi=new MultipartRequest(request, uploadDir, maxSize,"utf-8");
		
		System.out.println(multi.getParameter("pic"));
		String cate = multi.getParameter("cate");
		String name = multi.getParameter("name");
		String price = multi.getParameter("price");
		String describe = multi.getParameter("describe");
		System.out.println(cate+","+name+","+price+","+describe);
		return "/jsp/mypage/ceoMypage.jsp";
	}
	

}
