package kr.co.mlec.board.dao;

import java.sql.Connection;

import java.lang.Math;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.vo.EventFileVO;
import kr.co.mlec.board.vo.EventVO;
import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class EventDAO {

	public List<EventVO> selectAllEvent(int page) {
		
		List<EventVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			StringBuilder sql2 = new StringBuilder();	
			sql.append(" select notice_no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ,view_cnt");
			sql.append(" from (                                   ");
			sql.append("         select 	ROWNUM as rnum, e.*      ");
			sql.append("         from (                          ");
			sql.append("                 select *                ");
			sql.append("                 from event             ");
			sql.append("                 order by notice_no desc ");
			sql.append("                 ) e                     ");
			sql.append("          ) e2                           ");
			sql.append(" where rnum between (?*20)-19 and (?*20)");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, page);
			pstmt.setInt(2, page);

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int noticeNo = rs.getInt("notice_no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				
				EventVO event = new EventVO();
				event.setNoticeNo(noticeNo);
				event.setTitle(title);
				event.setWriter(writer);
				event.setRegDate(regDate);
				event.setViewCnt(viewCnt);
				
				list.add(event);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return list;
	}
	
	
	/**
	 * 게시물 삽입을 위한 sequence번호 추출(seq_notice_notice_no)
	 */
	public int selectNo() {
		String sql = "select seq_event_notice_no.nextval from dual ";

		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);				
		) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	

	/**
	 * 게시글 삽입하는 기능
	 */
	public void insertEvent(EventVO event) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into event (notice_no, title, writer, content) ");
			sql.append(" values(seq_event_notice_no.nextval, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			
			int loc = 1;
			
//			pstmt.setInt(loc++, notice.getNoticeNo());
			pstmt.setString(loc++, event.getTitle());
			pstmt.setString(loc++, event.getWriter());
			pstmt.setString(loc++, event.getContent());

			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
	}
	
	/**
	 * 게시글 번호로 조회하는 기능
	 */
	public EventVO selectByNo(int no) {
		
		EventVO event = null; 
		
		StringBuilder sql = new StringBuilder();			
		
		sql.append("select notice_No, title, writer, content, view_cnt ");
		sql.append(" , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append(" from event ");
		sql.append(" where notice_no =? ");
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			
			pstmt.setInt(1,no);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int noticeNo = rs.getInt("notice_no"); 
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				
				event = new EventVO(noticeNo, title, writer, content, viewCnt, regDate);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return event;
	}
	
	/**
	 * 게시글 수정
	 */
	public void updateEvent(EventVO event) {
		
		System.out.println("1");
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" update event ");
		sql.append(" set title =?, content =? ");
		sql.append(" where notice_no = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, event.getTitle());
			pstmt.setString(2, event.getContent());
			pstmt.setInt(3, event.getNoticeNo());
			
			System.out.println("2");
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("3");
			
	}
	
	
	/**
	 * 게시글 삭제
	 */
	public void deleteEvent(int no) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" delete from event where notice_no = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 게시물번호에 해당 첨부파일 조회하는 기능 
	 */
	public List<EventFileVO> selectFileByNo(int boardNo){
		
		List<EventFileVO> fileList = new ArrayList<>(); 
		
		StringBuilder sql = new StringBuilder(); 
		sql.append("select no, file_ori_name, file_save_name, file_size ");
		sql.append(" from event_file_VO "); 
		sql.append(" where board_no = ? ");
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
				
		){
			
			pstmt.setInt(1, boardNo);
			ResultSet rs = pstmt.executeQuery(); 
			while(rs.next()) {
				EventFileVO fileVO = new EventFileVO(); 
				fileVO.setNo(rs.getInt("no"));
				fileVO.setFileOriName(rs.getString("file_ori_name"));
				fileVO.setFileSaveName(rs.getString("file_save_name"));
				fileVO.setFileSize(rs.getInt("file_size"));
				
				fileList.add(fileVO);
			}
			
		}catch(Exception e) {
			
		}
		
		return fileList;
	}

	
	
	/**
	 * 첨부파일 삽입기능
	 * @param fileVO
	 */
	public void insertFile(EventFileVO fileVO) {
		StringBuilder sql = new StringBuilder();
		sql.append("insert into event_file (no, board_no, file_ori_name, file_save_name, file_size) "); 
		sql.append(" values ( seq_t_board_file_no.nextval,?,?,?,?)");
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, fileVO.getBoardNo());
			pstmt.setString(2, fileVO.getFileOriName());
			pstmt.setString(3, fileVO.getFileSaveName());
			pstmt.setInt(4, fileVO.getFileSize());
			
			pstmt.executeUpdate(); 
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
