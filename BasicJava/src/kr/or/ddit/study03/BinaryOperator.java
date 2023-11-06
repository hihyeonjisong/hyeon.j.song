package kr.or.ddit.study03;

import java.util.Scanner;

public class BinaryOperator {

	public static void main(String[] args) {
		// 이항연산자: 대부분의 연산자.
		// 산술연산자, 관계연산자, 논리연산자, 비트연산자, 대입연산자.
		// 산술연산자 +-/*%
		// 관계연산자 > < == >= <= !=(같지않다)
		
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int score = sc.nextInt();
		
		System.out.println(score>=90); // 출력값 true,false 나옴
		
		if(score>=90) {
			System.out.println("A");
		}
		else if(score>=80) {
			System.out.println("B");
		}
		else if(score>=70) {
			System.out.println("C");
		}
		else if(score>=60) {
			System.out.println("D");
		}
		
		
		
		
		
		
		
		// 논리연산자 :&&, ||, !   (shift+window)
		// A && B  A,B 중 하나라도 거짓이면 거짓(참참)
		// A || B  A,B 중 하나라도 참이면 참
		//
		
		boolean a = true;
		boolean b = false;
		
		System.out.println(a&&b);
		System.out.println(a||b);
		

	}

}
