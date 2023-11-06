package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Bus;

public class BusDao {
	private static BusDao singleTon = null;

	private BusDao() {
	};

	public static BusDao getInstance() {
		if (singleTon == null) {
			singleTon = new BusDao();
		}
		return singleTon;
	}
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public List<Bus> list(String st, String ed) {
		String sql =
				"select * from bus\r\n" + 
				"where st_bus = ? and ed_bus = ? \r\n" + 
				"and de_time between sysdate and trunc(sysdate)+1\r\n" + 
				"and not sit_no =0";
		List<Object> param = new ArrayList();
		param.add(st);
		param.add(ed);
		List<Map<String, Object>> list = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(list, Bus.class);
	}

	public void updateSitNo(List<Object> param2) {
		String sql = "update bus\r\n" + 
					" set sit_no =?\r\n" + 
					" where no =?";
		jdbc.update(sql, param2);
	}
	
}
