package kr.or.ddit.study06.exam4; //나를 부른그곳으로

public class MethodTest {
	public static void main(String[] args) { 
		System.out.println("메인메소드");
		
		MethodTest mt = new MethodTest();
		double return3 =mt.method3();
		mt.method1();
		int return2 = mt.method2();
		
		System.out.println("method3 리턴값 :"+return3);
		System.out.println("method2 리턴값 :"+return2);
	}
	public void method1() { //VOID:아무것도하지않는다
		System.out.println("public void method1");
		System.out.println("리턴값 없어요");
	}
	public int method2() { //괄호 안 : 파라미터값
		System.out.println("public int method2");
		System.out.println("리턴값 int");
		return 10;
	}
	public double method3() {
		System.out.println("public int method3");
		System.out.println("리턴값 double");
		return method2()*3;
	}
}
