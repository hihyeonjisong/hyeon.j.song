package kr.or.ddit.study06.exam2;

import java.awt.Point;

public class Triangle {
	/*
	 * x1, y1, x2, y2, x3, y3 //x,y축 그래프 점 3개
	 */
	int x1;
	int y1;
	int x2;
	int y2;
	int x3;
	int y3;
	double area;
//	point p1;
//	point p2;
//	point p3;
	
	public Triangle(int x1, int y1, int x2, int y2, int x3, int y3) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		this.x3 = x3;
		this.y3 = y3;
//		this.area = Math.abs(((x1*y2+x2*y3*x3*y1)-(x2*y1+x3*y2+x1*y3))/2.0);
		int r1 =x1*y2+x2*y3*x3*y1;
		int r2 =x2*y1+x3*y2+x1*y3;
		this.area = Math.abs((r1-r2)/2.0); //절댓값
		
	}
	public Triangle(Point p1, Point p2, Point p3){ //p1의 x,y값 꺼내서 x1,y1
		this(p1.x, p1.y, p2.x, p2.y, p3.x, p3.y);
//		this.x1 = p1.x;
//		this.y1 = p1.y;
//		this.x2 = p2.x;
//		this.y2 = p2.y;
//		this.x3 = p3.x;
//		this.y3 = p3.y;
		
	}
	

	
	public String toString() {
		return "점 1의 좌표(" + x1+ ","+ y1+")"
				+"점 2의 좌표(" + x2+ ","+ y2+")"
				+"점 3의 좌표(" + x3+ ","+ y3+")"
				+"넓이= "+area;
				
		
	}
}
