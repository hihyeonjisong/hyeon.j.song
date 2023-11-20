package dao;

import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.STRING;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Buyseat;
import vo.Nonmember;

// 데이터베이스로 쿼리를 날려서 결과를 얻는다.
public class NonmemberDAO {
	// 싱글톤 패턴을 만든다.
	private static NonmemberDAO singleTon = null;

	private NonmemberDAO() {
	};

	public static NonmemberDAO getInstance() {
		if (singleTon == null) {
			singleTon = new NonmemberDAO();
		}
		return singleTon;
	}

	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();

	/**
	 * 핸드폰번호와 비밀번호가 param인 멤버정보가져오는 select문
	 */
	public Nonmember nonmemberlogin (List<Object> param) {
		String sql = "SELECT NM_NO, NM_NAME, NM_TELNO, NM_PASS FROM NONMEMBER\r\n" + 
				"    WHERE NM_TELNO = ? AND NM_PASS = ?";
		Map map =  jdbc.selectOne(sql,param);
		if(map ==null)
			return null;
		return ConvertUtils.convertToVo(map, Nonmember.class);
	}
	
	public int signUp(List<Object> param) {
		String sql = " INSERT INTO NONMEMBER (NM_NO,NM_NAME,NM_TELNO,NM_PASS) \r\n " + 
				"    VALUES((SELECT 'b' || LPAD(TO_NUMBER(MAX(SUBSTR(NM_NO, 2))) + 1, 3, '0') FROM NONMEMBER ), ?,?,?) \r\n" ;
		return jdbc.update(sql,param);
	}

	public Nonmember telverlap(List<Object> param) {
		String sql = "SELECT * FROM NONMEMBER\r\n" + 
				"    WHERE NM_TELNO = ?";
//		Map<String, Object> m = jdbc.selectOne(sql, param);
		
		if(jdbc.selectOne(sql, param) == null) return null;
		Map<String, Object> m = jdbc.selectOne(sql, param);
		return ConvertUtils.convertToVo(m, Nonmember.class);
	}


}
