package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Manager;
import vo.Member;

public class ManagerDAO {
	private static ManagerDAO singleTon = null; // 외부에서 접근x

	private ManagerDAO() {
	};

	public static ManagerDAO getInstance() { // public으로 객체를 만들어서 사용함->10줄에가서 1번만 사용가능함
		if (singleTon == null) {
			singleTon = new ManagerDAO();

		}
		return singleTon;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

//	public List<Manager> managerLogin() {
//		String sql = 
//		return null;
//	}

	public Manager managerLogin(String id, String pass) {
		String sql = "select * from manager where mg_id = ? and mg_pass = ?";//★
		List<Object> param = new ArrayList<Object>();
		param.add(id);
		param.add(pass);
		Map result = jdbc.selectOne(sql, param);
		if(result==null) {
			return null;
		}
//		String id1     = (String) result.get("MG_ID");
//		String pass1   = (String) result.get("MG_PASS");
//		String name1   = (String) result.get("MG_NAME");
//		
//		
//			
//		Manager manager = new Manager();
//		manager.setMg_id(id1);
//		manager.setMg_pass(pass1);
//		manager.setMg_name(name1);
		
		
		return ConvertUtils.convertToVo(result, Manager.class);
	}
}
