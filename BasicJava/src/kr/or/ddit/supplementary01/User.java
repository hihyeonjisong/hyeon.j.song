package kr.or.ddit.supplementary01;

public class User {
	String name; //필드:데이터 저장
	int age;
	String hobby;
	
	//생성자가 한개라도 있으면 기본(default)생성자가 없어져서
	//기본 생성자 쓰려면 만들어야함
	public User() {
		
	}
	
	public User(String name, int age,String hobby) {//생성자
		this.name = name;                                          //붕어빵틀
		this.age = age;                                            //alt+shift+s
		this.hobby = hobby;
	}

	public String getName() {//getter setter:필드 값을 사용할수 있게해줌
		return name;         //조건을 넣을수있음
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age<0) {
			System.out.println("0이하는 입력불가");
		}
		this.age = age;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
}
