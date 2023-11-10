package dao;

import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Admin;

public class AdminDao {
	private static AdminDao singleTon = null;

	private AdminDao() {
	};

	public static AdminDao getInstance() {
		if (singleTon == null) {
			singleTon = new AdminDao();
		}
		return singleTon;
	}

	JDBCUtil jdbc = JDBCUtil.getInstance();

	public Admin login(List<Object> param) {
		//테이블에서 해당하는 레코드를 찾기위한 sql쿼리
		String sql = " select * from st_admin where id =? and pass =? ";
		//jdbc객체를 사용하여 쿼리를 실행하고 결과를 map<String,Object>형태로 받아온다
		Map<String, Object> map = jdbc.selectOne(sql, param);
		//만약결과값인 map이 null이라면(레코드를 찾지 못했다면) null을 반환
		//그렇지 않으면 convertutil~을 사용하여 Admin객체로 변환하여 반환한다
		if(map == null) return null;
		Admin ad = ConvertUtils.convertToVo(map, Admin.class);
		return ad;
	}
	
}
