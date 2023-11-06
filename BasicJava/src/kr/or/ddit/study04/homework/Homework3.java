package kr.or.ddit.study04.homework;

import java.util.Scanner;

public class Homework3 {
	Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Homework3 obj = new Homework3();
		obj.method1();
	}

	void method1() {
		/*가위바위보 게임
		 * 1.가위 2.바위 3.보 (범위 1~3)
		 * 스캐너를 통해 숫자를 입력받고 승패 결과 출력할것.비기기 포함
		 * scanner통해 입력받기
		 */
		//결과값 0은 이겼다 1은 졌다 2는 비겼다
		int win = 0;
		int lose = 1;
		int same = 2;
		String s="";
		int com = (int)(Math.random()*3)+1;
		int c = com;
		System.out.println("1.가위 2.바위 3.보 입니다.\n숫자 1~3중 하나를 입력하세요.");
		int user1= sc.nextInt() ;
		System.out.println("컴퓨터는 "+c+"를 냈습니다.");
		
		int u1 = user1;
//이길때 1&3 2&1 3&2
//질때   1&2 2&3 3&1
		if(u1==1) {
			if(com==3) {
				s="0";
			}else if(com==2) {
				s="1";
			}else {
				s="2";
			}
			
		}else if(u1==2) {
			if(com==1) {
				s="0";
			}else if(com==3) {
				s="1";
			}else {
				s="2";
			}
			
		}else {
			if(com==2) {
				s="0";
			}else if(com==1) {
				s="1";
			}else {
				s="2";
			}
			
		}
		//0,1,2문자를 다른 문자로 바꾸기
		String text ="";
		if(s=="0") {
			text+="이겼습니다.";
		}else if(s=="1") {
			text+="졌습니다.";
		}else {
			text+="비겼습니다.";
		}System.out.println(text);
		
		
		
		
		
		
	}

}
