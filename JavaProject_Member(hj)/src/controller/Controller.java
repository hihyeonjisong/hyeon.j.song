package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import print.Print;
import service.ManagerService;
import service.MemberService;
import util.ScanUtil;
import util.View;
import vo.Manager;
import vo.Member;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();
	// 싱글톤 패턴을 불러옴
	MemberService memberService = MemberService.getInstance();
	ManagerService managerService = ManagerService.getInstance();

	public static void main(String[] args) {
		new Controller().start();
	}

	private void start() {
		sessionStorage.put("login", false); // false: 로그인 안됨
		sessionStorage.put("loginInfo", null);
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case MANAGER:
				view = manager();
				break;
			case MANAGER_LOGIN:
				view = managerLogin();
				break;
			case MAIN:
				view = main();
				break;
			case MEMBER_SIGNUP:
				view = memberSignup();
				break;
			case MEMBER:
				view = memberHome();
				break;
//			case MEMBER:
//				view = member();
//				break;
			case MEMBERLIST:
				view = memberList();
				break;

			}
		}
	}

	private View memberHome() {
		printMemberhome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.MEMBER_SIGNUP;
		case 2:
			return View.MEMBER_UPDATE;
		case 3:
			return View.MEMBER_OUT;
		case 4:
			return View.MEMBER;
		case 5:
			return View.HOME;	
		default:
			return View.MEMBER;
		}
	}

	private View memberSignup() {
		printVar();
		System.out.println("회원가입 정보를 입력해주세요.");
		printVar();
		String id;
		String pass;
		String name;
		int age;
		int room;
		while (true) {
			id = ScanUtil.nextLine("아이디 : ");
			boolean idPass = memberService.idChk(id);
			if (idPass)
				break;
			System.out.println("10자 이내 입력");
			System.out.println("영문이랑 숫자만 입력");
		}
		while (true) {
			pass = ScanUtil.nextLine("비밀번호 : ");
			boolean passPass = memberService.passChk(pass);
			if (passPass)
				break;
			System.out.println("10 이내 입력");
			System.out.println("영문이랑 숫자만 입력");
		}
		while (true) {
			name = ScanUtil.nextLine("이름  : ");
			boolean namePass = memberService.nameChk(name);
			if (namePass)
				break;
			System.out.println("2~4글자 입력");
		}
		while (true) {
			age = ScanUtil.nextInt("나이  : ");

			boolean agePass = memberService.ageChk(age);
			if (agePass)
				break;
			System.out.println("숫자만 입력");
		}
		while (true) {
			room = ScanUtil.nextInt("방번호 입력: ");
			boolean roomPass = memberService.roomChk(room);
			if (roomPass)
				break;
			System.out.println("101호,102호,103호 중에서 입력");
		}

		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		param.add(name);
		param.add(age);
		param.add(room);

		boolean signPass = memberService.signUp(param);
		if (signPass) {
			System.out.println("회원가입이 성공하였습니다.♬");
			return View.MEMBER;
		} else {
			System.out.println("회원가입이 실패했습니다. 다시 시도해 주세요.");
			return View.MEMBER_SIGNUP;
		}
	}

	private View main() {

		Manager loginInfo = (Manager) sessionStorage.get("loginInfo");
//		Controller.sessionStorage.put("mg_name");
		System.out.println(loginInfo.getMg_name() + "님! 로그인 되었습니다");
		System.out.println("환영합니다.");
		return null;
	}

	private View managerLogin() {
		View page;
		String id = ScanUtil.nextLine("아이디 입력 :");
		String pass = ScanUtil.nextLine("비밀번호 입력 :");

		boolean loginChk = managerService.managerLogin(id, pass);

		if (loginChk) {
			page = View.MAIN;
		} else {
			System.out.println("다시 로그인해주세요!");
			page = View.MANAGER_LOGIN;
		}
		return page;
	}

	private View memberList() {
		List<Member> list = MemberService.memberList();
		printMemberList(list);
		return null;
	}

	private View manager() {
		printManagerLoginMenu();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.MANAGER_LOGIN;
		case 2:
			return View.HOME;
		default:
			return View.HOME;

		}
	}

//	private View book_add() {
//		String name = ScanUtil.nextLine("책 제목 작성");
//		String price = ScanUtil.nextLine("가격 작성");
//		String sale = ScanUtil.nextLine("판매가 작성");
//		String writer = ScanUtil.nextLine("저자 작성");
//		String company = ScanUtil.nextLine("출판사 작성");
//		String pudate = ScanUtil.nextLine("출간일 작성");
//		String con = ScanUtil.nextLine("책 설명 작성");
//
//		List<Object> param = new ArrayList();
//		param.add(name);
//		param.add(price);
//		param.add(sale);
//		param.add(writer);
//		param.add(company);
//		param.add(pudate);
//		param.add(con);
//
//		bookService.bookInsert(param);
//		return View.BOOK_LIST;
//	}

//	private View book_del() {
//		printDelete();
//		int select = ScanUtil.nextInt("메뉴를 선택하세요");
//		switch (select) {
//		case 1:
//			int delNo = ScanUtil.nextInt("삭제할번호 선택");
//			String del = ScanUtil.nextLine(delNo + "게시글을 삭제 하시겠습니까?(y/n)");
//			if (del.equals("y")) {
//				bookService.bookDel(delNo);
//			}
//			return View.BOOK_LIST;
//		case 2:
//			int pageNo = (int) sessionStorage.get("pageNo") + 1;
//			sessionStorage.put("pageNo", pageNo);
//			return View.BOOK_DEL;
//		case 3:
//			pageNo = (int) sessionStorage.get("pageNo") - 1;
//			sessionStorage.put("pageNo", pageNo);
//			return View.BOOK_DEL;
//		case 4:
//			return View.HOME;
//		default:
//			return View.BOOK_DEL;
//		}
//	}

//	private View book_Detail() {
//		int bookNo = (int) sessionStorage.get("bookNo");
//		Book book = bookService.bookDetail(bookNo);
//		printDetail(book);
//		int select = ScanUtil.nextInt("메뉴를 선택하세요");
//		switch (select) {
//		case 1:
//			return View.BOOK_LIST;
//		default:
//			return View.BOOK_DETAIL;
//		}
//	}

//	private View book_list() {
//		List<Book> list = bookService.bookList();
//		printBookList(list);
//		printListMenu();
//		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
//		switch (select) {
//		case 1:
//			int bookNo = ScanUtil.nextInt("책 번호를 입력");
//			sessionStorage.put("bookNo", bookNo);
//			return View.BOOK_DETAIL;
//		case 2:
//			return View.HOME;
//		default:
//			return View.BOOK_LIST;
//		}
//	
//}

	private View home() {
		printHome();
		int select = ScanUtil.nextInt("메뉴를 선택하세요.");
		switch (select) {
		case 1:
			return View.MANAGER;
		case 2:
			return View.MEMBER;
		default:
			return View.HOME;
		}
	}
}
