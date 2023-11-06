package service;

import java.util.ArrayList;
import java.util.List;

import dao.BusDao;
import dao.TicketDao;
import vo.Bus;

public class TicketService {
	private static TicketService singleTon = null; // 외부에서 접근x

	private TicketService() {
	};

	public static TicketService getInstance() { // public으로 객체를 만들어서 사용함->10줄에가서 1번만 사용가능함
		if (singleTon == null) {
			singleTon = new TicketService();

		}
		return singleTon;
	}
	TicketDao ticketDao = TicketDao.getInstance();
	BusDao busDao = BusDao.getInstance();
	
	public void ticketCreate(Bus bus) {
		//
		int no =bus.getNo();
		//sit:총좌석 개수  , 7-6 =1 =sit_no(좌석 번호)
		int sit_no=7-bus.getSit();
		//Ticket : TI+버스번호+좌석번호
		String ticket = "TI-"+no+"-"+sit_no;
		//DB에 전달할 파라미터를 저장할 리스트를 생성한다
		List<Object> param = new ArrayList();
		param.add(ticket);
		param.add(sit_no);
		param.add(no);
		//티켓Dao에 ticket정보를 넣는 ticketCreate매서드를 호출한다.(param리스트를 DB에 전달하여 티켓정보를 인서트한다)
		ticketDao.ticketCreate(param);
		
		//또 다른 데이터베이스 업데이트를 위한 파라미터리스트를 생성
		List<Object> param2 = new ArrayList();
		//위에서 빠지고 남은 총좌석 = Sit -1(위에서 예약한 좌석)
		param2.add(bus.getSit()-1);
		param2.add(no);
		//남은 좌석수를 업데이트 하는 updateSitno메서드를 호출한다
		busDao.updateSitNo(param2);
		
		
		//위의3개를 인서트한다
		
	}
}
