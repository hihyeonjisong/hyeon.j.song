package kr.or.ddit.study06.exam1;

public class Class {//class 구성요소: 필드,메소드
	String field1; //필드:데이터 저장공간
	int    field2;
	
	static double field3; //static은 클래스에 종속된변수
	
	public static void main(String[] args) {//메인메소드
		
	}
	public void test() { //test메소드
		
	}
	public Class() { //기본생성자
		
	}
	public Class(String field1, int field2) {//생성자
		this.field1 = field1;
		this.field2 = field2;
	}
	
}

