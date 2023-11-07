package controller;//화면 이동 입출력

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import exception.PassChkException;
import print.Print;
import service.LoginService;
import util.ScanUtil;
import util.View;

public class Controller extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = new HashMap<>();

	LoginService loginService = LoginService.getInstance();

	public static void main(String[] args) { // public(강제로)
		new Controller().start();
	}

	private void start() {
		sessionStorage.put("login", false); // false: 로그인 안됨
		sessionStorage.put("loginInfo", null);// -sessionStorage : 로그인 결과 저장
		View view = View.HOME;
		while (true) {
			switch (view) {
			case HOME:
				view = home();
				break;
			case MEMBER_LOGIN:
				view = login();
				break;
			case MEMBER_SIGNUP:
				view = signUp();
				break;
			case MAIN:
				view = main();
				break;
			}
		}
	}

	private View signUp() {
		System.out.println("회원가입 정보를 입력해주세요.");
		/*
		 * id 10자 이내 입력 하도록 체크할것 영문이랑 숫자만 입력가능하도록
		 */
		String id;
		while(true) {
			id = ScanUtil.nextLine("아이디 >>");// ScanUtil 이란 메소드로 편하게사용
			boolean idPass = loginService.idChk(id);
			if(idPass) break;	
			System.out.println("10자 이내 입력");
			System.out.println("영문이랑 숫자만 입력");
		}
		/*
		 * id 10자 이내 입력하도록 체크할것 영문이랑,숫자 만 입력가능하도록
		 */
		String pass ;
		while(true) {
			pass= ScanUtil.nextLine("비밀번호 >>");// ScanUtil 이란 메소드로 편하게사용
			boolean passPass = loginService.passChk(pass);
			if(passPass) break;	
			System.out.println("10자 이내 입력");
			System.out.println("영문이랑 숫자만 입력");
		}
		// 2~4글자 입력. 체크
		String name ;
		while(true) {
			name= ScanUtil.nextLine("이름 >>");// ScanUtil 이란 메소드로 편하게사용
			boolean namePass = loginService.nameChk(name);
			if(namePass) break;	
			System.out.println("2~4글자 입력");
		}

		// 11자 숫자 입력하도록 체크
		
		String phone;
		while(true) {
			phone =ScanUtil.nextLine("번호 >>");
			phone = phone.replace("-", "");//- 없애기
			try {
				if(phone.length()!=11) { //길이 체크
					System.out.println("11자숫자입력");
					continue;
				}
				Long.parseLong(phone);//숫자를 long으로 형변환 ->형변환 안되면 exception발생
				break;
			}catch(Exception e) {
				
			}
			System.out.println("11자리 숫자만 입력하세요.");
			
			
		}

//		if (pass.contains("admin")) {
//			throw new PassChkException();
//
//			String pass = ScanUtil.nextLine("비밀번호 >>");
//			String name = ScanUtil.nextLine("이름 >>");
//			String phone = ScanUtil.nextLine("번호 >>");

		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		param.add(name);
		param.add(phone);

		boolean signPass = loginService.signUp(param);
		if (signPass) {
			System.out.println("회원가입이 성공 하였습니다.");
			return View.HOME;
		} else {
			System.out.println("회원가입이 실패했습니다. 다시 시도해 주세요.");
			return View.MEMBER_SIGNUP;

		}
	}

	private View main() {
//		Member loginInfo = (Member) sessionStorage.get("loginInfo");
//		System.out.println(loginInfo.getName() + "님! 로그인 되었습니다");
		System.out.println("환영합니다.");
		return null;
	}

	private View login() {
		View pageNo;
		String id = ScanUtil.nextLine("아이디 입력>>> ");// ScanUtil 이란 메소드로 편하게사용
		String pass = ScanUtil.nextLine("비밀번호 입력>>> ");

		boolean loginChk = loginService.login(id, pass);
		if (loginChk) {
			pageNo = View.MAIN;
		} else {
			System.out.println("다시 로그인해주세요!");
			pageNo = View.MEMBER_LOGIN;
		}
		return pageNo;//★★★
	}

	private View home() {
		printHome();
		switch (ScanUtil.nextInt("번호 입력 >> ")) {
		case 1:
			return View.MEMBER_LOGIN;
		case 2:
			return View.MEMBER_SIGNUP;
		default:
			return View.HOME;
		}
	}

}
