package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class CeoSignUpDAO {
	
	
	/**
	 * 아이디 중복체크
	 * @param id
	 * @return
	 */
	public int checkId(String id) {
		
		int re = 0; 
		
		StringBuilder sql = new StringBuilder(); 
		sql.append("select * from ceo where id =? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				re=1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return re;  
	}
	
	
	
	public void CeoSignUp(CeoSignUpVO person) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert into ceo (ceo_no, id, password, email, name, phone) ");
		sql.append("        , to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append(" values ( ?, ?, ?, ?, ?, ?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			int loc = 1;
			
			pstmt.setInt(loc++, person.getCeoNo());
			pstmt.setString(loc++, person.getId());
			pstmt.setString(loc++, person.getPassword());
			pstmt.setString(loc++, person.getEmail());
			pstmt.setString(loc++, person.getName());
			pstmt.setString(loc++, person.getPhone());
			pstmt.setString(loc++, person.getRegDate());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
