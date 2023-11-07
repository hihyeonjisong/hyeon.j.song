package service;

import java.util.List;

import controller.Controller;
import dao.ManagerDAO;
import vo.Manager;

public class ManagerService {
	private static ManagerService singleTon = null;

	private ManagerService() {
	};

	public static ManagerService getInstance() {
		if (singleTon == null) {
			singleTon = new ManagerService();
		}
		return singleTon;
	}

	ManagerDAO dao = ManagerDAO.getInstance();

	public static int loginCount = 0;

//	public List<Manager> ManagerList(List<Object> param) {
//		return dao.ManagerList(param);
//	}
//
//	public List<Manager> ManagerSearcList(List<Object> param) {
//		return dao.ManagerSearcList(param);
//	}
//
//	public List<Manager> managerLogin() {
//		return dao.managerLogin();
//	}

	public boolean managerLogin(String id, String pass) {
		Manager result = dao.managerLogin(id, pass);
		if (result != null && result.getMg_id().equals(id) && result.getMg_pass().equals(pass)) {
//			loginCount++;
			Controller.sessionStorage.put("login", true);
			Controller.sessionStorage.put("loginInfo", result);
			return true;
		} else
			return false;

	}
}
