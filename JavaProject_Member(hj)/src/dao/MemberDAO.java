package dao;

import java.util.List;

import util.JDBCUtil;

public class MemberDAO {
	private static MemberDAO singleTon = null; // 외부에서 접근x

	private MemberDAO() {
	};

	public static MemberDAO getInstance() { // public으로 객체를 만들어서 사용함->10줄에가서 1번만 사용가능함
		if (singleTon == null) {
			singleTon = new MemberDAO();
		}
		return singleTon;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	public int sign(List<Object>param) {
		String sql = "insert into student(mem_id,mem_pass,mem_name,mem_age,mem_room_"
				+"values(?,?,?,?,?)";
		return jdbc.update(sql,param);
	}
}
