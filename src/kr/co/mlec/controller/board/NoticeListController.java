package kr.co.mlec.controller.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.controller.Controller;

public class NoticeListController implements Controller{
	
	
	
	//handleRequest는 실제 servlet2.5버전에서 사용한 이름. 현재는 아님
	@Override
	public String handleRequest(HttpServletRequest request,HttpServletResponse response) throws Exception {
		
		NoticeDAO dao = new NoticeDAO();
		int pageNo = 1; 
		
		try {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch(Exception e) {
			
		}
/*		
		int pageNo;
		
		if(request.getParameter("page")==null || request.getParameter("page").length() == 0){
			pageNo = 1;
		}else{
			pageNo = Integer.parseInt(request.getParameter("page"));
		}
*/
		
		// 해당 페이지의 게시글 목록 
		List<NoticeVO> list = dao.selectNotice(pageNo);
		
		// 전체 게시글 카운트
		int totalCount = dao.selectNoticeCount();
		
		//한 페이지에 보여질 목록 수 
		int listSize = 15; 
		
		//마지막 페이지 구하기 
		int lastPage = (totalCount % listSize ==0)? totalCount / listSize : totalCount / listSize +1; 
		
		
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("lastPage", lastPage);
		request.setAttribute("list", list);
		
		//목록에 보여질 탭 사이즈
		int tabSize= 5; 
		//현재 페이지에 해당하는 탭 위치; 
		int currTab = (pageNo -1) / tabSize +1; 
		int beginPage = (currTab -1) * tabSize +1; 
		int endPage = (currTab * tabSize < lastPage) ? currTab * tabSize : lastPage; 
		
		request.setAttribute("beginPage", beginPage);
		request.setAttribute("endPage", endPage);
		
		System.out.println(totalCount);
		System.out.println(listSize);
		
		return "/jsp/board/noticeList.jsp";
		
	}

}
