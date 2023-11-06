package kr.or.ddit.study04;

import java.util.Scanner;

public class SwitchExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		SwitchExample obj = new SwitchExample();
//		obj.method1(); //Switch문 설명 +break!(끝에 꼭 있음)
//		obj.method2(); //회원등급 1~3
//		obj.method3(); //30,31인 달
//		obj.method4(); //국가명
//		obj.method5(); //학점
// 정렬단축:ctrl shift f		
		
		
	}

	private void method5() {
		System.out.println("점수입력");
		int score = sc.nextInt();
		switch(score/10) { //수식도 입력 가능함!(int대신)
		case 10:
			System.out.println("A+학점");
		case 9:
			switch(score%10) { //switch문 안에 또 switch문 사용 가능함
			case 0: case 1: case 2:
				System.out.println("A-학점");
				break;
			case 3: case 4: case 5:case 6:
				System.out.println("A0 학점");
				break;
			case 7: case 8: case 9:
				System.out.println("A+학점");
				break;
			default:
				break;
			}
			break;
		}
		
		
	}

	private void method4() {
		System.out.println("국가명 입력");
		String nation = sc.nextLine();
		//switch도  ctrl+enter
		switch (nation) { //이곳에 들어간 변수값대로
		case "korea":	  //case도 따라감
			System.out.println("한국입니다.");
			break;
		case "japan":
			System.out.println("일본입니다.");
			break;
		case "china":
			System.out.println("중국입니다.");
			break;

		default:
			System.out.println("잘못 입력되었습니다.");
			break;
		}
		
		
	}

	private void method3() {
		//계절을 출력
		//끝자리 31일인 달
		//끝자리 30인달
		//끝자리 28,29인 달
		System.out.println("월을 입력");
		int month = sc.nextInt();
		switch(month) {						//month라는 변수값이
		case 1: case 3: case 5: case 7: case 8: case 10: case 12://case 일때
			System.out.println("31일로 끝납니다.");					//출력
			break;												//멈춤!(안까먹자!)
		case 4: case 6: case 9:case 11:
			System.out.println("30일로 끝납니다.");
			break;
		case 2:
			System.out.println("28,29로 끝납니다.");
			break;
//위와 같음  default:  
//			System.out.println("잘못입력되었습니다.");
//			break;
		}
	}

	private void method2() {
		System.out.println("회원등급을 입력하세요 1~3");
		int grade = sc.nextInt();
		
		switch(grade) {				//grade값이
		case 1:						//1일때
			System.out.println("VIP");
			break;
		case 2:						
			System.out.println("우수");
			break;
		case 3:
			System.out.println("일반");
			break;
		default:
			System.out.println("잘못 입력됨");
			break;
	
		
			
		}
		
	}

	private void method1() {
		/*
		 * switch문
		 * 변수가 어떤값을 갖는가에 따라 실행문 선택
		 * if 문보다 코드가 간결함.
		 *
		 switch(변수) {
		 	case 값1 :  ->값1(if문의 조건)
		 	break;
		 	case 값2 :
		 	break;
		 	default :  ->마지막(else와 동일)
		 	
		 }
		 */
	}

}
