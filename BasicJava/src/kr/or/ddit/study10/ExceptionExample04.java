package kr.or.ddit.study10;

import java.util.Scanner;

/**
 * 예외 클래스 생성 -class 클래스명 extend Exception 클래스명(){ super("예외 메세지");
 */
public class ExceptionExample04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("닉네임 입력 : ");
		String nickName = sc.nextLine();

		try { // 의심이 갈만한 것들은 try catch문으로 묶어주는게 좋음(에러가 나도 종료되지 않음)
			if (nickName.contains("18")) {
				throw new NickNameException();
			}
			if (nickName.length() > 10) {
				throw new NickNameLengthException();
			}
		} catch (NickNameException e) {
			System.out.println("금지어가 포함되었습니다.");
		} catch (NickNameLengthException e) {
			System.out.println("길이가 너무 깁니다.");
		}

	}
}

class NickNameLengthException extends RuntimeException {
	public NickNameLengthException() {
		super("닉네임 길이가 너무 깁니다.");
	}
}

class NickNameException extends RuntimeException {
	public NickNameException() {
		super("부적절한 닉네임 입니다.");
	}
}