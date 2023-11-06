package kr.or.ddit.study07.phone;

public class SmartPhone extends Phone { // tell기능이 extends되어 구현됌
	public void internet() {
		System.out.println("인터넷 검색");
	}

	public void touch() {
		System.out.println("터치동작");
	}

	@Override //부모클래스 추가해서 기능수정
	public void camera() { //camera+ ctrl+ space

		System.out.println("1000만 화소 카메라");
	}

}
