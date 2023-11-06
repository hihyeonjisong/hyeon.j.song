package kr.or.ddit.study06.exam5.db;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBconnService {
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs =null;
	
	public static void main(String[] args) {//db접속을1번만 하기 위해서 Static씀
		DBconnService dbs = new DBconnService();
		dbs.selectAll();
		dbs.selectAll();
		dbs.selectAll();
	}
	
	public void selectAll() {
		EmpVO emp = new EmpVO();
		conn = DBconn.getConnection();
		try {
			stmt = conn.createStatement();
			String sql = "SELECT EMPID,NAME, DEPT FROM EMP";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) { //
				String empid = rs.getNString("EMPID");//
				String name = rs.getNString("NAME");
				String dept = rs.getNString("DEPT");
//				System.out.printf("%s\t%s\t%s\n",empid,name,dept);
				emp.setDept(dept);
				emp.setEmpid(empid);
				emp.setName(name);
				
				System.out.println(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
