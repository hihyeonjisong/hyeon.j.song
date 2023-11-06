package kr.or.ddit.study08;

public interface ILogin {
	public boolean login(String id, String pass); //인터페이스:메소드 명만 하고 끝남(직접구현x)
	public boolean sign(String id, String pass, String name, String tell);
}
