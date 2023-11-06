package kr.or.ddit.study03; //이해안감


import java.util.Scanner; //ctrl+shift+o

public class TestTemp2 {

	Scanner sc = new Scanner(System.in);
	private Object test;

	public static void main(String[] args) {
		TestTemp2 obj = new TestTemp2();
		obj.test(); //빨간줄누르고 f2하면 밑에 생성됨 , 이 줄만 주석처리하면 밑에 출력도 전부 주석처리됨
		obj.test2();
		
	}

	private void test2() {
		System.out.println("test2 메소드입니다.");
		System.out.println("test2 메소드입니다.");
		System.out.println("test2 메소드입니다.");
		System.out.println("test2 메소드입니다.");
		System.out.println("test2 메소드입니다.");
	
	}

	private void test() {
		System.out.println("test 메소드입니다.");
		System.out.println("test 메소드입니다.");
		System.out.println("test 메소드입니다.");
		System.out.println("test 메소드입니다.");
		System.out.println("test 메소드입니다.");
		
	}
	
	

		}


	