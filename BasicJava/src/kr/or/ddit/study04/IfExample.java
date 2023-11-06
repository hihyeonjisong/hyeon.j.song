package kr.or.ddit.study04;

import java.util.Scanner;// ctrl shift o

public class IfExample {
// {클래스 블럭 시작
	Scanner sc = new Scanner(System.in);//test에 틀 저장해놈
	String c ="클래스 변수 입니다.";
	//메인 블럭 시작
	public static void main(String[] args) {
		IfExample obj = new IfExample();
//		obj.method1();
//		obj.method2();
//		obj.method3();
		obj.method4();
		System.out.println("메인 메소드에서 호출"+obj.c);
	//메인 블럭 끝
		
	//메소드 블럭 시작	
	}
	private void method4() {
		//
		if(1==1) //  {  ->안해줘도됌
			System.out.println("실행1");
		System.out.println("실행");
		
		
	}
	private void method3() {
		//점수를 입력 받고 학점을 출력하시오.
		//(90점 이상 A)(80:B)(70:c)(60:D)(0~59:F)
		// 100~95 A+ 95~90A-
		System.out.println("점수를 입력하세요.");
		int grade = sc.nextInt();
		
		String g=""; 
		if(grade>=90) {
			g= "A";
//			if(grade>=95) {
		   //if(grade%10>5 || grade%10 == 0) 100점 일때
//				g+="+";
		}else if(grade>=80) {
				g="B";
		}else if(grade>=70) {
				g="C";
		}else if(grade>=60) {
				g="D";
		}else {
				g="F";
		}
		
		//+,-붙는거
		if(grade%10>5 || grade%10 == 0) { //100점일때 나머지0이라서
			g+="+";
		}else {
			g+="-";
		}
		System.out.println(g+"입니다.");
			
		
		
		
	}
	
	private void method2() {
		//키와 체중을 입력하여 bmi 지수에 따른
		//정상, 과체중, 비만, 고도비만 등의 정보를 출력하시오.
		//bmi 지수 = 체중/(키*키)
		//0~18.4:저체중
		//18.5~22.9:정상
		//23.0~24.9:과체중
		//25.0~29.9:비만
		//30.0이상 :고도비만
		System.out.println("키를 입력하세요.");
		double key = sc.nextDouble(); //double값 입력 가능
		System.out.println("몸무게를 입력하세요.");
		double weight = sc.nextDouble();
		double bmi = weight/(key*key);
		
		System.out.println("bmi 수치는"+bmi);
		if(bmi<18.5) {
			System.out.println("저체중");
		}else if( bmi<23) { 
//else if(bmi>=18.5 && bmi<23) ->조건2개일때  &&로 이어줌
			System.out.println("정상");
		}else if( bmi<25) {
			System.out.println("과체중");
		}else if( bmi<30) {
			System.out.println("비만");
		}else {
			System.out.println("고도비만");
		}
		
	}
	private void method1() {
		//if 블럭 시작
		System.out.println("메소드1에서 호출"+c);
		String a ="method1";
		if(false) {
			String s ="if 시작점";
			System.out.println(s);//다른 블럭 이어서 변수 s 같아도 여러번 사용 가능함(블럭 별로 변수)
			System.out.println(a);//String a 변수 사용 가능하다
			//if문 안에 if문 사용가능
			if(false) {
				String ss = "if 안에 if문";
				
			}else {
				
			}
			
		}else if(true) {
			String s ="else if 시작점";
		}
		System.out.println("method1");
		
		
	}
//클래스 블럭 끝}
}
