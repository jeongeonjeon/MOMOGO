package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class CeoSignUpDAO {
	public void CeoSignUp(CeoSignUpVO person) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert into ceo (ceo_no, id, password, email, name, phone) ");
		sql.append(" values ( SEQ_CEO_CEO_NO.nextval, ?, ?, ?, ?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			int loc = 1;
			
			pstmt.setString(loc++, person.getId());
			pstmt.setString(loc++, person.getPassword());
			pstmt.setString(loc++, person.getEmail());
			pstmt.setString(loc++, person.getName());
			pstmt.setString(loc++, person.getPhone());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 로그인 서비스
	 */
	public CeoSignUpVO login(CeoSignUpVO loginVO) {

		CeoSignUpVO userVO = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, type ");
		sql.append("  from ceo ");
		sql.append(" where id = ? and password = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPassword());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String id 		= rs.getString("id");
				String password = rs.getString("password");
				String type 	= rs.getString("type");
				
				userVO = new CeoSignUpVO(id, password, type);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userVO;
	}
}
