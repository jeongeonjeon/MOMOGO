package kr.co.mlec.ceo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.util.ConnectionFactory;

public class CeoDAO {

	
	public void insertMenu(CeoSignUpVO ceoVO, CeoSignUpVO aa) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert menu (store_no, menu, price, image, type) ");
		sql.append(" values (? ,?, ?, ?, ?) ");
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
		
//			String id = ceoVO.getId();
//			
//			pstmt.setString(1, id);
//			pstmt.setString(2, aa );
//			pstmt.setInt(3, aa);
//			pstmt.setString(4, aa);
//			pstmt.setString(5, aa);
//			
//			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void deleteMenu(CeoSignUpVO ceoVo) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append("  delete from menu where notice_no = ? and menu = ?  ");
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
		
//			pstmt.setString(1, ceoVO.);
//			pstmt.setString(2, ceoVO.);
//			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
}
