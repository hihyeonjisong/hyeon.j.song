package service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import dao.BusDao;
import dao.TicketDao;
import vo.Bus;

public class TicketService {
	private static TicketService singleTon = null;

	private TicketService() {
	};

	public static TicketService getInstance() {
		if (singleTon == null) {
			singleTon = new TicketService();
		}
		return singleTon;
	}
	TicketDao ticketDao = TicketDao.getInstance();
	BusDao busDao = BusDao.getInstance();

	public void ticketCreate(Bus bus) {
		int no = bus.getNo();
		int sit_no =7-bus.getSit_no();
		String ticket = "TI-"+no+"-"+sit_no;
		List<Object> param = new ArrayList();
		param.add(ticket);
		param.add(sit_no);
		param.add(no);
		ticketDao.ticketCreate(param);
		
		List<Object> param2 = new ArrayList();
		param2.add(bus.getSit_no()-1);
		param2.add(no);
		busDao.updateSitNo(param2);
		
	}
}
