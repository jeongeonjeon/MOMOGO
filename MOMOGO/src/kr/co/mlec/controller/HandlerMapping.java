package kr.co.mlec.controller;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

public class HandlerMapping {
	//요청 URI를 받고 중간 controller객체를 생성하는 기능 클래스 uri=>키값/ 중간 Controller객체 =>value값

	//uri와 중간 컨트롤러들을 세팅하는 과정 입니다. 생성자함수이기 때문에 클래스를 만듬과 동시에 만들어진다.
	private Map<String, Controller> mappings;
	
	public HandlerMapping(String propLocation) {
		mappings = new HashMap<>();
		
		Properties prop = new Properties();
		try {
			InputStream inStream = new FileInputStream(propLocation);	
			//xml(서블릿)에 등록한 propLocation으로 been.properties주소를 읽는다. 
			
			prop.load(inStream);	//been.properties주소를 찾아서 그 파일에 있는 텍스트를  =를 기준으로 좌변,우변뽑아온다.
			
			//prop에는 been.properties가 =를 기준으로 해서 통으로 문자열이 들어오기 때문에 다시 키값을 뽑아 컨트롤러 객체를 생성해서 짝을지어주는 과정이필요
			Set<Object> keys = prop.keySet();	//bean.properties의 왼쪽 키 값들을 뽑아온다. 
			for(Object key : keys) {
				String className = prop.getProperty(key.toString());	
				//key.toString으로 key값을 가져와서 getProperty로 key값에 해당하는 controller객체가 있는 주소를 뽑아온다.
				
				System.out.println(key+":" +className);
				
				Class<?> clz = Class.forName(className);	//이건 아래 controller의 객체를 생성하기 위해서 이코드를 써줘야한다는 것으로 암기
				
				mappings.put(key.toString(), (Controller)clz.newInstance());
				//key의 문자열과, controller객체 생성
						
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);	//forward시킬 jsp파일을 가지고 있는 중간 controller객체를 가져온다.
	}
	
/*
	public static void main(String[] args) throws Exception {
		
		System.out.print("패키지를 포함한 클래스명을 입력해: ");
		String className = new Scanner(System.in).nextLine();
		
		Class<?> clz = Class.forName("java.util.Random");
		
		Object obj = clz.newInstance();	//class.forname()랜덤하게 들어오는 클래스를  객체를 만든다.
		System.out.println(obj);
		
		
//		java.util.Random r = new java.util.Random();
//		int random = r.nextInt(100);
//		
//		System.out.println("추출된 난수: " + random);
	}
*/
}

