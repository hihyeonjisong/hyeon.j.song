package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Bus;

public class BusDao {//1.싱글톤 만들기
	private static BusDao singleTon = null;

	private BusDao() {
	};

	public static BusDao getInstance() {
		if (singleTon == null) {
			singleTon = new BusDao();
		}
		return singleTon;
	}
	
	//2.jdbc연결
	JDBCUtil jdbc = JDBCUtil.getInstance();

//	public List<Bus> BusList(List<Object> param) {
//		String sql = "select * \r\n" + 
//				"from \r\n" + 
//				"    (select ROWNUM rnum , A.* \r\n" + 
//				"     from  (select no, name, price, substr(text,0,5) text,\r\n" + 
//				"                 count, to_char(reg, 'YYYY-MM-DD') reg \r\n" + 
//				"               from Bus_board) A\r\n" + 
//				"    )"+
//				"where rnum>=? and rnum<=?";
//		List<Map<String, Object>> l= jdbc.selectList(sql, param);
//		return ConvertUtils.convertToList(l, BusBoard.class);
//	}
//
//	public List<BusBoard> BusSearcList(List<Object> param) {
//		String sql ="select no, name, price, substr(text,0,5) text,\r\n" + 
//				"                 count, to_char(reg, 'YYYY-MM-DD') reg \r\n" + 
//				"from Bus_board\r\n" + 
//				"where name like '%'||?||'%'\r\n" ; 
//		List<Map<String, Object>> l= jdbc.selectList(sql, param);
//		return ConvertUtils.convertToList(l, BusBoard.class);		
//	}

	public List<Bus> list(String st, String ed) {
		String sql ="select no,st_bus,ed_bus, to_char(de_time,'yyyy-mm-dd HH24:MI') de_time ,bus_cls,company,price, sit from bus \r\n" + 
				"where st_bus =? and ed_bus =?\r\n" + 
				"and de_time between sysdate and trunc(sysdate)+1 \r\n" + 
				"and not sit=0";
		List<Object>param = new ArrayList<Object>();
		param.add(st);
		param.add(ed);
		List<Map<String,Object>>list = jdbc.selectList(sql,param);
		return ConvertUtils.convertToList(list, Bus.class);
		
	}

	public void updateSitNo(List<Object> param2) {
		String sql ="update bus\r\n"+
				"	set sit=? \r\n"+
				"	where no = ?";
		
	}
	

}
