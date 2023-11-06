package kr.or.ddit.study02;

public class BooleanExample {
	public static void main(String[] args) {
		// true, false
		// 논리 타입으로 두가지로 표시됨.
		// 실행 흐름 등을 변경하는데 표시
		
		boolean flag = false;
		int age = 25;
		
		flag = (age>17);
		if(flag) {
			System.out.println("성년 입니다.");
		}else {
			System.out.println("미성년 입니다.");
		}
		
		while(flag) {
			System.out.println("flag 값이 참이라면 계속 반복됩니다."); //빨간네모 누르면 정지됨
		}
		
		
	}

}
