package kr.or.ddit.study10;

/*
 * throw : 예외 강제 발생
 *    -일반 메소드 내부에서 사용
 *    사용형식
 *    throw 예외클래스 객체명
 *    -> IOException io= newIoException();
 *     
 *     ex)throw new Exception();
 * 		  throw IOExeption();
 * 
 * 
 * 
 */
public class ExceptionExample03 {
	static String[]name;
	public static void main(String[] args) {
		setArray();
		try { 
			System.out.println(getArray(4));
		}catch(ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();  에러메세지를 출력
			e.printStackTrace();
			System.out.println("에러를 여기서 처리");
		}
		
	}
	public static void setArray() {
		name= new String[]{"홍길동","이순신","강감찬","이성계"};
	}
	public static String getArray(int num) throws ArrayIndexOutOfBoundsException{
		
		return name[num];
	}
}
