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
		
		System.out.println(address + " : " + category);
		
		List<StoreVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append("  select store_no, category, store_name,image  ");
		sql.append("  from store s  ");
		sql.append("  where category = ?  ");
		sql.append("   and  (replace(s.delivery_area1,' ','') IN (  ");
		sql.append("         select replace(a2.address,' ','')       ");
		sql.append("         from address a1, address a2           ");
		sql.append("         where replace(a1.address,' ','') = ?  ");
		sql.append("         and a1.code = a2.code  ");
		sql.append("         )  ");
		sql.append("   or replace(s.delivery_area2,' ','') IN (  ");
		sql.append("         select replace(a2.address,' ','')                    ");
		sql.append("         from address a1, address a2           ");
		sql.append("         where replace(a1.address,' ','') = ?  ");
		sql.append("         and a1.code = a2.code  ");
		sql.append("         )  ");
		sql.append("   or replace(s.delivery_area3,' ','') IN (  ");
		sql.append("         select replace(a2.address,' ','')                    ");
		sql.append("         from address a1, address a2           ");
		sql.append("         where replace(a1.address,' ','') = ?  ");
		sql.append("         and a1.code = a2.code  ");
		sql.append("         )  ");
		sql.append("   or replace(s.delivery_area4,' ','') IN (  ");
		sql.append("         select replace(a2.address,' ','')                    ");
		sql.append("         from address a1, address a2           ");
		sql.append("         where replace(a1.address,' ','') = ?  ");
		sql.append("         and a1.code = a2.code  ");
		sql.append("         )  ");
		sql.append("   or replace(s.delivery_area5,' ','') IN (  ");
		sql.append("         select replace(a2.address,' ','')                    ");
		sql.append("         from address a1, address a2           ");
		sql.append("         where replace(a1.address,' ','') = ?  ");
		sql.append("         and a1.code = a2.code  ");
		sql.append("         ))   ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
		
			int loc = 1;
			
			pstmt.setString(loc++, category);
			pstmt.setString(loc++, address);
			pstmt.setString(loc++, address);
			pstmt.setString(loc++, address);
			pstmt.setString(loc++, address);
			pstmt.setString(loc++, address);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				int storeNo  	 = rs.getInt("store_no");
				String catego    = rs.getString("category");
				String storeName = rs.getString("store_name");
				String imageUrl  = rs.getString("image");
				
				StoreVO store = new StoreVO();
				store.setStoreNo(storeNo);
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



	public List<StoreVO> detailSelectStore(){
		List<StoreVO> list  = new ArrayList<>();
		
		
		return list;
	}

}




