package controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import print.Print;
import service.MemberService;
import service.NonmemberService;
import service.ReserveService;
import util.ScanUtil;
import util.View;
import vo.Buyseat;
import vo.Classvo;
import vo.Gubun;
import vo.Member;
import vo.Nonmember;
import vo.Price;
import vo.ReserveList;
import vo.Seat;
import vo.Yeojung;

public class ReserveController extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = Controller.sessionStorage;
	// 싱글톤 패턴을 불러옴
	NonmemberService nonmemberService = NonmemberService.getInstance();
	MemberService memberService = MemberService.getInstance();
	ReserveService reserveService = ReserveService.getInstance();
	
	public View logout() {
		printLogout();
		sessionStorage.clear();
		return View.HOME;
	}

	public View mylist_del() {
		mylist_show();
		int by_no = ScanUtil.nextInt("삭제할 예매번호를 선택하세요.");

		String del = ScanUtil.nextLine(by_no + "번 예매를 삭제 하시겠습니까?(y/n)");
		if (del.equalsIgnoreCase("y")) {
			reserveService.seatlistdel(by_no);
			reserveService.mylistdel(by_no);
			System.out.println(by_no + "번 예매 삭제 완료 되었습니다.");
		}

		return View.RESERVE;
	}

	public View mylist_up() {
		mylist_show();
		printVar();
		int upno = ScanUtil.nextInt("수정할 예약 번호를 입력해주세요.");
		sessionStorage.put("upno", upno); // 수정할 예매 번호
		String up = ScanUtil.nextLine(upno + "번 예매를  수정 하시겠습니까?(y/n)");
		if (up.equalsIgnoreCase("y")) {
			List<Object> param = new ArrayList();
			param.add(upno);
			ReserveList uc = reserveService.upcon(param);
			sessionStorage.put("upcon", uc);

			return View.RESERVE_UPTIME;

		}
		return View.RESERVE;
	}

	public View reserve_plus() {
		printPlusreserve();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.RESERVATION;
		case 2:
			return View.RESERVE;
		case 3:
			return View.LOGOUT;
		default:
			System.out.println("잘못입력!");
			return View.RESERVE_PLUS;

		}
	}

	
	public View mylist_show() {
		Nonmember nm = (Nonmember) sessionStorage.get("nonmember");
		Member mm = (Member) sessionStorage.get("member");
		List<Object> param = new ArrayList();

		if (nm != null) {
			param.add(nm.getNm_no());
			List<ReserveList> list = reserveService.nonReservelist(param);
			reserveList(list);
		} else {
			param.add(mm.getMe_no());
			List<ReserveList> list = reserveService.memReservelist(param);
			reserveList(list);
		}
		System.out.println();
		return View.RESERVE;
	}

	public View reserve_show() {
		Nonmember nm = (Nonmember) sessionStorage.get("nonmember");
		Member mm = (Member) sessionStorage.get("member");

		List<Object> param = new ArrayList();
		param.add((String) sessionStorage.get("seatno"));
		param.add((int) sessionStorage.get("hocha"));
		param.add((int) sessionStorage.get("yjno"));
		Buyseat bs = reserveService.getbuyno(param);

		param.clear();
		param.add((int) sessionStorage.get("yjno"));
		Price pr = reserveService.getprice(param);

		int hocha = (int) sessionStorage.get("hocha");
		int gu = (int) sessionStorage.get("gubun");
		double vprice;
		if (hocha == 2 || hocha == 3 || hocha == 4) {
			vprice = (int) pr.getPr_pr() * 1.2;
			switch (gu) {
			case 1:
				break;
			case 2:
				vprice = vprice * 0.5;
				break;
			case 3:
				vprice = vprice * 0.4;
				break;
			case 4:
				vprice = vprice * 0.3;
				break;
			}

		} else {
			vprice = pr.getPr_pr();
			switch (gu) {
			case 1:
				break;
			case 2:
				vprice = vprice * 0.5;
				break;
			case 3:
				vprice = vprice * 0.4;
				break;
			case 4:
				vprice = vprice * 0.3;
				break;

			}
		}

		param.clear();

		param.add(bs.getBy_no());
		param.add((String) sessionStorage.get("date"));

		param.add((int) sessionStorage.get("gubun"));
		param.add((int) vprice);

		ReserveList up = (ReserveList) sessionStorage.get("upcon");
		if (sessionStorage.get("upcon") != null) {// 수정
			if (nm != null) {
				param.add(nm.getNm_no()); // 비회원번호
				param.remove(0);
				param.remove(0);
				param.add(0, up.getBy_date());
				param.add((int) sessionStorage.get("upno")); // by_no 예매번호
				reserveService.upnonfinallist(param);// 비회원 수정 update
				System.out.println("수정이 완료 되었습니다.");
				param.clear();
				param.add(nm.getNm_no());
				param.add((int) sessionStorage.get("upno"));
				List<ReserveList> list = reserveService.upnonReservelist(param);
				reserveList(list);

			} else {
				param.add(mm.getMe_no());
				param.remove(0);
				param.remove(0);
				param.add(0, up.getBy_date());
				param.add((int) sessionStorage.get("upno"));
				reserveService.upmemfinallist(param);
				System.out.println("수정이 완료 되었습니다.");
				param.clear();
				param.add(mm.getMe_no());
				param.add((int) sessionStorage.get("upno"));
				List<ReserveList> list = reserveService.upmemReservelist(param);
				reserveList(list);
			}
		} else {

			if (nm != null) {
				param.add(nm.getNm_no());
				reserveService.nonfinalList(param);// 비회원 insert

				System.out.println("예매가 완료되었습니다.");
				param.clear();
				param.add(nm.getNm_no());
				List<ReserveList> list = reserveService.nonReservelist(param);
				reserveList(list);
			} else {
				param.add(mm.getMe_no());
				reserveService.memfinalList(param);// 회원 insert
				System.out.println("예매가 완료되었습니다.");
				param.clear();
				param.add(mm.getMe_no());
				List<ReserveList> list = reserveService.memReservelist(param);
				reserveList(list);
			}
		}

		return View.RESERVE_PLUS;
	}

	public View reserve_gubun() {
		List<Gubun> list = reserveService.gubunlist();
		printGubunlist(list); // 구분리스트
		printVar();
		int select = ScanUtil.nextInt("구분 번호를 선택하세요.");
		sessionStorage.put("gubun", select);
		List<Object> param = new ArrayList();
		param.add(select);

		List<Object> param2 = new ArrayList();
		param2.add((String) sessionStorage.get("seat"));

		Seat sv = reserveService.seatno(param2); // SE_NO를 SE_NM으로 바꿔옴
		sessionStorage.put("seatno", sv.getSe_no()); // SE_NM을 넣음

		List<Object> param3 = new ArrayList();
		if (sessionStorage.get("upcon") == null) {
			param3.add(sv.getSe_no());// 예매시 좌석번호
			param3.add((int) sessionStorage.get("hocha"));// 예매시 호차
			param3.add((int) sessionStorage.get("yjno"));// 예매시 여정번호
			reserveService.buyno(param3);
		} else {
			param3.add(sv.getSe_no());// 수정시 좌석번호
			param3.add((int) sessionStorage.get("hocha"));// 수정시 호차
			param3.add((int) sessionStorage.get("yjno"));// 수정시 여정번호
			param3.add((int) sessionStorage.get("upno")); // by_no 예매번호

			reserveService.upbuyno(param3);
		}
		// INSERT 구문
		return View.RESERVE_SHOW;
	}

	public View reserve_seat() {
		
		List<Object> param = new ArrayList();
		param.add(sessionStorage.get("hocha"));
		List<Seat> sn = reserveService.selectNo(param);  //전체좌석
		param.add(sessionStorage.get("yjno"));
		
		
		List<Object> test = new ArrayList();
		List<Buyseat> bs2 = reserveService.test(param);
//		for (Buyseat buyseat : bs2) {
//			System.out.println(buyseat.getSe_nm());
//		}
		test.clear();
		int a = 1;
//		String s = String.format("%02d",  a);
		int count = 0; // 각 줄에 출력된 좌석 수를 세는 변수
		System.out.println();
		System.out.println("[    좌석 배치도      ]");
		System.out.println();
		System.out.println("    A  B  C  D");
		System.out.print(String.format("%02d  ", a));
		for (Seat seat : sn) {
		    seat.getSe_nm();
		    // 좌석 출력
//		    System.out.print(seat.getSe_nm());
		    
		    for (Buyseat buyseat : bs2) {
		    	test.add(buyseat.getSe_nm());
//		    	System.out.println(buyseat.getSe_nm());
			}
//		    {A10, D10, D12}
		    if(test.contains(seat.getSe_nm())) {
		    	System.out.print(seat.getSe_nm().replace(seat.getSe_nm(), "■ "));
//		    	seat.getSe_nm().replace(seat.getSe_nm(), " ");
		    }
		    else {
//		    	System.out.print(seat.getSe_nm());
		    	System.out.print("□ ");
		    	
		    }
		    
		    count++;
		  
		    // 4개씩 출력 후 줄바꿈
		    if (count % 4 == 0 && a!=16) {
		        
		    	System.out.println();
		    	a++;
		    	System.out.print(String.format("%02d  ", a));
		        count = 0; // 다음 줄을 위해 count를 초기화
		    } else {
		        System.out.print(" "); // 공백 추가
		    }
		}
		
		// 마지막 줄바꿈 (4의 배수가 아닌 경우에 대비)
		if (count > 0) {
		    System.out.println();
		}
		System.out.println();
		printVar();
		String seatselect = ScanUtil.nextLine("좌석명를 입력하세요");
		sessionStorage.put("seat", seatselect);

		return View.RESERVE_GUBUN;

	}

	public View reserve_class() {
		List<Classvo> ns = reserveService.numberlist();
		printClasslist(ns);
		printVar();
		int select = ScanUtil.nextInt("호차번호를 선택하세요.");
		printVar();
		sessionStorage.put("hocha", select);

		return View.RESERVE_SEAT;
	}

	private String getSelectedDate(int choice) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, choice);
		Date selectedDate = cal.getTime();
		return sdf.format(selectedDate);

	}

	public View reserve_uptime() {
		ReserveList uc = (ReserveList) sessionStorage.get("upcon");
		
		List<Object> param = new ArrayList();
		param.add(uc.getTr_st()); // 수정 부분에서 가지고 온 출발지
		param.add(uc.getTr_ed()); // 수정 부분에서 가지고 온 도착지

		LocalDate now = LocalDate.now();
		// 날짜 포맷 지정
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		// 포맷 적용하여 결과 출력
		String formatterNow = now.format(formatter);
		printVar();
		if (formatterNow == uc.getBy_date()) { // 받아온 그 날짜가 오늘 날짜면
			List<Yeojung> l = reserveService.reservetoday(param);
			printTimelist(l);
		} else {
			List<Yeojung> s = reserveService.reservenottoday(param);
			printTimelist(s);
		}
		printVar();
		param.clear();
		int selectt = ScanUtil.nextInt("번호를 선택하세요.");
		sessionStorage.put("yjno", selectt);
		param.add(selectt);
		Yeojung yv = reserveService.selectYeojung(param);
		System.out.println("출발시간 [ " + yv.getTr_si() + " ] 이 선택 되었습니다.");
		return View.RESERVE_CLASS;

	}

	public View reserve_time() {

		int ds = (int) sessionStorage.get("dateselect");//

		Yeojung train = (Yeojung) sessionStorage.get("train");

		List<Object> param = new ArrayList();
		param.add(train.getTr_st());
		param.add(train.getTr_ed());

		if (ds == 1) {
			List<Yeojung> l = reserveService.reservetoday(param);
			printTimelist(l);
		} else {
			List<Yeojung> s = reserveService.reservenottoday(param);
			printTimelist(s);
		}

		param.clear();
		printVar();
		int selectt = ScanUtil.nextInt("번호를 선택하세요.");
		sessionStorage.put("yjno", selectt);
		param.add(selectt);
		Yeojung yv = reserveService.selectYeojung(param);
		System.out.println("출발시간 [ " + yv.getTr_si() + " ] 이 선택 되었습니다.");
		return View.RESERVE_CLASS;

	}

	public View reserve_date() {
		printreserveService();
		printVar();
		int select = ScanUtil.nextInt("원하시는 날짜를 선택하세요.");
		printVar();
		sessionStorage.put("dateselect", select);
		switch (select) {
		case 1:
			System.out.println(getSelectedDate(0) + "이 선택되었습니다.");
			break;
		case 2:
			System.out.println(getSelectedDate(1) + "이 선택되었습니다.");
			break;
		case 3:
			System.out.println(getSelectedDate(2) + "이 선택되었습니다.");
			break;
		case 4:
			System.out.println(getSelectedDate(3) + "이 선택되었습니다.");
			break;
		default:
			System.out.println("다시선택하세요");
			return View.RESERVE_DATE;

		}

		sessionStorage.put("date", getSelectedDate(select - 1));

		List<Object> param = new ArrayList();
		Yeojung yj = (Yeojung) sessionStorage.get("train");// 출발지,도착지 입력

		param.add(yj.getTr_st());
		printVar();
		System.out.println("☆+:...:+☆+:...:+☆+:...:+☆+:...:+☆+:...:+☆");
		System.out.println("                "+yj.getTr_st() + " ➾   " + yj.getTr_ed());
		System.out.println("☆+:...:+☆+:...:+☆+:...:+☆+:...:+☆+:...:+☆");
		param.add(yj.getTr_ed());

		return View.RESERVE_TIME;
	}

	public View reservation() {

		Yeojung yj = new Yeojung();
		printTrainstart();
		String st = ScanUtil.nextLine("출발지 입력>>");
		yj.setTr_st(st);
		printTrainend();
		String ed = ScanUtil.nextLine("도착지 입력>>");
		yj.setTr_ed(ed);
		sessionStorage.put("train", yj);

		printDatechoice();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.RESERVATION;
		case 2:
			return View.RESERVE_DATE;
		}
		return null;
	}

	public View reserve() {
		printReserveMenu();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.RESERVATION;
		case 2:
			return View.MYLIST_SHOW;
		case 3:
			return View.MYLIST_UP;
		case 4:
			return View.MYLIST_DEl;
		case 5:
			return View.LOGOUT;
		default:
			return View.HOME;
		}

	}

	


}
