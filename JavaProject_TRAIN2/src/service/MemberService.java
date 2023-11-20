package service;

import java.util.List;

import controller.Controller;
import dao.MemberDAO;
import vo.Member;

public class MemberService {
	private static MemberService singleTon = null;

	private MemberService() {
	};

	public static MemberService getInstance() {
		if (singleTon == null) {
			singleTon = new MemberService();
		}
		return singleTon;
	}

	// 다오를 부름
	MemberDAO memberdao = MemberDAO.getInstance();
	/**
	 * 멤버 정보 가져옴
	 */
	public Member memberlogin(List<Object> param) {
		return memberdao.memberlogin(param);
	}

	public boolean idChk(String id) {
		boolean idpass = true;
		for (char ch : id.toCharArray()) {
			if (('0' < ch && ch <= '9') && ('a' < ch && ch <= 'z')) {

			}
			if (8 <= id.length() && id.length() <= 12) {

			} else {
				return false;
			}
		}
		return true;
	}

	public boolean passChk(String pass) {
		boolean passpass = true;
		for (char ch : pass.toCharArray()) {
			if (('0' < ch && ch <= '9') && ('a' < ch && ch <= 'z')) {

			}
			if (5 < pass.length() && pass.length() <= 20) {

			} else {
				return false;
			}
		}
		return true;
	}

	public boolean nameChk(String name) {
		if (2 <= name.length() && name.length() <= 10)
			return true;
		return false;
	}

	public boolean phoneChk(String phone) {
		if (phone.length() != 11) {
			return false;
		}
		return true;
	}

	public boolean birChk(String bir) {
		if (bir.length() != 13) {
			return false;
		}
		return true;
	}

	public boolean signup(List<Object> param) {
		int result = memberdao.signUp(param);
		if (result == 0) {
			return false;
		} else {
			return true;
		}

	}

	public Member idoverlap(List<Object> param2) {
		return memberdao.idoverlap(param2);		
	}



}
