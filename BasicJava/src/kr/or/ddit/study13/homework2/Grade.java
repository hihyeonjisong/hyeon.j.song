package kr.or.ddit.study13.homework2;

import java.util.Scanner;

public class Grade {
	// 문제 3 – 세 과목의 성적을 입력 받고 총점합을 출력할 수 있는 Grade class를 설계하시오.
	int kor;
	int math;
	int eng;
	int sum;
	


	public Grade(int kor,int math,int eng) { //생성자는 void 쓰면 안됌
		this.kor=kor;
		this.math=math;
		this.eng=eng;
		this.sum=kor+math+eng;
	}
	


	@Override
	public String toString() {
		return " [국어=" + kor + ", 수학=" + math + ", 영어=" + eng + ", 총합=" + sum + "]";
	}


	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수를 입력하세요.");
		int kor = sc.nextInt();
		System.out.println("수학점수를 입력하세요.");
		int math = sc.nextInt();
		System.out.println("영어를 입력하세요");
		int eng = sc.nextInt();
		Grade g = new Grade(kor,math,eng);
		System.out.println("총 점수 합은 "+ g);

	}

}
