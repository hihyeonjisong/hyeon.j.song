package kr.or.ddit.study06.exam4;

import java.util.Scanner;

public class PersonTest {
	public static void main(String[] args) {
		PersonVo p1 = new PersonVo("이름1",20,"한국");
		PersonVo p2 = new PersonVo("이름2",20,"한국");
		PersonVo p3 = new PersonVo("이름3",20,"한국");
		PersonVo p4 = new PersonVo("이름4",20,"한국");
		PersonVo p5 = new PersonVo("이름5",20,"한국");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("나이를 입력하세요");//나이 음수 입력하지않게 계속체크해줘야함(귀찮음)
		int age1 = sc.nextInt();
//		if(age1<0) {
//			System.out.println("음수는 입력할수 없습니다");
//		}else {
//			p1.age =age1;
//		}
		p1.setAge(age1); //위의 구문이 한줄로 입력됨
		
		System.out.println("나이를 입력하세요");
		int age2= sc.nextInt();
		p2.setAge(age2);
//		p2.age = age2;
		
		System.out.println("나이를 입력하세요");
		int age3 = sc.nextInt();
		p3.setAge(age3);
//		p3.age = age3;
		
		System.out.println("나이를 입력하세요");
		int age4 = sc.nextInt();
		p4.age = age4;
		
		System.out.println("나이를 입력하세요");
		int age5 = sc.nextInt();
		p5.age = age5;
		
	}
}
