package kr.or.ddit.study05; //row 두번클릭-벌레클릭(디버그)

import java.util.Arrays; //array 가져올땐 import 해야함
import java.util.Scanner;

public class ArrayExample {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample obj = new ArrayExample();//배열 새롭게 선택
//		obj.method1();
//		obj.method2();
//		obj.method3();
//		obj.method4();
//		obj.method5();//깊은복사,얕은복사
		obj.method6();//버블정렬
//		obj.method7();//a,b값 바꾸는방법
//		obj.method8();//선택정렬
		
	}

	private void method8() {
		/*선택정렬
		 * 원본자료가 n개일때 n-1차로 운행한다
		 * 왼쪽 자료부터 기준값으로 선정하여 나머지 모든 자료와 비교한다.
		 */
		int[]num = {67,55,9,86,98}; //큰값보다 작은값을 바꾸려고
		for (int i = 0; i < num.length; i++) {
			//i = 0(67,55,9,86,98)
			//     (55 67 9 86 98)  67랑 55비교
			//     (9  67 55 86 98) 55랑 9 비교
			//     (9  67 55 86 98) 
			//     (9  67 55 86 98) 
			
			//i=1  (9  67 55 86 98)
			//     (9  55 67 86 98)
			//	   (9  67 55 86 98) <-------여기부터 다시 입력하기!!!!
			// 	   (9  67 55 86 98)
			//	
			
			for (int j = 0; j < num.length; j++) {//첫번째 값은 고정됐으니 두번째세번재비교하기
				if(num[i]<num[j]) {  //
					int temp = num [i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(num));
	}

	private void method7() {
		//a b값 바꾸는 방법
		int a =7;
		int b =3;
		System.out.printf("a 값은%d b 값은 %d\n",a,b);
		int temp = a;
		a= b;
		b= temp;
		System.out.printf("a 값은%d b 값은 %d",a,b);
	}

	private void method6() {
		// 버블 정렬(bubble sort)
		//원본자료가 n개일대 n-1차 운행한다.
		//각 회차에서 인접한 두값을 비교하여 오름차순인 경우 작은값을 //큰값부터 나오게 하려면 부등호 바꾸면 됌
		//앞에 위치시킴
		int[]num = {67,55,9,86,98};
		System.out.println(Arrays.toString(num)); //
		for (int i = 0; i < num.length-1; i++) {
		//i=0//67 55 9 86 98
			//55 67 9 86 98
			//55 9 67 86 98
			//55 9 67 86 98
			//55 9 67 86 98
		//i=1//55 9 67 86 98
			//9 55  67 86 98
			//9 55  67 86 98
			//9 55  67 86 98
			//9 55  67 86 98
			
			for (int j = 0; j < num.length-1; j++) {//뒷값인 b가 클경우 a b 바꾸는 방법
				if(num[j]>num[j+1]) {
					int temp =num[j];//a b 값 바꿀때
					num[j] = num[j+1];//a값에 b값을 넣음
					num[j+1] = temp;//
				}
			}
		}
		System.out.println(Arrays.toString(num));
	}

	private void method5() {//깊은복사 얕은복사 면접 단골 문제!!!
		/*
		 * 배열복사: 얕은 복사(shallow copy), 깊은 복사(deep copy)
		 * 얕은 복사(shallow copy) : 복사된 배열이나 원본 배열이 변경될대 서로 간의 값이 같이 변경
		 */
		int[] source = {1,2,3,4,5};
//		int[] target = source;//얕은 복사 하는 방법 :source배열변수를 target변수에 넣는다(새로운 배열 생성하는것 아님)(메모리주소값을 똑같이 가짐!)
//		
//		for (int i = 0; i < source.length; i++) {
//			System.out.print(source[i]+"\t");
//		}
//		System.out.println();
//		for (int i = 0; i < source.length; i++) {
//			System.out.print(source[i]+"\t");
//		}
//		System.out.println();
//		
//		target[2] = 30;			//얕은복사하면 target배열변수의 값이 바뀌면 source배열변수가 바뀜(source값을 바꿔도 target 값이 바뀜)
//		
//		for (int i = 0; i < source.length; i++) {
//			System.out.print(source[i]+"\t");
//		}
//		System.out.println();
//		for (int i = 0; i < source.length; i++) {
//			System.out.print(source[i]+"\t");
//		}
//		System.out.println();
		/*
		 * 깊은 복사 : 배열공간을 별도로 확보
		 * 1.반복문 이용
		 * 2.System.arraycopy()
		 * 3.clone()
		 */
		int[] des1 = new int [source.length]; //깊은복사:new새로운 객체를 만듦!( 배열 새로 만듦)(새로운 메모리에 주소 할당받음)
		for (int i = 0; i < des1.length; i++) {
			des1[i]=source[i];
		}
		
		des1[2] =30;						//깊은복사하면 
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i]+"\t");
		}
		System.out.println();
		for (int i = 0; i < des1.length; i++) {
			System.out.print(des1[i]+"\t");
		}
		System.out.println();
		
		
		
		int[]des2 = new int [source.length]; //
		System.arraycopy(source,0, des2,0,3);//(원본배열,시작위치,복사할배열,시작위치,복사할개수)
		des2[2]=31;
		System.out.print("system.arraycopy 사용");
		for (int i = 0; i < source.length; i++) {
			System.out.print(source[i] + "\t");
		}
		System.out.println();
		for (int i = 0; i < des2.length; i++) {
			System.out.print(des2[i] + "\t");
	}
		System.out.println();
		
		
		System.out.println("clone 사용");//고급복사 3번째방법(젤 많이씀)
		
		int[] des3 = source.clone();
		des3[2]=32;
		for (int i = 0; i < source.length; i++) {
			System.out.println(source[i] + "\t");
		}
		System.out.println();
		for (int i = 0; i < des3.length; i++) {
			System.out.println(des3[i] + "\t");
	}
		System.out.println();
}

	private void method4() {
		// 키보드로 거스름돈을 입력 받아 화폐단위별로 개수를 구하시오
		int coin[] = {10000,5000,1000,500,100,50,10}; //배열의 장점:자유롭게 추가 할수 있음
		System.out.println("거스름돈의 액수를 입력");
		int money = sc.nextInt();
		for (int i = 0; i < coin.length; i++) {
			int c =coin[i];
			System.out.printf("%d원 : %d 개\n", coin[i],(money/coin[i]));
			money%=coin[i];//money의 나머지값이 계속 남게됨->또 실행할땐 money가 입력받은 값이 아니라 나머지값으로 봐야함
		}
		
		
	}

	private void method3() {
		// TODO Auto-generated method stub
		int[] score = {75,65,55,95,75,75,75,75,75};
//		score[0] = 75; //같음
//		score[1] = 65;
//		score[2] = 55;
//		score[3] = 95;
//		score[4] = 75;
//		score[5] = 75;
//		score[6]= 75;
//		score[7]= 75;
//		score[8] = 75;
//		score[9]= 75;
		int  min = score[0];
		int max =score[0];
		int sum =0;
		double avg =0;
		
		for (int i = 0; i < score.length; i++) {
			if(score[i]<min) { //score[i]값이 min보다 작으면 min에 넣어->또 score[i+1]값을 넣어서 min보다 작으면 min에 넣어->반복하다보면 최솟값이 min에 저장됨
				min = score[i];
			}
			if(score[i]>max) {//score[i]값이 max보다 작으면 max에 넣어->또 score[i+1]값을 넣어서 max보다 작으면 max에 넣어->반복하다보면 최솟값이 max에 저장됨
				max =score[i];
			}
			sum+=score[i];//배열 합
					
		}	
		avg=(double)sum/score.length;//배열 평균=배열총합/배열총개수
		System.out.println(min+","+max);
		System.out.println(sum+","+avg);
		
			
		}
		
		
	private void method2() {
		// TODO Auto-generated method stub
		//정수 5개를 저장하고 역순으로 출력
		int[]num;         //변수 선언
		num = new int[5];//나눠서 표현할수 있음!
		for (int i = 0; i <num.length; i++) {
			System.out.printf("i번째 정수 입력 : ");
			num[i] = sc.nextInt();
		}
		for (int i = num.length-1; i >=0; i--) { //역순이니까 전체배열수-1부터 넣은것 출력,그다음 전체배열수-2한것 넣은것 출력
			System.out.println(num[i]);
		}
	}

	private void method1() {//[]배열선언 
							//new<-메모리 할당
							//int[]<-생성될 개수
		// int 변수 5개 선언하기
//		int a1;
//		int a2;
//		int a3;
//		int a4;
//		int a5;
		int[] a1 = new int[5]; //변수 5개를 선언함 // int[] a1와 같음 (변수명 앞에다 쓰는것 추천)
		for(int i =0;i<a1.length;i++) {
			System.out.println(a1[i]); //a1의 i번째 방을 선언함
		}

	}

}
