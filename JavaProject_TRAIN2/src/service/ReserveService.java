package service;

import java.util.List;

import dao.MemberDAO;
import dao.ReserveDAO;
import vo.Buyseat;
import vo.Classvo;
import vo.Gubun;
import vo.Price;
import vo.ReserveList;
import vo.Seat;
import vo.Yeojung;

public class ReserveService {
	private static ReserveService singleTon = null;

	private ReserveService() {
	};

	public static ReserveService getInstance() {
		if (singleTon == null) {
			singleTon = new ReserveService();
		}
		return singleTon;
	}

	// 다오를 부름
	MemberDAO memberdao = MemberDAO.getInstance();
	ReserveDAO reservedao = ReserveDAO.getInstance();


	public void buyno(List<Object> param3) {
		reservedao.buyno(param3);
		
	}
	

	public Seat seatno(List<Object> param2) {
		return reservedao.seatno(param2);
		
	}
	

	public List<Yeojung> reservetoday(List<Object> param) {
		return reservedao.reservetoday(param);
	}


	public List<Yeojung> reservenottoday(List<Object> param) {
		return reservedao.reservenottoday(param);
	}

	public List<Classvo> numberlist() {
		return reservedao.numberlist();
	}

	public Yeojung selectYeojung(List<Object> param) {
		return reservedao.selectYeojung(param);
		
	}


	public List<Gubun> gubunlist() {
		return reservedao.gubunlist();
		
	}

	public List<Seat> selectNo(List<Object> param) {
		return reservedao.selectNo(param);
		
	}

	public Buyseat getbuyno(List<Object> param) {
		return reservedao.getbuyno(param);
		
	}

	public Price getprice(List<Object> param) {
		return reservedao.getprice(param);
		
	}

	public void nonfinalList(List<Object> param) {
		reservedao.nonfinalList(param);
	}

	public void memfinalList(List<Object> param) {
		reservedao.memfinalList(param);
		
	}


	public List<ReserveList> nonReservelist(List<Object> param) {
		return reservedao.nonReservelist(param);
		
	}

	public List<ReserveList> memReservelist(List<Object> param) {
		return reservedao.memReservelist(param);
		
	}

	public void mylistdel(int by_no) {
		reservedao.mylistdel(by_no);
		
	}

	public ReserveList upcon(List<Object> param) {
		return reservedao.upcon(param);
		
	}



	public void upnonfinallist(List<Object> param) {
		reservedao.upnonfinallist(param);
		
	}

	public void upmemfinallist(List<Object> param) {
		reservedao.upmemfinallist(param);
		
	}

	public List<ReserveList> upnonReservelist(List<Object> param) {
		return reservedao.upnonReservelist(param);
	}

	public List<ReserveList> upmemReservelist(List<Object> param) {
		return reservedao.upmemnonReservelist(param);
	}

	public void upbuyno(List<Object> param3) {
		reservedao.upbuyno(param3);
		
	}

	public void seatlistdel(int by_no) {
		reservedao.seatlistdel(by_no);
		
	}

	public List<Buyseat> buySeatlist() {
		return reservedao.buySeatlist();
		
	}

	public List<Buyseat> test(List<Object> test) {
		return reservedao.test(test);
		
	}





	






	

}
