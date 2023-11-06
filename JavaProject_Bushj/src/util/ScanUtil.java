package util;

import java.util.Scanner;

public class ScanUtil {
	// 스캐너를 손쉽게 사용할 수 있는 static 메서드를 가지고있음
	static Scanner sc = new Scanner(System.in);
	
	//nextLine이란 공개 정적(static)메소드
	public static String nextLine(String print) {//nextLine: String 값을 읽을수있음
		System.out.print(print);                 //next int: int 값을 읽음
		return nextLine();//nextLine이라는 다른 메소드를 호출하고 결과를 반환함
	}
	
	private static String nextLine() {
		return sc.nextLine();
	}
	
	//정수값을 입력받는 역할을 함
	public static int nextInt(String print) { //사용자가 String입력하면 어떤 입력을 요청하는지메세지를 호출하고
		                                      //그에대한 입력을 받을수 있게됨
		System.out.print(print);
		return nextInt();
	}
	
	//사용자로부터 정수를 입력받는데 사용됨
	private static int nextInt() {
		while(true) { //올바른 정수를 입력받을때까지 계속 입력을 기다림
			try {     //try-catch : try블록 안에 사용자로부터 입력을 시도하는 부분있음
				int result = Integer.parseInt(sc.nextLine());//문자열을 읽고 정수로 변환하려함
				return result;//예외가 발생하지 않고 정수로 변환에 성공하면 변환된정수값을 반환하고 메서드가 종료됨
			}catch (NumberFormatException e) {//예외(사용자가 정수로 올바르게 입력하지 않았을때)처리 실행됨
				System.out.println("잘못 입력!!");//NumberFormatException: 숫자로 변환할수 없는 문자열을 
				                              //정수로 변환하려고 했을때
			}
		}
	}
}
