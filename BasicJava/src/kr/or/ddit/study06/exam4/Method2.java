package kr.or.ddit.study06.exam4;

public class Method2 {
	public static void main(String[] args) {
//		Circle c = new Circle();
//		int r =10;
//		double area = c.getArea(r);
//		double cf = c.getCf(10);
//		System.out.println("반지름 "+r+"짜리 원의 넓이는 "+area);
//		System.out.println("반지름 "+r+"짜리 원의 넓이는 "+cf);
//		
//		System.out.println();
//		double r2 =10.5;
//		double area2 = c.getArea(r2);
//		double cf2 = c.getCf(10);
//		System.out.println("반지름 "+r+"짜리 원의 넓이는 "+area);
//		System.out.println("반지름 "+r+"짜리 원의 넓이는 "+cf2);
		
		Method2 m2 = new Method2();//재귀함수(구현 쉬움)(에러나기쉬우니조심)
		m2.recrucive(10);
	}
	public void recrucive(int i) {
		if(i==0) {
			System.out.println("종료되었습니다.");
			return;
		}
		System.out.println(i);
		recrucive(--i);
	}
	
	
}
