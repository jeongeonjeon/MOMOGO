package kr.co.mlec.controller.update;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.ceo.dao.CeoDAO;
import kr.co.mlec.controller.Controller;
import kr.co.mlec.controller.mypage.FileUploadRename;
import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.menu.vo.MenuVO;

public class CeoAddMenuController implements Controller{

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		request.setCharacterEncoding("utf-8");
		
		/* multipart/form data에 필요한 객체*/
		MultipartRequest multi=null;
		
		/* 서버에 저장할 경로 설정 */
		String uploadDir = request.getRealPath("/img/menuImg/");
		
		/* posted 되는 사이즈 */
		int maxSize = 20*1024*1024;//최대사이즈 20MB
		
		/* 멀티파트리퀘스트 객체 생성, 이 객체는 생성되면서 사진데이터가 저장된다. */
		multi=new MultipartRequest(request, uploadDir, maxSize,"utf-8", new FileUploadRename());
		
		/* formData에서 보내진 다른 텍스트 파라미터, multi 객체에서 꺼내야함 */
		String cate = multi.getParameter("cate");
		String picOriName = multi.getParameter("foodPicName");
		String name = multi.getParameter("name");
		int price = Integer.parseInt(multi.getParameter("price"));
		String describe = multi.getParameter("describe");
		System.out.println(cate+","+picOriName+","+name+","+price+","+describe);
		
		/* MenuVO에 담아 DAO로 보내기 위한 프로세스 */
		CeoSignUpVO ceo = (CeoSignUpVO)request.getSession().getAttribute("ceoVO");
		int ceoNo = ceo.getCeoNo();
		
		MenuVO menu = new MenuVO();
		menu.setCeoNo(ceoNo);
		menu.setPrice(price);
		menu.setDetail(describe);
		menu.setMenuName(name);
		menu.setType(cate);
		menu.setMenuImage(multi.getFilesystemName("foodPic"));
		
		/* dao */
		CeoDAO cDAO = new CeoDAO();
		cDAO.insertMenu(menu);
		
		return "redirect:/MOMOGO/mypage/ceoMypage.do";
		
	}
}
