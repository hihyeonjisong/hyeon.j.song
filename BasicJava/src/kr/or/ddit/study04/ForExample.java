package kr.or.ddit.study04;//window-show view에서 콘솔창 띄울수있음

import java.util.Scanner;

public class ForExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample obj = new ForExample();
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();//홀수
//		obj.method5();//짝수
//		obj.method6();
		obj.method7();//scanner 를 통해 문자를 입력받고  입력받은 문자부터 z까지 입력받기*

	}

	private void method7() {
		// a~z까지 출력
//		for(int c ='a';c<='z';c++) {
//			System.out.println((char)c);
//		}
		
		
		//scanner 를 통해 문자를 입력받고  입력받은 문자부터
		//z까지 출력할것.
		System.out.println("문자를 입력해주세요.");
		String s =sc.nextLine(); 
		char c = s.charAt(0);//1번째 문자를 갖고옴
		for( int cc =c  ; cc<'z'; cc++) { //초기화문 안써도됌 for(;c<='z';c++)
			System.out.println((char)cc);
		}

		
	}

	private void method6() {
		// 1~100까지 홀수의합
		// 1~100까지 짝수의 합
		
		//홀수
		int sumOdd = 0;
		//짝수
		int sumEven = 0;
		for(int i =1; i<=100 ; i++) {
			if(i%2==0) {
				sumEven+=i;
			}else {
				sumOdd+=i;
			}
		}System.out.println("짝수의 합은"+sumEven);
		 System.out.println("홀수의 합은"+sumOdd);
		
	
		
	}

	private void method5() {
		// 1~10까지 짝수의 합을 구하시오.
		int sum = 0;
		for(int i =2; i<11 ; i+=2) {
			sum+=i;
		}
		System.out.println("1~10까지 짝수의 합은"+sum);
	}

	private void method4() {
//		// 1~10까지 홀수의 합을 구하시오.
		int sum = 0;
		//방법1
		//1,3,5,7,9, i 실행됨
//		for(int i =1; i<11;i+=2) {
//			sum+=i;
//		}System.out.println("1~10까지 홀수의 합은"+sum);
		

		
		//방법2
		//1,2,3,4,5,6,7,8,9,10 i 실행되며
//		for(int i =1; i<11;i++) {
//			//i값이 홀수일때만 더해짐
//			if(i%2==1) {
//				sum+=i;
//			}
//			System.out.println("1~10까지 홀수의 합은"+sum);
		for(int i =1; i<=10;i++) {
			if(i%2==1) {
				sum+=i;
			}
		
		}System.out.println(sum);
		
		
		
	}

	private void method3() {
		// 10~20까지의 합을 구하시오
		int sum=0; //sum을 0부터 시작해야 +1했을때 1이됌.
		for(int i=10; i<21; i++) {
			sum+=i;
			System.out.println("sum 현재값은 :"+sum);
			System.out.println("i 현재값은 :"+i);
		}
		System.out.println("결과값은 "+sum);
	
		
		
	}

	private void method2() {
		//1~10까지의 합을 구하시오.
		int sum=0;
		for(int i=1; i<=10; i++) {
			sum+=i;
			System.out.println("sum 현재 값은 :"+sum);
			System.out.println("i 현재 값은 :"+ i);
		}
		System.out.println("결과값은 "+sum);
		
		
	
		
	}

	private void method1() {
		/*
		 * 반복문
		 * for, while문
		 *     int i=0 ->초기화식
		 *     i <10   ->조건식(종료조건)
		 *     i++	   ->증감식(반복시 실행)
		 for (int i = 0; i < 10 ; i++) {
			
		}
		*/
		for (int i = 0; i < 10 ; i++) { //1.초기화식 2.조건식->출력 3.증감식
			System.out.println("for 문 안입니다.");
			System.out.println(i);        
			
		}System.out.println("for 문 밖입니다.");
		
	
		
		
	}

}
