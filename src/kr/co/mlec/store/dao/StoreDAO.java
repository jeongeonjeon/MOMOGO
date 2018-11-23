package kr.co.mlec.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.store.vo.StoreVO;
import kr.co.mlec.util.ConnectionFactory;

public class StoreDAO {
	
	public List<StoreVO> selectCategoryStore(String address, String category){
		
		address = address.replaceAll(" ", "");
		
		List<StoreVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append("select DISTINCT s.*							"); 
		sql.append(" from store s, (                            ");
		sql.append("        select a1.address                   ");
		sql.append("        from address a1, address a2         ");
		sql.append("        where replace(a1.address,' ','') = ?");
		sql.append("        and a1.code = a2.code               ");
		sql.append("  ) a                                       ");
		sql.append(" where category = ?                         ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
		
			int loc = 1;
			
			pstmt.setString(loc++, address);
			pstmt.setString(loc++, category);
			
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






