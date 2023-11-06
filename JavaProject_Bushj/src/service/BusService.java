package service;

import java.util.List;

import dao.BusDao;
import vo.Bus;


public class BusService {//알고리즘 처리
	private static BusService singleTon = null;

	private BusService() {
	};

	public static BusService getInstance() {
		if (singleTon == null) {
			singleTon = new BusService();
		}
		return singleTon;
	}
	
	BusDao busdao = BusDao.getInstance();

//	public List<BusBoard> BusList(List<Object> param) {
//		return busdao.BusList(param);
//	}
//
//	public List<BusBoard> BusSearcList(List<Object> param) {
//		return dao.BusSearcList(param);
//	}

	public  List<Bus> list(String st, String ed) {
		return busdao.list(st,ed);
		
	}

}
