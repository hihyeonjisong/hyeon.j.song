package kr.or.ddit.study03;// 이해안됨

import java.util.Scanner;

public class LogicalOperator {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		LogicalOperator obj = new LogicalOperator();
		obj.test(); 		// 이것을 주석처리하면 밑의 test전체가 주석처리됨
		obj.test2();
	}

	private void test(){
	
		//어려워서 넘어감
		// 논리연산자 
		//		&(and)(참참참)  |( or)(둘중하나참이면 참)	 
		// 45 : 00101101		00101101		
		// 25 : 00011001		00011001
		//      00001001=>9		00111101=>61
		//		^(xor)(서로다를때 참)	~(not)
		//		00101101		00101101
		//		00011001		00011001
		//		00110100=>52	11010010=>-(10101101)+1=>-46
		int a =45;
		int b =25;
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b);
		System.out.println(~a);
		
	}
 
	private void test2(){
		// shift operator
		// >> << >>>
		// 숫자 >> 정수 => 숫자를 정수만큼 오른쪽으로 평행이동
		//=> 숫자를 2^(정수로)나눔 몫이됨.
		
		System.out.println(12>>2);
		System.out.println();
	}
		
		

}
