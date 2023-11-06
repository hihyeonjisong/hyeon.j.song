package kr.or.ddit.study03;

import java.util.Scanner;

public class TrinomialOperator {

	public static void main(String[] args) {
		//삼항연산자: 3개의 피연산자를 필요로 하는 연산
		//			삼항연산자는 ? 앞의 조건식의 결과에 따라 콜론 앞뒤의 
		//			피연산자가 선택 조건 연산식이라고도 함.
		/*
		 * 조건식 ? 값 또는 연산식 : 값 또는 연산식
		 * 		|        |             |
		 *      |--true--|             |
		 *      |                      | 
		 *      |_________________false|
		 * 
		 */
		
//		int age =20;
//		String message= (age>=18) ? "성년" : "미성년";//int값이 18보다 크면 성년 작으면 미성년
//		System.out.println(message);
//		
		Scanner sc = new Scanner(System.in);
		System.out.print("나이를 입력해주시오.");
		int age = sc.nextInt(); // 변수 입력시 두번째 글자는 대문자로
		String message = (age >=18) ? "성년" : "미성년";
		System.out.println(message);
		
		
		
	}

}
