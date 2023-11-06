package kr.or.ddit.study02;

import java.util.Scanner;

public class TypeChange2 {

	public static void main(String[] args) {
	//Scanner 연습
//		Scanner sc = new Scanner(System.in); 
//		System.out.println("국어 점수를 입력해 주세요"); //scanner 앞의 안내문구 써주세요
//		int kor = sc.nextInt();  //입력을 받을때까지 컴퓨터가 기다림 (console창에 쳐야해)
//		System.out.println("국어 점수는 : "+kor);
//		
//		System.out.println("영어 점수를 입력해 주세요");
//		int eng = sc.nextInt();
//		System.out.println("영어 점수는 : "+eng);
//		
//		System.out.println("수학 점수를 입력해 주세요.");
//		int math = sc.nextInt();
//		System.out.println("수학 점수는 : "+math);
//		
//		//총점,평균
//		int sum = kor + eng + math ;
//		System.out.println("총 점수의 합은 : "+sum +"입니다.");
//		
//		double mean = ((double)sum)/3; //평균값은 실수 ,강제변환 !
//		System.out.println("평균값은 "+mean+"입니다.");
//	}

		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수를 입력해 주세요.");
		int kor = sc.nextInt();
		System.out.println("국어 점수는: "+kor);
		
		System.out.println("영어점수를 입력해 주세요.");
		int eng = sc.nextInt();
		System.out.println("영어 점수는:"+eng);
		
		int sum = kor + eng;
		System.out.println("총 점수의 합은:"+sum +"입니다.");
		
		double mean = sum/2;
		System.out.println("평균값은"+mean+"입니다.");
	}
		
}
