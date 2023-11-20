package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Member;
import vo.Seat;

public class MemberDAO {
	private static MemberDAO singleTon = null;

	private MemberDAO() {
	};

	public static MemberDAO getInstance() {
		if (singleTon == null) {
			singleTon = new MemberDAO();
		}
		return singleTon;
	}

	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	/**
	 * id,pass가 param인 멤버정보가져오는 select문
	 */
	public Member memberlogin(List<Object> param) {
		String sql = "SELECT ME_NO, ME_ID, ME_PASS, ME_NAME, ME_TELNO, ME_BIR \r\n" + "    FROM MEMBER\r\n"
				+ "    WHERE ME_ID = ? AND ME_PASS  = ?";
		Map m = jdbc.selectOne(sql, param);
		if (m == null)
			return null;
		return ConvertUtils.convertToVo(m, Member.class);
	}


	public int signUp(List<Object> param) {
		String sql = "INSERT INTO MEMBER (ME_NO, ME_ID, ME_PASS, ME_NAME, ME_TELNO, ME_BIR)\r\n" + 
				"    VALUES((SELECT 'a' || LPAD(TO_NUMBER(MAX(SUBSTR(ME_NO, 2))) + 1, 3, '0') FROM MEMBER),\r\n" + 
				"    ?,?,?,?,?)";
		return jdbc.update(sql, param);
	}

	public Member idoverlap(List<Object> param2) {
		String sql = "SELECT * FROM MEMBER\r\n" + 
				"    WHERE ME_ID = ?";
		if(jdbc.selectOne(sql, param2) == null) return null;
		Map<String, Object> map = jdbc.selectOne(sql, param2);
		return ConvertUtils.convertToVo(map, Member.class);
	}


}
