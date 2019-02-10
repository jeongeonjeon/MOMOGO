package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.join.vo.PersonalVO;
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
		sql.append("select * from m_ceo where id =? ");
		
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
		
		sql.append(" insert into m_ceo (ceo_no, id, password, email, name, phone) ");
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
		sql.append("  from m_ceo ");
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
	
	/**
	 * 마이페이지 일반회원 정보조회
	 */
	/*
	public CeoSignUpVO selectById(String id) {
		
		CeoSignUpVO ceo = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select id, password, email, name, phone, type" );
		sql.append("       ,to_char(reg_date, 'yyyy-mm-dd') as reg_date ");
		sql.append("  from ceo ");
		sql.append(" where id = ? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){	
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String ceoId = rs.getString("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String type = rs.getString("type");
				String regDate = rs.getString("reg_date");
				
				ceo = new CeoSignUpVO();
				
				ceo.setId(ceoId);
				ceo.setPassword(password);
				ceo.setEmail(email);
				ceo.setName(name);
				ceo.setPhone(phone);
				ceo.setType(type);
				ceo.setRegDate(regDate);	

				
				System.out.println(ceo);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ceo;
	}
	*/
	
	
	public CeoSignUpVO selectById(String id) {
		
		CeoSignUpVO ceo = null;
		StringBuilder sql = new StringBuilder();
		sql.append("select c.id, c.password, c.email, c.name, c.phone, c.type" );
		sql.append("       ,to_char(c.reg_date, 'yyyy-mm-dd') as reg_date, s.basic_addr, s.detail_addr ");
		sql.append("  from m_ceo c, m_store s ");
		sql.append(" where c.id = s.ceo_id ");
		sql.append("   and c.id = ?");
		
		try(
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){	
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String ceoId = rs.getString("id");
				String password = rs.getString("password");
				String email = rs.getString("email");
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String type = rs.getString("type");
				String regDate = rs.getString("reg_date");
				String basicAddr = rs.getString("basic_addr");
				String detailAddr = rs.getString("detail_addr");
				
				ceo = new CeoSignUpVO();
				
				ceo.setId(ceoId);
				ceo.setPassword(password);
				ceo.setEmail(email);
				ceo.setName(name);
				ceo.setPhone(phone);
				ceo.setType(type);
				ceo.setRegDate(regDate);	
				ceo.setBasicAddr(basicAddr);
				ceo.setDetailAddr(detailAddr);
				
				System.out.println(ceo);
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ceo;
	}
	
	
	
	
	/**
	 * 이름, 휴대전화 , 이메일로 아이디 찾기
	 */	
	public CeoSignUpVO searchId(CeoSignUpVO idVO) {
		
		CeoSignUpVO searchIdVO =  null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, phone, email ");
		sql.append("  from m_ceo ");
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
					
					searchIdVO = new CeoSignUpVO(id, name, phone, email);							
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		
		
		return searchIdVO;
	}
	
	/**
	 * 이름, 휴대전화 , 이메일로 비밀번호 찾기
	 */	
	public CeoSignUpVO searchPw(CeoSignUpVO pwVO) {
		
		CeoSignUpVO searchPwVO =  null;
		
		StringBuilder sql = new StringBuilder();
		sql.append("select id, name, phone, password ");
		sql.append("  from m_ceo ");
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
					
					searchPwVO = new CeoSignUpVO();		
					
					searchPwVO.setId(id);
					searchPwVO.setName(name);
					searchPwVO.setPhone(phone);
					searchPwVO.setPassword(password);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}		
		
		return searchPwVO;
	}	
	
	/**
	 * 비밀번호 변경
	 */	
	public void changePw(CeoSignUpVO changePw) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {

			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update m_ceo ");
			sql.append("   set password = ? ");
			sql.append(" where id = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, changePw.getPassword());
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
		sql.append("delete from m_ceo ");
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