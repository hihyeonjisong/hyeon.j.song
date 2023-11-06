package kr.or.ddit.study04;

import java.util.Scanner;

public class WhileExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WhileExample obj = new WhileExample();
//		obj.method1();
//		obj.method2(); //다시다시
//		obj.method3();
//		obj.method4();//다시
		

	}

	private void method4() {
		// do while 
		//반드시 한번 실행됨 (do빠져나와서 while이 false여도 do1번 실행함)
		int i =0;
		do {
			i++;
//			continue; //continue뒤에 print문 있으면 실행안됨. print다음에 위치해야함
			System.out.println("실행 : "+i);
			
			if(i==1) {
				
				continue; 
			}
			System.out.println("실행2 : " +i);
		}while(i<3); 
		
	}

	private void method3() {//반복문이 언제까지 될지 모를때 while문 사용함
		int overflow = 1000000;
		while(true) {
			overflow++; 		//1씩 증가함 
			System.out.println(overflow);
			if(overflow<0) { 	//int 값 범위로 넘어갈때 -값이 발생함
				System.out.println(overflow);
				System.out.println("오버플로우 발생");
				break;
			}
		}
		
	}

	private void method2() {
		String menu = 
				"***커피메뉴**\n"
			+ "1.아메리카노\t1000		\n"
			+ "2.카페라떼\t1500		\n"
			+ "3.자바칩 프라프치노\t2000		\n"
			+ "4.카라멜 마키아또\t2500		\n"
			+ "5.프로그램 종료		\n";
		int sum=0;
		String bill = "***영수증**\n";
		
		while(true) {
			System.out.println(menu);
			System.out.println("메뉴를 선택해 주세요.");
			int select = sc.nextInt();//숫자를 입력받을거임
			int exit = 0;
			switch(select) {
			case 
			
			1:
				sum+=1000;
				bill+="아메리카노\n";
//				System.out.println("아메리카노");
				break;
			case 2:
				sum+=1500;
				bill+="카페라떼\n";
//				System.out.println("카페라떼");
				break;
			case 3:
				sum+=2000;
				bill+="자바칩 프라프치노\n";
//				System.out.println("자바칩 프라프치노");
				break;
			case 4:
				sum+=2500;
				bill+="카라멜 마키아또\n";
//				System.out.println("카라멜 마키아또");
				break;
			case 5:
				System.out.println("프로그램 종료");
				exit = -1; //
				break;
			default:
				System.out.println("잘못 입력 되었습니다.");
				break;
			}
			if(exit == -1) {				//while문이 종료되는 종료조건
//				     						 (5를 입력->case5->exit이 -1이 됌 ->while문 빠져나와서 멈춤
				break;
			}
		}
		System.out.println("총 금액은 :"+sum);
		System.out.println(bill);
	}


	private void method1() {
		/*
		 * While 반복문 무한루프 등을 사용할때 주로 사용
		 *                끝나는 지점을 알수 없을 때 ex)파일 일어들일때
		조건식 
		while(true) {
			실행문
		}
		*/
		
		int num = 0;
		while(num<10) {
			System.out.println(num++ +"번 실행됨");//++num은 1부터 실행
		}
	}

}
