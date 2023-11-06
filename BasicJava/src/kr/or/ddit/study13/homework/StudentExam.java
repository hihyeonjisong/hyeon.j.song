package kr.or.ddit.study13.homework;

import kr.or.ddit.study13.homework2.Student;

public class StudentExam {
	String st_no;
	String major;
	String name;
	
	
	public StudentExam(String st_no, String major, String name) {
		this.st_no = st_no;
		this.major = major;
		this.name = name;
	}


	public static void main(String[] args) {
		Student s_1 = new Student("20172745","영어영문학과","송현지");
		Student s_2 = new Student("20127745","국어국문학과","김은지");
		
		System.out.println(s_1);
		System.out.println(s_2);
	}
	
	
}
