package service;

import java.util.List;

import dao.MemberDAO;
import vo.Member;

public class MemberService {
	// 싱글톤 패턴을 만든다.
	private static MemberService instance = null;

	private MemberService() {
	}

	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberService();
		return instance;
	}

	public static int loginCount = 0;

	// Dao를 부른다
	MemberDAO dao = MemberDAO.getInstance();

	public void MemberDel(int delNo) {
		dao.MemberDel(delNo);

	}

	public void MemberInsert(List<Object> param) {
		dao.MemberInsert(param);

	}

	public static List<Member> memberList() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean idPassChk(String idpass) {
		boolean pass = true;
		for (char ch : idpass.toCharArray()) {
			if ('0' <= ch && ch <= '9') {
			} else if ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z') {
			} else
				return false;
			if (idpass.length() < 10) {
			} else
				return false;
		}
		return true;
	}
	public boolean idChk(String id) {
		return idPassChk(id);
	}

	public boolean passChk(String pass) {
		return idPassChk(pass);
	}

	public boolean nameChk(String name) {
		if(2<=name.length() && name.length()<=4)return true;
		return false;
	}

	public boolean ageChk(int age) {
		if(age>0 ||age<150) {
			return true;
		}else
		return false;
	}

	public boolean roomChk(int room) {
		if(room ==101||room==102||room==103) {
			return true;
		}else
			return false;
	}

	public boolean signUp(List<Object> param) {
		return false;
	}

}
