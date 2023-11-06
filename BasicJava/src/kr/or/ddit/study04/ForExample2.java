package kr.or.ddit.study04;

import java.util.Scanner;

public class ForExample2 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ForExample2 obj = new ForExample2();
//		obj.method1();//영어에 포함된 모음의 수를 구하시오(a e i o u)
//		obj.method2();// 구구단 출력
//		obj.method3();
		obj.method4();
		
	}

	private void method4() {
		// TODO Auto-generated method stub
		int sum=0;
		for (int i = 1; i <=10; i++) sum+=i; //조건이 한줄이면 중괄호 안써줘도 됌
		System.out.println(sum);
			
		
		
	}

	private void method3() {
		// 과제 continue 사용 방법
		//1~10  홀수만 출력 하시오
		for (int i = 0; i < 10; i++) {
			if(i%2==0) {
				continue;
			}
			System.out.println("홀수만 출력: "+i);
		}
		
	}

	private void method2() {
		// 구구단 출력
		for(int dan =2; dan<=9;dan++) {
			for(int i=1;i<9;i++) {
				System.out.printf("%d * %d = %d\n",dan,i,dan*i);//변수여러개일땐 printf가 편함
			}
				System.out.println();
		}
		
	}

	private void method1() { 
		//영어에 포함된 모음의 수를 구하시오
		// a e i o u
		String s = sc.nextLine();
		
		//.length 문자열 길이
		int length = s.length();
		int cnt = 0;
		for(int i=0; i<length; i++) {
			char c = s.charAt(i);
			if(c=='a'|| c=='e'|| c=='i' ||c=='o'||c=='u') {
				cnt++;
			}
			
		}
		System.out.println("입력한 문자에 포함된 총 모음의 수는 :"+cnt);
		
	}

}
