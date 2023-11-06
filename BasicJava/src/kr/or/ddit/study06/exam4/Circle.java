package kr.or.ddit.study06.exam4;

public class Circle {
	double PI = 3.141592;
	public static void main(String[] args) {
		Circle c = new Circle() ;
		double result =c.getArea(10); //getArea부터 실행->
		double result2 =c.getArea(5); //getArea부터 실행->
		
		
		
	}
	public double getArea(int r) { // 형식값(리턴타입) -메소드이름
		System.out.println("파라미터 int인 getArea");
		return PI*r*r;

	}
	/*
	 * 오버로딩 변수 타입, 개수를 다르게 하여 메소드를 호출할수 있도록 하는것
	 * 파라미터값을 변경했음
	 */
	public double getArea(double r) { // 형식값(리턴타입) -메소드이름
		return PI*r*r;
		
	}
	public double getCf(int r) { //
		return PI*r*2;
	}
	public double getCf(double r) { //
		return PI*r*2;
	}
}
