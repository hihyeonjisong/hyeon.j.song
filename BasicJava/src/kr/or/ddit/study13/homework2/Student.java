package kr.or.ddit.study13.homework2;


public class Student{
	
		
	/*
	 * 문제 1 - 다음을 만족하는 Student 클래스를 작성하시오.
		· String형의 학과와 정수형의 학번을 필드로 선언
		· Student 클래스의 main() 메소드에서 Student 객체를 생성하여 학과와 학번 필드에 적당한 값을 입력 후 출력
		(출력까지, to string)->override쓰라는말
	 */
//	HashMap map = new HashMap();
//	map.compute("송현지", ,,)
	String st_no;
	String major;
	String name;
	@Override
	public String toString() {//출력형식을 만듦
		return "Student[학번=" + st_no + ", 전공=" + major + ", 이름=" + name + "]";
	}
	
	
	public Student(String st_no,String major, String name) { 
		this.st_no=st_no;
		this.major=major;
		this.name=name;
	}
	
	public static void main(String[] args) {
		Student s_1 = new Student("20172745","영어영문학과","송현지");
		Student s_2 = new Student("20127745","국어국문학과","김은지");
		
		System.out.println(s_1);
		System.out.println(s_2);
	}
	
}
