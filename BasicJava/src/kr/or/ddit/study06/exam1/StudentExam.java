package kr.or.ddit.study06.exam1;

public class StudentExam {
	int a =10; //객체가 생성 안됐음
	static int b =17; //static 은 객체를 생성 안해도 불러올수있음(Static:공통으로 사용함->어디든 b는 17임)
	public static void main(String[] args) {
		Student s1 = new Student();//객체 생성함
		s1.major = "학과1";
		s1.name  = "양영훈";
		s1.age   = 40;
		System.out.println(s1);
		
//		System.out.println(a); //a는 객체를 생성 안해서 못씀
		StudentExam obj = new StudentExam(); //-> obj라는 객체 생성해서 이제는 출력됌
		System.out.println(obj.a);
		System.out.println(b);
		
	}
}
