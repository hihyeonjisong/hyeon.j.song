package kr.or.ddit.study05;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample3 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample3 obj = new ArrayExample3();
//		obj.method1();//2차원배열 개념
//		obj.method2();// 다시
//		obj.method3();//

		obj.method4();//
		
	}

	private void method4() {
		// 5명의 3과목(국 영 수 총점 평균) 성적과 이름을 배열에 저장하고 (배열은  for문 사용해야함)
		//총점과 평균 등수를 구하여 출력해라
		String[] stuName = {"홍길동","강감찬","이성계","이순신","정몽주"};
		int[][]score = {{80,70,70,0,0,1},
						{90,85,90,0,0,1},
						{90,70,75,0,0,1},
						{65,75,70,0,0,1},
						{80,80,70,0,0,1}};
		
		for (int i = 0; i < score.length; i++) { //총점계산      //변수 이름 p로 하면 쉬움
//			 int kor = score[i][0]; //[가로i줄][세로:0번째]
//			 int eng = score[i][1]; //[가로i줄][세로:1번째]
//			 int math = score[i][2];//[가로i줄][세로:2번째]
//			 int sum = kor+eng+math;
			 int sum =0;
//			 score[i][3] = score[i][0]+score[i][1]+score[i][2];//[가로i줄에서][0,1,2번째를 추출]
			 for (int j = 0; j < 3; j++) {
			 sum += score[i][j];
			 score[i][3] += score[i][j];
			 score[i][4] += ((int)(double)sum/3);
			 } 
			 
		}
			for (int i = 0; i < score.length; i++) {
				int rank =1;
				for (int j = 0; j < score.length; j++) {
					//총점비교후 값이 더 작으면 등수를 증가 시킨다
					if(score[j][3]<score[i][3]) { //i의총점이 j의총점보다 작으면 i의 등수를 1씩 증가시킴
						rank++; //내가 꼴지면 +4
					}
				}
				score[i][5] = rank;
				System.out.println(Arrays.toString(score[i]));
			}
		System.out.println();
			
		//버블정렬	
		for (int i = 0; i < score.length-1; i++) {
			for (int j = 0; j < score.length-1; j++) {
				if( score[j][4]>score[j+1][4]) {
					int[] temp = score[j];
					score[j] = score[j+1];
					score[j+1]= temp;
		            //이름 바꿈			
					String tempName = stuName[j];
					stuName[j]= stuName[j+1];
					stuName[j + 1]= tempName;
				}
				
			}
		}
		//출력부분과 연산부분을 분리하는게 좋다
		
		
		for (int i = 0; i < score.length; i++) {
			System.out.print(""+stuName[i]+"\t");//학생이름출력
			for (int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j]+"\t");//점수출력
			}
			System.out.println();
		}  
		
			
	}		
	
	
	
//			//////////////////////값을 바꾸는거 (a b 바꾸는거)
//			int[] temp = score[0].clone();
//			score[0] =score[1];
//			score[1] =temp;
//			
//			String temp_s = stuName[0];//이름을 바꾸는거
//			stuName[0] = stuName[1];
//			stuName[1] =temp_s;
//			System.out.println("-------------------");
//			for (int i = 0; i < temp.length; i++) {
//				System.out.print(""+stuName[i]+"\t");
//				for (int j = 0; j < score[i].length; j++) {
//					System.out.print(score[i][j]+"\t");
//					
//				}
//				System.out.println();
//			}
//		}
	
		
	

	private void method3() {//배열 길이가 다르면 이렇게 씀 (알고만 있기.잘안씀)
		// 1차원 배열 건너뛰기
		int[][] arr = new int [3][];//2차원배열이지만 1차원 배열을 담겠다는뜻
		
		arr[1] = new int[3];//나중에 선언할수 있음
		arr[0] = new int[3];
		arr[2] = new int[5];
		for (int i = 0; i < arr.length; i++) {
			System.out.println("i"+i);
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j]); //2번째 객체를 설정 안해서 null오류가 뜸
			}
			System.out.println(); 
		}
		
	}

	private void method2() {
		// 국어 영어 수학
		String[]stuName = {"홍길동","강감찬","이순신"};
		int[][] score = {{80,75,87},
						{80,90,91},
						{77,73,65},
						};
		int h_math = score[0][2];
		
		int []lee = score[2];
		int l_kor = score[2][0]; 
		
		//3명의 국어 점수만 출력 ->복잡함 (for문 이용)
		int h_kor = score [0][0];
		int k_kor = score [0][1];
		int le_kor = score [0][2];
		
		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[0].length; j++) {
				if(j==0) {
				System.out.println("국어점수 "+score[i][j]);
				}
			}
		}
		
		System.out.println("홍길동수학:"+h_math);//1차원 배열의 1번째(=배열로는2번째) ->홍길동수학점수
		System.out.println(lee); //1차원 배열 객체라서-> 주소값을 불러옴 그래서
		System.out.println(Arrays.toString(lee));//1차원 배열을 꺼내려면 Arrays.toString을 써야함 or for문이용
		System.out.println(l_kor); //->이순신 국어점수
		
	}

	private void method1() {
		int[][] arr = new int[2][5]; //1차원배열 1개를 5번을 생성해서 2차원배열만듦(앞의 숫자는 1차원 배열이 몇개 있는지, 뒤의 숫잔는 1차원배열안에 몇개가있는지)
		for (int i = 0; i < arr.length; i++) {//2차원배열에서 한번꺼내면 1차원배열
			int []a1 =arr[i];//new int[2]일차원 배열 불러온것(length는2)
			for (int j = 0; j < a1.length; j++) {//1차원배열에서 한번꺼내면 int
				a1[j] =i;// new int[5]일차원 배열 불러온것(length는 5)
			}
		}
		for (int i = 0; i < arr.length; i++) {//2차원배열에서 한번꺼내면 1차원배열
			int []a1 =arr[i];
			for (int j = 0; j < a1.length; j++) {//1차원배열에서 한번꺼내면 int
				System.out.print(a1[j]+"\t");
			}
			
		}System.out.println();
		
	}
}
