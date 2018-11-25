package kr.co.mlec.controller;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import kr.co.mlec.board.dao.EventDAO;
import kr.co.mlec.board.dao.NoticeDAO;
import kr.co.mlec.board.vo.EventFileVO;
import kr.co.mlec.board.vo.EventVO;
import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.util.MomogoFileNamePolicy;

public class EventFormProcessController implements Controller {
	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String saveFolder = "C:\\Lecture\\MOMOGO\\WebContent\\upload";
		
		MultipartRequest multi = new MultipartRequest( //파일이 날라오기때문에 그것
				request, 
				saveFolder, 
				1024 * 1024 * 3,
				"utf-8",
				new MomogoFileNamePolicy()
		);
		
		System.out.print(multi);
		
		
		// 게시물 저장(event)
		
		EventVO event = new EventVO();
		
		event.setTitle(request.getParameter("title"));
		event.setWriter(request.getParameter("writer"));
		event.setContent(request.getParameter("content"));
		
		EventDAO dao = new EventDAO();
		
		int noticeNo = dao.selectNo();
		event.setNoticeNo(noticeNo);
	 			
	 	dao.insertEvent(event);		
	 	
	 	
	 	//첨부파일 저장 
	 	
	 	Enumeration<String> files = multi.getFileNames();
		while(files.hasMoreElements()){
			String fileName  = files.nextElement() ; 
			System.out.println("fileName : " + fileName); 
			File f = multi.getFile(fileName);
			System.out.println(fileName + ":" + f); 
			
			if(f != null){
			String fileOriName =  multi.getOriginalFileName(fileName);
			String fileSaveName =	multi.getFilesystemName(fileName); 
			int fileSize = (int)f.length(); 
		
			EventFileVO fileVO = new EventFileVO();
			fileVO.setFileOriName(fileOriName);  
			fileVO.setFileSaveName(fileSaveName);
			fileVO.setFileSize(fileSize);
			fileVO.setBoardNo(boardNo);
			
			dao.insertFile(fileVO);
		
			}
		}

		return "/jsp/board/eventFormProcess.jsp";
	}

}
