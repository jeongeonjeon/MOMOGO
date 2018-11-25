package kr.co.mlec.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.menu.vo.MenuVO;
import kr.co.mlec.review.vo.ReviewVO;
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
				store.setStoreImage(imageUrl);
				store.setStoreName(storeName);
				
				list.add(store);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}



	public List<StoreVO> detailSelectStore(String storeNo){
		
		List<StoreVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 
		
		
		sql.append("select * ");
		sql.append("  from store ");
		sql.append(" where store_no = ? ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){

			pstmt.setInt(1, Integer.parseInt(storeNo));

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
			
				StoreVO store = new StoreVO();
				
				String storeName = rs.getString("store_name");
				String storeTel  = rs.getString("store_tel");
				String address   = rs.getString("basic_addr");
				String start     = rs.getString("start_time");
				String end       = rs.getString("end_time");
				String storeImage = rs.getString("image");
				
				store.setStoreName(storeName);
				store.setStoreTel(storeTel);
				store.setAddress(address);
				store.setStart(start);
				store.setEnd(end);
				store.setStoreImage(storeImage);
				
				list.add(store);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	public List<MenuVO> detailSelectMenu(String storeNo){
		
		List<MenuVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 

		//menu 조회
		sql.append(" select menu, price, m.image, type ,detail ");
		sql.append("  from store s, menu m  ");
		sql.append(" where s.store_no = m.store_no  ");
		sql.append("   and s.store_no = ?  ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
			pstmt.setInt(1, Integer.parseInt(storeNo));
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String menuName  = rs.getString("menu");
				int price        = rs.getInt("price");
				String menuImage  = rs.getString("image");
				String type       = rs.getString("type");
				String detail       = rs.getString("detail");
				
				MenuVO menu = new MenuVO();
				
				menu.setMenuName(menuName);
				menu.setPrice(price);
				menu.setMenuImage(menuImage);
				menu.setType(type);
				menu.setDetail(detail);
				
				list.add(menu);
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}

	public List<ReviewVO> detailSelectReview(String storeNo){
		
		List<ReviewVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 
		
		//review 조회
		sql.append(" select id, content, write_date, star ");
		sql.append("  from store s, review r ");
		sql.append(" where s.store_no = r.store_no ");
		sql.append("   and s.store_no = ? ");
	
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
			pstmt.setInt(1, Integer.parseInt(storeNo));

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {

				String id        = rs.getString("id");
				String content   = rs.getString("content");
				String writeDate = rs.getString("write_date");
				int star         = rs.getInt("star");
				
				ReviewVO review = new ReviewVO();
				review.setId(id);
				review.setContent(content);
				review.setWriteDate(writeDate);
				review.setStar(star);
				
				list.add(review);
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}


}




