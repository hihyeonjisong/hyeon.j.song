package kr.or.ddit.study07.pen;

public class BallPen extends pen {
	private String color; // 볼펜의 색

	public String getColor() {
		return color;
	}

	public void setColor(String color) {//setColor 메소드가 void를 반환하는 이유는 
		this.color = color; //이 메소드가 어떠한 값을 반환하지 않고, 단순히 객체의 상태를 변경하는 용도로 사용되기 때문입니다.
	}
}
