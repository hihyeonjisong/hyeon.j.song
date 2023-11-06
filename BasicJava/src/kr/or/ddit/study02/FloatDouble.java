package kr.or.ddit.study02;

public class FloatDouble {
	public static void main(String[] args) {
		// 1.float : 4byte(부호(1bit), 지수 (8bit),
		//					가수(23bit)
		//			끝에  f 추가
		// 2.double : 8byte(부호(1bit), 지수 (11bit),
		//					가수 (52bit)
		
		float f1 = 3.141562f; // float엔 f 써줘야함
		double d1 = 3.141562;
		
		// 변환 오차 발생
		if(f1 == d1) {	//==은 같다,같은지 궁금할때
			System.out.println("같은 값"); //if문이 참일경우
		}else {
			System.out.println("다른 값"); //if문이 거짓일경우 ->변수값이 달라서 다른값으로 나옴
										 // float double을 같이 쓰지마(과학관련분야)
		}
	}

}
