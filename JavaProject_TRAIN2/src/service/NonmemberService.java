package service;

import java.util.List;

import controller.Controller;
import dao.NonmemberDAO;
import vo.Nonmember;


public class NonmemberService {
	// 싱글톤 패턴을 만든다.
	private static NonmemberService singleTon = null;

	private NonmemberService() {
	};

	public static NonmemberService getInstance() {
		if (singleTon == null) {
			singleTon = new NonmemberService();
		}
		return singleTon;
	}

	// Dao를 부른다
	NonmemberDAO nonmemberDao = NonmemberDAO.getInstance();
	

	/**
	 * 비회원 정보 가져옴
	 */
	public Nonmember nonmemberlogin(List<Object> param) {
		 return nonmemberDao.nonmemberlogin(param);
	}
	
	public boolean nameChk(String name) {
		if(2<name.length() && name.length()<=10) {
			return true;
		}else return false;
		
	}

	public boolean passChk(String pass) {
		if( 5 == pass.length()) {
			return true;
		}else return false;
	}

	public boolean signUp(List<Object> param) {
		if(nonmemberDao.signUp(param) != 0) {
			return true;
		}else {
			return false;
		}
		
	}

	public Nonmember telverlap(List<Object> param) {
		return nonmemberDao.telverlap(param);
		
	}





}
