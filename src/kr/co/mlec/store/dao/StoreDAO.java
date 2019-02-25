package kr.co.mlec.store.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.menu.vo.MenuVO;
import kr.co.mlec.reply.vo.ReplyVO;
import kr.co.mlec.review.vo.ReviewVO;
import kr.co.mlec.store.vo.StoreVO;
import kr.co.mlec.util.ConnectionFactory;

public class StoreDAO {
	
	public void insertReview(int storeNo, int star, String id, String replyText, int depth, int parentNo) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into m_review ");
		sql.append("values (SEQ_REVIEW_REIVEW_NO.nextval,?,?,?,sysdate,?,?,?)");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
				int loc = 1;
				pstmt.setInt(loc++, storeNo);
				pstmt.setString(loc++, id);
				pstmt.setString(loc++, replyText);
				pstmt.setInt(loc++, star);
				pstmt.setInt(loc++, parentNo);
				pstmt.setInt(loc++, depth );
				
				pstmt.executeUpdate();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public void insertReview(int storeNo, String id, String replyText, int depth, int parentNo) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into m_review ");
		sql.append("values (SEQ_REVIEW_REIVEW_NO.nextval,?,?,?,sysdate, null ,?,?)");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
				int loc = 1;
				pstmt.setInt(loc++, storeNo);
				pstmt.setString(loc++, id);
				pstmt.setString(loc++, replyText);
				pstmt.setInt(loc++, parentNo);
				pstmt.setInt(loc++, depth );
				
				pstmt.executeUpdate();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
		
	public List<StoreVO> selectCategoryStore(String address, String category){
		
		address = address.replaceAll(" ", "");
		
		System.out.println(address + " : " + category);
		
		List<StoreVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 
		
		sql.append("select s.store_no, category, store_name, image ");
		sql.append("  from m_store s, m_delivery_area d            ");
		sql.append(" where category = ?                           ");
		sql.append("   and  s.store_no = d.store_no               ");
		sql.append("   and  (replace(d.delivery_area,' ','') IN ( ");
		sql.append("       select replace(a2.address,' ','')     ");
		sql.append("       from m_address a1, m_address a2       ");
		sql.append("       where replace(a1.address,' ','') = ?  ");
		sql.append("       and a1.code = a2.code                 ");
		sql.append("       )                                     ");
		sql.append(")                                            ");
		
		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		){
		
			int loc = 1;
			
			pstmt.setString(loc++, category);
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
		sql.append("  from m_store ");
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
				String licenseNo = rs.getString("license_no");
				
				store.setStoreName(storeName);
				store.setStoreTel(storeTel);
				store.setAddress(address);
				store.setStart(start);
				store.setEnd(end);
				store.setStoreImage(storeImage);
				store.setLicenseNo(licenseNo);
				
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
		sql.append("  from m_store s, m_menu m  ");
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
		sql.append(" select id, content, write_date, star, review_no, depth, parent_no ");
		sql.append("  from m_store s, m_review r ");
		sql.append(" where s.store_no = r.store_no ");
		sql.append("   and s.store_no = ? ");
	
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
			pstmt.setInt(1, Integer.parseInt(storeNo));

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {

				int reviewNo = rs.getInt("review_no");
				String id        = rs.getString("id");
				String content   = rs.getString("content");
				String writeDate = rs.getString("write_date");
				int star         = rs.getInt("star");
				int parentNo  = rs.getInt("parent_no");
				int depth = rs.getInt("depth");
				
				ReviewVO review = new ReviewVO();
				review.setReviewNo(reviewNo);
				review.setId(id);
				review.setContent(content);
				review.setWriteDate(writeDate);
				review.setStar(star);
				review.setParentNo(parentNo);
				review.setDepth(depth);
				
				list.add(review);
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	

	
	public List<ReplyVO> detailSelectReply(String storeNo){
		
		List<ReplyVO> list  = new ArrayList<>();
		
		StringBuilder sql = new StringBuilder(); 
		
		//review 조회
		sql.append(" select reply_no, p.review_no, reply_id, reply_content, reply_date");
		sql.append("   from m_review r, m_reply p");
		sql.append("  where r.review_no = p.review_no ");
		sql.append("    and r.review_no = ? ");
	
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){
			
			pstmt.setInt(1, Integer.parseInt(storeNo));

			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {

				int replyNo	 = rs.getInt("reply_no");
				int reviewNo = rs.getInt("review_no");
				String id        = rs.getString("reply_id");
				String content   = rs.getString("reply_content");
				String writeDate = rs.getString("reply_date");
				
				ReplyVO reply = new ReplyVO();
				reply.setId(id);
				reply.setContent(content);
				reply.setWriteDate(writeDate);
				reply.setReplyNo(replyNo);
				reply.setReviewNo(reviewNo);
				
				list.add(reply);
			}
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(list);
		
		return list;
	}
	
	
	public int selectNo() {
		String sql = "select seq_myorder_orderno.nextval from dual ";

		try (
			Connection conn = new ConnectionFactory().getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);				
		) {
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public void insertMyOrder(String id, int no, String storeNo) {
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into m_myorder(id, orderno, storeno) ");
		sql.append(" values(?,?,?) ");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){	
				
				int loc = 1;
				
				pstmt.setString(loc++, id);
				pstmt.setInt(loc++, no);
				pstmt.setInt(loc++, Integer.parseInt(storeNo));
				
				pstmt.executeUpdate();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertOrder(int no,String name){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("insert into m_ordermenu ");
		sql.append("values ( ?,?)");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){	
				
				pstmt.setInt(1, no);
				pstmt.setString(2, name);
				
				pstmt.executeUpdate();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void deleteReview(int reviewNo) {
		StringBuilder sql = new StringBuilder(); 
		
		sql.append("delete from m_review where review_no = ?");
		
		try (
				Connection conn = new ConnectionFactory().getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			){	
				
				pstmt.setInt(1, reviewNo);
				
				pstmt.executeUpdate();
				
		}catch (Exception e) {
			e.printStackTrace();
		}
	}


}




