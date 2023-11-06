package kr.or.ddit.study05;

import java.util.Scanner;

public class ReferenceType {
	Scanner sc = new Scanner(System.in);
	String a = "전역변수"; // method 1,2에서 a 사용 가능 
	public static void main(String[] args) {
		ReferenceType obj = new ReferenceType();
//		obj.method1(); 
//		obj.method2();
//		obj.method3();
		obj.method4();
	}
	private void method4() {
		// TODO Auto-generated method stub
		Customers c1 = new Customers();//class타입
		System.out.println("c1="+c1);//c1=kr.or.ddit.study5.Customers@4554617c
										//	패키지          .                .주소값
		Customers c2 = new Customers();
		System.out.println("c2="+c2);
		System.out.println(c1.name);//class c1의 name값
		System.out.println(c1.age);
	}
	private void method3() {
		// TODO Auto-generated method stub
		String str1= "홍길동";
		String str2= "홍길동";
		String str3= "강감찬";
		String str4 = new String("강감찬");
		String str5 = new String("강감찬");
				
		System.out.println(str1==str2); //true
		System.out.println(str2==str3); //false
		System.out.println(str3==str4); //false : 같은값으로 안보고 또 생성해서 주소값!이 다름
		System.out.println(str3.equals(str4)); // 값이 같은지 비교하고 싶을때( .equals씀)
		System.out.println(str4==str5); //
	}
	private void method1() {
		// TODO Auto-generated method stub
		String b="method1 변수";
		System.out.println(a);
		System.out.println(b);
	}
	private void method2() {
		// TODO Auto-generated method stub
		String b="method2 변수";
		System.out.println(a);
		System.out.println(b);
	
	}

}

class Customers{ //class를 저장공간으로 사용할수 있음
	String name;
	int age;
	Customers() { //생성자
		this.name="강감찬";
		age =10;
	}
	@Override
	public String toString() {
		return name+","+ super.toString(); //tostring은 주소값 출력
	}
}
