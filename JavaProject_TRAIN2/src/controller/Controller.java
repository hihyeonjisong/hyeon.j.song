package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.MemberService;
import service.NonmemberService;
import util.ScanUtil;
import util.View;
import vo.Member;
import vo.Nonmember;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();
	// 싱글톤 패턴을 불러옴
	NonmemberService nonmemberService = NonmemberService.getInstance();
	MemberService memberService = MemberService.getInstance();

	LoginController lc = new LoginController();
	ReserveController rc = new ReserveController();
	
	public static void main(String[] args) {
		
		new Controller().start();
	}

	private void start() {
		View view = View.HOME;
		printimage();
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case MEMBER_LOGIN:
				view = lc.member_login();
				break;
			case NONMEMBER_LOGIN:
				view = lc.nonmember_login();
				break;
			case MEMBER_JOIN:
				view = lc.member_join();
				break;
			case NONMEMBER_JOIN:
				view = lc.nonmember_join();
				break;
			case RESERVE:
				view = rc.reserve();
				break;
			case RESERVATION:
				view = rc.reservation();
				break;
			case RESERVE_DATE:
				view = rc.reserve_date();
				break;
			case RESERVE_TIME:
				view = rc.reserve_time();
				break;
			case RESERVE_CLASS:
				view = rc.reserve_class();
				break;
			case RESERVE_SEAT:
				view = rc.reserve_seat();
				break;
			case RESERVE_GUBUN:
				view = rc.reserve_gubun();
				break;
			case RESERVE_SHOW:
				view = rc.reserve_show();
				break;
			case RESERVE_PLUS:
				view = rc.reserve_plus();
				break;
			case MYLIST_SHOW:
				view = rc.mylist_show();
				break;
			case MYLIST_UP://수정할번호 선택
				view = rc.mylist_up();
				break;
			case RESERVE_UPTIME:
				view = rc.reserve_uptime();
				break;
			case MYLIST_DEl:
				view = rc.mylist_del();
				break;
			case LOGOUT:
				view = rc.logout();

			}
		}
	}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.MEMBER_LOGIN;
		case 2:
			return View.NONMEMBER_LOGIN;
		case 3:
			return View.MEMBER_JOIN;
		case 4:
			return View.NONMEMBER_JOIN;
		default:
			return View.HOME;
		}
	}
}
