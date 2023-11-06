package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.BusService;
import service.TicketService;
import util.ScanUtil;
import util.View;
import vo.Bus;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();
	// service랑 연결
	BusService busservice = BusService.getInstance();
	TicketService ticketservice =TicketService.getInstance();

	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case BUS_RESERVE:
				view = reserve();
				break;
			case TICKET_CREATE:
				view = ticketCreate();
				break;
			case RESERVE_lIST:
				view = list();
//			case RESERVE_CANCLE:
//				view = cancle();

			}
		}
	}

	private View ticketCreate() {
		Bus bus = (Bus) sessionStorage.get("bus");//보낼때도 그랬으니 꺼낼때도 bus라는 클래스로 꺼내야함
		
		return null;
	}

	private View cancle() {
		// TODO Auto-generated method stub
		return null;
	}

	private View list() {
		// TODO Auto-generated method stub
		return null;
	}

	private View reserve() {
		String st = ScanUtil.nextLine("출발지역>> ");
		String ed = ScanUtil.nextLine("도착지역>> ");

		// 리스트 파라미터 보내야함
		List<Bus> busList = busservice.list(st, ed);

		printlist(busList);
		printReserveMenu();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		while (true) {
			switch (select) {
			//티켓(테이블)이 발급되야함
			case 1:
				//원하는 버스가 선택됨
				int busNo = ScanUtil.nextInt("예매번호를 선택하세요.");
				Bus bus = busList.get(busNo);
				//세션으로 저장해서 보내야함
				sessionStorage.put("busNo", bus);
				return View.TICKET_CREATE;
			case 2:
				return View.RESERVE_lIST;
			case 3:
				return View.HOME;
			//3중 하나 안고르면 무한반복
			default:
				System.out.println("다시 입력하세요.");
				;
			}
		}
	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.BUS_RESERVE;
		case 2:
			return View.RESERVE_lIST;
		case 3:
			return View.RESERVE_CANCLE;
		default:
			return View.HOME;
		}
	}
}
