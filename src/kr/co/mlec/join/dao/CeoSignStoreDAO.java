package kr.co.mlec.join.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.mlec.join.vo.CeoSignStoreVO;
import kr.co.mlec.util.ConnectionFactory;

public class CeoSignStoreDAO {
	public void CeoSignStore(CeoSignStoreVO store) {
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append(" insert into m_store (store_no, ceo_id, store_name, license_no, store_tel, basic_addr, detail_addr, category, delivery_area1, delivery_area2, delivery_area3, delivery_area4, delivery_area5) ");
		sql.append(" values ( seq_store_store_no.nextval, ?, ?, ?, ?, ?, ?, ? ,? ,? ,?, ? ,?) ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
		
			int loc = 1;
			
			pstmt.setString(loc++, store.getCeo_id());
			pstmt.setString(loc++, store.getStoreName());
			pstmt.setString(loc++, store.getLicenseNo());
			pstmt.setString(loc++, store.getStoreTel());
			pstmt.setString(loc++, store.getBaseAddr());
			pstmt.setString(loc++, store.getDetailAddr());
			pstmt.setString(loc++, store.getCategory());
			pstmt.setString(loc++, store.getDeleveryArea1());
			pstmt.setString(loc++, store.getDeleveryArea2());
			pstmt.setString(loc++, store.getDeleveryArea3());
			pstmt.setString(loc++, store.getDeleveryArea4());
			pstmt.setString(loc++, store.getDeleveryArea5());
			
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
