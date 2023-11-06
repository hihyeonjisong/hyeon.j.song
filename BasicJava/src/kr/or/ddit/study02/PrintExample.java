package kr.or.ddit.study02;

public class PrintExample {
	public static void main(String[] arg) {
		
		System.out.print("홍길동"); //옆으로씀
		System.out.print(" 34061");
		System.out.print(" 대전시 중구 계롱로");
		System.out.println();// 다음줄 넘김		
		
		System.out.println("홍길동2");
		System.out.println(" 34061");
		System.out.println("  대전시 중구 계룡로");
		
		//System.out.printf("형식지정문자열", 변수 리스트); 변수를 ""에 넣는다
		//"형식지정문자열"
		//"%[[- 0]n]d 10진 정수
		//- : 왼쪽 정렬
		//0 : 남은 왼쪽 빈공간에 0 채움
		
		System.out.printf("숫자 : %d 입니다.\n", 1000);// %d에 1000이 들어간다
		System.out.printf("%d\n",1000);
		System.out.printf("%-8d\n",1000); //왼쪽정렬
		System.out.printf("%08d\n",1000);
		
		System.out.printf("이름: %1$s, 나이: %2$d\n", "김자바", 25); //책p.91
		System.out.printf("이름 : %1$s, 나이 : %2$d", "김자바",25);
	}

}
