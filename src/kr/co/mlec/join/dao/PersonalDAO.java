package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.join.vo.PersonalVO;
import kr.co.mlec.util.ConnectionFactory;

public class PersonalDAO {
	
	public void Personal_Signup(PersonalVO person) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert into table (id, pass, name, email, phone) ");
		sql.append(" values ( ?, ?, ?, ?, ?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			
			pstmt.setString(1, person.getId());
			pstmt.setString(2, person.getPass());
			pstmt.setString(3, person.getName());
			pstmt.setString(4, person.getEmail());
			pstmt.setInt(5, person.getPhone());
			
			pstmt.executeUpdate();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 로그인 서비스
	 */
	public PersonalVO login(PersonalVO loginVO) {

		PersonalVO userVO = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, user_type ");
		sql.append("  from personal ");
		sql.append(" where id = ? and password = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			
			pstmt.setString(1, loginVO.getId());
			pstmt.setString(2, loginVO.getPass());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String id 		= rs.getString("id");
				String password = rs.getString("password");
				String type 	= rs.getString("type");
				
				userVO = new PersonalVO(id, password, type);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return userVO;
	}

}
