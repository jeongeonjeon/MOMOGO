package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class CeoSignUpDAO {
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
