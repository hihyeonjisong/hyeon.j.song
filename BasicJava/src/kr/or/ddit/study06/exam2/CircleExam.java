package kr.or.ddit.study06.exam2;

public class CircleExam {
	public static void main(String[] args) {
		/*
		 * 원 c1,c2 선언하고
		 * c1 = x 10 y 10 r 10
		 * c2 = x 20 y 20 r 10
		 */
		Circle c1 = new Circle(10,10,10); //객체 만들기
		Circle c2 = new Circle(20,20,10);
		/*
		 * 원에 넓이 필드 추가 하고 구할것
		 * 3.14* 반지름 *반지름
		 */
		
		
		c1.area = 3.14 * c1.r * c1.r;
		c2.area = 3.14 * c2.r * c2.r;
		
		System.out.println(c1);
		
		/*
		 * 원의 둘레 출력해보기!!!!!!!!!!!!!!!!!
		 */

		
		
	}
}
