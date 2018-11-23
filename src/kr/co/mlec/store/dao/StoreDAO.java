package kr.co.mlec.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import kr.co.mlec.join.vo.CeoSignUpVO;
import kr.co.mlec.store.vo.StoreVO;
import kr.co.mlec.util.ConnectionFactory;

public class StoreDAO {
	
	public List<StoreVO> selectCategoryStore(String address, String category){
		
		address = address.replaceAll(" ", "");
		
		List<StoreVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append("select *           ");
	 	sql.append("  from store      ");
		sql.append(" where category = ?");
		sql.append("   and replace(delivery_area1, ' ', '') = ?");
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
		
			int loc = 1;
			
			pstmt.setString(loc++, category);
			pstmt.setString(loc++, address);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				String catego    = rs.getString("category");
				String addr      = rs.getString("delivery_area1");
				String storeName = rs.getString("store_name");
				String imageUrl  = rs.getString("file_up");
				
				StoreVO store = new StoreVO();
				store.setAddress(addr);
				store.setCategory(catego);
				store.setImageUrl(imageUrl);
				store.setStoreName(storeName);
				
				list.add(store);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}






