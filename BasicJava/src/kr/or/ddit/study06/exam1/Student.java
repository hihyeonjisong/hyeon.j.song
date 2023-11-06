package kr.or.ddit.study06.exam1;

public class Student {
	//학과
	//학생이름
	//나이
	String major; //붕어빵 틀 제작하듯이 공간을 만듦
	String name;
	int age;
	
	@Override     //출력하기 좋게 만들었다
	public String toString() {
		return "Student [major=" + major + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
