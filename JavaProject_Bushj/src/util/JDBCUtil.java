package util;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCUtil {
	/*
	 * JDBC를 좀 더 쉽고 편하게 사용하기 위한 Utility 클래스
	 * 
	 * Map<String, Object> selectOne(String sql)
	 * Map<String, Object> selectOne(String sql, List<Object> param)
	 * List<Map<String, Object>> selectList(String sql)
	 * List<Map<String, Object>> selectList(String sql, List<Object> param)
	 * int update(String sql)
	 * int update(String sql, List<Object> param)
	 * */
	
	// 싱글톤 패턴 : 인스턴스의 생성을 제한하여 하나의 인스턴스만 사용하는 디자인 패턴
	//         여러곳에서 이 클래스의 인스턴스를 공유하고자할때 싱글톤패턴사용함
	
	// 인스턴스를 보관할 변수
	private static JDBCUtil instance = null;
	// JDBCUtil 객체를 만들 수 없게(인스턴스화 할 수 없게) private으로 제한함
	private JDBCUtil() {} 
    //instance 변수가 null인 경우에만 JDBCUtil 생성자를 호출하여 인스턴스를 생성합니다.
	//이렇게 하면 한 번만 인스턴스를 생성하고, 이후에는 생성된 인스턴스를 반환합니다.
	public static JDBCUtil getInstance() {
		if(instance == null) 
			instance = new JDBCUtil();
		return instance;
	}
	
	//데이터베이스에서 특정 조건을 만족하는 레코드를 선택하고 출력하는 것을 목적
	public static void main(String[] args) {
		//1.JDBCUtil 클래스의 새 인스턴스를 생성합니다. 
		//이 인스턴스를 사용하여 데이터베이스 연결과 쿼리 실행을 수행할 것으로 예상됩니다.
		JDBCUtil jdbc = new JDBCUtil();
		//2.sql쿼리를 정의함
		String sql = "SELECT * FROM PROD";
		//3.jdbc 객체를 사용하여 데이터베이스에 정의된 쿼리를 실행하고 
		//그 결과를 List<Map<String, Object>> 형식으로 저장합니다. 
		//이 결과는 여러 레코드를 포함하는 리스트로 표현됩니다.
		List<Map<String, Object>> list = jdbc.selectList(sql);
		for (Map<String, Object> map : list) {
//			String PROD_NAME = (String) map.get("PROD_NAME");"PROD_NAME" 열의 값을 가져와서 "컴퓨터"를 포함하는지 확인한 후,
			                                                //조건을 만족하는 경우 해당 레코드를 출력함
//			if(PROD_NAME.contains("컴퓨터")) {
//				System.out.println(map);
//			}
			String PROD_BUYER = (String) map.get("PROD_BUYER");//PROD_BUYER"열의 값을 가져와서 문자열로 변환
			if(PROD_BUYER.equals("P10101")) {                  //"PROD_BUYER" 값이 "P10101"과 일치하면 해당 레코드를 출력함
				System.out.println(map);
			}
		}
	}
	
	private String url = "jdbc:oracle:thin:@192.168.143.35:1521:xe";
	private String user = "pc11";
	private String password = "java";
	
	private Connection conn = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	
	//데이터베이스 결과 집합을 Java에서 사용하기 쉽도록 해시 맵의 리스트 형태로 변환하는 과정
	public List<Map<String, Object>> selectList(String sql, List<Object> param){
		// sql => "SELECT * FROM MEMBER WHERE MEM_ADD1 LIKE '%'||?||'%'"
		// sql => "SELECT * FROM JAVA_BOARD WHERE WRITER=?"
		// sql => "SELECT * FROM JAVA_BOARD WHERE BOARD_NUM > ?"
		List<Map<String, Object>> result = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				//ArrayList 객체가 null인 경우, 새로운 ArrayList를 생성하여 초기화합니다. 
				//result는 데이터베이스 결과를 저장하기 위한 컨테이너
				if(result == null) result = new ArrayList<>();
				//데이터베이스 결과 행을 나타내는 새로운 HashMap 객체 row
				//열 이름(문자열)과 해당 열의 값(객체)을 저장
				Map<String, Object> row = new HashMap<>();
				//결과 집합의 열 수(columnCount)에 대한 루프를 시작
				for(int i = 1; i <= columnCount; i++) {
				//객체 rsmd를 사용하여 현재 열의 레이블(이름)을 가져옴,결과 집합의 열 이름을 나타냄
					String key = rsmd.getColumnLabel(i);
					Object value = rs.getObject(i);
					//현재 열의 이름(key)과 해당 열의 값을 row HashMap에 추가
					row.put(key, value);
				}
				//row HashMap을 결과 ArrayList(result)에 추가:현재 행의 데이터가 ArrayList에 저장됨
				result.add(row);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(conn != null) try { conn.close(); } catch(Exception e) {}
		}
		return result;
	}
	
	public <T> List<T> selectList1(String sql, List<Object> param){
		// sql => "SELECT * FROM MEMBER WHERE MEM_ADD1 LIKE '%'||?||'%'"
		// sql => "SELECT * FROM JAVA_BOARD WHERE WRITER=?"
		// sql => "SELECT * FROM JAVA_BOARD WHERE BOARD_NUM > ?"
		List<Map<String, Object>> convertMaps = selectList(sql, param);
        List<T> convertValueObjects = (List<T>) ConvertUtils.convertToList(convertMaps, Object.class);
		return convertValueObjects;
	}
	
	public List<Map<String, Object>> selectList(String sql){
		// sql => "SELECT * FROM MEMBER"
		// sql => "SELECT * FROM JAVA_BOARD"
		// sql => "SELECT * FROM JAVA_BOARD WHERE BOARD_NUM > 10"
		List<Map<String, Object>> result = null;
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				if(result == null) result = new ArrayList<>();
				Map<String, Object> row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(key, value);
				}
				result.add(row);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try { rs.close(); } catch(Exception e) {}
			if(ps != null) try { ps.close(); } catch(Exception e) {}
			if(conn != null) try { conn.close(); } catch(Exception e) {}
		}
		return result;
	}

	public int update(String sql, List<Object> param) {
		// sql => "DELETE FROM JAVA_BOARD WHERE BOARD_NUMBER=?"
		// sql => "UPDATE JAVA_BOARD SET TITLE='하하' WHERE BOARD_NUMBER=?"
		// sql => "INSERT MY_MEMBER (MEM_ID, MEM_PASS, MEM_NAME) VALUES (?, ?, ?)"
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {  rs.close();  } catch (Exception e) { }
			if(ps != null) try {  ps.close();  } catch (Exception e) { }
			if(conn != null) try { conn.close(); } catch (Exception e) { }
		}
		return result;
	}
	
	public int update(String sql) {
		// sql => "DELETE FROM JAVA_BOARD"
		// sql => "UPDATE JAVA_BOARD SET TITLE='하하'"
		// sql => "UPDATE JAVA_BOARD SET TITLE='하하' WHERE BOARD_NUMBER=1"
		// sql => "INSERT MY_MEMBER (MEM_ID, MEM_PASS, MEM_NAME) VALUES ('admin', '1234', '홍길동')"
		int result = 0;
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {  rs.close();  } catch (Exception e) { }
			if(ps != null) try {  ps.close();  } catch (Exception e) { }
			if(conn != null) try { conn.close(); } catch (Exception e) { }
		}
		return result;
	}
	
	public Map<String, Object> selectOne(String sql, List<Object> param){
		// sql => "SELECT * FROM JAVA_BOARD WHERE BOARD_NUMBER=?"
		// param => [1]
		//
		// sql => "SELECT * FROM JAVA_BOARD WHERE WRITER=? AND TITLE=?"
		// param => ["홍길동", "안녕"]
		Map<String, Object> row = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			for(int i = 0; i < param.size(); i++) {
				ps.setObject(i + 1, param.get(i));
			}
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					Object value = rs.getObject(i);
					row.put(key,value);
				}
				// {DATETIME=2022-08-05 16:35:08.0, WRITER=홍길동, TITLE=안녕하세요, CONTENT=안녕안녕, BOARD_NUMBER=1}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {  rs.close();  } catch (Exception e) { }
			if(ps != null) try {  ps.close();  } catch (Exception e) { }
			if(conn != null) try { conn.close(); } catch (Exception e) { }
		}
		return row;
	}
	
	public Map<String, Object> selectOne(String sql){
		// sql => "SELECT * FROM JAVA_BOARD 
		//			WHERE BOARD_NUMBER=(SELECT MAX(BOARD_NUMBER) FROM JAVA_BOARD)"
		// sql => "SELECT * FROM MEMBER MEM_ID='a001' AND MEM_PASS='123'"
		Map<String, Object> row = null;
		
		try {
			conn = DriverManager.getConnection(url, user, password);
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next()) {
				row = new HashMap<>();
				for(int i = 1; i <= columnCount; i++) {
					String key = rsmd.getColumnLabel(i);
					// getColumnName vs getColumnLabel
					// getColumnName : 원본 컬럼명을 가져옴
					// getColumnLabel : as로 선언된 별명을 가져옴, 없으면 원본 컬럼명
					Object value = rs.getObject(i);
					row.put(key,value);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) try {  rs.close();  } catch (Exception e) { }
			if(ps != null) try {  ps.close();  } catch (Exception e) { }
			if(conn != null) try { conn.close(); } catch (Exception e) { }
		}
		
		return row;
	}
}







