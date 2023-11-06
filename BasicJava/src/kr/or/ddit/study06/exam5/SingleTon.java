package kr.or.ddit.study06.exam5;//다음시간에
/**
 * 
 * 디자인 패턴 중에 하나인 싱글톤
 * 클래스를 여러개 만들지 못하도록 방지함.
 *
 */
public class SingleTon {
	
	private static SingleTon singleTon = null; //외부에서 접근x
//	private static SingleTon singleTon = new SingleTon();     객체생성 같은건가요? 
	
	int a =10; //객체를 생성하는 순간에 메모리에 올린다.
	private SingleTon() {//
		
		try {
			Thread.sleep(3000);	//3초후에
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
	};

	public static SingleTon getInstance() { //public으로 객체를 만들어서 사용함->10줄에가서 1번만 사용가능함
		System.out.println("객체가 호출되었습니다.");
		if (singleTon == null) {               // 위에서 null이라고해서 
			singleTon = new SingleTon();

		}
		System.out.println("객체로드가 완료되었습니다.");
		return singleTon;
	}
	
}
