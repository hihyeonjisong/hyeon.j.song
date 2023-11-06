package kr.or.ddit.study02;

public class ExamVariable {
	public static int a =4;  //main 밖에서도 사용가능 :전역변수(클래스 밑에서 사용하기)
	public static void main(String[] args) {  	//main 안에서만 사용가능 :z 
//		int x , y , z;   선언
//		x=3;			x 3 저장
//		y=2;
//		z=4;			(위와아래동일함)
		
		int x=3;	// x 선언하면서 저장 (=은 넣는다!라는뜻임)
		int y=2;
		int z=x+y;
		
		System.out.println("x + y 의 결과값은 "+z ); // ""로 문자 출력같이함
		
		System.out.println("a 값은 : "+4+ " 입니다.");
	}

	public void test() {
	//	System.out.println("x + y 의 결과값은 "+z);  // main밖이라서 z 실행 안됌.
		System.out.println("a 값은 : "+4+ " 입니다."); //main밖에서도 a 실행됌.
	}
}
