package kr.co.mlec.ceo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.util.ConnectionFactory;

public class CeoDAO {

	
	public void insertMenu(CeoSignUpVO ceoVO, CeoSignUpVO aa) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert m_menu (store_no, menu, price, image, type) ");
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
		
		sql.append("  delete from m_menu where notice_no = ? and menu = ?  ");
		
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
	
	public int updateCeoProfile(CeoSignUpVO ceoVO) {
		
		StringBuilder sql = new StringBuilder(); 
		int updateResult = 0;
		
		sql.append(" update m_ceo ");
		sql.append(" set password=? ");
		sql.append(" ,email=? ");
		sql.append(" ,name=? ");
		sql.append(" ,phone=? ");
		sql.append(" where id=?  ");
		
		try(
				Connection conn = new ConnectionFactory().getConnection(); 
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
				pstmt.setString(1, ceoVO.getPassword());
				pstmt.setString(2, ceoVO.getEmail());
				pstmt.setString(3,  ceoVO.getName());
				pstmt.setString(4,  ceoVO.getPhone());
				pstmt.setString(5, ceoVO.getId());
				updateResult = pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		return updateResult;
	}
	
}
