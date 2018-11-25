package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;
import kr.co.mlec.util.ConnectionFactory;
import kr.co.mlec.util.JDBCClose;

public class PersonalDAO {
	
	
	/**
	 * 아이디 중복체크
	 * @param id
	 * @return
	 */
	public int checkId(String id) {
		
		int re = 0; 
		
		StringBuilder sql = new StringBuilder(); 
		sql.append("select * from personal where id =? ");
		
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
	
	/**
	 * 로그인 서비스
	 */
	public PersonalVO login(PersonalVO loginVO) {

		PersonalVO userVO = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, type ");
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

	/**
	 * 마이페이지 일반회원 정보조회
	 */
	
	public PersonalVO selectById(String id) {
		
		PersonalVO personal = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select id,password,email,name,phone,type" );
		sql.append("       ,to_char(reg_date, 'yyyy-mm-dd') as reg_date");
		sql.append(" from personal ");
		sql.append(" where id=?");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){	
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String personalId = rs.getString("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String type = rs.getString("type");
				String regDate = rs.getString("reg_date");
				
				personal = new PersonalVO(personalId,password,email,name,phone,type,regDate);
			}
		} catch( Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(personal);
		
		return personal;
	}
	
	/**
	 * 이름, 휴대전화 , 이메일로 아이디 찾기
	 */	
	public PersonalVO searchId(PersonalVO idVO) {
		
		PersonalVO searchIdVO = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, phone, email ");
		sql.append("  from personal ");
		sql.append(" where name = ? and phone = ? and email = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, idVO.getName());
			pstmt.setString(2, idVO.getPhone());
			pstmt.setString(3, idVO.getEmail());			
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				
				searchIdVO = new PersonalVO(id, name, email, phone);							
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return searchIdVO;
	}
	
	/**
	 * 이름, 휴대전화 , 이메일로 비밀번호 찾기
	 */	
	public PersonalVO searchPw(PersonalVO pwVO) {
		
		PersonalVO searchPwVO = null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, phone, password ");
		sql.append("  from personal ");
		sql.append(" where name = ? and id = ? and phone = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		) {
			pstmt.setString(1, pwVO.getName());
			pstmt.setString(2, pwVO.getId());
			pstmt.setString(3, pwVO.getPhone());			
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String id = rs.getString("id");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String password = rs.getString("password");
				
				searchPwVO = new PersonalVO();					
				
				searchPwVO.setId(id);
				searchPwVO.setName(name);
				searchPwVO.setPhone(phone);
				searchPwVO.setPass(password);
				
			}
			System.out.println(searchPwVO);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return searchPwVO;
	}
	
	/**
	 * 비밀번호 변경
	 */	
	public void changePw(PersonalVO changePw) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update personal ");
			sql.append("   set password = ? ");
			sql.append(" where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, changePw.getPass());
			pstmt.setString(2, changePw.getId());

			pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(pstmt, conn);
		}
		
	}
	
	/**
	 * 회원탈퇴
	 */
	public void leaveMember(String id) {
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from personal ");
		sql.append(" where id = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setString(1, id);
			pstmt.executeUpdate();			
		} catch (Exception e) {
			e.printStackTrace();
		}
}

	
}
