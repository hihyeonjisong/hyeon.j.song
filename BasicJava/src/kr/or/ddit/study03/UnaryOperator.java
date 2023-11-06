package kr.or.ddit.study03;

public class UnaryOperator {

	public static void main(String[] args) {
		//부호 연산자
		int num = 100;
		int res1 = -num;
		
		System.out.println("num\t"+num);   
		System.out.println("res1\t"+res1);
		
		//증감연산자
		//++변수 :다른 연산을 수행하기 전에 1을 증가시킴
		//변수++ :모든 작업을 끝난 후에 1을 증가시킴
		//--변수 다른연산을 수행하기 전에 1을 감소 시킴
		//변수-- 다른연산을 수행하기 후에 1을 감소시킴
		
		int value = 10;
		int res   = ++value;
		System.out.println("value\t"+value);
		System.out.println("res\t"+res);
		
		
		System.out.println("-----------");	//
		value = 10;      // res = value 값을 먼저 넣어준뒤
		res   = value++; // value = value+1 
		System.out.println("value\t"+value);
		System.out.println("res\t"+res);
		
		System.out.println("-----------");
		value =10;
		res  =--value;
		System.out.println("value\t"+value);
		System.out.println("res\t"+res);
		
		System.out.println("-----------");
		value =10;
		res  =value--;	//res에 value를 먼저 넣어준뒤 value-1
		System.out.println("value\t"+value);
		System.out.println("res\t"+res);
		
		boolean b = true;
		
		System.out.println("b="+b);	//b=true
		System.out.println("b="+!b);//!:not	b=false
		
		
		
		
		
		
		
		
		
	}

}
