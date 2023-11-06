package kr.or.ddit.study08;

public class MobileLoginImple_인터페이스 implements ILogin { //

	@Override
	public boolean login(String id, String pass) {
		System.out.println("안드로이드 키보드를 통해 구현");
		return false;
	}

	@Override
	public boolean sign(String id, String pass, String name, String tell) {
		// TODO Auto-generated method stub
		return false;
	}

}
