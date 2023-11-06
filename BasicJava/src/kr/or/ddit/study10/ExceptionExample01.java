package kr.or.ddit.study10;

public class ExceptionExample01 {
	public static void main(String[] args) {
		ExceptionExample01 ee = new ExceptionExample01();
		ee.devide(10, 3);
		ee.devide(3, 0);//Arithmetic에러 (콘솔창에서 보고 알수있음)(둘째줄엔 에러 장소)
		
	}
	
	public double devide(int a,int b) {
		
		if(b==0) {//에러 원인 알수있게해줌
			System.out.println("0으로 나눌수 없습니다.");
			return 0;
		}
		return a/b;
	}
}
