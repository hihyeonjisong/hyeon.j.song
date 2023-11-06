package dao;

import java.util.List;

import util.JDBCUtil;

public class TicketDao {
	private static TicketDao singleTon = null; // 외부에서 접근x

	private TicketDao() {
	};

	public static TicketDao getInstance() { // public으로 객체를 만들어서 사용함->10줄에가서 1번만 사용가능함
		if (singleTon == null) {
			singleTon = new TicketDao();

		}
		return singleTon;
	}
	
	JDBCUtil jdbc = JDBCUtil.getInstance();

	public void ticketCreate(List<Object> param) {
		String sql ="insert into ticket\r\n"+
					"values(?,?,?)";
		jdbc.update(sql,param);
		
	}
	
}
