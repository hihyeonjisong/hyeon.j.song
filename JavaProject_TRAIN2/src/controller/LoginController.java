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

public class LoginController extends Print {
	// 세션
	static public Map<String, Object> sessionStorage = Controller.sessionStorage;
	// 싱글톤 패턴을 불러옴
	NonmemberService nonmemberService = NonmemberService.getInstance();
	MemberService memberService = MemberService.getInstance();

	public View nonmember_join() {
		String name;
		String telno;
		String pass;
		while (true) {
			name = ScanUtil.nextLine("이름>> ");
			boolean namePass = nonmemberService.nameChk(name);
			if (namePass)
				break;
			System.out.println("2~10자리의  이름을 입력해주세요.");
		}
		while (true) {
			telno = ScanUtil.nextLine("번호>> ");
			telno = telno.replace("-", "");
			List<Object> param = new ArrayList();
			param.add(telno);
//			Nonmember nm = nonmemberService.telverlap(param);
			if (nonmemberService.telverlap(param) != null) {
				System.out.println("비회원정보가 이미 등록 되어 있습니다.");
				continue;
			}
			try {
				if (telno.length() != 11) {
					System.out.println("11자리 숫자를 입력해주세요.");
					continue;
				}
				Long.parseLong(telno);
				break;
			} catch (Exception e) {

			}
			System.out.println("11자리 숫자만 입력하세요.");
		}
		while (true) {
			pass = ScanUtil.nextLine("비밀번호>> ");
			boolean passPass = nonmemberService.passChk(pass);
			if (passPass)
				break;
			System.out.println("5자리숫자로 조합하여 만들어주세요.");

		}
		List<Object> param = new ArrayList();
		param.add(name);
		param.add(telno);
		param.add(pass);

		boolean signPass = nonmemberService.signUp(param);
		if (signPass) {
//			Nonmember nm = (Nonmember) sessionStorage.get("nonmember"); 
//			System.out.println(nm.getNm_name()+"님 비회원등록이 성공하였습니다.");
			System.out.println("비회원 등록이 성공하였습니다.");
			return View.HOME;
		} else {
			System.out.println("회원가입이 실패했습니다. 다시 시도해 주세요.");
			return View.NONMEMBER_JOIN;
		}

	}

	public View member_join() {
		System.out.println("회원가입 정보를 입력해주세요");
		// ID 체크
		String id;
		while (true) {
			id = ScanUtil.nextLine("아이디>>");
			List<Object> param2 = new ArrayList();
			param2.add(id);
			
			if(memberService.idoverlap(param2) != null) {
				System.out.println("이미 등록된 아이디 입니다.");
				continue;
			}
				
				
			boolean idPass = memberService.idChk(id);
			if (idPass)
				break;
			System.out.println("8~12자 이내 / 영문+숫자 조합하여 입력");
			
		}
		
		String pass;
		while (true) {
			pass = ScanUtil.nextLine("비밀번호>>");
			boolean passPass = memberService.passChk(pass);
			if (passPass)
				break;
			System.out.println("6~20자 이내 /영문+숫자 조합하여 입력 ");
		}
		
		String name;
		while (true) {
			name = ScanUtil.nextLine("이름 >>");
			boolean namePass = memberService.nameChk(name);
			if (namePass)
				break;
			System.out.println("2~4글자 입력");
		}
		
		String phone;
		while (true) {
			phone = ScanUtil.nextLine("번호>>");
			phone = phone.replace("-", "");
			boolean phonePass = memberService.phoneChk(phone);
			if (phonePass)
				break;
			System.out.println("11자리 숫자 입력");
		}
		
		String bir;
		while (true) {
			bir = ScanUtil.nextLine("주민등록번호>>");
			bir = bir.replace("-", "");
			boolean birPass = memberService.birChk(bir);
			if (birPass)
				break;
			System.out.println("13자리 숫자 입력");
		}

		List<Object> param = new ArrayList();
		param.add(id);
		param.add(pass);
		param.add(name);
		param.add(phone);
		param.add(bir);
		boolean signPass = memberService.signup(param);
		if (signPass) {
			System.out.println("회원가입이 성공하였습니다.");
			return View.HOME;
		} else {
			System.out.println("회원가입이 실패하였습니다. 다시 시도해주세요.");
			return View.HOME;
		}
		

	}

	public View nonmember_login() {
		String telno;// telno자료가 -여서 다시생각해보기
		while (true) {
			telno = ScanUtil.nextLine("전화번호>> ");
			telno = telno.replace("-", "");
			try {
				if (telno.length() != 11) {
					System.out.println("010부터 숫자를 차례로 입력해주세요.");
					continue;
				}
				Long.parseLong(telno);
				break;
			} catch (Exception e) {
				System.out.println("010부터 숫자를 차례로 입력해주세요.");
			}

		}
		String pass = ScanUtil.nextLine("비밀번호>> ");
		List<Object> param = new ArrayList<Object>();
//		param.add("01049396059");
//		param.add("12345");
		param.add(telno);
		param.add(pass);
		Nonmember nm = nonmemberService.nonmemberlogin(param);
		if (nm == null) {
			System.out.println("해당하는 비회원을 찾을수 없습니다.");
			printLoginfalse();
			int select = ScanUtil.nextInt("메뉴를 선택하세요.");
			switch (select) {
			case 1:
				return View.MEMBER_JOIN;
			case 2:
				return View.NONMEMBER_JOIN;
			default:
				return View.HOME;
			}
		} else {
			sessionStorage.put("nonmember", nm);
			System.out.println();
			System.out.println("♥"+nm.getNm_name()+"님♥ 환영합니다.");
			return View.RESERVE;
		}
	}

	public View member_login() {
		List<Object> param = new ArrayList<Object>();
		System.out.println("로그인 정보를 입력해주세요");
		param.add(ScanUtil.nextLine("id>>"));
		param.add(ScanUtil.nextLine("pass>>"));
		Member mb = memberService.memberlogin(param);
		if (mb == null) {
			System.out.println("회원정보가 없습니다.");
			printLoginfalse();
			int select = ScanUtil.nextInt("메뉴를 선택하세요.");
			switch (select) {
			case 1:
				return View.MEMBER_JOIN;
			case 2:
				return View.NONMEMBER_JOIN;
			default:
				return View.HOME;
			}
		} else {
			sessionStorage.put("member", mb);
			System.out.println();
			System.out.println("♥"+mb.getMe_name()+"님♥ 환영합니다.");
			return View.RESERVE;
		}

	}

}
