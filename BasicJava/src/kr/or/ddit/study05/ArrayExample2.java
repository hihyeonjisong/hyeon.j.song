package kr.or.ddit.study05;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayExample2 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayExample2 obj = new ArrayExample2();
		obj.method1();
//		obj.method2();
	}

	private void method2() {
		/*
		 * 각 타입별 초기화 값 (0을 표기하는게 타입별로 다름)
		 * boolean :false
		 * char    :'\u0000'
		 * byte,short,int,long :0
		 * float :0.0f
		 * double:0.0
		 * 
		 * reference type : null <= new int 를 만들지 않아서 자주 발생함
		 * 메모리값을 갖고올때 기본적으로 null을 사용
		 * String 도 null
		 */
		boolean[]b = new boolean[5];
		char[]c = new char[5];
		byte[]bte = new byte[5];
		short[]s = new short[5];
		int[]i = new int[5];
		long[]l = new long[5];
		float[]f = new float[5];
		double[]d = new double[5];
		
		System.out.println(Arrays.toString(b));
		System.out.println(Arrays.toString(c));
		System.out.println(Arrays.toString(bte));
		System.out.println(Arrays.toString(s));
		System.out.println(Arrays.toString(i));
		System.out.println(Arrays.toString(l));
		System.out.println(Arrays.toString(f));
		System.out.println(Arrays.toString(d));
		
		String[]str = new String[5]; //값이 안만들어져서 null이 나옴(string객체생성안됐음)
		System.out.println(Arrays.toString(str));
		
	}

	private void method1() {
		/*
		 * lotto 45개 번호 배열 생성후
		 * 섞어서 앞에 6개 출력
		 */
		//1~45숫자가 담긴 45개의 배열방을 가로로 쭉 생성(배열은 0부터 숫자는1부터라서 1을 더했음)
		int [] lotto= new int[45] ;
		for (int i = 0; i < lotto.length; i++)  {
			lotto[i]=i+1; //0일땐1 1일땐2 ...44일땐 45넣어줌
		}
		//충분히 많이 섞을것
		for (int i = 0; i < 1000000; i++) {	
			int ran = (int)(Math.random()*lotto.length);
			int temp = lotto[0]; //값을 바꾸면서 섞음 
			lotto[0]=lotto[ran];
			lotto[ran]=temp;
			
		}
		//0~5까지 출력 (이미 섞여서 랜덤이니까 순서대로 6개를 출력)
		for (int i = 0; i < 6; i++) {
			
			System.out.print(lotto[i]+"\t");
			
		}System.out.println();
		
		
		/*
		 * 배열 길이가 6인값을 생성
		 * 위에서 만든 로또 번호를 옮길것
		 * copy (일부만 복사할거라서 .clone사용 못함)
		 */
		//깊은복사1
//		int [] copy =new int[6]; //깊은복사하기위해 copy배열 생성
//		for (int i = 0; i < copy.length; i++) {
//			copy[i]=lotto[i];//6번 반복하면 6개가 다 채워짐 // lotto0,1,2,3,4,5 값을 copy0,1,2,3,4,5에 대입한다는뜻
//		}
//		System.out.println(Arrays.toString(copy));
		
		//깊은복사2
		int [] copy =new int[6]; 
		System.arraycopy(lotto, 0, copy, 0, 6); 
		System.out.println(Arrays.toString(copy));
		
		for (int i = 0; i < copy.length-1; i++) { //버블정렬:앞의 값이랑 비교( j는 비교하고자하는 값임)
			for (int j = 0; j < copy.length-1; j++) {
				if(copy[j]>copy[j+1]) {
					int temp = copy[j];
					copy[j] = copy[j+1];
					copy[j+1]=temp;
				}
			}
		}System.out.println(Arrays.toString(copy));

		
		
		
	}
}
