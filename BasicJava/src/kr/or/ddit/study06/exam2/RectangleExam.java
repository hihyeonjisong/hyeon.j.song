package kr.or.ddit.study06.exam2;

public class RectangleExam {
	public static void main(String[] args) {
		/*
		 * 사각형1,사각형2 선언 및 호출하기
		 */
		Rectangle r1 = new Rectangle(0,0,10,10); //객체 생성
		Rectangle r2 = new Rectangle(10,0,10,10);
		
		//넓이 구하기
		int r1width =r1.width;
		int r1height = r1.height;
		int r1Area = r1width*r1height;
		
		r1.area = r1Area;
		System.out.println(r1width);
		System.out.println(r1height);
		System.out.println(r1Area);
		System.out.println(r1);
		
		
		r2.area = r2.width*r2.height; //빨리 하는방법
		System.out.println(r2);
		
		
		
	}
}
