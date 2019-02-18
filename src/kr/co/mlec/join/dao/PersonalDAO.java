package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.join.vo.PersonalVO;
import kr.co.mlec.order.vo.OrderVO;
import kr.co.mlec.store.vo.StoreVO;
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
		sql.append("select * from m_personal where id =? ");
		
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
	
	/**
	 * 회원가입
	 * @param person
	 * @return
	 */
	public void Personal_Signup(PersonalVO person) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert into m_personal (id, password, name, email, phone) ");
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
		sql.append("  from m_personal ");
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
		sql.append(" from m_personal ");
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
		sql.append("  from m_personal ");
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
		sql.append("  from m_personal ");
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
			sql.append("update m_personal ");
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
	 * 회원정보수정
	 */
	
	public void updateInfo(PersonalVO updateInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			conn = new ConnectionFactory().getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append("update m_personal ");
			sql.append("    set name = ?, password= ? , phone = ? , email = ? ");
			sql.append("  where id = ?");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			int loc = 1;
			
			pstmt.setString(loc++, updateInfo.getName());
			pstmt.setString(loc++, updateInfo.getPass());
			pstmt.setString(loc++, updateInfo.getPhone());
			pstmt.setString(loc++, updateInfo.getEmail());
			pstmt.setString(loc++, updateInfo.getId());
			
			
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
		sql.append("delete from m_personal ");
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
	
	
	/**
	 * 마이페이지 주문내역조회
	 */
	public List<OrderVO> mypageSelectOrder(String id){
		List<OrderVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 
		
		
		sql.append("select o.orderno, menu, id, storeno, reg_date, status, store_name ");
		sql.append("  from m_orderMenu o, m_myorder m, m_store s ");                   
		sql.append(" where m.storeno = s.store_no ");                   
		sql.append("   and o.orderno = m.orderno ");                   
		sql.append("   and id = ? ");                                
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){

			pstmt.setString(1, id);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
			
				OrderVO order = new OrderVO();
				
				int orderNo = rs.getInt("orderno");
				String menu = rs.getString("menu");
				String userid = rs.getString("id");
				int storeNo = rs.getInt("storeno");
				String regDate = rs.getString("reg_date");
				String status = rs.getString("status");
				String storeName = rs.getString("store_name");
				
				order.setOrderNo(orderNo);
				order.setMenu(menu);
				order.setId(userid);
				order.setStoreNo(storeNo);
				order.setRegDate(regDate);
				order.setStatus(status);
				order.setStoreName(storeName);
				
				list.add(order);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}

}