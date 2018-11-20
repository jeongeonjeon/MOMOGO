package kr.co.mlec.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.board.vo.NoticeVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class NoticeDAO {

	public List<NoticeVO> selectAllNotice() {
		
		List<NoticeVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select notice_no, title, writer, to_char(reg_date, 'yyyy-mm-dd') as reg_date ,view_cnt");
			sql.append("   from notice ");
			sql.append("  order by notice_no desc ");
	

			pstmt = conn.prepareStatement(sql.toString());

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
}
