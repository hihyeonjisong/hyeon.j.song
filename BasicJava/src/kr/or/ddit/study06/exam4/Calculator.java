package kr.or.ddit.study06.exam4;

public class Calculator {
	public static void main(String[] args) {
		
		Calculator c = new Calculator();
		double plus = c.plus(5, 10);
		System.out.println(plus);
		double minus = c.minus(10,5);
		System.out.println(minus);
		double divide =c.divide(10, 5); // 타입변수 = 참조변수.메소드(매개값, )    : 리턴값을 받을경우
		System.out.println(divide);
		double multiply =c.multiply(10, 5);
		System.out.println(multiply);
		
//	public double callCal(double x ,double y, String op) {
//		if(op.equals("+")) {
//			return plus(x,y);
//		}
//		else if(op.equals("-")) {
//			return minus(x,y);
//		}
//		else if(op.equals("*")) {
//			return multiply(x,y);
//		}
//		else if(op.equals("/")) {
//			return divide(x,y);
//		}else {
//			System.out.println("해당연산자는 지원하지 않습니다.");
//			return b;
//		}
//	}
//		
	}
	

	//더하기 메소드 생성해보기
	public double plus (double x,double y) { //메소드는 꼭 return문을 가져야함!(void 제외)
		double p = x+y;
//		System.out.println("x+y값은 :"+(x+y));
//		return 0; //기본값,별의미없음
		return p;
		
	}
	//빼기 메소드 생성해보기
	public double minus (double x,double y) {
		double m = x-y;
		System.out.println("x-y값은  :"+m);
		return m;
	}
	
	//나누기 메소드 생성해봐
	public double divide (double x, double y) {
		double d = x/y;
//		System.out.println(d);
		return d;
	}
	
	//곱하기 메소드 생성해봐
	public double multiply( double x,double y) {
		double mp = x*y;
		System.out.println(mp);
		return mp;
	}
}
