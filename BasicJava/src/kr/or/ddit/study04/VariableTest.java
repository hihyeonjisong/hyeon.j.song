package kr.or.ddit.study04; //맨밑 질문 왜 안돼?

import java.util.Scanner;

public class VariableTest {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		VariableTest obj = new VariableTest();
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();
//		obj.method5();
		obj.method6();
		
		
	}

	private void method1() {
		//기본타입을 각각 선언해보고 값을 저장할것
		//8가지
		//system.out.println을 이용해서 출력까지 해보자.
		
		//정수형
		//byte= 8bit 프로그램 기본단위로 많이 사용(많이 사용)
		byte b = 127;
		short s = 32;
		int i = 100;
		long l = 100000000000L;
		
		//실수형
		float f = 0.1f; 
		//타입이 달라도 변수명은 같으면 안됌
		double d = 0.1;
		if( f == d) {
			System.out.println("같음");
		}else {
			System.out.println("다름"); //->float과 double은 값이 다름
		}
		
		//char
		char c ='a'; //한글자만 ,작은따옴표
		
		boolean b1 = true;
		boolean __b1 = true;//변수 이름 비슷하게 지을때ㅋㅋ
		
		
	}
	private void method2() {

		//각 데이터를 형변환하고 출력하시오.
		
		//char->int 작은것에서 큰것으로 변환할땐 자동으로됌
		char c1 ='a';
		int i1 = c1;
		System.out.println(i1);
		
		//int->char int가 더 크니까 타입 강제변환 해야함
		int i2 = 65;
		char c2 = (char)i2;
		System.out.println(c2);
		
		//int->double
		//int 값 변수 a,b를 나누기 연산 후 double로 저장
		int i3 = 5;
		double d3 = (double)i3/2;
		System.out.println(d3);
		
		//char ->String
		//c3_1+c3_2값을 문자열에 저장
		char c3_1 = 'a';
		char c3_2 = 'b';
		String s3 = ""+c3_1 + c3_2;// ""는 문자열을 더한다는뜻
								   // 문자열+ c3_1 이니까 문자로 인식함
		
		
		
	}
    private void method3() {
    	//Math.random ->double값임
    	//0~0.999999999999999999999 범위 값.
    	//*10은 범위 값  +1은 시작 값
    	//(int)(Math.random()*10)+1
//    	int ran = (int)(Math.random()*10)+1; //범위 0~10까지(10포함하는 범위라서 +1함)
//    	System.out.println(ran);
    	
    	//양꼬치는 1인분에 12000원 음료수는 2000원 입니다.
    	//양코치 n개와 음료수k개를 먹었다면 총얼마 지불해야하는지 출력해보시오.
    	//n 값은 1~10
    	//k 값은 1~3
    	int n = (int)(Math.random()*10)+1;
    	int k = (int)(Math.random()*3)+1;
    	
    	int result = 12000*n + 2000*k;
    	System.out.println(n+","+k+"\n"+result);
 
    	
  } 
    private void method4() {
    	//정수 num1, num2 랜덤한 변수(1~50)로 주어질때
	    //num1을 num2로 나눈 나머지와 몫을 출력하세요.
	  	int num1 = (int)(Math.random()*50)+1;
	  	int num2 = (int)(Math.random()*50)+1;
	  	
	  	int result4 = num1/num2;
	  	int result5 = num1%num2;
//	  	System.out.println(result4+","+result5);
	  	//printf로 출력하는게 더 깔끔함
	  	System.out.printf("몫은 %d, 나머지는 %d ",result4,result5);
    	
  }
    private void method5() {
    	//정수 num1,num2 랜덤한 변수(1~50)로 주어질때
    	//num1을 num2로 나눈 값에 1000을 곱한 후
    	//정수 부분을 출력하세요.
//    	int num1 = (int)(Math.random()*50)+1;
//	  	int num2 = (int)(Math.random()*50)+1;
    	
    	int num1=20;
    	int num2=14;
	  	//int는 나눌때 항상 조심!
	  	//int result = (num1/num2)*1000;//틀림 (int라서 정수끼리 나누고 정수만꺼냄->거기에다 1000을 곱하면 값이 달라짐)
	  	int result = num1*1000/num2;//정답
	  	double result_d = (double)result/1000;		
	  	//소수점 3자리 출력하도록 해볼것
	  	//방법1
	  	double result1 = (double)num1*1000/num2/1000.0;//1000.0->double로 인식함
	  	//방법2(결과를 나눠서 표시하면 보기 쉬움)
//	  	int result_int=num1*1000/num2;
//	  	double result =(double)result_int/1000;
	  	
	  	System.out.println(result);
	  	System.out.println(result_d);
	  	System.out.printf("%.3f",result1);//소숫점세자리 나타내는 또 다른 방법
    	
    	
    }
    private void method6() {
    	/*
    	 * 두 정수에 대한 연산으로 두 정수를 붙여서 쓴값을 출력합니다.
    	 * 예를들면 다음과 같습니다.(범위 0~100)
    	 * a=12, b=3
    	 * 12☆3=123
    	 * 3☆12=312
    	 * 
    	 * 양의 정수와 a와 b가 주어졌을때
    	 * a☆b 와 b☆a값중 더 큰값을 출력하세요
    	 */
//    	int a = (int)(Math.random()*100)+1;
//	  	int b = (int)(Math.random()*100)+1;
//    	
//	  	
//	  	String ab = ""+a+b;
////	  	String ab = String.valueOf(a)+String.valueOf(b); 숫자를 문자로 바꿈(위와 같은 말임)
//	  	String ba = ""+b+a;
//	  	
//	  	//문자->숫자
//	  	int ab_int =Integer.parseInt(ab);
//	  	int ba_int =Integer.parseInt(ba);
//	  	
//	  	if(ba_int<ab_int) {
//	  		System.out.println(ab_int);
//	  	}else {
//	  		System.out.println(ba_int);
//	  	}
    	
    	int a =(int)(Math.random()*100)+1;
    	int b =(int)(Math.random()*100)+1;
    	
    	String ab =""+a+b;
    	String ba =""+b+a;
    	
    	
    	if(ba > ab) {
    		System.out.println(ba);
    	}else {
    		System.out.println(ab);
    	}
	  	
	  	
    }
    	
    
    	
    	
    	
    
}
