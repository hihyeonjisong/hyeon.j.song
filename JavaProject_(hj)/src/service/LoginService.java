package service;

import java.util.List;

import controller.Controller;
import dao.LoginDAO;
import exception.PassChkException;
import vo.Member;

public class LoginService {
	// 싱글톤 패턴을 만든다.
	private static LoginService instance = null;

	private LoginService() {
	}

	public static LoginService getInstance() {// 싱글톤으로 객체1개만 생성되도록 만듦(객체가 두개이상이면 변수int a값이 각자 다르니까)
		if (instance == null)
			instance = new LoginService();
		return instance;
	}

	public static int loginCount = 0;

	// Dao를 부른다
	LoginDAO dao = LoginDAO.getInstance();

	public boolean login(String id, String pass) {
		Member result = dao.login(id, pass);

		if (result != null && result.getId().equals(id)) {
			loginCount++;//★★★
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result);
			return true;
		} else {
			return false;
		}
	}

	public boolean signUp(List<Object> param) throws PassChkException {
		int result = dao.signUp(param);
		String pass = (String) param.get(1);
		if (pass.contains("admin")) {
			throw new PassChkException();

		}
		if (result == 0) {
			return false;
		} else
			return true;
	}

	/**
	 * 영문이랑, 숫자만 입력 가능하도록 id 10자 이내 입력 하도록 체크할것
	 */
	public boolean idPassChk(String string) {
		boolean pass = true;
		for (char ch : string.toCharArray()) {
			if ('0' <= ch && ch <= '9') {// 숫자체크
			} else if ('a' <= ch && ch <= 'z' || 'A' <= ch && ch <= 'Z') {// 영문체크

			} else
				return false;
			if(string.length()<10) {
				
			}else return false;
		}
		return true;

	}
	//id pass 를 메소드로 따로 뺌
	public boolean idChk(String id) {
		return idPassChk(id);
	}
	
	public boolean passChk(String pass) {
		return idPassChk(pass);
	}
	
	public boolean nameChk(String name) {
		if(2<=name.length() && name.length()<=4) return true;
		return false;
	}



}
