package kr.or.ddit.study06.exam5;

public class singleTonecall {
	public static void main(String[] args) {
		SingleTon singleTon = SingleTon.getInstance(); //메소드 호출:  클래스 변수1 = 클래스.getInstance
		
		singleTon.a =100;
		System.out.println(singleTon.a);
		SingleTon singleTon2 =  SingleTon.getInstance();
		
		System.out.println(singleTon.a);
	}
}
