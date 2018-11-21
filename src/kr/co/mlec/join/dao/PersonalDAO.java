package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.join.vo.PersonalVO;
import kr.co.mlec.util.ConnectionFactory;

public class PersonalDAO {
	
	public void Personal_Signup(PersonalVO person) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert into personal (id, password, name, email, phone) ");
		sql.append(" values ( ?, ?, ?, ?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setString(1, person.getId());
			pstmt.setString(2, person.getPass());
			pstmt.setString(3, person.getName());
			pstmt.setString(4, person.getEmail());
			pstmt.setString(5, person.getPhone());
			
			pstmt.executeUpdate();
			
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
