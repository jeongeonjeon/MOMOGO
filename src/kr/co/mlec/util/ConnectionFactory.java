package kr.co.mlec.util;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectionFactory {
	
	
	public Connection getConnection() /*throws Exception*/{	//怨듭슜 util class濡� 諛고룷�븷 寃쎌슦 try-catch瑜� �궗�슜�븯�뒗 寃껋씠 醫뗫떎
		
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//String url = "jdbc:oracle:thin:@192.168.0.4:1521:xe";
			String user = "hr";
			String password = "hr";
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

}
