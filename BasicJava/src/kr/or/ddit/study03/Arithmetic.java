package kr.or.ddit.study03;

public class Arithmetic {

	public static void main(String[] args) {
		//종류 : +,-,/,*,%
		//사칙연산과 마찬가지로 /, *먼저적용
		
		int a =5;
		int b=3;
		System.out.println(a+b);
		System.out.println(a-b);
		System.out.println(a*b);
		System.out.println((double)a/b); //나눗셈은 double 써주기 !
		
		System.out.println(a%b );//나머지

	}

}
