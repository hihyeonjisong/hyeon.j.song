package kr.or.ddit.study06.exam2;

public class Korean {
	String nation = "대한민국";//필드
	String name;
	String ssn;

	public Korean() {//기본생성자
		
	}
	
	public Korean(String nation, String name, String ssn) {//일반1번 생성자 
		this.nation = nation;
		this.name = name;
		this.ssn = ssn;
	
	}
	

	public Korean(String nation) {//일반 2번 생성자
		this.nation = nation;
		
	
	
	}

	public Korean(String name, String ssn) {//일반 3번 생성자
		this("한국"); //생성자는 맨 위로 올라와야함
		this.name = name;
		this.ssn = ssn;
		
	}
}
