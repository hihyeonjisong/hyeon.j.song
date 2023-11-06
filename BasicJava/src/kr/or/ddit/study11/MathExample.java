package kr.or.ddit.study11;

public class MathExample {
	public static void main(String[] args) {
		//0~1사이 값
		double ran = Math.random()*40;//40까지의 값중에 랜덤뽑으려면 *40해야함
		System.out.println(ran);
		//절대값,double,int...등을 사용할수있게 오버로딩되어 지원됨
		int abs = Math.abs(-10);
		System.out.println(abs);
		
		int a =30;
		int b = 10;
		//max 둘중 높은값
		int max = Math.max(a, b);
		System.out.println(max);
		//둘중 낮은값
		int min = Math.min(a, b);
		//a의 b승 (2^4)
		double pow = Math.pow(2, 4.4);
		System.out.println(pow);
		//100은 10의 제곱
		double log10 = Math.log10(100);
		System.out.println(log10);//->2.0
		//루트
		double sqrt = Math.sqrt(100);
		System.out.println(sqrt);
		//반올림(2째자리에서 반올림)
		double var = 13.541213;
		double round = Math.round(var*10);
		System.out.println(round/10);
		
		double round2 = roundN(var*4);
		System.out.println(round2);
		

	}
	
	public static double roundN(double var,int n) {
		double pow = Math.pow(10, n-1);
		return Math.round(var*pow)/pow;
	}
}
