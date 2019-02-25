package kr.co.mlec.ceo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.menu.vo.MenuVO;
import kr.co.mlec.util.ConnectionFactory;

public class CeoDAO {

	
	public void insertMenu(MenuVO menu) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert into m_menu (store_no, menu, price, image, type, detail) ");
		sql.append(" values (? ,?, ?, ?, ?, ?) ");
		
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
			pstmt.setInt(1, menu.getCeoNo());
			pstmt.setString(2, menu.getMenuName() );
			pstmt.setInt(3, menu.getPrice());
			pstmt.setString(4, menu.getMenuImage());
			pstmt.setString(5, menu.getType());
			pstmt.setString(6, menu.getDetail());
			
			pstmt.executeUpdate();
			
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
	
	public List<MenuVO> selectAllMenu(int ceoNo) {
		
		List<MenuVO> lists= new ArrayList<>();
		
		StringBuilder sql= new StringBuilder();
		sql.append(" select * from m_menu where store_no=? ");
		
		try(
			Connection conn = new ConnectionFactory().getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
				pstmt.setInt(1, ceoNo);
				ResultSet rs = pstmt.executeQuery();
				while(rs.next()) {
					MenuVO menu=new MenuVO();
					menu.setCeoNo(ceoNo);
					menu.setPrice(rs.getInt("price"));
					menu.setDetail(rs.getString("detail"));
					menu.setType(rs.getString("type"));
					menu.setMenuName(rs.getString("menu"));
					menu.setMenuImage(rs.getString("image"));
					
					lists.add(menu);
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		return lists;
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
