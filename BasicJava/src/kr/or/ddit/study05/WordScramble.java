package kr.or.ddit.study05;

import java.util.Arrays;
import java.util.Scanner;

public class WordScramble {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		WordScramble obj = new WordScramble();
		obj.method1();
	}

	private void method1() {
		//5개의 단어가 제공,이중 임의의 단어가 선택됨
		//선택된 단어의 철자를 섞어 사용자에게 제시됨
		//사용자는 이를 보고 원래의 단어를 입력함
		//사용자가 단어를 맞출때까지 반복하여 단어를 맞추었을대 시도 횟수 출력.
		String[]word = {"apple","banna","love","hope","persimmon"}; //다섯개 방이 있는 word배열
		int ran =(int)(Math.random()*word.length);					//word배열변수에서 랜덤으로 하나를 뽑은값의 순서값(int로뽑음)
		String select = word[ran];									// 뽑은 순서값을 다시 문자로 바꿈
		
		char[]ch = select.toCharArray(); //toCharArray:문자형식의변수를 배열변수로 바꿔줌 
		for (int i = 0; i < 10000; i++) {//
			//r값이 3이
			//3과 1번째 배열값이 바뀜
			//1=p 3=1->alppe
			//r값이 2이
			//2와 1번째 배열값이 바뀜
			//1=p 2=p -> aplpe
			int r = (int)(Math.random()*ch.length);//ch배열변수에서 랜덤으로 하나를 뽑음
			char temp = ch[1];//2번째 방의 값을 temp에 넣음----->
			ch[1]=ch[r];	//r+1번째 방을 2번째 방에 넣음   ----->for문에서 만번 돌리는 작업(문자를 랜덤으로)
			ch[r]=temp;		//temp값을 r+1번째 방에 넣음    ----->
			
		}
		System.out.println("밑의 문자를 배열해서 글자를 만드시오.");
		System.out.println(Arrays.toString(ch)); //Array.toString(ch):ch배열을 문자로 출력함
		int count =0; //count변수 만듦
		
		while(true) {
			System.out.println("정답을 입력하세요");
			String str = sc.nextLine();
			count++;
			if(select.equals(str)) { //.equals():랜덤으로 뽑은 문자 select가 입력한str과 같으면 //배열에서 값 같은지 비교할때
			System.out.println("정답입니다 ");
			System.out.println("시도횟수는 : "+count);
			break;					//if조건이 맞으면 멈춤
			}else {
				System.out.println("다시시도하세요.");
			}
		}
	}

}
