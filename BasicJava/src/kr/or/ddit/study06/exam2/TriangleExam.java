package kr.or.ddit.study06.exam2;

public class TriangleExam {
	public static void main(String[] args) {
		Triangle t1 = new Triangle(2,3,4,5,1,6);  //->보기 불편해서
//		Triangle t2 = new Triangle(1,1,3,2,1,5);
		
		System.out.println(t1);
		/*
		 * t2 는 point 객체를 이용해서 만들어볼것
		 * 
		 */
		Point p1 = new Point(0,0);				//점 3개로 나눠서 표현
		Point p2 = new Point(100,0);
		Point p3 = new Point(50,0);
		
		Triangle t2 = new Triangle (p1,p2,p3);
		System.out.println(t2);
		
		
	}

}
