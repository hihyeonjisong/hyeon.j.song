package kr.or.ddit.study06.exam5;

public class StaticTest {
	static int a =10;
		   int b=10;
	public static void main(String[] args) {
		/*
		StaticTest s1 = new StaticTest();
		System.out.println(a);//Static int a
		System.out.println(s1.b);//int b
		
		a=20;
		s1.b =15;
		
		System.out.println("변경후 값");
		System.out.println(a);//Static int a
		System.out.println(s1.b);//int b
		
		StaticTest s2 = new StaticTest();
		System.out.println(a);//->a:20(static int a는 메모리는 1개 할당,모든클래스가 공유한다)
		System.out.println(s2.b);//->b:10
		
		StaticTest s3 = new StaticTest();
		System.out.println(a);//->b:10
		System.out.println(s2.b);
	*/
		StaticTest st = new StaticTest();
		st.b =20;
		st.method1();
		
		method2(); //static메소드는 객체 만들지 않아도됌(이미 메모리에 올라가있음)
		
		StaticTest st2 = new StaticTest();
		st2.method1();
		
	}
	public void method1() {
		System.out.println("public void method1() 호출");
		System.out.println("static int a\t"+a);
		System.out.println(" int b\t"+b+"\n");//b값을 못가져옴.(27줄에 객체가 만들어졌을때의 b값이라서)
		
	}
	public static void method2() {
		System.out.println("public void static method2() 호출");
		System.out.println("static int a\t"+a+"\n");//static int a 바로 부를수있음, b값못불러움
		
	}
}
