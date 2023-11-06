package kr.or.ddit.study02;

public class CharExample {
	public static void main(String[] args) {
		// char : 부호 없는 2byte 정수 0~65535
		
		// char은 작은 따옴표 사용
		char c1 = 'D';
		System.out.println("c1 = " + c1); //
		
		char c2 = 97;
		System.out.println("c2 = " + c2);//98이란 문자는 b였다 
										//97이란 문자는 a였다
		
		char a = 97;
		char b = 98;
		char c = 99;
		char d = 100;
		char e = 101;
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		System.out.println("e = " + e);
		System.out.println(a+", "+ b +", "+ c +", " + d +", " + e);
		
		char f = 64;
		System.out.println("f = " + f);
	}

}
