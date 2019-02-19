package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.lang.Math;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class NoticeDAO {
	
	private static final int LIST_SIZE = 15;

	public List<NoticeVO> selectAllNotice(int page) {
		
		List<NoticeVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			StringBuilder sql2 = new StringBuilder();
/*
			sql2.append(" select count(*) cnt from notice ");
			pstmt2 = conn.prepareStatement(sql2.toString());
			
			ResultSet rs2 = pstmt2.executeQuery();
			rs2.next();
			int cnt = rs2.getInt("cnt");//게시판 글 개수
			cnt = (int)Math.ceil(cnt/(20.0));	//게시판 페이지 수
*/			
			
			sql.append(" select notice_no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ,view_cnt");
			sql.append(" from (                                   ");
			sql.append("         select 	ROWNUM as rnum, e.*      ");
			sql.append("         from (                          ");
			sql.append("                 select *                ");
			sql.append("                 from m_notice             ");
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
				
				NoticeVO notice = new NoticeVO();
				notice.setNoticeNo(noticeNo);
				notice.setTitle(title);
				notice.setWriter(writer);
				notice.setRegDate(regDate);
				notice.setViewCnt(viewCnt);
				
				list.add(notice);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
		return list;
	}
	
	/**
	 * 페이지
	 * @param page
	 * @return
	 */
	public List<NoticeVO> selectNotice(int page) {
		
		int start = (page -1) * LIST_SIZE +1; 
		int end = page * LIST_SIZE;
		
		List<NoticeVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			StringBuilder sql2 = new StringBuilder();
			/*
			sql2.append(" select count(*) cnt from notice ");
			pstmt2 = conn.prepareStatement(sql2.toString());
			
			ResultSet rs2 = pstmt2.executeQuery();
			rs2.next();
			int cnt = rs2.getInt("cnt");//게시판 글 개수
			cnt = (int)Math.ceil(cnt/(20.0));	//게시판 페이지 수
			 */			
			
			sql.append(" select notice_no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ,view_cnt");
			sql.append(" from (                                   ");
			sql.append("         select 	ROWNUM as rnum, e.*      ");
			sql.append("         from (                          ");
			sql.append("                 select *                ");
			sql.append("                 from m_notice             ");
			sql.append("                 order by notice_no desc ");
			sql.append("                 ) e                     ");
			sql.append("          ) e2                           ");
			sql.append(" where rnum between ? and ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int noticeNo = rs.getInt("notice_no");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				int viewCnt = rs.getInt("view_cnt");
				String regDate = rs.getString("reg_date");
				
				NoticeVO notice = new NoticeVO();
				notice.setNoticeNo(noticeNo);
				notice.setTitle(title);
				notice.setWriter(writer);
				notice.setRegDate(regDate);
				notice.setViewCnt(viewCnt);
				
				list.add(notice);
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
		String sql = "select seq_notice_notice_no.nextval from dual ";

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
	public void insertNotice(NoticeVO notice) {
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("insert into m_notice(notice_no, title, writer, content) ");
			sql.append(" values(seq_notice_notice_no.nextval, ?, ?, ?) ");
			pstmt = conn.prepareStatement(sql.toString());
			
			int loc = 1;
			
//			pstmt.setInt(loc++, notice.getNoticeNo());
			pstmt.setString(loc++, notice.getTitle());
			pstmt.setString(loc++, notice.getWriter());
			pstmt.setString(loc++, notice.getContent());

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
	public NoticeVO selectByNo(int no) {
		
		NoticeVO notice = null; 
		
		StringBuilder sql = new StringBuilder();			
		
		sql.append("select notice_No, title, writer, content, view_cnt ");
		sql.append(" , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append(" from m_notice ");
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
				
				notice = new NoticeVO(noticeNo, title, writer, content, viewCnt, regDate);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return notice;
	}
	
	/**
	 * 게시글 수정
	 */
	public void updateNotice(NoticeVO notice) {
		
		System.out.println("1");
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" update m_notice ");
		sql.append(" set title =?, content =? ");
		sql.append(" where notice_no = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, notice.getTitle());
			pstmt.setString(2, notice.getContent());
			pstmt.setInt(3, notice.getNoticeNo());
			
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
	public void deleteNotice(int no) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" delete from m_notice where notice_no = ? ");
		
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
	 * 전체 게시글 카운트
	 * @return
	 */
	public int selectNoticeCount() {
		int totalCount = 0; 
				
		StringBuilder sql = new StringBuilder();			
		
		sql.append("select count(*) cnt from m_notice");
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());	
		){
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalCount = rs.getInt("cnt");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return totalCount;
	}
	
	/**
	 * 게시글 조회수 카운트
	 */
	public void updateViewCnt(int noticeNo) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" update m_notice ");
		sql.append(" set view_cnt = view_cnt+1 ");
		sql.append(" where notice_no = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, noticeNo);
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
