package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.ConvertUtils;
import util.JDBCUtil;
import vo.Buyseat;
import vo.Classvo;
import vo.Gubun;
import vo.Price;
import vo.ReserveList;
import vo.Seat;
import vo.Yeojung;

public class ReserveDAO {
	private static ReserveDAO singleTon = null;

	private ReserveDAO() {
	};

	public static ReserveDAO getInstance() {
		if (singleTon == null) {
			singleTon = new ReserveDAO();
		}
		return singleTon;
	}

	// JDBC를 부른다.
	JDBCUtil jdbc = JDBCUtil.getInstance();
	
	
	public void buyno(List<Object> param3) {
		String sql = "INSERT INTO BUYSEAT(BY_NO, SE_NO, TR_CI, YJ_NO)\r\n" + 
				"    VALUES((select max(by_no)+1 from BUYSEAT),?,?,?)";
		jdbc.update(sql,param3);
		
	}
	
	public Seat seatno(List<Object> param2) {
		String sql = "SELECT SE_NO FROM SEAT \r\n" + 
				"WHERE SE_NM = ? \r\n" ;
		Map<String, Object> l = jdbc.selectOne(sql, param2);
		return ConvertUtils.convertToVo(l, Seat.class);
	}
	
	
	

	public List<Yeojung> reservetoday(List<Object> param) {
		
		String sql = "SELECT YJ_NO, TR_ST, TR_ED, TO_CHAR(TO_DATE(TR_SI, 'HH24:MI:SS'), 'HH24:MI') AS tr_si, TO_CHAR(TO_DATE(TR_EI, 'HH24:MI:SS'), 'HH24:MI')AS tr_ei\r\n" + 
				"    FROM YEOJUNG\r\n" + 
				"    WHERE TR_ST = ? AND TR_ED = ? AND TO_CHAR(SYSDATE, 'HH24:MI') < TO_CHAR(TO_DATE(TR_SI, 'HH24:MI'), 'HH24:MI')";
		List<Map<String, Object>> l = jdbc.selectList(sql,param);
		return ConvertUtils.convertToList(l, Yeojung.class);
		
	}

	public List<Yeojung> reservenottoday(List<Object> param) {
		String sql = "SELECT YJ_NO, TR_ST, TR_ED, TO_CHAR(TO_DATE(TR_SI, 'HH24:MI:SS'), 'HH24:MI') AS tr_si, TO_CHAR(TO_DATE(TR_EI, 'HH24:MI:SS'), 'HH24:MI')AS tr_ei\r\n" + 
				"    FROM YEOJUNG\r\n" + 
				"    WHERE TR_ST = ? AND TR_ED = ?";
		List<Map<String, Object>> l = jdbc.selectList(sql,param);
		return ConvertUtils.convertToList(l, Yeojung.class);
	}

	public List<Classvo> numberlist() {
		String sql = "SELECT TR_CI, CL_NAME FROM CLASS";
		List<Map<String, Object>> l = jdbc.selectList(sql);
		return ConvertUtils.convertToList(l, Classvo.class);
	}

	public Yeojung selectYeojung(List<Object> param) {
		String sql = "SELECT * FROM YEOJUNG WHERE YJ_NO = ?";
		Map<String, Object> l = jdbc.selectOne(sql, param);
		return ConvertUtils.convertToVo(l, Yeojung.class);
	}


	public List<Gubun> gubunlist() {
		String sql = "SELECT * FROM GUBUN";
		List<Map<String, Object>> l = jdbc.selectList(sql);
		return ConvertUtils.convertToList(l, Gubun.class);
	}

	public List<Seat> selectNo(List<Object> param) {
		String sql = "SELECT DISTINCT * FROM SEAT A, CLASS B\r\n" + 
				"    WHERE  B.TR_CI = ?";
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(l, Seat.class);
//		String sql = "SELECT DISTINCT * FROM SEAT A, CLASS B\r\n" + 
//				"    WHERE  B.TR_CI = ?";
//		Map<String, Object> map = jdbc.selectOne(sql, param);
//		return ConvertUtils.convertToVo(map, Seat.class);
	}

	public Buyseat getbuyno(List<Object> param) {
		String sql = "SELECT BY_NO FROM BUYSEAT\r\n" + 
				"    WHERE SE_NO = ? AND TR_CI = ? AND  YJ_NO = ?";
		Map<String, Object> l = jdbc.selectOne(sql, param);
		return ConvertUtils.convertToVo(l, Buyseat.class);
		
	}

	public Price getprice(List<Object> param) {
		String sql = "SELECT PR_PR FROM PRICE\r\n" + 
				"    WHERE PR_NO = (SELECT PR_NO FROM YEOJUNG WHERE YJ_NO=?)";
		Map<String, Object> l = jdbc.selectOne(sql, param);
		return ConvertUtils.convertToVo(l, Price.class);
	}

	public void nonfinalList(List<Object> param) {
		String sql = "INSERT INTO BUY(P_NO, BY_NO, BY_DATE, GU_NO, BY_PRICE, NM_NO)\r\n" + 
				"    VALUES((select max(P_NO)+1 from BUY),?,?,?,?,?)";
		jdbc.update(sql,param);
	}

	public void memfinalList(List<Object> param) {
		String sql = "INSERT INTO BUY(P_NO, BY_NO, BY_DATE, GU_NO, BY_PRICE, ME_NO)\r\n" + 
				"    VALUES((select max(P_NO)+1 from BUY),?,?,?,?,?)";
		jdbc.update(sql,param);
		
	}
	

	public List<ReserveList> nonReservelist(List<Object> param) {
		String sql = "SELECT A.BY_NO, TO_CHAR(A.BY_DATE, 'YYYY-MM-DD') by_date, C.TR_ST, C.TR_ED, C.TR_SI, C.TR_EI, D.CL_NAME, B.SE_NO, A.BY_PRICE\r\n" + 
				"    FROM BUY A , BUYSEAT B, YEOJUNG C, CLASS D\r\n" + 
				"    WHERE A.BY_NO = B.BY_NO AND B.YJ_NO = C.YJ_NO AND B.TR_CI = D.TR_CI AND A.NM_NO = ? AND A.BY_DELYN IS NULL  "
				+ " ORDER BY A.BY_NO ASC";
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(l, ReserveList.class);
	}

	public List<ReserveList> memReservelist(List<Object> param) {
		String sql = "SELECT A.BY_NO, TO_CHAR(A.BY_DATE, 'YYYY-MM-DD') by_date, C.TR_ST, C.TR_ED, C.TR_SI, C.TR_EI, D.CL_NAME, B.SE_NO, A.BY_PRICE\r\n" + 
				"    FROM BUY A , BUYSEAT B, YEOJUNG C, CLASS D\r\n" + 
				"    WHERE A.BY_NO = B.BY_NO AND B.YJ_NO = C.YJ_NO AND B.TR_CI = D.TR_CI AND A.ME_NO = ? AND A.BY_DELYN IS NULL "
				+ " ORDER BY A.BY_NO ASC";
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(l, ReserveList.class);
	}

	public void mylistdel(int by_no) {
		String sql = "DELETE FROM BUY\r\n" + 
				"    WHERE BY_NO = ?";
		List<Object> param = new ArrayList();
		param.add(by_no);
		jdbc.update(sql,param);
		
	}

	public ReserveList upcon(List<Object> param) {
		String sql = "SELECT TO_CHAR(A.BY_DATE, 'YYYY-MM-DD') by_date, C.TR_ST, C.TR_ED\r\n" + 
				"    FROM BUY A, BUYSEAT B, YEOJUNG C \r\n" + 
				"    WHERE A.BY_NO = B.BY_NO AND B.YJ_NO = C.YJ_NO AND A.BY_NO = ?";
		Map<String, Object> l = jdbc.selectOne(sql, param);
		return ConvertUtils.convertToVo(l, ReserveList.class);
	}

	public void upnonfinallist(List<Object> param) {
		String sql = " UPDATE BUY SET BY_DATE = ?, GU_NO = ?, BY_PRICE = ?, NM_NO = ?\r\n" + 
				"    WHERE BY_NO = ?";
		jdbc.update(sql,param);
		
	}

	public void upmemfinallist(List<Object> param) {
		String sql = " UPDATE BUY SET BY_DATE = ?, GU_NO = ?, BY_PRICE = ?, ME_NO = ?\r\n" + 
				"    WHERE BY_NO = ?";
		jdbc.update(sql,param);
		
	}

	public List<ReserveList> upnonReservelist(List<Object> param) {
		String sql = "SELECT A.BY_NO, TO_CHAR(A.BY_DATE, 'YYYY-MM-DD') by_date, C.TR_ST, C.TR_ED, C.TR_SI, C.TR_EI, D.CL_NAME, B.SE_NO, A.BY_PRICE\r\n" + 
				"    FROM BUY A , BUYSEAT B, YEOJUNG C, CLASS D\r\n" + 
				"    WHERE A.BY_NO = B.BY_NO AND B.YJ_NO = C.YJ_NO AND B.TR_CI = D.TR_CI AND A.NM_NO = ? AND A.BY_NO = ? AND A.BY_DELYN IS NULL";
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(l, ReserveList.class);
		
	}

	public List<ReserveList> upmemnonReservelist(List<Object> param) {
		String sql = "SELECT A.BY_NO, TO_CHAR(A.BY_DATE, 'YYYY-MM-DD') by_date, C.TR_ST, C.TR_ED, C.TR_SI, C.TR_EI, D.CL_NAME, B.SE_NO, A.BY_PRICE\r\n" + 
				"    FROM BUY A , BUYSEAT B, YEOJUNG C, CLASS D\r\n" + 
				"    WHERE A.BY_NO = B.BY_NO AND B.YJ_NO = C.YJ_NO AND B.TR_CI = D.TR_CI AND A.ME_NO = ? AND A.BY_NO = ? AND A.BY_DELYN IS NULL";
		List<Map<String, Object>> l = jdbc.selectList(sql, param);
		return ConvertUtils.convertToList(l, ReserveList.class);
	
	}

	public void upbuyno(List<Object> param3) {
		String sql = "UPDATE BUYSEAT \r\n" + 
				"    SET SE_NO = ?, TR_CI = ?, YJ_NO = ?\r\n" + 
				"    WHERE BY_NO = ?";
		jdbc.update(sql,param3);
		
	}

	public void seatlistdel(int by_no) {
		String sql = "DELETE FROM BUYSEAT\r\n" + 
				"    WHERE BY_NO = ?";
		List<Object> param = new ArrayList();
		param.add(by_no);
		jdbc.update(sql,param);
		
	}

	public List<Buyseat> buySeatlist() {
		String sql = "SELECT SE_NO FROM BUYSEAT";
		List<Map<String, Object>> l = jdbc.selectList(sql);
		return ConvertUtils.convertToList(l, Buyseat.class);	
	}

	public List<Buyseat> test(List<Object> test) {
		String sql = "select se_nm from buyseat a, seat b\r\n" + 
				"where a.se_no = b.se_no and tr_ci = ? and yj_no = ?";
		List<Map<String, Object>> l = jdbc.selectList(sql, test);
		return ConvertUtils.convertToList(l, Buyseat.class);
		
	}


	



	
}
