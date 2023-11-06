package kr.or.ddit.study06.exam2;

public class Circle {
	/*
	 * x,y,(double)반지름
	 */
	int x;
	int y;
	double r;
	double area;
	double cf;//원의둘레
	
	Circle (int x, int y, double r){ //생성자 만들기
		this.x = x;
		this.y = y;
		this.r = r;
		this.area = 3.14*r*r; //계산 매번하지 않아도됌(재사용 하면됌)
		this.cf = 3.14*2*r;
	
	}

	@Override
	public String toString() {
		return "Circle [x=" + x + ", y=" + y + ", 반지름=" + r + ", 넓이=" + area + ", 둘레=" + cf + "]";
	}

	
}
