package kr.or.ddit.supplementary01;

public class Main {
	public static void main(String[] args) {
		MemberVo m1 = new MemberVo();//m1객체
		m1.id = "test1";// . : 클래스내부에 있는것을 사용한다는뜻
		m1.name="테스트계정1";
		m1.call();//call 메소드 호출
		System.out.println(m1.call);
		MemberVo m2 = new MemberVo();
		System.out.println(m2.call);
		testStatic();
		
		Main obj = new Main(); // ?
		obj.test();
		
	}
	public static void testStatic() {
		System.out.println("testStatic");
	}
	
	public void test() {
		System.out.println("test call");
	}
}
