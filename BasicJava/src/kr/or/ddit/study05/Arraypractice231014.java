package kr.or.ddit.study05;

import java.util.Arrays;
import java.util.Scanner;

public class Arraypractice231014 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Arraypractice231014 obj = new Arraypractice231014();
//		obj.method1();
//		obj.method2();
//		obj.method3();//질문
//		obj.method4();//우하향,우상향 합 구하기
//		obj.method5();//선택정렬
//		obj.method6();//버블정렬
//		obj.method7();// 로또
		obj.method8();// ArrayExample3과제 등수 정렬 정답

	}

	private void method8() {
		// 5명의 3과목(국어 영어 수학) 성적과 이름을 배열에 저장하고
		// 총점과 평균과 등수를 구하여 출력하시오.

		String[] stuName = { "홍길동", "강감찬", "이성계", "이순신", "정몽주" };

		int[][] score = { { 80, 70, 80, 0, 0, 1 }, { 90, 85, 90, 0, 0, 1 }, { 90, 70, 75, 0, 0, 1 },
				{ 65, 75, 70, 0, 0, 1 }, { 80, 80, 71, 0, 0, 1 } };

		for (int i = 0; i < score.length; i++) { //총점,합계
			int sum = 0;
			for (int j = 0; j < 3; j++) {
				sum += score[i][j];
				score[i][3] += score[i][j];//i행j열에있는 반복된 점수들을 i행3열에 저장한다
				score[i][4] = (int) (sum / 3.0);//3.0으로 double 나누기계산하고 int형변환함
			}
		}

		for (int i = 0; i < score.length; i++) { //등수 늘어나는것 정함
			int rank = 1;
			for (int j = 0; j < score.length; j++) {
				if (score[j][4] > score[i][4]) {
					rank++; //i의 위치에대한 등수를 증가시킴
				}
			}
			score[i][5] = rank;
			System.out.println(Arrays.toString(score[i]));
		}

		System.out.println();

		for (int i = 0; i < score.length - 1; i++) { //버블정렬
			for (int j = 0; j < score.length - 1; j++) {
				if (score[j][4] < score[j + 1][4]) {
					int[] temp = score[j];
					score[j] = score[j + 1];
					score[j + 1] = temp;

					String tempName = stuName[j];
					stuName[j] = stuName[j + 1];
					stuName[j + 1] = tempName;
				}
			}
		}

		for (int i = 0; i < score.length; i++) {
			System.out.print("" + stuName[i] + "\t");
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
	}

	

	private void method7() {
		// 로또 (45개 번호배열 만들고 섞어서 앞에 6개 출력
		// 1.1~45가 담긴 45개의 배열방을 만들기(0엔 1을넣고 1엔2를넣고 ...):로또는1부터시작하니까
		int[] lotto = new int[45];
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = i + 1;
		}
		// 랜덤으로 마구 섞기
		for (int i = 0; i < 100000; i++) {
			int ran = (int) (Math.random() * lotto.length);
			int temp = lotto[0];
			lotto[0] = lotto[ran];
			lotto[ran] = temp;
		}
		// 0~5를 출력
		for (int i = 0; i < 6; i++) {
			System.out.print(lotto[i] + "\t");

		}
		System.out.println();

	}

	private void method6() {
		// 버블정렬 67>55면 앞뒤 바꿈 (98은 뒤의것과 바꿀수 없어서 num.length-1하는것임)
		int[] num = { 67, 55, 9, 86, 98 };
		for (int i = 0; i < num.length - 1; i++) {
			for (int j = 0; j < num.length - 1; j++) {
				if (num[j] > num[j + 1]) {
					int temp = num[j];
					num[j] = num[j + 1];//결국 j에 제일 작은 값이 오면 값바꾸기가 끝나고 끝남
					num[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num));

	}

	private void method5() {
		// 선택정렬 ,i번째값보다 
		int[] num = { 67, 55, 9, 86, 98 };
		for (int i = 0; i < num.length; i++) {
			for (int j = 0; j < num.length; j++) {
				if (num[i] < num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp; //결국 i에 제일큰값이 오면 값바꾸기가 끝나고 끝나고를 반복함
				}
			}
		}
		System.out.println(Arrays.toString(num));
	}

	private void method4() {
		// 우하향 합 구하기(직접써서 규칙성 찾고->구현방법 생각하기)
		int sum = 0;
		int[][] arr = { { 2, 3, 8 }, { 8, 9, 1 }, { 7, 0, 5 } };
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j)
					sum += arr[i][j];
			}
		}
		System.out.println("우하향대각선의 합은 :" + sum);
		sum = 0;

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i + j == 2)
					sum += arr[i][j];
			}
		}
		System.out.println("우상향대각선의 합은 :" + sum);

	}

	private void method3() {
		// 행의 합 구하기,열의합 구하기
		int sum = 0;
		int[][] arr = { { 2, 3, 8 }, { 8, 9, 1 }, { 7, 0, 5 } };
		for (int i = 0; i < arr.length; i++) {// 행의 합 구하기
			for (int j = 0; j < arr.length; j++) {
				sum += arr[i][j];
			}
			System.out.println(i + 1 + "행의 합은" + sum);
			sum = 0; // 초기화 함-> 열의합 구하는for문 쓰려고 초기화해준거??
		}
		for (int i = 0; i < arr.length; i++) {// 열의합 구하기
			for (int j = 0; j < arr.length; j++) {
				sum += arr[j][i];
			}
			System.out.println(i + 1 + "열의 합은" + sum); // 열의 합인데 j+1+"열의합은"아닌가???
			sum = 0;
		}
	}

	private void method2() {
		int arrayInt[] = new int[10];
		for (int i = 0; i < arrayInt.length; i++) {
			System.out.print(i);
		}
		
		System.out.println();
		int arrayInt2[] = { 1, 3, 5, 7, 9 };
		for (int i = 0; i < arrayInt2.length; i++) {
			System.out.print(i); // i번째를 출력하니까 0,1,..4(번째)가 나옴!
		}
		System.out.println();
		int arrayInt3[] = { 1, 3, 5, 7, 9 };
		for (int i = 0; i < arrayInt3.length; i++) {
			System.out.print(arrayInt3[i]); //배열의[i번째]값을 출력하니까 1,3,5,7,9나옴
		}
		System.out.println();
		String arrayStr[] = { "a", "b", "c" };
		for (int i = 0; i < arrayStr.length; i++) {
			System.out.print(arrayStr[i]);
		}

	}

	private void method1() {// 배열 오류!:존재하지 않는 값을 정의하려해서
		String[] members = { "최진혁", "최유빈", "한이람" };
		System.out.println(members[3]);

	}
}
