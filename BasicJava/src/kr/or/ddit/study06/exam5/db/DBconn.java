package kr.or.ddit.study06.exam5.db;

//import java.sql.*;//sql 전체를 import하겠다
import java.sql.Connection;//상위(java)하위(sql)클래스이름()
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconn {
	static Connection conn = null;
	
	public static Connection getConnection() { //접속하기위한주소만들기
		String url = "jdbc:oracle:thin:@localhost:1521:xe";//localhost부터 ip
		String user = "pc11";
		String pwd = "java";
		
		if(conn == null) {
			System.out.println("?");
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				conn = DriverManager.getConnection(url,user,pwd); //db접속정보가 담김
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return conn;
	}
}
