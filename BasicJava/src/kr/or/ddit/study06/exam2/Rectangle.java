package kr.or.ddit.study06.exam2;

public class Rectangle {
	/*
	 *  int x,y 선언
	 *  높이 가로넓이 선언 해볼것
	 *  생성자 구현해볼것
	 */
	int x;
	int y;
	int height;
	int width;
	int area;
	
	Rectangle (int x,int y,int height,int width){   //생성자 만드는방법!
		this.x =x; //생성자에 값을 넣기위해 this. 사용함
		this.y =y;
		this.height = height;
		this.width = width;
		this.area = height*width; //안에서 넓이 구하는 방법->생성자 안만들어줘도됌
	}

	@Override
	public String toString() {
		return "Rectangle [x좌표는=" + x + ", y좌표는=" + y + ", 높이=" + height + ", 너비=" + width + ", 넓이=" + area + "]";
	}
	
	
	
	
	
	
}
