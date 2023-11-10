package service;

import java.util.List;

import controller.Controller;
import dao.AdminDao;
import vo.Admin;

public class AdminService {
	private static AdminService singleTon = null;

	private AdminService() {
	};

	public static AdminService getInstance() {
		if (singleTon == null) {
			singleTon = new AdminService();
		}
		return singleTon;
	}

	AdminDao adDao = AdminDao.getInstance();
	
	public boolean login(List<Object> param) {//param이라는 list를 인자로 받는다
		//데이터베이스에서 해당하는 id,pass를 가진 객체를 가져온다
		Admin ad = adDao.login(param);
		if(ad != null) {//가져온 Admin객체가 null이 아니라면 
			//해당 객체를 세션스토리지에 admin이라는키로 저장하고  true를 반환한다
			Controller.sessionStorage.put("admin",ad);
			return true;
		}
		return false;
	}
	
}
