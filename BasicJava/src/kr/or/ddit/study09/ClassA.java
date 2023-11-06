package kr.or.ddit.study09;

public class ClassA {
	public static void main(String[] args) {
		
	}
	class B{                              //중첩클래스: class안에서 또 class만듬
		public void methodB() {
			System.out.println("class B methodB");
		}
	}
}
