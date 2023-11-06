package kr.or.ddit.study02; //다시 확인하기

import java.util.Scanner;

public class TypeChange3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //Scanner은 class라서 대문자
		
		System.out.println("문자열을 입력해주세요");
//		"10"문자임
		
		
		String str = sc.nextLine(); //키보드에 입력된값을 str로 인식한다.
		System.out.println("입력받은 문자열은 "+ str);
		
		//안내문구 써주는게 좋음
		System.out.println("숫자만 입력해주세요");
//		String str = "10";
		//int->Integer
		
		int num = Integer.parseInt(str)+3; //문자를 숫자로 바꿈
		System.out.println("변경된 숫자 입니다."+num);
		
		//long ->Long 문자를 다시 숫자로 바꿈 
		long l1 = Long.parseLong(str); //str을 long으로 쓸수있게하는 주문!
		
		double b1 = Double.parseDouble(str);//
		
		
		
	}

}
