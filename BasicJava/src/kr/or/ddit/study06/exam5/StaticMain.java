package kr.or.ddit.study06.exam5;

public class StaticMain {
	public static void main(String[] args) {
		int a = StaticTest.a;//StaticTest class가져와서 사용
		StaticTest.method2();//조심해서사용하기(1.메모리차지,2.값변경될수있음)
		
		//안가져오면 이렇게 사용해야함
		StaticTest st = new StaticTest();//객체를 생성해야지만 사용할수있음
		int b=st.b;
		st.method1();
	}
}
