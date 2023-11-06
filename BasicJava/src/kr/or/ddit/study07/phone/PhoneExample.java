package kr.or.ddit.study07.phone;

public class PhoneExample {
	public static void main(String[] args) {
		System.out.println("---그냥폰---");
		Phone phone = new Phone();//Phone클래스의 인스턴스인phone을 생성하고
		phone.tell(); //객체 phone의 메소드를 불러옴
		phone.camera();// 이 메서드는 객체의 정보나 상태를 출력하거나 메시지를 반환하는 기능을 수행할 것입니다
		
		System.out.println("---폴더폰---");
		FolderPhone fp = new FolderPhone();
		fp.fold();
		fp.tell();
		fp.camera();
		
		System.out.println("---스마트폰---");
		SmartPhone sp = new SmartPhone();
		sp.tell();
		sp.internet();
		sp.touch();
		sp.camera();
	}
}
