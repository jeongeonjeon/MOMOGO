package kr.co.mlec.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;



public class HandlerMapping {
	
	//Map객체 사용
	private Map<String, Controller> mappings;
	
	public HandlerMapping(String propLocation) {
		
		mappings = new HashMap<>();
		
		Properties prop = new Properties();

		try {
			InputStream inStream = new FileInputStream(propLocation);
			prop.load(inStream); 	//'='을 기준으로 추출
			
			Set<Object> keys = prop.keySet();
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());
				
				System.out.println(key +":"+className);
				
				Class<?> clz = Class.forName(className);
				

				mappings.put(key.toString(), (Controller)clz.newInstance());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		mappings.put("/board/writeForm.do", new WriteFormController());
		
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}

	/*	//이 코드를 Map으로 변경함
	  	switch(uri) {
		case "/board/list.do":
			System.out.println("게시판 목록처리");
			control = new ListController();
			break;
		case "/board/writeForm.do":
			System.out.println("새글 등록처리");
			control = new WriteFormController();
			break;
		}
	 */

/*	
	public static void main(String[] args) throws Exception {
		
		String className = new Scanner(System.in).nextLine();
		
		Class<?> clz = Class.forName(className);
		
		Object obj = clz.newInstance();
		System.out.println(obj);
		
//		String className = "java.util.Random";
//		
//		java.util.Random r = new java.util.Random();
//		int random = r.nextInt(100);

	}
*/	
	
	

}










